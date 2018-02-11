using System;
using System.Diagnostics;
using HNFApp;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace HNFUnitTest
{
    [TestClass]
    public class UnitTest
    {
        [TestMethod]
        public void SimpleTest()
        {
            int[][] a =
            {
               new int[]{1, 2, 3}, 
               new int[]{5, 4, 3}, 
               new int[]{8, 7, 9}
            };
            HNFApp.Hermite h = new Hermite();
            h.initialize(a, 3, 3);
            int[][] b = h.getHNF();
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    Debug.Write(b[i][j]);
                    Debug.Write(' ');
                }
                Debug.WriteLine(' ');
            }
            Assert.AreEqual(a,b);
        }
    }
}
