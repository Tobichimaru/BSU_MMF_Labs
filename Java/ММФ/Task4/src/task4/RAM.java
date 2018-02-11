
package task4;

/**
 * @author Saia
 */

public class RAM {
    private int capasity;
    private int working_memory;
    
    public RAM() {
        capasity = 2;
        working_memory = 0;
    }
    
    public int getCapasity() {
        return capasity;
    }
    
    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }
    
     public int getMemory() {
        return working_memory;
    }
    
    public void setMemory(int memory) {
        this.working_memory = memory;
    }
    
    @Override
    public boolean equals(Object obj) { 
        if (this == obj) return true;
        if (obj == null) return false; 
        if (obj instanceof RAM){ //warning 
            RAM temp = (RAM) obj; 
            return (this.capasity == temp.capasity && 
                    this.working_memory == temp.working_memory); 
        } else 
            return false;
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.capasity;
        hash = 23 * hash + this.working_memory;
        return hash;
    }

    @Override
    public String toString() {
       return getClass().getName() + "@capasity=" + capasity + 
               "; working memory=" + working_memory; 
    }
}
