using System;
using System.Diagnostics;

namespace QueueLib
{
    class Program
    {
        private static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
       
        private static String GenerateRandomString()
        {
            var stringChars = new char[8];
            var random = new Random();

            for (int i = 0; i < stringChars.Length; i++)
            {
                stringChars[i] = chars[random.Next(chars.Length)];
            }

            return new String(stringChars);
        }

        static void Main(string[] args)
        {
            Console.WriteLine("This application contains generic implementation of queue structure.");
            Console.WriteLine("Test: adding and removing 10.000.000 strings (8 chars) to queue.");

            int n = 10000000;
            String[] a = new String[n];
            CustomQueue<String> queue = new CustomQueue<string>();
            for (int i = 0; i < n; i++) 
                a[i] = GenerateRandomString();

            Console.WriteLine("Adding...");
            var timer = Stopwatch.StartNew();
            for (int i = 0; i < n; i++)
                queue.Enqueue(a[i]);

            Console.WriteLine("Removing...");
            for (int i = 0; i < n; i++)
                queue.Dequeue();
            timer.Stop();

            Console.WriteLine("Time for adding and removing  in milliseconds: " + timer.Elapsed.TotalMilliseconds);
            Console.Read();
        }
    }
}