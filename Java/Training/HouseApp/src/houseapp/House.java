
package houseapp;

import java.security.InvalidParameterException;

/*
    Класс, описывающий дом
*/

public class House {
    //статический счетчик экземпляров класса
    private static int counter;
    
    private int id;
    private String streetName;
    private HouseType houseType; //тип дома
    private Apartament[] apartaments; //список квартир
    private int operatingPeriod; //срок эксплуатации
    
    //Статический конструктор, вызывается один раз за время работы приложения
    static {
        counter = 0;
    }
    
    //конструктор
    public House(String street, HouseType house, int period) {
        initialize(street, house, period, null);
        counter++;
        id = counter;
    }
    
    //конструктор
    public House(String street, HouseType house, int period, Apartament[] array) {
        initialize(street, house, period, array);
        counter++; 
        id = counter;
    }
    
    //конструктор копирования
    public House(House other) {
        id = other.id;
        initialize(other.streetName, other.houseType, other.operatingPeriod, 
                other.apartaments);
    }
    
    public HouseType getType() {
        return houseType;
    }
    
    public Apartament[] getApartaments() {
        //array copy
        Apartament[] other = new Apartament[apartaments.length];
        System.arraycopy(apartaments, 0, other, 0, apartaments.length);
        
        return other;
    }
    
    public void setType(HouseType type) {
        houseType = type;
    }
    
    public String toString() {
        return "House ID: " + Integer.toString(id)
                + "\n Street: " + streetName
                + "\n House type: " + houseType.name()
                + "\n Operating period: : " + Integer.toString(operatingPeriod) + " months"
                + "\n Number of Apartaments: " + Integer.toString(apartaments.length)
                + "\n";
    }
    
    //инициализатор полей
    private void initialize(String street, HouseType house, int period, Apartament[] array) {
        //проверка входных данных
        if (period <= 0) 
            throw new InvalidParameterException("Operating period should be positive!");
        
        streetName = street;
        houseType = house;
        operatingPeriod = period;
        
        //копируем массив
        apartaments = new Apartament[array.length];
        System.arraycopy(array, 0, apartaments, 0, array.length);
    }
    
}
