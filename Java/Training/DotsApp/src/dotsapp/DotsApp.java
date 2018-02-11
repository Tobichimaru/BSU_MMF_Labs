/*
  Реализовать методы сложения, вычитания, умножения и деления объектов 
  (для тех классов, объекты которых могут поддерживать арифметические действия).
  
  Определить класс Точка на плоскости (в пространстве) и во времени. 
  1)Задать движение точки в определенном направлении. 
  2)Создать методы по определению скорости и ускорения точки.  
  3)Проверить для двух точек возможность пересечения траекторий. 
  4)Определить расстояние между двумя точками в заданный момент времени.
 */

package dotsapp;

public class DotsApp {

    public static void main(String[] args) {
        Point2D p1 = new Point2D(0, 0);
        //задаем вектор скорости и ускорения
        p1.setSpeed(new Vector2D(1, 1));
        p1.setAcceleration(new Vector2D(2, 2));
        
        Point2D p2 = new Point2D(2, 0);
        //задаем вектор скорости и ускорения
        p2.setSpeed(new Vector2D(-1, -1));
        p2.setAcceleration(new Vector2D(2, 2));
        
        //Проверяем метод поиска расстояния
        double t = 0;
        System.out.print("Distance between " + p1.toString() + " and " 
                + p2.toString() + " with t = " + String.valueOf(t) + ": ");
        System.out.println(p1.getDistanceTo(p2, t));
        
        t = 1;
        System.out.print("Distance between " + p1.toString(t) + " and " 
                + p2.toString(t) + " with t = " + String.valueOf(t) + ": ");
        System.out.println(p1.getDistanceTo(p2, t));
        
        t = 2;
        System.out.print("Distance between " + p1.toString(t) + " and " 
                + p2.toString(t) + " with t = " + String.valueOf(t) + ": ");
        System.out.println(p1.getDistanceTo(p2, t));
        
        //Проверим метод поиска пересечения
//        System.out.print("Intersection of " + p1.toString() + " and " 
//                + p2.toString() + ":");
//        Point2D result = p1.getIntersectionT(p2);
//        if (result == null) 
//            System.out.println("No intersection");
//        else System.out.println(result.toString());
        
        //Проверка метода сложения
        System.out.println(p1.toString() + " + " + p2.toString() + " = " + p1.Add(p2).toString());
        
        //Проверка метода сложения
        System.out.println(p1.toString() + " - " + p2.toString() + " = " + p1.Subtract(p2).toString());
    }
    
}
