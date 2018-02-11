
package solarsystemapp;

import java.util.ArrayList;
import java.util.Objects;

public class SolarSystem {
    private ArrayList<Planet> planets;
    private Star star;
 
    public SolarSystem(Star star) {
        this.star = star;
        planets = new ArrayList<>();
    }
    
    public SolarSystem(Star star, ArrayList<Planet> planets) {
        this.star = star;
        this.planets = new ArrayList<>(planets);
    }
    
    public void addPlanet(Planet planet) {
        if (planets.size() > 1000) {
            throw new OutOfMemoryError("To much planets in the system!");
        }
        planets.add(planet);
    }
    
    public int getNumberOfPlanets() {
        return planets.size();
    }
    
    @Override
    public String toString() {
        String result = "Star: " + star.toString() + "\nPlanets:\n";
        for (int i = 0; i < planets.size(); i++){ 
            result += planets.get(i).toString();
            result += "\n";
        }
        return result;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof SolarSystem))return false;
        SolarSystem otherSolarSystem = (SolarSystem)other;
        return equals(otherSolarSystem);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.planets);
        hash = 29 * hash + Objects.hashCode(this.star);
        return hash;
    }
    
    public boolean equals(SolarSystem other) {
        if (planets.size() != other.planets.size()) 
            return false;
        if (!star.equals(other.star)) 
            return false;
        for (int i = 0; i < planets.size(); i++) 
            if (!planets.get(i).equals(other.planets.get(i)))
                return false;
        return false;
    }

    
}
