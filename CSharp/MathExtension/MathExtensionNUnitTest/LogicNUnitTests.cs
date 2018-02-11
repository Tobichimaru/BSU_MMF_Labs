using System;
using System.Collections.Generic;
using MathExtension;
using NUnit.Framework;

namespace MathExtensionNUnitTest
{
    [TestFixture]
    public class LogicNUnitTests
    {
        [Test, TestCaseSource(typeof(LogicFactoryClass), "TwoParamsTestData")]
        public int GcdEuclidTwoParamsWithYield(int a, int b)
        {
            return MathFunctions.GcdEuclid(a, b);
        }

        [Test, TestCaseSource(typeof(LogicFactoryClass), "TwoParamsTestData")]
        public int GcdBinaryTwoParamsWithYield(int a, int b)
        {
            return MathFunctions.GcdBinary(a, b);;
        }

        [Test, TestCaseSource(typeof(LogicFactoryClass), "SeveralParamsTestData")]
        public int GcdEuclidSeveralParamsWithYield(int[] a)
        {
            return MathFunctions.GcdEuclid(a);;
        }

        [Test, TestCaseSource(typeof(LogicFactoryClass), "SeveralParamsTestData")]
        public int GcdBinarySeveralParamsWithYield(int[] a)
        {
            return MathFunctions.GcdBinary(a);;
        }

        [Test, TestCaseSource(typeof(LogicFactoryClass), "NRootTestData")]
        public double NRootTestWithYield(double a, int n)
        {
            double eps = 0.000001;
            int epsN = 6;
            var actual = MathFunctions.NRoot(a, n, eps);
            return Math.Round(actual, epsN);
        }
    }

    public class LogicFactoryClass
    {
        public IEnumerable<TestCaseData> TwoParamsTestData
        {
            get
            {
                yield return new TestCaseData(10, 3).Returns(1);
                yield return new TestCaseData(250, 40).Returns(10);
                yield return new TestCaseData(0, 6).Returns(6);
            }
        }

        public IEnumerable<TestCaseData> SeveralParamsTestData
        {
            get
            {
                yield return new TestCaseData(new[]{0, 15, 9, 18, 0, 6}).Returns(3);
                yield return new TestCaseData(new[]{ 4, 16, 80, 8, 88, 32 }).Returns(4);
                yield return new TestCaseData(null).Throws(typeof (ArgumentNullException));
            }
        }

        public IEnumerable<TestCaseData> NRootTestData
        {
            get
            {
                yield return new TestCaseData(16, 4).Returns(2);
                yield return new TestCaseData(125, 3).Returns(5);
                yield return new TestCaseData(1125899906842624, 50).Returns(2);
                yield return new TestCaseData(3, -2).Throws(typeof(ArgumentException));
            }
        }
    }
}
