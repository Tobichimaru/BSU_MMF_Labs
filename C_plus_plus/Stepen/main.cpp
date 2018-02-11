#include <iostream>
#include <cmath>

using namespace std;

double Stepen(double x, int n) {

    double ans = 1;
    for (int i = 1; i <= fabs(n); i++) {
        ans *= x;
    }
    if (n < 0) ans = 1/ans;
    return ans;
}


int main()
{
    int k = 0;
    double a;

    cout << "Input integer k:" << endl;
    cin >> k;
    cout << "Input number a:" << endl;
    cin >> a;
    double b = Stepen(2.7, k) + Stepen(a + 1, -5);
    cout << "The result is: " << b << endl;
    return 0;
}
//
