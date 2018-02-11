using System;
using System.Diagnostics;

namespace MergeSortApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("This application allows sorting arrays of different types.");
            Console.WriteLine("The sorting algorithm is the \"Merge Sort\" algorithm.\n");
            Console.WriteLine("Test: sorting of random array of 5.000.000 integers.");

            int n = 5000000;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = new Random().Next(int.MinValue, int.MaxValue);

            Console.WriteLine("Sorting...");
            var timer = Stopwatch.StartNew();

            MergeSort.Sort(a, 0, n - 1);
            timer.Stop();

            Console.WriteLine("Time for sorting in milliseconds: " + timer.Elapsed.TotalMilliseconds);
            Console.Read();
        }
    }
}
