using EixoX.Data;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;

namespace DemoApp.Core
{
    public class DemoappDb<T> : DatabaseStorage<T>
    {
        private static DemoappDb<T> _instance;

        public static DemoappDb<T> Instance
        {
            get
            {
                return _instance ?? (_instance = new DemoappDb<T>());
            }
        }

        private DemoappDb()
            : base(
            new OracleDb(
                ConfigurationManager.ConnectionStrings["LocalDatabase"].ConnectionString), 
                DatabaseAspect<T>.Instance)
        {

        }
    }
}
