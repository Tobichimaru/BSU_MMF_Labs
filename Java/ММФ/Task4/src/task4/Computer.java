package task4;

import java.util.Objects;

/**
 * @author Saia
 */

public class Computer {
    private final HardDisk hard_disk;
    private final DiskDrive disk_drive;
    private final RAM ram;
    
    public Computer() {
        hard_disk = new HardDisk();
        disk_drive = new DiskDrive();
        ram = new RAM();
    }
    
    public void turnOn() {
        ram.setMemory(1);
    }
    
    public void turnOff() {
        ram.setMemory(0);
    }
    
    public void clearVirus() {
        try {
            hard_disk.clearVirus();
        } catch (HardDisk.HardDiskHasNotVirusException ex) {
        }
    }
    
    public int getHardDiskCapacity() {
        return hard_disk.getCapasity();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false; 
        if (obj instanceof Computer){ //warning 
            Computer temp = (Computer) obj; 
            return (this.hard_disk.equals(temp.hard_disk) && 
                    this.ram.equals(temp.ram) &&
                    this.disk_drive.equals(temp.disk_drive)); 
        } else return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.hard_disk);
        hash = 79 * hash + Objects.hashCode(this.disk_drive);
        hash = 79 * hash + Objects.hashCode(this.ram);
        return hash;
    }
    
    @Override
    public String toString() {
       return getClass().getName() + "\n " + hard_disk.toString() + 
               "\n " + disk_drive.toString() +
               "\n " + ram.toString(); 
    }
    
}


