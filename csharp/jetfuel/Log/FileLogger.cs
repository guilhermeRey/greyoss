using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;

namespace EixoX.Log
{
    public class FileLogger
    {
        private static readonly Mutex mutex = new Mutex();

        private static readonly string loggerPath = System.Configuration.ConfigurationManager.AppSettings["LoggerPath"];

        public void WriteEvent(DateTime signalTime, string name, string content)
        {
            mutex.WaitOne();
            try
            {
                string fileName = string.Concat("Log-", DateTime.Now.Year, "-", DateTime.Now.Month.ToString("00"), "-", DateTime.Now.Day.ToString("00"), ".txt");
                fileName = System.IO.Path.Combine(loggerPath, fileName);

                Directory.CreateDirectory(loggerPath);

                using (System.IO.StreamWriter writer = new System.IO.StreamWriter(fileName, true, Encoding.UTF8))
                {
                    try
                    {
                        writer.WriteLine(signalTime + " > " + name);
                        writer.WriteLine(content);
                        writer.WriteLine("=========================================");
                    }
                    finally
                    {
                        writer.Close();
                    }
                }
            }
            finally
            {
                mutex.ReleaseMutex();
            }
        }

        public void WriteEvent(DateTime signalTime, string name, string[] content)
        {
            mutex.WaitOne();
            try
            {
                string fileName = string.Concat("Log-", DateTime.Now.Year, "-", DateTime.Now.Month.ToString("00"), "-", DateTime.Now.Day.ToString("00"), ".txt");
                fileName = System.IO.Path.Combine(loggerPath, fileName);

                Directory.CreateDirectory(loggerPath);

                using (System.IO.StreamWriter writer = new System.IO.StreamWriter(fileName, true, Encoding.UTF8))
                {
                    try
                    {
                        writer.WriteLine(signalTime + " > " + name);
                        foreach (string c in content)
                            writer.WriteLine(c);
                        writer.WriteLine("=========================================");
                    }
                    finally
                    {
                        writer.Close();
                    }
                }
            }
            finally
            {
                mutex.ReleaseMutex();
            }
        }

        private FileLogger() { }
        private static FileLogger _Instance;
        public static FileLogger Instance
        {
            get { return _Instance ?? (_Instance = new FileLogger()); }
        }

    }
}
