/*
 Создать приложение, удовлетворяющее требованиям, приведенным в задании. 
 Наследование применять только в тех заданиях, в которых это логически обосновано. 
 Аргументировать принадлежность классу каждого создаваемого метода и корректно 
 переопределить для каждого класса методы equals(), hashCode(), toString():
 
 Создать объект класса Звездная система, используя классы Планета, Звезда, Луна. 
 Методы: вывести на консоль количество планет в звездной системе, название звезды, 
 добавление планеты в систему.

 При возникновении ощибок, генерировать и обрабатывать исключительные ситации
 Предусмотреть обработку исключений при нехватке памяти, отсутствию требуемой записи,
 ннедопустимом значении поля и так далее.


 */

package solarsystemapp;

import java.security.InvalidParameterException;

public class SolarSystemApp {

    public static void main(String[] args) {
        Star star = new Star("Sun");
        SolarSystem system = new SolarSystem(star);
        
        system.addPlanet(new Planet("Mercury", 150));
        system.addPlanet(new Planet("Venus", 200));
        system.addPlanet(new Planet("Earth", 320));
        system.addPlanet(new Planet("Mars", 500));
        system.addPlanet(new Planet("Jupiter", 800));
        system.addPlanet(new Planet("Saturn", 1000));
        system.addPlanet(new Planet("Uranus", 400));
        system.addPlanet(new Planet("Neptune", 100));
        
        System.out.println("Number of planets: " 
                + Integer.toString(system.getNumberOfPlanets()));
        System.out.println(system.toString());
        
        Moon moon = new Moon();
        system.addPlanet(moon);
        
        System.out.println(moon.toString());
        System.out.println("Number of planets: " 
                + Integer.toString(system.getNumberOfPlanets()));
        
        try {
            Planet planet = new Planet("Some Planet", -1);
        } catch (InvalidParameterException er) {
            System.out.println("Invalid argument: " + er.getMessage());
        }
        
        try {
            while (true) {
                system.addPlanet(new Planet("Some Planet", 1));
            }
        } catch (OutOfMemoryError er) {
            System.out.println("System was overloaded: " + er.getMessage());
        }
    }
    
}
