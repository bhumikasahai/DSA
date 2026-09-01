class Bank{
    private int balance=1000;
    public int getBalance(){
        return balance;
    }
    public void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }
    }
}
public class encapsulation {
    public static void main(String[] args) {
        Bank b = new Bank();
        b.deposit(1000);
        b.withdraw(300);
        System.out.println("Balance: " + b.getBalance());
    }    
}
