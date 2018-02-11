using System;
using System.Web.Mvc;
using DemoApp;
using MvcUI.Models;

namespace MvcUI.Controllers
{
    public class EventsController : Controller
    {
        public ActionResult Calculate(UserModel model)
        {
            int[] a = new int[model.ArrayLength];
            string[] strArr = model.ArrayElements.Split(' ');
            for (int i = 0; i < model.ArrayLength; i++)
            {
                a[i] = Convert.ToInt32(strArr[i]);
            }
            int sum = Logic.CalculateSum(a);
            return View(sum);
        }
    }
}