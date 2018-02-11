
package solarsystemapp;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Planet {
    private String name;
    private int radius;
    
    public Planet(String name, int radius) {
        if (radius <= 0) 
            throw new InvalidParameterException("Radius should be positive");
        this.name = name;
        this.radius = radius;
    }
    
    @Override
    public String toString() {
        return "Planet "  + name + " with radius " + Integer.toString(radius);
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Planet))return false;
        Planet otherPlanet = (Planet)other;
        return equals(otherPlanet);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + this.radius;
        return hash;
    }
    
    public boolean equals(Planet other) {
        return (name.equals(other.name) && radius == other.radius);
    }
    
}
