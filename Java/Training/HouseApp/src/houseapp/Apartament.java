
package houseapp;

import java.security.InvalidParameterException;

/*
    Класс, описывающий квартиру
*/

public class Apartament {
    private static int counter; //статический счетчик экземпляров класса
    
    private int id;
    private double area;
    private int floor;
    private int apartamentNumber;
    private int numberOfRooms;
    
    //Статический конструктор, вызывается один раз за время работы приложения
    static {
        counter = 0; 
    }
    
    //конструктор 
    public Apartament(int apartNumber, double area, int floor, int numberOfRooms) {
        //проверка входных данных
        if (area <= 0) 
            throw new InvalidParameterException("Area should be positive!");
        if (numberOfRooms <= 0) 
            throw new InvalidParameterException("Number of rooms should be positive!");
        if (apartNumber <= 0) 
            throw new InvalidParameterException("Apartaments number should be positive!");
        
        id = counter;
        counter++;
        apartamentNumber = apartNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
    }
    
    //конструктор копирования
    public Apartament(Apartament other) {
        id = other.id;
        area = other.area;
        floor = other.floor;
        numberOfRooms = other.numberOfRooms;
        apartamentNumber = other.apartamentNumber;
    }
    
    //получить площадь квартиры
    public double getArea() {
        return area;
    }
    
    //получить количество комнат
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    
    //получить этаж
    public int getFloor() {
        return floor;
    }
    
    public String toString() {
        return "Apartament ID: " + Integer.toString(id)
                + "\n №" + Integer.toString(apartamentNumber)
                + "\n Area: " + String.valueOf(area) + " sq.m.\n"
                + " Floor: " + Integer.toString(floor)
                + "\n Number of rooms: " + Integer.toString(numberOfRooms) + "\n";
    }
}
