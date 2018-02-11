using System;
using System.Collections.Generic;

namespace ArrayApplication
{
    public class OtherLogic
    {
        public static void Sort<T>(T[] a, Comparison<T> comparisonDelegate)
        {
            if (ReferenceEquals(a, null))
            {
                throw new ArgumentNullException();
            }
            if (ReferenceEquals(comparisonDelegate, null))
            {
                comparisonDelegate = delegate(T lhs, T rhs)
                {
                    if (ReferenceEquals(lhs, null) && ReferenceEquals(rhs, null)) return 0;
                    if (ReferenceEquals(lhs, null)) return -1;
                    if (ReferenceEquals(rhs, null)) return 1;
                    if (lhs.GetHashCode() < rhs.GetHashCode())
                        return 1;
                    if (lhs.GetHashCode() > rhs.GetHashCode())
                        return -1;
                    return 0;
                };
            }
            Adapter<T> adapter = new Adapter<T>(comparisonDelegate);
            Sort(a, adapter);
        }

        public static void Sort<T>(T[] a, IComparer<T> comparer)
        {
            if (ReferenceEquals(a, null) || (ReferenceEquals(comparer, null)))
            {
                throw new ArgumentNullException();
            }
            for (int i = 0; i < a.Length - 1; i++)
            {
                for (int j = i + 1; j < a.Length; j++)
                {
                    if (comparer.Compare(a[i], a[j]) < 0)
                    {
                        Swap(ref a[i], ref a[j]);
                    }
                }
            }
        }

        private static void Swap<T>(ref T a, ref T b)
        {
            T varArr = a;
            a = b;
            b = varArr;
        }

        private class Adapter<T> : IComparer<T>
        {
            private readonly Comparison<T> comparisonDelegate;

            public Adapter(Comparison<T> comparisonDelegate)
            {
                this.comparisonDelegate = comparisonDelegate;
            }

            public int Compare(T a, T b)
            {
                return comparisonDelegate(a, b);
            }
        }
    }
}
