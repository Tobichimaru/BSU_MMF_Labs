/*
 * Создать и реализовать интерфейсы, также использовать наследование и полиморфизм 
 *  для следующих предметных областей:
 *  interface Корабль 
 *  abstract class Военный Корабль  
 *  class Авианосец
 */

package shipsapp;

interface Ship {
    public void echo();
}

abstract class Warship implements Ship {
    @Override
    public void echo() {
        System.out.println("I am a warship!");
    }
}

class AircraftCarrier extends Warship {
    @Override
    public void echo() {
        System.out.println("I am a Aircraft Carrier!");
    }
}

class SomeWarship extends Warship {
    
}

public class ShipsApp {

    public static void main(String[] args) {
        AircraftCarrier a = new AircraftCarrier();
        a.echo();
        
        Warship b = new AircraftCarrier();
        b.echo();
        
        Ship c = new AircraftCarrier();
        c.echo();
        
        SomeWarship d = new SomeWarship();
        d.echo();
    }    
}
