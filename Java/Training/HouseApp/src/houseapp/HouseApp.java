
/*
    Создать классы, спецификации которых приведены ниже. Определить конструкторы 
 и методы setТип(), getТип(), toString(). 
    Определить дополнительно методы в классе, создающем массив объектов. Задать 
 критерий выбора данных и вывести эти данные на консоль. В каждом классе, 
 обладающем информацией, должно быть объявлено несколько конструкторов.

 House: id, Номер квартиры, Площадь, Этаж, Количество комнат, 
 Улица, Тип здания, Срок эксплуатации.

 Создать массив объектов. Вывести:
  a) список квартир, имеющих заданное число комнат;
  b) список квартир, имеющих заданное число комнат и расположенных на этаже, 
        который находится в заданном промежутке;
  c) список квартир, имеющих площадь, превосходящую заданную.

 */

package houseapp;

public class HouseApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //инициализируем дома
        House house1 = new House("ul. Lenina", HouseType.BLOCK, 320, 
        new Apartament[] {
            new Apartament(404, 100, 5, 3),
            new Apartament(208, 10.9, 10, 1),
            new Apartament(999, 29.4, 3, 5),
            new Apartament(23, 30, -1, 2)
        });
        
        House house2 = new House("ul. Tanka", HouseType.WOOD, 100, 
        new Apartament[] {
            new Apartament(2, 15.1, 2, 2),
            new Apartament(3, 20.1, 5, 1),
        });
        
        House house3 = new House("ul. Mira", HouseType.BRICK, 200, 
        new Apartament[] {
            new Apartament(1, 15, 6, 2),
            new Apartament(3, 30.5, 5, 1),
            new Apartament(208, 10, 8, 1),
        });
        
        //массив домов
        House[] houses = {house1, house2, house3};
        for (int i = 0; i < houses.length; i++) {
            System.out.println(houses[i].toString());
        }
        
        //a) список квартир, имеющих заданное число комнат;
        int numberOfRooms = 2; //задаем искомое число комнат
        System.out.println("a) Number of rooms = " + Integer.toString(numberOfRooms));
        for (int i = 0; i < houses.length; i++) {
            //для каждого дома берем список комнат
            Apartament[] a = houses[i].getApartaments();
            for (int j = 0; j < a.length; j++) {
                if (a[j].getNumberOfRooms() == numberOfRooms)
                    System.out.println(a[j].toString()); 
            }
        }
        
        //b) список квартир, имеющих заданное число комнат и расположенных на этаже, 
        //который находится в заданном промежутке;
        int l = 2, r = 5; //задаем промежуток
        System.out.println("b) Floors from " + Integer.toString(l) + " to " + Integer.toString(r));
        for (int i = 0; i < houses.length; i++) {
            Apartament[] a = houses[i].getApartaments();
            for (int j = 0; j < a.length; j++) {
                if (a[j].getFloor() >= l && a[j].getFloor() <= r)
                    System.out.println(a[j].toString()); 
            }
        }
        
        //c) список квартир, имеющих площадь, превосходящую заданную.
        double area = 20;
        System.out.println("c) Area > " + String.valueOf(area));
        for (int i = 0; i < houses.length; i++) {
            Apartament[] a = houses[i].getApartaments();
            for (int j = 0; j < a.length; j++) {
                if (a[j].getArea() > area)
                    System.out.println(a[j].toString()); 
            }
        }
    }
    
}
