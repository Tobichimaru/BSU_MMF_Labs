package task6;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 * @task Создать классы, спецификации которых приведены ниже. Определить кон-
структоры и методы setТип(), getТип(), toString(). Определить допол-
нительно методы в классе, создающем массив объектов. Задать критерий выбора
данных и вывести эти данные на консоль.
* Phone: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Дебет, 
* Кредит, Время городских и междугородных разговоров.
Создать массив объектов. Вывести:
a) сведения об абонентах, у которых время внутригородских разговоров 
* превышает заданное;
b) сведения об абонентах, которые пользовались междугородной связью;
c) сведения об абонентах в алфавитном порядке.
 * @author Saia
 */

public class Task6 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       Phone phones[] = null;
       int n = 0;
       try {
        String filePath = "C:\\Users\\Saia\\Documents\\GitHub\\Java\\ММФ\\Task6\\src\\task6\\input.txt";
        FileReader fr = new FileReader(filePath);
        Scanner scan = new Scanner(fr);
                
        double credit, debit, inTime, outTime;
        String firstName, lastName, thirdName, adress, cardId;
        
        n = scan.nextInt();
        scan.nextLine();
        phones = new Phone[n];
        for (int i = 0; i < n; i++) {
            firstName = scan.nextLine();
            lastName = scan.nextLine();
            thirdName = scan.nextLine();
            adress = scan.nextLine();
            cardId = scan.nextLine();
            debit = scan.nextDouble();
            credit = scan.nextDouble();
            inTime = scan.nextDouble();
            outTime = scan.nextDouble();
            scan.nextLine();
            phones[i] = new Phone(firstName, lastName, thirdName, adress, 
                    cardId, debit, credit, inTime, outTime);
        }
       } catch (FileNotFoundException e) { 
            System.err.println(e);
       }
       
       System.out.println("This abonents have used global calls: ");
       for (int i = 0; i < n; i++) {
           if (phones[i].getOutTime() > 0) {
                System.out.println(phones[i].getName());
           }
       }
       
       System.out.println("\nThis abonents have used local calls more than 60sc: ");
       for (int i = 0; i < n; i++) {
           if (phones[i].getInTime() > 60) {
                System.out.println(phones[i].getName());
           }
       }
    }
    
}
