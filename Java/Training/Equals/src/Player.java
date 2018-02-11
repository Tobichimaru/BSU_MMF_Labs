import java.util.ArrayList;
import java.util.Objects;

public class Player {

    private String name;
    private ArrayList<Card> cards;

    public Player(String name){
        this.name = name;
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
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.cards);
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cards, other.cards)) {
            return false;
        }
        return true;
    }
    
}
