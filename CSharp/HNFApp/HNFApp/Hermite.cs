using System;

namespace HNFApp
{
    public class Hermite
    {
        private int[][] a;
        private int m, n;
        private int i, k, l, b;
        private int[][] w;

        public void initialize(int[][] a, int n, int m)
        {
            this.a = a;
            this.n = n;
            this.m = m;
            w = new int[m][];
            for (int j = 0; j < m; j++)
                w[j] = new int[n];

            i = m;
            k = n;
            if (m <= n) l = 0;
            else l = m - n;
            finishLine();
        }

        private void finishLine()
        {
            bool flag = false;
            for (int j = 0; j < k; j++)
                if (a[j][i] != 0)
                {
                    flag = true;
                    break;
                }
            if (!flag && a[i][k] < 0)
            {
                for (int j = 0; j < m; j++)
                    a[j][k] = -a[j][k];
                finalReduce();
            }
            chooseElement();
        }

        private void chooseElement()
        {
            int min = Int32.MaxValue;
            int j0 = 0, var;
            for (int j = 0; j < k; j++)
                if (a[i][j] != 0 && Math.Abs(a[i][j]) < min)
                {
                    min = Math.Abs(a[i][j]);
                    j0 = j;
                }
            if (j0 < k)
                for (int j = 0; j < m; j++)
                {
                    var = a[j][j0];
                    a[j][j0] = a[j][k];
                    a[j][k] = var;
                }
            if (a[i][k] < 0)
            {
                for (int j = 0; j < m; j++)
                    a[j][k] = -a[j][k];
                b = a[i][k];
            }
            reduce();
        }

        private void reduce()
        {
            int q;
            for (int j = 0; j < k; j++)
            {
                q = a[i][j]/b;
                for (int t = 0; t < m; t++)
                    a[t][j] = a[t][j] - q*a[t][k];
            }
            finishLine();
        }

        private void finalReduce()
        {
            b = a[i][k];
            if (b == 0)
            {
                k++;
                finish();
            }
            else
            {
                int q;
                for (int j = k; j < m; j++)
                {
                    q = a[i][j]/b;
                    for (int t = 0; t < m; t++)
                        a[t][j] = a[t][j] - q*a[t][k];
                }
            }
            finish();
        }

        private void finish()
        {
            if (i == l) 
                for (int j = 0; j < n-k+1; j++)
                    for (int t = 0; t < m; t++)
                        w[t][j] = a[t][j + k - 1];
            else
            {
                i--;
                k--;
                finishLine();
            }
        }

        public int[][] getHNF()
        {
            return w;
        }
    }
}
