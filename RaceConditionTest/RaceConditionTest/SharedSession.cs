using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace RaceConditionTest
{
    public static class SharedSession
    {
        private static readonly object lockRunning = new object();
        private static readonly object lockData = new object();

        private static bool _running = false;
        private static string _data = "";

        public static bool Running
        {
            get
            {
                lock (lockRunning)
                {
                    return _running;
                }
            }

            set
            {
                lock (lockRunning)
                {
                    _running = value;
                }
            }
        }

        public static void SetData(int seconds, string value)
        {
            lock (lockData)
            {
                int count = RaceCondition.Counter;
                string aux = Thread.CurrentThread.Name;
                RaceConditionTest.RaceCondition.threads[Thread.CurrentThread.Name].Status = "Running";
                SharedSession._data = value;
                RaceCondition.theForm.WriteLine(count + ". Thread " + aux + " wrote");
                System.Threading.Thread.Sleep(seconds * 1000);
            }

            RaceConditionTest.RaceCondition.threads[Thread.CurrentThread.Name].Status = "";
        }

        public static string GetData(int seconds)
        {
            string _r = "";
            lock (lockData)
            {
                int count = RaceCondition.Counter;
                string aux = Thread.CurrentThread.Name;
                RaceConditionTest.RaceCondition.threads[Thread.CurrentThread.Name].Status = "Running";
                System.Threading.Thread.Sleep(seconds * 1000);
                RaceCondition.theForm.WriteLine(count + ". Thread " + aux + " read");
                _r = SharedSession._data;
            }

            RaceConditionTest.RaceCondition.threads[Thread.CurrentThread.Name].Status = "";
            return _r;
        }
    }
}
