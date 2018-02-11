
package dotsapp;

public class Point2D {
    //начальные координаты точки
    private double x;
    private double y;    
    
    private Vector2D v; //направленная скорость
    private Vector2D a; //направленное ускорение
    
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point2D(Point2D other) {
        x = other.x;
        y = other.y;
        v = new Vector2D(other.getSpeed());
        a = new Vector2D(other.getAcceleration());
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    //координата x в заданный момент времени t
    public double getX(double t) {
        return x + v.getVx()*t + 0.5*a.getVx()*t*t;
    }
    
    //координата y в заданный момент времени t
    public double getY(double t) {
        return y + v.getVy()*t + 0.5*a.getVy()*t*t;
    }
    
    public Vector2D getSpeed() {
        return v;
    }
    
    public void setSpeed(Vector2D v) {
        this.v = new Vector2D(v);
    }
    
    public Vector2D getAcceleration() {
        return a;
    }
    
    public void setAcceleration(Vector2D a) {
        this.a = new Vector2D(a);
    }
    
    public String toString() {
        return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
    }
    
    public String toString(double t) {
        return "(" + String.valueOf(getX(t)) + ", " + String.valueOf(getY(t)) + ")";
    }
    
    //сложение точек
    public Point2D Add(Point2D other) {
        Point2D p = new Point2D(other);
        p.x += x;
        p.y += y;
        p.v.Add(v);
        p.a.Add(a);
        return p;
    }
    
    //вычитание точек
    public Point2D Subtract(Point2D other) {
        Point2D p = new Point2D(this);
        p.x -= other.x;
        p.y -= other.y;
        p.v.Subtract(other.getSpeed());
        p.a.Subtract(other.getAcceleration());
        return p;
    }
    
    public double getDistanceTo(Point2D other, double t) {
        //координаты текущей точки в момент времени t
        double xt = getX(t);
        double yt = getX(t);
        
        //координаты второй точки в момент времени t
        double xt_other = other.getX(t);
        double yt_other = other.getY(t);
        
        //Декартово расстояние
        return Math.sqrt(Math.pow(xt - xt_other, 2) + Math.pow(yt - yt_other, 2));
    }
    
//    public Point2D getIntersectionT(Point2D other) {
//        
//    }
}
