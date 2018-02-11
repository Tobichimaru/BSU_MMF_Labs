using System;
using System.Collections.Generic;

namespace MergeSortApp
{
    public static class MergeSort
    {
        public static void Sort<T>(T[] a, Comparison<T> comparisonDelegate = null)
        {
            if (ReferenceEquals(a, null))
                throw new ArgumentNullException();

            Sort(a, 0, a.Length - 1, comparisonDelegate);
        }

        public static void Sort<T>(T[] a, int left, int right, Comparison<T> comparisonDelegate = null)
        {
            if (ReferenceEquals(a, null))
                throw new ArgumentNullException();

            if (ReferenceEquals(comparisonDelegate, null))
            {
                comparisonDelegate = delegate(T lhs, T rhs)
                {
                    if (ReferenceEquals(lhs, null) && ReferenceEquals(rhs, null)) return 0;
                    if (ReferenceEquals(lhs, null)) return -1;
                    if (ReferenceEquals(rhs, null)) return 1;
                    return string.Compare(lhs.ToString(), rhs.ToString(), StringComparison.Ordinal);
                };
            }

            if (right <= left) return;

            T[] auxiliary = new T[a.Length];
            left = Math.Max(left, 0);
            right = Math.Min(right, a.Length);

            SortPart(a, auxiliary, comparisonDelegate, left, right);
        }


        public static void Sort<T>(T[] a, IComparer<T> comparer)
        {
            if (ReferenceEquals(a, null))
                throw new ArgumentNullException();

            Sort(a, 0, a.Length - 1, comparer);
        }

        public static void Sort<T>(T[] a, int left, int right, IComparer<T> comparer)
        {
            if (ReferenceEquals(comparer, null))
                Sort(a, left, right, comparer);
            else 
                Sort(a, left, right, comparer.Compare);
        }

       private static void SortPart<T>(T[] a, T[] auxiliary, Comparison<T> comparisonDelegate, int left, int right)
       {
            if (right <= left) return;
            int middle = left + (right - left)/2;
            SortPart(a, auxiliary, comparisonDelegate, left, middle);
            SortPart(a, auxiliary, comparisonDelegate, middle + 1, right);
            Merge(a, auxiliary, comparisonDelegate, left, middle, right);
       }

       private static void Merge<T>(T[] a, T[] auxiliary, Comparison<T> comparisonDelegate, int left, int middle, int right)
       {
           for (int k = left; k <= right; k++)
               auxiliary[k] = a[k];

           int lpi = left, rpi = middle + 1;
           for (int k = left; k <= right; k++)
           {
               if (lpi > middle)
                   a[k] = auxiliary[rpi++];
               else if (rpi > right)
                   a[k] = auxiliary[lpi++];
               else a[k] = comparisonDelegate(auxiliary[rpi], auxiliary[lpi]) < 0 ? auxiliary[rpi++] : auxiliary[lpi++];
           }
        }
    }
}
