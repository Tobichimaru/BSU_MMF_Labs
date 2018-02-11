
using System.Collections.Generic;

namespace UnitTestProject
{
    public class SumComparer: IComparer<int[]>
    {
        public int Compare(int[] a, int[] b)
        {
            return CompareFunctions.CompareSum(a, b);
        }
    }
}
