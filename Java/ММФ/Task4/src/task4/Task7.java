package task4;

/**
 * @task Создать объект класса Компьютер, используя классы Винчестер, 
 * Дисковод, ОЗУ. Методы: включить, выключить, проверить на вирусы, 
 * вывести на консоль размер винчестера. Создать приложение, удовлетворяющее 
 * требованиям, приведенным в задании. Аргументировать принадлежность классу 
 * каждого создаваемого метода и корректно переопределить
 * для каждого класса методы equals(), hashCode(), toString().
 * @author Saia
 */

public class Task7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.turnOn();
        System.out.println(computer.toString());
        computer.clearVirus();
        System.out.println(computer.toString());
    }
    
}
