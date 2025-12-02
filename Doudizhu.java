import java.util.ArrayList; 
import java.util.HashMap;
public class Doudizhu {
    private ArrayList<ArrayList<Integer>> playerHands = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> deck = new ArrayList<Integer>();
    private HashMap<Integer, String> cardValue;
    private int[] landlordCards = new int[3];
    private int landLord;

    public Doudizhu (){
        for (int i = 0; i < 3; i++){
            playerHands.add(new ArrayList<Integer>());
        }
        newDeck();
    }

    private void newDeck(){
        for (int i = 1; i < 14; i++){
            for (int n = 0; n < 4; n++){
                deck.add(i);
            }
        }
        deck.add(14);
        deck.add(15);

        cardValue = new HashMap<Integer, String>();
        cardValue.put(1, "3");
        cardValue.put(2, "4");
        cardValue.put(3, "5");
        cardValue.put(4, "6");
        cardValue.put(5, "7");
        cardValue.put(6, "8");
        cardValue.put(7, "9");
        cardValue.put(8,"10");
        cardValue.put(9,"Jack");
        cardValue.put(10,"Queen");
        cardValue.put(11,"King");
        cardValue.put(12,"Ace");
        cardValue.put(13,"2");
        cardValue.put(14,"Black Joker");
        cardValue.put(15,"Red Joker");
    }

    public void deal(){
        for (int i = 0; i < 3; i++){
            int n = (int) Math.random()*(54-i);
            landlordCards[i] = deck.get(n);
            deck.remove(n);
        }
        for (int i = 0; i < 17; i++){
            for (int n = 0; n < 3; n++){
                int x = (int) Math.random()*(deck.size());
                playerHands.get(n).add(x);
                deck.remove(x);
            }
        }
        landLord = (int) Math.random()*3 + 1;
        System.out.println("Player " + landLord + " is the landlord!");
        for (int i = 0; i < 3; i++){
            playerHands.get(landLord-1).add(landlordCards[i]);
        }
    }

    public void showHands(){
        for (int player = 0; player < 3; player++){
            System.out.print("Player 1: ");
            for (int i = 0; i < playerHands.get(player).size(); i++){
                String card = cardValue.get(playerHands.get(player).get(i));
                System.out.print(card + ", ");
            }
            System.out.println();
        }
    }
}