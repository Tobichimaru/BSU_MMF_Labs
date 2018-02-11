
package task5;

/**
 * @author Saia
 */
public class Task5 {

    public static void main(String[] args) {
        Surgeon s = new Surgeon();
        s.whoIsIt();
        s = new NeuroSurgeon(30, 5000);
        s.whoIsIt();
        s = new Surgeon(45, 7000);
        s.whoIsIt();
    }
    
}
