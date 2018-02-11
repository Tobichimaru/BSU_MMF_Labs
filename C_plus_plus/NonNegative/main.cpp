#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char** argv) {
    long long n;
    cin >> n;
    
    long long answer = 0;
    for(long long b = 0; b * b * b <= n; b++) {
        long long a = n - b * b * b;
        long long l = 0, r = 1000000000;
        
        while (l < r) {
            long long m = (l + r) / 2;
            if (m * m >= a) 
                r = m; 
            else l = m + 1;
        }
        if (l * l == a)
            ++answer;
    }
    
    cout << answer << endl;
    return 0;
}
