using DemoApp.Core;
using DemoApp.Core.Views;
using EixoX;
using EixoX.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DemoApp.Controllers
{
    public class DashboardController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            List<TituloByTime> times = DemoappDb<TituloByTime>.Instance
                .Select()
                .OrderBy("Titulos", SortDirection.Descending)
                .ThenBy("Nome", SortDirection.Ascending)
                .ToList();
            ViewData["times"] = times;
            
            return View(new TimeCreate());
        }

        [HttpPost]
        public ActionResult Index(TimeCreate create)
        {
            UsecaseResult result = new UsecaseResult();
            create.Execute(result);

            FlashMessage(result);
            List<TituloByTime> times = DemoappDb<TituloByTime>.Instance
                .Select()
                .OrderBy("Titulos", SortDirection.Descending)
                .ThenBy("Nome", SortDirection.Ascending)
                .ToList();
            ViewData["times"] = times;

            return View(create);
        }

        [HttpGet]
        public ActionResult DeleteTime(int timeId)
        {
            if (timeId == 0)
                return Redirect(Url.Content("~/Dashboard/"));

            Time time = DemoappDb<Time>.Instance.WithIdentity(timeId);
            UsecaseResult result = null;
            if (time == null)
            {
                result = new UsecaseResult()
                {
                    Message = "Time não encontrado",
                    ResultType = UsecaseResultType.Failed
                };                
            }
            else
            {
                DemoappDb<Time>.Instance.Delete(time);
                result = new UsecaseResult()
                {
                    Message = "Time deletado!",
                    ResultType = UsecaseResultType.Sucess
                };
            }

            FlashMessage(result);
            return Redirect(Url.Content("~/Dashboard/"));
        }

        public void FlashMessage(UsecaseResult result)
        {
            Session["Message"] = result.Message;
            if (result.ResultType == UsecaseResultType.Sucess)
                Session["MessageType"] = "success";
            else
                Session["MessageType"] = "danger";
        }
    }
}
