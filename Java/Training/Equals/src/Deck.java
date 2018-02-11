import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Golden on 22.03.2015.
 */
public class Deck {
    private static int START_CARDS_COUNT = 6;
    private ArrayList<Card> cards;
    private String[] cardNames = {"six","seven","eight","nine","ten","jack","queen","king","ace"};
    private String[] cardColors = {"hearts","diamonds","clubs","spades"};

    public void initializeDeck() {
        cards = new ArrayList<>();
        for (int i=0; i < cardNames.length; i++) {
            for (int j=0; j < cardColors.length; j++) {
                cards.add(new Card(cardNames[i],cardColors[j]));
            }
        }
    }

    public void generateDeck() {
        Random random = new Random();
        for (int i = 0; i  < cards.size(); i++) {
            int j = random.nextInt(36);
            Card temp = cards.get(i);
            cards.set(i,cards.get(j));
            cards.set(j,temp);
        }
    }


    public ArrayList<Card> getPlayerCards() {
        ArrayList<Card> playerCards = new ArrayList<Card>();
        for (int i = 0; i < START_CARDS_COUNT; i++){
            playerCards.add(cards.get(0));
            cards.remove(0);
        }
        return playerCards;
    }

    public Card getCard(){
        Card popCard = cards.get(0);
        cards.remove(0);
        return popCard;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.cards);
        hash = 59 * hash + Arrays.deepHashCode(this.cardNames);
        hash = 59 * hash + Arrays.deepHashCode(this.cardColors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deck other = (Deck) obj;
        if (!Objects.equals(this.cards, other.cards)) {
            return false;
        }
        if (!Arrays.deepEquals(this.cardNames, other.cardNames)) {
            return false;
        }
        if (!Arrays.deepEquals(this.cardColors, other.cardColors)) {
            return false;
        }
        return true;
    }
}
