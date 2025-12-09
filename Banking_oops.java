// File: src/domain/Customer.java
package domain;

public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}


// File: src/domain/Transaction.java
package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    public enum Type { DEPOSIT, WITHDRAW, TRANSFER_IN, TRANSFER_OUT }

    private final LocalDateTime timestamp;
    private final Type type;
    private final double amount;
    private final String narration;

    public Transaction(Type type, double amount, String narration) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.narration = narration;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getNarration() {
        return narration;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s | %-12s | %10.2f | %s", timestamp.format(f), type, amount, narration);
    }
}


// File: src/domain/Account.java
package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    public enum Type { SAVINGS, CURRENT }

    private final String accountNumber;
    private final Customer customer;
    private final Type accountType;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, Customer customer, Type accountType, double openingBalance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.accountType = accountType;
        this.balance = openingBalance;
        if (openingBalance > 0) {
            transactions.add(new Transaction(Transaction.Type.DEPOSIT, openingBalance, "Opening balance"));
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Type getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount, String narration) {
        this.balance += amount;
        transactions.add(new Transaction(Transaction.Type.DEPOSIT, amount, narration));
    }

    public synchronized void withdraw(double amount, String narration) {
        this.balance -= amount;
        transactions.add(new Transaction(Transaction.Type.WITHDRAW, amount, narration));
    }

    public synchronized void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    @Override
    public String toString() {
        return String.format("%s | %-20s | %-8s | %.2f", accountNumber, customer.getName(), accountType, balance);
    }
}


// File: src/repository/AccountRepository.java
package repository;

import domain.Account;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class AccountRepository {
    private final Map<String, Account> store = new ConcurrentHashMap<>();

    public void save(Account account) {
        store.put(account.getAccountNumber(), account);
    }

    public Optional<Account> findByAccountNumber(String accountNumber) {
        return Optional.ofNullable(store.get(accountNumber));
    }

    public List<Account> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<Account> searchByCustomerName(String nameQuery) {
        String q = nameQuery.toLowerCase();
        return store.values().stream()
                .filter(a -> a.getCustomer().getName().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public boolean exists(String accountNumber) {
        return store.containsKey(accountNumber);
    }
}


// File: src/exceptions/InvalidInputException.java
package exceptions;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}


// File: src/exceptions/InsufficientBalanceException.java
package exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}


// File: src/util/ValidationUtil.java
package util;

import exceptions.InvalidInputException;

public class ValidationUtil {
    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Name cannot be empty");
        }
    }

    public static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new InvalidInputException("Invalid email address");
        }
    }

    public static void validateAmount(double amount) {
        if (amount <= 0) {
            throw new InvalidInputException("Amount must be greater than zero");
        }
    }

    public static void validateAccountType(String type) {
        if (type == null) throw new InvalidInputException("Account type required");
        try {
            domain.Account.Type.valueOf(type.toUpperCase());
        } catch (Exception e) {
            throw new InvalidInputException("Account type must be SAVINGS or CURRENT");
        }
    }
}


// File: src/service/BankingService.java
package service;

import domain.Account;
import domain.Transaction;
import exceptions.InsufficientBalanceException;

import java.util.List;

public interface BankingService {
    Account createAccount(String name, String email, String accountType, double openingBalance);
    void deposit(String accountNumber, double amount, String narration);
    void withdraw(String accountNumber, double amount, String narration) throws InsufficientBalanceException;
    void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientBalanceException;
    List<Transaction> getStatement(String accountNumber);
    List<Account> listAccounts();
    List<Account> searchAccounts(String nameQuery);
}


// File: src/service/impl/BankingServiceImpl.java
package service.impl;

