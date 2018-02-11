#include <iostream>

using namespace std;

void printArray(int** a, int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            cout << a[i][j] << ' ';
        cout << endl;
    }
}

void swapMinMax(int** a, int n, int m) {
    int min = a[0][0], i_min = 0, j_min = 0;
    int max = a[0][0], i_max = 0, j_max = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] < min) {
                min = a[i][j];
                i_min = i;
                j_min = j;
            }
            if (a[i][j] > max) {
                max = a[i][j];
                i_max = i;
                j_max = j;
            }
        }
        cout << endl;
    }
    a[i_min][j_min] = max;
    a[i_max][j_max] = min;
}

int main()
{
    int n, m;
    cout << "Print the dimensions of the matrix in the format: n m" << endl;
    cin >> n >> m;
    if (n <= 0 || m <= 0) {
        cout << "Invalid dimension!" << endl;
        return 0;
    }

    int** a;
    a = new int*[n];
    for (int i = 0; i < n; i++)
        a[i] = new int[m];

    cout << endl << "Print the elements of the 2-dimensional array:" << endl;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> a[i][j];
    cout << endl << "The input array:" << endl;
    printArray(a, n, m);
    swapMinMax(a, n, m);
    cout << "The min and max element have been swapped:" << endl;
    printArray(a, n, m);

    return 0;
}
