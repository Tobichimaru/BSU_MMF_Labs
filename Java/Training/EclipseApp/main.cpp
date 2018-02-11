
#include <cstdlib>
#include <iostream>
#include <cmath>

using namespace std;

struct Point {
 public: 
    double x;
    double y;
    double z;
    
    Point(double _x, double _y, double _z) {
        x = _x;
        y = _y;
        z = _z;
    }
};

Point Intersection(double xo, double yo, double zo, double p, double q, double r, 
        double x1, double y1, double z1, double p1, double q1, double r1) {
    double x=(xo*q*p1-x1*q1*p-yo*p*p1+y1*p*p1)/(q*p1-q1*p);
    double y=(yo*p*q1-y1*p1*q-xo*q*q1+x1*q*q1)/(p*q1-p1*q);
    double z=(zo*q*r1-z1*q1*r-yo*r*r1+y1*r*r1)/(q*r1-q1*r);
    return Point(x,y,z);
}

double dist(double x, double y, double z, double x1, double y1, double z1) {
    return sqrt(pow(x-x1,2) + pow(y-y1, 2) + pow(z-z1,2));
}

int main(int argc, char** argv) {
    long x1, x2, x3, y1, y2, y3, z1, z2, z3, r1, r2, r3;
//    cin >> x1 >> y1 >> z1 >> r1;
//    cin >> x2 >> y2 >> z2 >> r2;
//    cin >> x3 >> y3 >> z3 >> r3;
    x1 = 0; y1 = 0; z1 = 0; r1 = 10;
    x2 = 50; y2 = 0; z2 = 100; r2 = 40;
    x3 = 60; y3 = 0; z3 = 200; r3 = 1;

    //Направляющий вектор прямой через центры звезды и первого тела
    double d = dist(x1, y1, z1, x2, y2, z2);
    double ax = (x2-x1)/d;
    double ay = (y2-y1)/d;
    double az = (z2-z1)/d;

    //Нормальный вектор
    double _bx = ax;
    double _by = ay;
    double _bz = -(ay*_by + az*_bz)/ax; 
    double bx = _bx/(sqrt(_bx*_bx + _by*_by + _bz*_bz));
    double by = _by/(sqrt(_bx*_bx + _by*_by + _bz*_bz));
    double bz = _bz/(sqrt(_bx*_bx + _by*_by + _bz*_bz));
    
    //Точка на поверхности звезды
    double x4, y4, z4;
    x4 = x1 + r1*bx;
    y4 = y1 + r1*by;
    z4 = z1 + r1*bz;
    cout << "p4:" << x4 << " " << y4 << " " << z4 << endl;
    cout << "dist: " << sqrt(pow((x4-x1), 2) + pow((y4-y1), 2) + pow((z4-z1), 2))<< endl;

    //Точка на поверхности первого тела
    double x5 = x2 + r2*bx;
    double y5 = y2 + r2*by;
    double z5 = z2 + r2*bz;
    cout << "p5:" << x5 << " " << y5 << " " << z5 << endl;
    cout << "dist:" << sqrt(pow((x5-x2), 2) + pow((y5-y2), 2) + pow((z5-z2), 2))<< endl;

    //Направляющий вектор прямой Umbra
    double d2 = dist(x4,y4,z4, x5,y5,z5);
    double cx = (x5-x4)/d2;
    double cy = (y5-y4)/d2;
    double cz = (z5-z4)/d2;
    
    //противоположная точка на первом теле
    double x6 = x2 - r2*bx;
    double y6 = y2 - r2*by;
    double z6 = z2 - r2*bz;
    
    //Ищем направляющий вектор Penumbra
    double d3 = dist(x4,y4,z4, x6,y6,z6);
    double dx = (x6-x4)/d;
    double dy = (y6-y4)/d;
    double dz = (z6-z4)/d;
    
    //противоположная точка на звезде
    double x7 = x1 - r1*bx;
    double y7 = y1 - r1*by;
    double z7 = z1 - r1*bz;
    //Ищем направляющий вектор Penumbra
    double d4 = dist(x5,y5,z5, x7,y7,z7);
    double ex = (x5-x7)/d;
    double ey = (y5-y7)/d;
    double ez = (z5-z7)/d;

    Point I = Intersection(x3,y3,z3, bx,by,bz, x1,y1,z1, ax,ay,az);
    cout << "I: " << I.x << " " << I.y << " " << I.z << endl;

    Point L = Intersection(x3,y3,z3, bx,by,bz, x5,y5,z5, cx,cy,cz);
    cout << "L: " << L.x << " " << L.y << " " << L.z << endl;
    
    Point R = Intersection(x3,y3,z3, bx,by,bz, x7,y7,z7, ex,ey,ez);
    cout << "R: " << R.x << " " << R.y << " " << R.z << endl;
    
    
    if (dist(I.x,I.y,I.z, x3,y3,z3) < dist(L.x,L.y,L.z, I.x,I.y,I.z) - r3) {
        cout << "Entire total solar eclipse";
        return 0;
    }
    
    if (dist(L.x,L.y,L.z, x3,y3,z3) < dist(L.x,L.y,L.z, I.x,I.y,I.z) + r3) {
        cout << "Part total solar eclipse";
        return 0;
    }
    
    if (dist(I.x,I.y,I.z, x3,y3,z3) < dist(R.x,R.y,R.z, I.x,I.y,I.z) - r3) {
        cout << "Entire partial solar eclipse";
        return 0;
    }
    
    if (dist(R.x,R.y,R.z, x3,y3,z3) < dist(R.x,R.y,R.z, I.x,I.y,I.z) + r3) {
        cout << "Part partial solar eclipse";
        return 0;
    }
    cout << "No solar eclipse";
    
    return 0;
}

