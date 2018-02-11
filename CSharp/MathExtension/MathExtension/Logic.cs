using System;
using System.Diagnostics;

namespace MathExtension
{
    public static class MathFunctions
    {
        public static int GcdEuclid(int a, int b)
        {
            double time;
            return GcdEuclid(a, b, out time);
        }

        public static int GcdEuclid(int a, int b, out double time)
        {
            var timer = Stopwatch.StartNew();
            while (b != 0 && a != 0)
            {
                if (a > b) a %= b;
                else b %= a;
            }

            timer.Stop();
            time = timer.Elapsed.TotalMilliseconds;
            return b == 0 ? a : b;
        }

        public static int GcdBinary(int a, int b)
        {
            double time;
            return GcdBinary(a, b, out time);
        }

        public static int GcdBinary(int a, int b, out double time)
        {
            var timer = Stopwatch.StartNew();
            if (a == 0 || b == 0)
            {
                timer.Stop();
                time = timer.Elapsed.TotalMilliseconds;
                if (a == 0) return b;
                if (b == 0) return a;
            }
            int shift;
            for (shift = 0; ((a | b) & 1) == 0; ++shift)
            {
                a >>= 1;
                b >>= 1;
            }
            while ((a & 1) == 0) a >>= 1;
            do
            {
                while ((b & 1) == 0) b >>= 1;
                if (a > b) Swap(ref a, ref b);
                b -= a;
            } while (b != 0);

            time = timer.Elapsed.TotalMilliseconds;
            return a << shift;
        }

        public static int GcdEuclid(params int[] a)
        {
            double time;
            return GcdEuclid(out time, a);
        }

        public static int GcdEuclid(out double time, params int[] a)
        {
            var timer = Stopwatch.StartNew();

            if (a == null) throw new ArgumentNullException();
            if (a.Length == 0)
            {
                timer.Stop();
                time = timer.Elapsed.TotalMilliseconds;
                return 0;
            }

            var gcd = a[0];
            time = 0;
            for (var i = 1; i < a.Length; i++)
            {
                double funcTime;
                gcd = GcdEuclid(a[i], gcd, out funcTime);
                time += funcTime;
            }
            timer.Stop();
            time += timer.Elapsed.TotalMilliseconds;
            return gcd;
        }

        public static int GcdBinary(params int[] a)
        {
            double time;
            return GcdBinary(out time, a);
        }

        public static int GcdBinary(out double time, params int[] a)
        {
            var timer = Stopwatch.StartNew();

            if (a == null) throw new ArgumentNullException();
            if (a.Length == 0)
            {
                timer.Stop();
                time = timer.Elapsed.TotalMilliseconds;
                return 0;
            }

            var gcd = a[0];
            time = 0;
            for (var i = 1; i < a.Length; i++)
            {
                double funcTime;
                gcd = GcdBinary(a[i], gcd, out funcTime);
                time += funcTime;
            }
            timer.Stop();
            time += timer.Elapsed.TotalMilliseconds;
            return gcd;
        }

        private static void Swap(ref int a, ref int b)
        {
            var t = b;
            b = a;
            a = t;
        }

        public static double NRoot(double a, int n, double eps)
        {
            if (n < 1)
            {
                throw new ArgumentException();
            }
            double ans = 1, p = 1, m = n;
            do
            {
                ans = (1 / m) * ((m - 1) * ans + a / p);
                p = BinPower(ans, n - 1);
            } while (Math.Abs(a - p*ans) > eps);
            return ans;
        }

        private static double BinPower(double a, int n)
        {
            if (n == 0)
		        return 1;
	        if (n % 2 == 1)
		        return BinPower(a, n-1) * a;
            double b = BinPower(a, n/2);
            return b * b;
        }           
    }
}
