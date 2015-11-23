using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;

namespace RaceConditionTest
{
    public partial class ThreadMonitor : Form
    {
        public ThreadMonitor(Dictionary<string, MyThread> threads)
        {
            InitializeComponent();
            timer1.Start();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (RaceConditionTest.RaceCondition.threads != null)
            {
                string ts = "";

                RaceConditionTest.RaceCondition.semThreadList.WaitOne();
                foreach (KeyValuePair<string, MyThread> t in RaceConditionTest.RaceCondition.threads)
                    ts += t.Value.TheThread.Name + "[" + t.Value.Status + "]: " + t.Value.TheThread.ThreadState.ToString() + "\r\n";
                RaceConditionTest.RaceCondition.semThreadList.ReleaseMutex();
                txtConsole.Text = ts;
            }
        }


    }
}
