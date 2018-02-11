#include <iostream>
#include <algorithm>
#include <cstdlib>

using namespace std;

int main(int argc, char** argv) {
    long long f[500][500];
    int K, L;
    
    cin >> L >> K;
    f[0][0] = 1;
    
    for (int i = 0; i < L; i++) 
        for (int j = 0; j <= K; j++) 
            if (f[i][j] > 0) {
                f[i + 1][j] += f[i][j] * j;
                f[i + 1][j + 1] += f[i][j];
            }
    
    long long answer = f[L][K];
    long long fac = 1;
    
    for (int i = 1; i <= K; i++) 
        fac *= i;
    
    cout << answer * fac * (fac - 1) / 2LL << endl;
    return 0;
}