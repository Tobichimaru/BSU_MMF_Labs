package task6;

/**
 * @author Saia
 */

public class Phone {
    private static int count = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String thirdName;
    private String adress;
    private String cardId;
    private double debit;
    private double credit;
    private double inTime;
    private double outTime;
    
    public Phone() {
       this("", "", "", "", "", 0, 0, 0, 0);
    }
    
    public Phone(String firstName, String lastName, String thirdName, 
            String adress, String cardId, double debit, double credit, 
            double inTime, double outTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.adress = adress;
        this.cardId = cardId;
        this.debit = debit;
        this.credit = credit;
        this.inTime = inTime;
        this.outTime = outTime;
        ++count;
        id = count;
    }
    
    public String toString() {
        return "First name: " + firstName + 
                "\nLast name: " + lastName + 
                "\nThird name: " + thirdName + 
                "\nAdress: " + adress + 
                "\nCard Id: " + cardId + 
                "\nDebit: " + debit + 
                "\nCredit: " + credit + 
                "\nLocal calls: " + inTime + "sc" +
                "\nGlobal calls: " + inTime + "sc\n";
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return firstName + " " + lastName + " " + thirdName;
    }
    
    public String getAdress() {
        return adress;
    }
    
    public String getCardId() {
        return cardId;
    }
    
    public double getDebit() {
        return debit;
    }
    
    public double getCredit() {
        return credit;
    }
    
    public double getInTime() {
        return inTime;
    }
    
    public double getOutTime() {
        return outTime;
    }
    
    public void setName(String firstName, String lastName, String thirdName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    
    public void setDebit(double debit) {
        this.debit = debit;
    }
    
    public void setCredit(double credit) {
        this.credit = credit;
    }
    
    public void setTime(double inTime, double outTime) {
        this.inTime = inTime;
        this.outTime = outTime;
    }
}
