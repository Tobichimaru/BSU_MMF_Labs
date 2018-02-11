/* 
 * File:   main.cpp
 * Author: Mary Safonova
 * Created on 20 мая 2016 г., 0:45
 */

#define WINVER 0x0500
#define _WIN32_WINNT 0x0500
#pragma comment(lib, "Gdi32.lib")
#pragma comment(lib, "libgdi32.a") 

#include <cstdlib>
#include <functional>
#include <windows.h>
#include <stdlib.h>
#include <cmath>
#include <iostream>
#include <cmath>

using namespace std;

class oneParamFunction
{
    public:
        oneParamFunction(double (*funcPtr)(double)) 
        {
            this->funcPtr = funcPtr;
        }
        
        oneParamFunction(const oneParamFunction& other) 
        {
            funcPtr = other.funcPtr;
        }
        
        virtual ~oneParamFunction() {}

        double operator() (double p) const 
        {
            return funcPtr(p);
        }

        double integrate(double a, double b)
        {
            double h = 0.0001;
            double x = a;
            double S = 0;
            while(x < b)
            {
                S = S + 0.5*(funcPtr(x + h) + funcPtr(x))*h;
                x = x + h;
            }
            return S;
        }
        
        double derivative(double x)
        {
            double dx = 0.0001;
            return (funcPtr(x) - funcPtr(x+dx))/dx;
        }
        
        void tabulation(double a, double b, double h)
        {
            if (h <= 0) h = 0.001;
            for (double x = a; x <= b; x += h)
            {
                double t = funcPtr(x);
                std::cout.precision(2);
                std::cout<< "f(" << x << ") = " << t << std::endl; 
            }
        }
        
        void plot(double a, double b)
        {
            double x;
            HDC hDC = GetDC(GetConsoleWindow());
            HPEN Pen = CreatePen(PS_SOLID, 5, RGB(0, 0, 0));
            SelectObject(hDC, Pen);
            MoveToEx(hDC, 200, 400, NULL);
            LineTo(hDC, 800, 400);
            MoveToEx(hDC, 500, 200, NULL);
            LineTo(hDC, 500, 600);
            for (x = a; x <= b; x += 0.1)
            {
                MoveToEx(hDC, 50 * x + 500, -50 * funcPtr(x) + 400, NULL);
                LineTo(hDC, 50 * x + 500, -50 * funcPtr(x) + 400);
            }
        }

    private:
        double (*funcPtr)(double); //ссылка на функцию
};

double myFunc(double x) {
    return 2*x;
}

int main()
{
    oneParamFunction func(myFunc);
    cout << func.integrate(-1, 1) << endl;
    cout << func.derivative(3.2) << endl;
    func.tabulation(-1, 1, 0.25);
    
    func.plot(-2*3.14, 2*3.14);
    
    return 0;
}


