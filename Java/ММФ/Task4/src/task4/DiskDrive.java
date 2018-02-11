
package task4;

/**
 * @author Saia
 */

public class DiskDrive {
    private boolean empty;
    
    public DiskDrive () {
        empty = true;
    }
    
    public boolean isEmpty() {
        return empty;
    }
    
    public void insertDisk() throws DiskDriveHasDiskException {
        if (empty) {
            empty = false;
        } else {
            throw new DiskDriveHasDiskException();
        }
    }
    
    public void removeDisk() throws DiskDriveIsEmptyException {    
        if (empty) {
            throw new DiskDriveIsEmptyException();
        } else {
            empty = true;
        }
    }
    
    @Override
    public boolean equals(Object obj) { 
        if (this == obj) return true;
        if (obj == null) return false; 
        if (obj instanceof DiskDrive){ //warning 
            DiskDrive temp = (DiskDrive) obj; 
            return (this.hashCode() == temp.hashCode()); 
        } else 
            return false;
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.empty ? 1 : 0);
        return hash;
    }
    
    @Override
    public String toString() {
       return getClass().getName() + "@isEmpty=" + empty; 
    }
    
    
    public class DiskDriveIsEmptyException extends Exception {
        public DiskDriveIsEmptyException() {
            System.out.println("Disk Drive is empty!\n");
        }
    }
    
    public class DiskDriveHasDiskException extends Exception {
        public DiskDriveHasDiskException() {
            System.out.println("Disk Drive already has disk inside!\n");
        }
    }
}
