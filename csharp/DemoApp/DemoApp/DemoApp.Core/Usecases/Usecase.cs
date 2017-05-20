using EixoX;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoApp.Core.Usecases
{
    public abstract class Usecase
    {
        public abstract void ExecuteFlow(UsecaseResult result);

        public void Execute(UsecaseResult result)
        {
            try
            {
                this.ExecuteFlow(result);
            }
            catch (Exception ex)
            {
                result.ResultType = UsecaseResultType.Exception_Raised;
                result.Exception = ex;
                result.Message = ex.Message;
            }
        }
    }
}
