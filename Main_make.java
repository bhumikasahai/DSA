import java.util.*;

public class Main_make {
    static class Card {
        int value, suit;
        Card(int v, int s) { value = v; suit = s; }
    }

    static Map<Integer, Integer> suitPrioMap = new HashMap<>();

    static int parseValue(String s) {
        switch (s) {
            case "A": return 1;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            default: return Integer.parseInt(s);
        }
    }

    static boolean compare(Card a, Card b) {
        if (a.value != b.value)
            return a.value < b.value;
        return suitPrioMap.get(a.suit) > suitPrioMap.get(b.suit);
    }

    static Comparator<Card> cardComparator = (a, b) -> {
        if (a.value != b.value)
            return Integer.compare(a.value, b.value);
        return Integer.compare(suitPrioMap.get(b.suit), suitPrioMap.get(a.suit));
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Card> tempDeck1 = new ArrayList<>();
        List<Card> tempDeck2 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String c1 = sc.next();
            int s1 = sc.nextInt();
            String c2 = sc.next();
            int s2 = sc.nextInt();
            tempDeck1.add(new Card(parseValue(c1), s1));
            tempDeck2.add(new Card(parseValue(c2), s2));
        }

        for (int i = 1; i <= 4; i++) {
            int suit = sc.nextInt();
            suitPrioMap.put(suit, i);
        }

        tempDeck1.sort(cardComparator);
        tempDeck2.sort(cardComparator);

        Deque<Card> deck1 = new ArrayDeque<>(tempDeck1);
        Deque<Card> deck2 = new ArrayDeque<>(tempDeck2);
        List<Card> hand = new ArrayList<>();

        int currentPlayer = 1;

        while (true) {
            Deque<Card> currentDeck = (currentPlayer == 1) ? deck1 : deck2;
            if (currentDeck.isEmpty()) break;

            Card newCard = currentDeck.pollFirst();

            if (hand.isEmpty()) {
                hand.add(newCard);
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            } else {
                Card topCard = hand.get(hand.size() - 1);
                boolean wins = (newCard.value == topCard.value &&
                        suitPrioMap.get(newCard.suit) < suitPrioMap.get(topCard.suit));

                if (wins) {
                    hand.add(newCard);
                    hand.sort(cardComparator);
                    for (Card c : hand) currentDeck.addLast(c);
                    hand.clear();
                } else {
                    hand.add(newCard);
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                }
            }
        }

        if (deck1.isEmpty() && deck2.isEmpty()) {
            System.out.println("TIE");
        } else if (deck1.isEmpty()) {
            System.out.println("LOSER");
        } else {
            System.out.println("WINNER");
        }

        sc.close();
    }
}