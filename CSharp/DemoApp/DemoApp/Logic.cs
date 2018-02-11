
namespace DemoApp
{
    public static class Logic
    {
        public static int CalculateSum(int[] a)
        {
            if (a == null) return 0;
            int sum = 0;
            checked
            {
                for (int i = 0; i < a.Length; i++)
                {
                    sum += a[i];
                }
            }
            return sum;
        }
    }
}