import domain.Account;
import domain.Customer;
import domain.Transaction;
import exceptions.InsufficientBalanceException;
import repository.AccountRepository;
import service.BankingService;
import util.ValidationUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BankingServiceImpl implements BankingService {
    private final AccountRepository repo;

    public BankingServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    private String generateAccountNumber() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    @Override
    public Account createAccount(String name, String email, String accountType, double openingBalance) {
        ValidationUtil.validateName(name);
        ValidationUtil.validateEmail(email);
        ValidationUtil.validateAccountType(accountType);
        if (openingBalance < 0) openingBalance = 0;

        Customer c = new Customer(name.trim(), email.trim());
        Account.Type t = Account.Type.valueOf(accountType.toUpperCase());
        String accNo = generateAccountNumber();
        Account acc = new Account(accNo, c, t, openingBalance);
        repo.save(acc);
        return acc;
    }

    @Override
    public void deposit(String accountNumber, double amount, String narration) {
        ValidationUtil.validateAmount(amount);
        Account acc = repo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountNumber));
        acc.deposit(amount, narration == null ? "Deposit" : narration);
    }

    @Override
    public void withdraw(String accountNumber, double amount, String narration) throws InsufficientBalanceException {
        ValidationUtil.validateAmount(amount);
        Account acc = repo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountNumber));
        if (acc.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance. Available: " + acc.getBalance());
        }
        acc.withdraw(amount, narration == null ? "Withdraw" : narration);
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientBalanceException {
        ValidationUtil.validateAmount(amount);
        if (fromAccountNumber.equals(toAccountNumber)) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }
        Account from = repo.findByAccountNumber(fromAccountNumber)
                .orElseThrow(() -> new IllegalArgumentException("From account not found: " + fromAccountNumber));
        Account to = repo.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new IllegalArgumentException("To account not found: " + toAccountNumber));

        synchronized (this) {
            if (from.getBalance() < amount) {
                throw new InsufficientBalanceException("Insufficient balance in source account. Available: " + from.getBalance());
            }
            from.withdraw(amount, "Transfer to " + to.getAccountNumber());
            to.deposit(amount, "Transfer from " + from.getAccountNumber());
            // Add explicit transfer transactions for clarity
            from.addTransaction(new Transaction(Transaction.Type.TRANSFER_OUT, amount, "Transferred to " + to.getAccountNumber()));
            to.addTransaction(new Transaction(Transaction.Type.TRANSFER_IN, amount, "Received from " + from.getAccountNumber()));
        }
    }

    @Override
    public List<Transaction> getStatement(String accountNumber) {
        Account acc = repo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountNumber));
        return acc.getTransactions();
    }

    @Override
    public List<Account> listAccounts() {
        return repo.findAll();
    }

    @Override
    public List<Account> searchAccounts(String nameQuery) {
        return repo.searchByCustomerName(nameQuery);
    }
}


// File: src/app/Main.java
package app;

import domain.Account;
import domain.Transaction;
import exceptions.InsufficientBalanceException;
import repository.AccountRepository;
import service.BankingService;
import service.impl.BankingServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BankingService service = new BankingServiceImpl(new AccountRepository());

    public static void main(String[] args) {
        System.out.println("Welcome to SimpleBank Console App");
        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> createAccount();
                    case "2" -> deposit();
                    case "3" -> withdraw();
                    case "4" -> transfer();
                    case "5" -> viewStatement();
                    case "6" -> listAccounts();
                    case "7" -> searchAccounts();
                    case "0" -> {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (IllegalArgumentException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Open Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Between Accounts");
        System.out.println("5. View Account Statement");
        System.out.println("6. List All Accounts");
        System.out.println("7. Search Accounts by Customer Name");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void createAccount() {
        System.out.print("Customer name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Customer email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Account type (SAVINGS/CURRENT): ");
        String type = scanner.nextLine().trim();
        System.out.print("Opening balance (or leave blank for 0): ");
        String balStr = scanner.nextLine().trim();
        double opening = 0;
        if (!balStr.isEmpty()) {
            opening = Double.parseDouble(balStr);
        }
        Account acc = service.createAccount(name, email, type, opening);
        System.out.println("Account created: " + acc.getAccountNumber());
    }

    private static void deposit() {
        System.out.print("Account number: ");
        String accNo = scanner.nextLine().trim();
        System.out.print("Amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Narration (optional): ");
        String narr = scanner.nextLine().trim();
        service.deposit(accNo, amount, narr.isEmpty() ? null : narr);
        System.out.println("Deposit successful");
    }

    private static void withdraw() {
        System.out.print("Account number: ");
        String accNo = scanner.nextLine().trim();
        System.out.print("Amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Narration (optional): ");
        String narr = scanner.nextLine().trim();
        service.withdraw(accNo, amount, narr.isEmpty() ? null : narr);
        System.out.println("Withdrawal successful");
    }

    private static void transfer() {
        System.out.print("From account: ");
        String from = scanner.nextLine().trim();
        System.out.print("To account: ");
        String to = scanner.nextLine().trim();
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        service.transfer(from, to, amount);
        System.out.println("Transfer successful");
    }

    private static void viewStatement() {
        System.out.print("Account number: ");
        String accNo = scanner.nextLine().trim();
        List<Transaction> txs = service.getStatement(accNo);
        System.out.println("Statement for " + accNo + ":");
        System.out.println("Timestamp           | Type         |     Amount | Narration");
        System.out.println("----------------------------------------------------------------");
        txs.forEach(System.out::println);
    }

    private static void listAccounts() {
        List<Account> all = service.listAccounts();
        if (all.isEmpty()) System.out.println("No accounts found");
        else {
            System.out.println("AccountNo | Name                 | Type     | Balance");
            System.out.println("----------------------------------------------------");
            all.forEach(a -> System.out.println(a));
        }
    }

    private static void searchAccounts() {
        System.out.print("Enter name (or part): ");
        String q = scanner.nextLine().trim();
        List<Account> res = service.searchAccounts(q);
        if (res.isEmpty()) System.out.println("No matching accounts");
        else res.forEach(a -> System.out.println(a));
    }
}
