using System;
using System.Collections.Generic;

namespace ArrayApplication
{
    public class Logic
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
            for (int i = 0; i < a.Length - 1; i++)
            {
                for (int j = i + 1; j < a.Length; j++)
                {
                    if (comparisonDelegate(a[i], a[j]) < 0)
                    {
                        Swap(ref a[i], ref a[j]);
                    }
                }
            }
        }

        public static int BinarySearch<T>(T[] a, T elem) where T: IComparable<T>
        {
            if (ReferenceEquals(a, null) || ReferenceEquals(elem, null))
            {
                throw new ArgumentNullException();
            }
            Sort(a, (lhs, rhs) => rhs.CompareTo(lhs));
            int l = 0, r = a.Length, i;
            while (l < r)
            {
                i = (l + r)/2;
                if (a[i].CompareTo(elem) < 0)
                    l = i + 1; 
                else if (a[i].CompareTo(elem) > 0)
                    r = i;
                else
                    return i;
            }
            return -1;
        }

        public static void Sort<T>(T[] a, IComparer<T> comparer)
        {
            if (ReferenceEquals(a, null) || (ReferenceEquals(comparer, null)))
            {
                throw new ArgumentNullException();
            }
            Sort(a, comparer.Compare);
        }

        private static void Swap<T>(ref T a, ref T b)
        {
            T varArr = a;
            a = b;
            b = varArr;    
        }
    }
}
