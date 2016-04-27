using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace RaceConditionTest
{
    public class MyThread
    {
        public Thread TheThread { get; set; }
        private string _status = String.Empty;
        public string Status { get { return _status; } set { _status = value; } }

        public MyThread()
        {
            
        }
    }
}
