using System;
using DemoApp;

namespace ConsoleUI
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Please, print the number of elements in the array:");
            int n = Convert.ToInt32(Console.ReadLine());  //really the best method to read int from console?
            int[] a = new int[n];
            Console.WriteLine("Please, print the elements of the array:");
            for (int i = 0; i < n; i++)
            {
                a[i] = Convert.ToInt32(Console.ReadLine());  //how to throw exception, when it is NAN?
            }
            Console.Write("Sum of the array elements is \n");
            Console.WriteLine(Logic.CalculateSum(a));
            Console.Read(); //press the key to exit
        }
    }
}
