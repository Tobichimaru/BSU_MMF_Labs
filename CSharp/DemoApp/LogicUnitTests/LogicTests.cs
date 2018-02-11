using System;
using DemoApp;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LogicUnitTests
{
    [TestClass]
    public class LogicTests
    {
        [TestMethod]
        public void CalculateSumGeneralTest()
        {
            int[] a = {1, 2, 0, 1, 1};
            Assert.AreEqual(Logic.CalculateSum(a), 5);
        }

        [TestMethod]
        public void CalculateSumNegativeNumbersTest()
        {
            int[] a = { 1, 2, 3, -1, -2 };
            Assert.AreEqual(Logic.CalculateSum(a), 3);
        }

        [TestMethod]
        public void CalculateSumNullTest()
        {
            int[] a = null;
            Assert.AreEqual(Logic.CalculateSum(a), 0);
        }

        [TestMethod]
        public void CalculateSumEmptyTest()
        {
            int[] a = {};
            Assert.AreEqual(Logic.CalculateSum(a), 0);
        }

        [TestMethod]
        [ExpectedException(typeof(OverflowException))]
        public void CalculateSumOverflowTest()
        {
            int[] a = { 1, int.MaxValue};
            int actual = Logic.CalculateSum(a);
        }
    }
}
