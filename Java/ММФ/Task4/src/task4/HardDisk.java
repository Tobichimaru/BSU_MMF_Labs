
package task4;

/**
 * @author Saia
 */

public class HardDisk {
    private int capasity;
    private boolean virus;
    
    public HardDisk() {
        capasity = 100;
        virus = (Math.random() < 0.5);
    }
    
    public int getCapasity() {
        return capasity;
    }
    
    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }
    
    public boolean hasVirus() {
        return virus;
    }
    
    public void clearVirus() throws HardDiskHasNotVirusException {
        if (virus)
            virus = false;
        else 
            throw new HardDiskHasNotVirusException();
    }
    
    @Override
    public boolean equals(Object obj) { 
        if (this == obj) return true;
        if (obj == null) return false; 
        if (obj instanceof HardDisk){ //warning 
            HardDisk temp = (HardDisk) obj; 
            return (this.capasity == temp.capasity && this.virus == temp.virus); 
        } else 
            return false;
    } 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.capasity;
        hash = 41 * hash + (this.virus ? 1 : 0);
        return hash;
    }

    
    
    @Override
    public String toString() {
       return getClass().getName() + "@capasity=" + capasity + "; virus=" + virus; 
    }

   public class HardDiskHasNotVirusException extends Exception {
        public HardDiskHasNotVirusException() {
            System.out.println("Hard Disk has no viruses to delete\n");
        }
   }
}
