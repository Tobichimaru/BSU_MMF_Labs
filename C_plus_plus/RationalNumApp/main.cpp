/* 
 * File:   main.cpp
 * Author: Mary Safonova
 * Created on 20 мая 2016 г., 9:41
 */

#include <cstdlib>
#include <iostream>
#include <stdexcept>
#include <sstream>
#include <cmath>

using namespace std;

class RationalNumber
{
    public:
        RationalNumber() 
        {
            m = 0;
            n = 1;
        }
        
        RationalNumber(int m, int n) 
        {
            if (m == 0) //Нельзя делить на ноль, выбрасываем исключение
                throw std::invalid_argument("Divisor can't be zero!");
            this->m = m;
            this->n = n;
            simplify();
        }
        RationalNumber(const RationalNumber& other) //конструктор копирования
        {
            m = other.m;
            n = other.n;
        }
        
        void add(const RationalNumber& other) 
        {
            m = m * other.n + other.m * n;
            n = n * other.n;
            simplify();
        }
        
        void subtract(const RationalNumber& other)
        {
            m = m * other.n - other.m * n;
            n = n * other.n;
            simplify();
        }
        
        void multiply(const RationalNumber& other)
        {
            m = m * other.m;
            n = n * other.n;
            simplify();
        }
        
        void divide(const RationalNumber& other) 
        {
            m = m * other.n;
            n = n * other.m;
            simplify();
        }

        RationalNumber operator+(const RationalNumber& other)
        {
            RationalNumber r(m, n);
            r.add(other);
            return r;
        }
        
        RationalNumber operator*(const RationalNumber& other)
        {
            RationalNumber r(m ,n);
            r.multiply(other);
            return r;
        }
        
        RationalNumber operator-(const RationalNumber& other) 
        {
            RationalNumber r(m, n);
            r.subtract(other);
            return r;
        }
        
        RationalNumber operator/(const RationalNumber& other) 
        {
            RationalNumber r(m, n);
            r.divide(other);
            return r;
        }

        std::string to_string()
        {
            std::ostringstream ss;
            ss << m << "/" << n;
            return ss.str();
        }

    private:
        int m; //делимое
        int n; //делитель

        void simplify() //сокращает дробь
        {
            int i = 2;
            while (i <= std::abs(m)) {
                while (m % i == 0 && n % i == 0) {
                    m = m/i;
                    n = n/i;
                }
                i++;
            }
        }
};


int main(int argc, char** argv) {
    int m, n;

    cout << "Print the first rational number in format: m n" << endl;
    cin >> m >> n;
    RationalNumber r1(m, n);
    cout << "First ratio:" << r1.to_string() << endl << endl;

    cout << "Print the second rational number in format: m n" << endl;
    cin >> m >> n;
    RationalNumber r2(m, n);
    cout << "Second ratio:" << r2.to_string() << endl << endl;

    cout << r1.to_string() << " + " << r2.to_string() << " = " << (r1+r2).to_string() << endl;
    cout << r1.to_string() << " - " << r2.to_string() << " = " << (r1-r2).to_string() << endl;
    cout << r1.to_string() << " * " << r2.to_string() << " = " << (r1*r2).to_string() << endl;
    cout << r1.to_string() << " : " << r2.to_string() << " = " << (r1/r2).to_string() << endl;

    return 0;
}

