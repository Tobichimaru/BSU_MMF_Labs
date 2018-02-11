using System;
using MergeSortApp;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTests
{
    [TestClass]
    public class UnitTest
    {
       
        [TestMethod]
        public void SortIntegers()
        {
            int[] data = {9, 4, 5, 3, 2, 6, 1, 8, 7, 0};
            int[] expected = {9, 4, 1, 2, 3, 5, 6, 8, 7, 0};
            MergeSort.Sort(data, 2, 6);
            Assert.IsTrue(CompareArrays(data, expected));
        }

        [TestMethod]
        public void SortStrings()
        {
            String[] data = { "jade", "plum", "lust", "corn", "ecru", "pine", "navy", "mist", "leaf", "rose", "silk", "blue" };
            String[] expected = { "blue", "corn", "ecru", "jade", "leaf", "lust", "mist", "navy", "pine", "plum", "rose", "silk" };
            MergeSort.Sort(data);
            Assert.IsTrue(CompareArrays(data, expected));
        }

        [TestMethod]
        public void SortDouble()
        {
            double[] data = { 3.565656, 0.34234, -4.4545, 0.342341 };
            double[] expected = { -4.4545, 0.34234, 0.342341, 3.565656 };
            MergeSort.Sort(data);
            Assert.IsTrue(CompareArrays(data, expected));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentNullException))]
        public void SortNull()
        {
            int[] data = null;
            MergeSort.Sort(data);
        }

        private bool CompareArrays<T>(T[] lhs, T[] rhs) where T : IComparable 
        {
            if (ReferenceEquals(lhs, null) || ReferenceEquals(rhs, null)) return false;
            if (lhs.Length != rhs.Length) return false;

            for (int i = 0; i < lhs.Length; i++)
            {
                if (lhs[i].CompareTo(rhs[i]) != 0)
                    return false;
            }
            return true;
        }

    }
}
