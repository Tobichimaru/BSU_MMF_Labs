import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Player implements ISerialize {

    private String name;
    private ArrayList<Card> cards;

    public Player(String name){
        this.name = name;
        cards = new ArrayList<>();
    }

    public void initializePlayerDeck(Deck deck) {
        cards = deck.getPlayerCards();
    }

    public void addCard(Deck deck) {
        cards.add(deck.getCard());
    }

    public Card dropCard(Card card) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getName() == card.getName() || cards.get(i).getColor() == card.getColor()) {
                Card returnCard = cards.get(i);
                cards.remove(i);
                return returnCard;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (cards.isEmpty())
            return true;
        return false;
    }

    public void showCards() {
        System.out.println( name + " cards: ");
        for (int i = 0; i< cards.size(); i++){
            System.out.println( i + 1 +") " + cards.get(i).getName() + " of " + cards.get(i).getColor());
        }
    }

    public boolean getStatus(int status,Deck deck) {
        if (status == -1)
            return false;
        for (int i=0; i < status; i++) {
            addCard(deck);
        }
        return true;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public byte[] serialize() {
        ByteBuffer bb = ByteBuffer.allocate(4*cards.size() + 2*4);
        byte[] byte_name = name.getBytes();
        bb.putInt(byte_name.length);
        bb.putInt(cards.size());
        int cards_size = 0;
        for (Card c: cards) {
            int var = c.serialize().length;
            cards_size += var;
            bb.putInt(var);
        }
        byte[] byte_integers = bb.array();
        byte[] result = new byte[byte_name.length + byte_integers.length + cards_size];
        System.arraycopy(byte_integers, 0, result, 0, byte_integers.length);
        System.arraycopy(byte_name, 0, result, byte_integers.length, byte_name.length);
        int begin = byte_integers.length + byte_name.length;
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
        byte[] byte_int = new byte[8];
        int cards_length = 0, name_length = 0;
        System.arraycopy(buffer, 0, byte_int, 0, 8);
        ByteBuffer bb = ByteBuffer.wrap(byte_int);
        name_length = bb.getInt();
        cards_length = bb.getInt();
        
        int[] cards_integers = new int[cards_length]; 
        byte_int = new byte[cards_length*4];
        System.arraycopy(buffer, 8, byte_int, 0, cards_length*4);
        bb = ByteBuffer.wrap(byte_int);
        for (int i = 0; i < cards_length; i++) {
            cards_integers[i] = bb.getInt();
        }
        
        byte[] byte_name = new byte[name_length];
        System.arraycopy(buffer, 8+cards_length*4, byte_name, 0, name_length);
        name = new String(byte_name);
        
        int begin = 8+cards_length*4+name_length;
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
