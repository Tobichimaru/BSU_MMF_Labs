/**
 * Created by Golden on 21.03.2015.
 */
public class Main {

   public static void main(String args[]) {
       Deck deck = new Deck();
       deck.initializeDeck();
       deck.generateDeck();
       Player first = new Player("Andrew");
       first.initializePlayerDeck(deck);
       Player second = new Player("Bob");
       second.initializePlayerDeck(deck);
       Player currentPlayer = first;
       Card lastCard = deck.getCard();
       
       System.out.println("First player is the current player? "+ first.equals(currentPlayer));
       System.out.println("First player is the second player? " + first.equals(second));
   }
}
