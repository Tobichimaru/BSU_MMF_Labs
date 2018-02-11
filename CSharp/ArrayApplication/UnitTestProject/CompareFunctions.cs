using System.Linq;

namespace UnitTestProject
{
    class CompareFunctions
    {
        public static int CompareSum(int[] a, int[] b)
        {
            if (ReferenceEquals(a, null) && ReferenceEquals(b, null)) return 0;
            if (ReferenceEquals(a, null)) return -1;
            if (ReferenceEquals(b, null)) return 1;
            if (a.Sum() < b.Sum()) return 1;
            if (a.Sum() > b.Sum()) return -1;
            return 0;
        }

        public static int CompareMin(int[] a, int[] b)
        {
            if (ReferenceEquals(a, null) && ReferenceEquals(b, null)) return 0;
            if (ReferenceEquals(a, null)) return -1;
            if (ReferenceEquals(b, null)) return 1;
            if (a.Min() < b.Min()) return 1;
            if (a.Min() > b.Min()) return -1;
            return 0;
        }

        public static int CompareMax(int[] a, int[] b)
        {
            if (ReferenceEquals(a, null) && ReferenceEquals(b, null)) return 0;
            if (ReferenceEquals(a, null)) return -1;
            if (ReferenceEquals(b, null)) return 1;
            if (a.Max() < b.Max()) return 1;
            if (a.Max() > b.Max()) return -1;
            return 0;
        }

    }
}

