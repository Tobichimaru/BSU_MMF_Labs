#include <iostream>
#include <math.h>

using namespace std;

const double eps = 0.001;
const double PI = 3.1415926535897;

double func(double x) {
    return (pow(PI, 2)*x - PI*pow(x, 2))/8;
}

double sum(double x, int k) {
    return sin((2*k + 1)*x)/pow(2*k + 1, 2);
}

void printResult(double x) {
    double f = func(x);
    double f_sum = 0;
    int k = 0;
    do {
        k++;
        f_sum += sum(x, k);
    } while (fabs(f - f_sum) > eps && k < 1000);
    cout << "Calculation for x: " << x << endl;
    cout << "The value of F(x): " << f << endl;
    cout << "Approximation F(x): " << f_sum << endl;
    cout << "The number of members in the sum: " << k << endl<< endl;
}

int main()
{
    printResult(0.05);
    printResult(0.5);
    printResult(3);
    return 0;
}
