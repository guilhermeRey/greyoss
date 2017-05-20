using DemoApp.Core.Usecases;
using EixoX;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DemoApp.Controllers
{
    public class TituloController : Controller
    {
        [HttpGet]
        public ActionResult Editor(int id)
        {
            TituloCreate create = new TituloCreate(id);
            return View(create);
        }

        [HttpPost]
        public ActionResult Editor(TituloCreate create)
        {
            UsecaseResult result = new UsecaseResult();
            create.LoadTime();
            create.Execute(result);
            FlashMessage(result);
            if (result.ResultType == UsecaseResultType.Sucess)
                return Redirect(Url.Content("~/Dashboard"));
            return View(create);
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
