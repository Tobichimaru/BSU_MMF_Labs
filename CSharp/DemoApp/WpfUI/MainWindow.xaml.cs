using System;
using System.Windows;
using DemoApp;

namespace WpfUI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            int n = Convert.ToInt32(InputLength.Text);
            int[] a = new int[n];
            string[] strArr = InputArray.Text.Split(' ');
            for (int i = 0; i < n; i++)
            {
                a[i] = Convert.ToInt32(strArr[i]);
            }
            OutputField.Content = Logic.CalculateSum(a).ToString();
            InputArray.Clear();
            InputLength.Clear();
        }
    }
}
