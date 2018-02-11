
package solarsystemapp;

import java.util.Objects;

public class Star {
    private String name;
    
    public Star(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Star name: " + name;
    }
    
    
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Star))return false;
        Star otherStar = (Star)other;
        return equals(otherStar);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    public boolean equals(Star other) {
        return (name == null ? other.name == null : name.equals(other.name));
    }
    
}
