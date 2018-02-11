using System;
using System.Collections.Generic;
using MathExtension;
using NUnit.Framework;

namespace MathExtensionNUnitTest
{
    [TestFixture]
    class PolynomNunitTest
    {
        [Test, TestCaseSource(typeof(PolynomFactoryClass), "SumTestCaseDatas")]
        public Polynom PolynomsSumWithYield(double[] leftCoeff, double[] rightCoeff)
        {
            Polynom left = new Polynom(leftCoeff);
            Polynom right = new Polynom(rightCoeff);
            return left+right;
        }

        [Test, TestCaseSource(typeof(PolynomFactoryClass), "DifferenceTestCaseDatas")]
        public Polynom PolynomsDifferenceWithYield(double[] leftCoeff, double[] rightCoeff)
        {
            Polynom left = new Polynom(leftCoeff);
            Polynom right = new Polynom(rightCoeff);
            return left - right;
        }

        [Test, TestCaseSource(typeof(PolynomFactoryClass), "MultiplyTestCaseDatas")]
        public Polynom MultiplyWithYield(double[] leftCoeff, double[] rightCoeff)
        {
            Polynom left = new Polynom(leftCoeff);
            Polynom right = new Polynom(rightCoeff);
            if (leftCoeff.Length == 1)
            {
                return leftCoeff[0]*right;
            }
            if (rightCoeff.Length == 1)
            {
                return left*rightCoeff[0];
            }
            return left * right;
        }
    }

    public class PolynomFactoryClass
    {
        public IEnumerable<TestCaseData> SumTestCaseDatas
        {
            get
            {
                yield return new TestCaseData(new[] { 1, 0, 3, 0.5 }, new[] { 0, 2.5, 1, 2 }).Returns(new Polynom(1, 2.5, 4, 2.5));
                yield return new TestCaseData(new[] { 1.0, 0}, new[] { 0, 2.5, 1, 2 }).Returns(new Polynom(1, 2.5, 1, 2));
                yield return new TestCaseData(new[] { 1.0, 2}, new[] { 5, 6555.8}).Returns(new Polynom(6, 6557.8));
                yield return new TestCaseData(null, new[] { 0, 1.0 }).Throws(typeof(ArgumentNullException));
            }
        }

        public IEnumerable<TestCaseData> DifferenceTestCaseDatas
        {
            get
            {
                yield return new TestCaseData(new[] { 1, 0, 3, 0.5 }, new[] { 0, 2.5, 1, 2 }).Returns(new Polynom(1, -2.5, 2, -1.5));
                yield return new TestCaseData(new[] { 1.0, 2 }, new[] { 5, 6555.8 }).Returns(new Polynom(-4, -6553.8));
                yield return new TestCaseData(null, new[] { 0, 1.0 }).Throws(typeof(ArgumentNullException));
            }
        }

        public IEnumerable<TestCaseData> MultiplyTestCaseDatas
        {
            get
            {
                yield return new TestCaseData(new[] { 1, 0.5 }, new[] {0, 2.0}).Returns(new Polynom(0, 2, 1));
                yield return new TestCaseData(new[] { 1.0}, new[] { 5, 6555.8 }).Returns(new Polynom(5, 6555.8));
                yield return new TestCaseData(new[] { 0.0}, new[] { 0, 2.0 }).Returns(new Polynom());
                yield return new TestCaseData(new[] { 1.0, 3 }, new[] {2.0}).Returns(new Polynom(2.0, 6));
                yield return new TestCaseData(null, new[] { 0, 1.0 }).Throws(typeof(ArgumentNullException));
            }
        }
    }
}
