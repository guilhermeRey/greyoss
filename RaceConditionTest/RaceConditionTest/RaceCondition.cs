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
    public partial class RaceCondition : Form
    {
        #region "    Atributos    "
        // Semaforo para edicao e insercao de novas threads
        public static Mutex semThreadList = new Mutex();
        private static Dictionary<string, MyThread> _threads;
        public static Dictionary<string, MyThread> threads
        {
            get
            {
                Dictionary<string, MyThread> _r;
                semThreadList.WaitOne();
                _r = _threads;
                semThreadList.ReleaseMutex();
                return _r;
            }

            set
            {
                semThreadList.WaitOne();
                _threads = value;
                semThreadList.ReleaseMutex();
            }
        }

        private static Mutex semCounter = new Mutex();
        private static int _count = 0;
        public static int Counter
        {
            get
            {
                int _r = 0;
                semCounter.WaitOne();
                _count += 1;
                _r = _count;
                semCounter.ReleaseMutex();
                return _r;
            }
        }

        private static Mutex semMessage = new Mutex();
        
        static Random r = new Random();

        public static RaceCondition theForm;

        #endregion

        public RaceCondition()
        {
            InitializeComponent();

            SharedSession.Running = true;
            threads = new Dictionary<string, MyThread>();
            theForm = this;
        }

        private void KillThreads()
        {
            SharedSession.Running = false;
            foreach (KeyValuePair<string, MyThread> t in threads)
            {
                t.Value.TheThread.Join(10000);
                if (t.Value.TheThread.IsAlive)
                    t.Value.TheThread.Abort();
            }
            threads = new Dictionary<string,MyThread>();
        }

        public static void AddThread(string pid, MyThread t)
        {
            semThreadList.WaitOne();
            if (threads != null)
                threads.Add(pid, t);
            semThreadList.ReleaseMutex();
        }

        private void StartThread()
        {
            theForm.WriteLine(Counter + ". Thread " + Thread.CurrentThread.Name + " iniciada");
            while (SharedSession.Running)
            {
                if (r.Next(2) % 2 == 0)
                    SharedSession.SetData(r.Next(10), Convert.ToString(r.Next(100)));
                else
                    SharedSession.GetData(r.Next(10));
            }
            theForm.WriteLine(Counter + ". Thread " + Thread.CurrentThread.Name + " finalizada.");
        }

        private void btnCreateThread_Click(object sender, EventArgs e)
        {
            string pid = txtThreadName.Text;
            AddThread(pid,
                      new MyThread()
                      {
                          TheThread = new Thread(new ThreadStart(StartThread))
                      });
            
            threads[pid].TheThread.Name = pid;
            threads[pid].TheThread.IsBackground = checkBackground.Checked;
            threads[pid].TheThread.Start();
        }

        private void clock_Tick(object sender, EventArgs e)
        {
            RaceConditionTest.RaceCondition.semThreadList.WaitOne();

            if (RaceConditionTest.RaceCondition.threads != null)
            {
                string monitor = "";
                foreach (KeyValuePair<string, MyThread> t in RaceConditionTest.RaceCondition.threads)
                    monitor += t.Value.TheThread.Name + " [" + t.Value.Status + "]: " + t.Value.TheThread.ThreadState.ToString() + "\r\n";
                
                listMonitor.Text = monitor;
            }

            RaceConditionTest.RaceCondition.semThreadList.ReleaseMutex();
        }

        public void WriteLine(string value)
        {
            semMessage.WaitOne();
            this.Invoke((MethodInvoker)delegate
            {
                _console.Text += value + "\r\n";
            });
            semMessage.ReleaseMutex();
        }

        private void btnStopAll_Click(object sender, EventArgs e)
        {
            Thread tKill = new Thread(new ThreadStart(KillThreads));
            tKill.IsBackground = true;
            tKill.Start();
        }

        private void btnKill_Click(object sender, EventArgs e)
        {
            semThreadList.WaitOne();
            foreach (DataGridViewRow item in gridKiller.SelectedRows)
                threads[item.Cells["Name"].Value.ToString()].TheThread.Abort();
            semThreadList.ReleaseMutex();
        }

        private void btnPause_Click(object sender, EventArgs e)
        {
            if (btnPause.Text == " > ")
            {
                semThreadList.WaitOne();
                foreach (DataGridViewRow item in gridKiller.SelectedRows)
                    threads[item.Cells["Name"].Value.ToString()].TheThread.Resume();
                semThreadList.ReleaseMutex();
                btnPause.Text = " || ";
                return;
            }

            semThreadList.WaitOne();
            foreach (DataGridViewRow item in gridKiller.SelectedRows)
                threads[item.Cells["Name"].Value.ToString()].TheThread.Suspend();
            semThreadList.ReleaseMutex();
            btnPause.Text = " > ";
        }

        private void clockKiller_Tick(object sender, EventArgs e)
        {
            RaceConditionTest.RaceCondition.semThreadList.WaitOne();

            if (RaceConditionTest.RaceCondition.threads != null)
            {
                List<_Thread> _killer = new List<_Thread>();
                
                foreach (KeyValuePair<string, MyThread> t in RaceConditionTest.RaceCondition.threads)
                    _killer.Add(new _Thread(){ Name = t.Value.TheThread.Name, Id = t.Value.TheThread.ManagedThreadId.ToString() });
                
                gridKiller.DataSource = _killer;

            }

            RaceConditionTest.RaceCondition.semThreadList.ReleaseMutex();
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            _console.Text = "";
        }

        private void _console_TextChanged(object sender, EventArgs e)
        {

        }
        
    }

    public class _Thread
    {
        public string Name { get; set; }
        public string Id { get; set; }
    }
}
