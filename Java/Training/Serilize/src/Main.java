
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Golden on 21.03.2015.
 */
public class Main {

   public static void main(String args[]) throws IOException {
        Deck deck = new Deck();
        Player first = new Player("Andrew");
        Player second = new Player("Bob");

        System.out.println("Load last initial state (false/true)? (0/1):");
        int choise = System.in.read();
        
        File inFile = new File("savestate.txt");
        if (inFile.exists() && choise == 1) {
            Scanner file_in = new Scanner("savestate.txt");
            String str_deck = file_in.nextLine();
            String str_first = file_in.nextLine();
            String str_second = file_in.nextLine();
            deck.deserialize(str_deck.getBytes());
            first.deserialize(str_first.getBytes());
            second.deserialize(str_second.getBytes());
        } else {
            deck.initializeDeck();
            deck.generateDeck();
            first.initializePlayerDeck(deck);
            second.initializePlayerDeck(deck);
            
            File outFile = new File("savestate.txt");
            FileWriter fWriter = new FileWriter(outFile);
            try (PrintWriter pWriter = new PrintWriter(fWriter)) {
                pWriter.println(new String(deck.serialize()));
                pWriter.println(new String(first.serialize()));
                pWriter.println(new String(second.serialize()));
            }
       }
        
       second.initializePlayerDeck(deck);
       Player currentPlayer = first;
       Card lastCard = deck.getCard();
       while (true) {
           lastCard.show();
           currentPlayer.showCards();
           Card tempCard = currentPlayer.dropCard(lastCard);
           if (tempCard != null) {
               lastCard = tempCard;
               lastCard.setStatus();
               if (currentPlayer.isEmpty()) {
                   return;
               }
           } else {
               currentPlayer.addCard(deck);
           }
           if (currentPlayer == first) {
               currentPlayer = second;
               if (!currentPlayer.getStatus(lastCard.getStatus(),deck)) {
                   currentPlayer = first;
               }
           } else {
               currentPlayer = first;
               if (!currentPlayer.getStatus(lastCard.getStatus(),deck)) {
                   currentPlayer = second;
               }
           }
       }
   }
}
