using System;
using System.Collections.Generic;
using System.Linq;
using NUnit.Framework;
using QueueLib;

namespace UnitTestProject
{
    [TestFixture]
    public class QueueNUnitTests
    {
        private int FindElem<T>(CustomQueue<T> queue, T elem)
        {
            int pos = 0;
            foreach (T item in queue)
            {
                if (item.Equals(elem))
                    return pos;
                pos++;
            }
            return -1;
        }


        [Test, TestCaseSource(typeof(MyFactoryClass), "FindElemData")]
        public int FindElem(String[] a, String elem)
        {
            CustomQueue<String> queue = new CustomQueue<String>();
            foreach (String item in a)
            {
                queue.Enqueue(item);
            }
            return FindElem(queue, elem);
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "PartialDequeueData")]
        public int[] PartialDequeue(int[] a, int toDeleteItems)
        {
            CustomQueue<int> queue = new CustomQueue<int>();
            foreach (int item in a)
            {
                queue.Enqueue(item);
            }
            for (int i = 0; i < toDeleteItems; i++)
            {
                queue.Dequeue();
            }
            foreach (int item in a)
            {
                queue.Enqueue(item);
            }

            int[] result = new int[a.Length*2 - toDeleteItems];
            int k = 0;
            while (!queue.IsEmpty())
            {
                result[k] = queue.Dequeue();
                k++;
            }
            return result;
        }

        [Test, TestCaseSource(typeof(MyFactoryClass), "DequeueIntsData")]
        public int[] DequeueInts(int[] a)
        {
            CustomQueue<int> queue = new CustomQueue<int>();
            int[] result = new int[a.Length];
            foreach (int item in a)
            {
                queue.Enqueue(item);
            }
            int i = 0;
            while (!queue.IsEmpty())
            {
                result[i] = queue.Dequeue();
                i++;
            }
            return result;
        }

    }

    public class MyFactoryClass
    {
        public IEnumerable<TestCaseData> FindElemData
        {
            get
            {
                yield return new TestCaseData(new[] {"cat", "dog", "cow" }, "dog").Returns(1);
                yield return new TestCaseData(new[] {"cat", "dog", "cow" }, "kitten").Returns(-1);
            }
        }

        public IEnumerable<TestCaseData> PartialDequeueData
        {
            get
            {
                yield return new TestCaseData(new[] {1, 2, 3 }, 2).Returns(new[] {3, 1, 2, 3});
                yield return new TestCaseData(new[] {1, 2, 3, 4}, 2).Returns(new [] {3, 4, 1, 2, 3, 4});
                yield return new TestCaseData(new[] {1, 2}, 4).Throws(typeof (NullReferenceException));
            }
        }

        public IEnumerable<TestCaseData> DequeueIntsData
        {
            get
            {
                yield return new TestCaseData(new[] { 2, 5, 7 }).Returns(new[] { 2, 5, 7 });
                yield return new TestCaseData(new[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }).Returns(new[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
                
                int n = 1000000;
                int[] a = new int[n];
                Random random = new Random();
                for (int i = 0; i < n; i++)
                   a[i] = random.Next(int.MinValue, int.MaxValue);

                yield return new TestCaseData(a).Returns(a);
            }
        }
    }
}