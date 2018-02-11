
using System.Collections.Generic;

namespace UnitTestProject
{
    public class MaxComparer: IComparer<int[]>
    {
        public int Compare(int[] a, int[] b)
        {
            return CompareFunctions.CompareMax(a, b);
        }
    }
}
