
import java.util.Objects;

public class Card {
    private String name;
    private String color;
    private int status;

    public Card(String name,String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getStatus()
    {
        status = setStatus();
        return status;
    }

    public void show() {System.out.println("Last card is " + name + " of " + color);}


    public int setStatus() {
        if ("six".equals(name))
        {
            return 1;
        }
        else if ("seven".equals(name)) {
            return 2;
        }
        else if ("king".equals(name) && "spades".equals(color))
        {
            return 5;
        }
        else if ("ace".equals(name))
        {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.color);
        hash = 37 * hash + this.status;
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
        final Card other = (Card) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

}