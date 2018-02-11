import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Golden on 22.03.2015.
 */
public class Deck implements ISerialize {
    private static int START_CARDS_COUNT = 6;
    private ArrayList<Card> cards;
    private String[] cardNames = {"six","seven","eight","nine","ten","jack","queen","king","ace"};
    private String[] cardColors = {"hearts","diamonds","clubs","spades"};

    public Deck() {
        cards = new ArrayList<>();
    }
    
    public void initializeDeck() {
        cards = new ArrayList<Card>();
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
    
    public void showCards() {
        System.out.println("Desk cards: ");
        for (int i = 0; i< cards.size(); i++){
            System.out.println( i + 1 +") " + cards.get(i).getName() + " of " + cards.get(i).getColor());
        }
    }
    
    @Override
    public byte[] serialize() {
        ByteBuffer bb = ByteBuffer.allocate(4*cards.size() + 4);
        bb.putInt(cards.size());
        int cards_size = 0;
        for (Card c: cards) {
            int var = c.serialize().length;
            cards_size += var;
            bb.putInt(var);
        }
        byte[] byte_integers = bb.array();
        byte[] result = new byte[byte_integers.length + cards_size];
        System.arraycopy(byte_integers, 0, result, 0, byte_integers.length);
        int begin = byte_integers.length;
        byte[] buffer;
        for (Card c: cards) {
            buffer = c.serialize();
            System.arraycopy(buffer, 0, result, begin, buffer.length);
            begin += buffer.length;
        }
        return result;
    }
    
    @Override
    public void deserialize(byte[] buffer) {
        byte[] byte_int = new byte[4];
        int cards_length = 0;
        System.arraycopy(buffer, 0, byte_int, 0, 4);
        ByteBuffer bb = ByteBuffer.wrap(byte_int);
        cards_length = bb.getInt();
        
        int[] cards_integers = new int[cards_length]; 
        byte_int = new byte[cards_length*4];
        System.arraycopy(buffer, 4, byte_int, 0, cards_length*4);
        bb = ByteBuffer.wrap(byte_int);
        for (int i = 0; i < cards_length; i++) {
            cards_integers[i] = bb.getInt();
        }
        
        int begin = 4+cards_length*4;
        byte[] card_ser;
        cards.clear();
        for (int i = 0; i < cards_length; i++) {
            Card c = new Card();
            card_ser = new byte[cards_integers[i]];
            System.arraycopy(buffer, begin, card_ser, 0, cards_integers[i]);
            c.deserialize(card_ser);
            cards.add(c);
            begin += cards_integers[i];
        }
    }
    
}
