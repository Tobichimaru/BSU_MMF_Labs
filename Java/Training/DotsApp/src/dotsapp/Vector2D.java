
package dotsapp;

public class Vector2D {
    double vx;
    double vy;
    
    public Vector2D(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }
    
    public Vector2D(Vector2D other) {
        vx = other.vx;
        vy = other.vy;
    }
    
    public double getVx() {
        return vx;
    }
    
    public double getVy() {
        return vx;
    }
    
    public void setVx(double vx) {
        this.vx = vx;
    }
    
    public void setVy(double vy) {
        this.vy = vx;
    }
    
    public Vector2D Add(Vector2D other) {
        Vector2D v = new Vector2D(other);
        v.vx += vx;
        v.vy += vy;
        return v;
    }
    
    public Vector2D Subtract(Vector2D other) {
        Vector2D v = new Vector2D(this);
        v.vx -= other.vx;
        v.vy -= other.vy;
        return v;
    }
}
