using System;
using System.Collections.Generic;
using System.Diagnostics;
using NUnit.Framework;
using ArrayApplication;

namespace UnitTestProject
{
    [TestFixture]
    public class LogicNUnitTests
    {
        private void printArray(int[][] a)
        {
            for (int i = 0; i < a.GetLength(0); i++)
            {
                if (ReferenceEquals(a[i], null))
                    Debug.Write("null");
                else
                {
                    for (int j = 0; j < a[i].Length; j++)
                        Debug.Write(a[i][j] + " ");
                }
                Debug.WriteLine(' ');
            }
        }

        private bool compareArrays(ref int[][] a, ref int[][] b)
        {
            printArray(a);
            printArray(b);

            if (a.GetLength(0) != b.GetLength(0)) return false;
            bool equal = true;
            for (int i = 0; i < a.GetLength(0); i++)
            {
                if (ReferenceEquals(a[i], null) || ReferenceEquals(b[i], null))
                {
                    if (!(ReferenceEquals(a[i], null) && ReferenceEquals(b[i], null)))
                    {
                        equal = false;
                        break;
                    }
                }
                else
                {
                    if (a[i].Length != b[i].Length)
                    {
                        equal = false;
                        break;
                    }
                    for (int j = 0; j < a[i].Length; j++)
                    {
                        if (a[i][j].CompareTo(b[i][j]) != 0)
                        {
                            equal = false;
                            break;
                        }
                    }
                }
            }
            return equal;
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "SumTestData")]
        public bool SumSortDelegateTestWithYield(int[][] a, ref int[][] expected)
        {
            OtherLogic.Sort(a, CompareFunctions.CompareSum);
            return compareArrays(ref a, ref expected);
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "MinTestData")]
        public bool MinSortDelegateTestWithYield(int[][] a, ref int[][] expected)
        {
            OtherLogic.Sort(a, CompareFunctions.CompareMin);
            return compareArrays(ref a, ref expected);
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "MaxTestData")]
        public bool MaxSortDelegateTestWithYield(int[][] a, ref int[][] expected)
        {
            OtherLogic.Sort(a, CompareFunctions.CompareMax);
            return compareArrays(ref a, ref expected);
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "SumTestData")]
        public bool SumSortInterfaceTestWithYield(int[][] a, ref int[][] expected)
        {
            Logic.Sort(a, new SumComparer());
            return compareArrays(ref a, ref expected);
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "MinTestData")]
        public bool MinSortInterfaceTestWithYield(int[][] a, ref int[][] expected)
        {
            Logic.Sort(a, new MinComparer());
            return compareArrays(ref a, ref expected);
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "MaxTestData")]
        public bool MaxSortInterfaceTestWithYield(int[][] a, ref int[][] expected)
        {
            Logic.Sort(a, new MaxComparer());
            return compareArrays(ref a, ref expected);
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "SearchTestData")]
        public int BinarySearchTestWithYield(int[] a, int elem)
        {
            int pos = Logic.BinarySearch(a, elem);
            for (int i = 0; i < a.Length; i++)
                Debug.Write(a[i] + " ");
            return pos;
        }
    }

    public class MyFactoryClass
    {
        public IEnumerable<TestCaseData> SumTestData
        {
            get
            {
                yield return new TestCaseData(new[]  
                {
                    new[] {1, 2, 1, 2},
                    new[] {3, 1, 0},
                    new[] {5, 4, 7, 2, -2},
                    new[] {-10, 0, 10}
                }, new[]
                {
                    new[] {-10, 0, 10},
                    new[] {3, 1, 0},
                    new[] {1, 2, 1, 2},
                    new[] {5, 4, 7, 2, -2}
                }).Returns(true);

                yield return new TestCaseData(new[]  {
                    new[] {1, 2, 1, 2},
                    null,
                    new[] {3, 1, 0},
                    new[] {5, 4, 7, 2, -2},
                    null,
                    null,
                    new[] {-10, 0, 10}
                }, new[]
                {
                    new[] {-10, 0, 10},
                    new[] {3, 1, 0},
                    new[] {1, 2, 1, 2},
                    new[] {5, 4, 7, 2, -2},
                    null,
                    null,
                    null
                }).Returns(true);
            }
        }

        public IEnumerable<TestCaseData> MinTestData
        {
            get
            {
                yield return new TestCaseData(new[]  {
                    new[] {1, 2, 1, 2},
                    new[] {3, 1, 0},
                    new[] {5, 4, 7, 2, -2},
                    new[] {-10, 0, 10}
                }, new[]
                {
                    new[] {-10, 0, 10},
                    new[] {5, 4, 7, 2, -2},
                    new[] {3, 1, 0},
                    new[] {1, 2, 1, 2}  
                }).Returns(true);

                yield return new TestCaseData(new[]  {
                    new[] {1, 2, 1, 2},
                    null,
                    new[] {3, 1, 0},
                    new[] {5, 4, 7, 2, -2},
                    null,
                    null,
                    new[] {-10, 0, 10}
                }, new[]
                {
                    new[] {-10, 0, 10},
                    new[] {5, 4, 7, 2, -2},
                    new[] {3, 1, 0},
                    new[] {1, 2, 1, 2},
                    null,
                    null,
                    null
                }).Returns(true);
            }
        }

        public IEnumerable<TestCaseData> MaxTestData
        {
            get
            {
                yield return new TestCaseData(new[]
                {
                    new[] {1, 2, 1, 2},
                    new[] {3, 1, 0},
                    new[] {5, 4, 7, 2, -2},
                    new[] {-10, 0, 10}
                }, new[]
                {
                    new[] {1, 2, 1, 2},
                    new[] {3, 1, 0},
                    new[] {5, 4, 7, 2, -2},
                    new[] {-10, 0, 10}
                }).Returns(true);

                yield return new TestCaseData(new[]
                {
                    new[] {1, 2, 1, 2},
                    null,
                    new[] {3, 1, 0},
                    new[] {5, 4, 7, 2, -2},
                    null,
                    null,
                    new[] {-10, 0, 10}
                }, new[]
                {
                    new[] {1, 2, 1, 2},
                    new[] {3, 1, 0},
                    new[] {5, 4, 7, 2, -2},
                    new[] {-10, 0, 10},
                    null,
                    null,
                    null
                }).Returns(true);
            }
        }

        public IEnumerable<TestCaseData> SearchTestData
        {
            get
            {
                yield return new TestCaseData(new[] {5, 4, 7, 2, -2}, 2).Returns(1);
                yield return new TestCaseData(new[] { 5, 4, 7, 2, -2 }, 5).Returns(3);
                yield return new TestCaseData(new[] { 5, 4, 7, 2, -2 }, 7).Returns(4);
                yield return new TestCaseData(new[] { 5, 4, 7, 2, -2 }, -2).Returns(0);
                yield return new TestCaseData(new[] { 5, 4, 7, 2, -2 }, 10).Returns(-1);
                yield return new TestCaseData(new[] { -2 }, -2).Returns(0);
                yield return new TestCaseData(new int[] {}, -2).Returns(-1);
                yield return new TestCaseData(null, -2).Throws(typeof(ArgumentNullException));
            }
        }

    }
}