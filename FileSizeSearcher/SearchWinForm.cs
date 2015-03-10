using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace FileSizeSearcher
{
    public partial class SearchWinForm : Form
    {
        private int MinMb;
        private long Errors = 0;
        private DateTime Start;
        private bool ReadyToStart;

        public SearchWinForm()
        {
            InitializeComponent();

            gridResults.Columns.Add("dirName", "Dir Name");
            gridResults.Columns.Add("fileName", "File Name");
            gridResults.Columns.Add("fileSize", "File Size (Mb)");

            this.ReadyToStart = false;
        }

        private void PrepareAmbient()
        {
            gridResults.Rows.Clear();
            ReadyToStart = CheckInput(txtStartFolder) && CheckInput(txtMinSize);
            
            if (!ReadyToStart)
                throw new Exception("You must set the start folder AND the minimun file size!");

            this.MinMb = int.Parse(txtMinSize.Text);
            this.Start = DateTime.Now;
        }

        private bool CheckInput(TextBox control)
        {
            return  control != null && control.Text != String.Empty;
        }

        private void EndSearch()
        {
            progressBar1.Value = 0;
            TimeSpan end = DateTime.Now.Subtract(this.Start);

            lblConsole.Text = string.Format("Search concluded. Duration: {0}h:{1}m:{2}s with {3} errors"
                                            , end.Hours
                                            , end.Minutes
                                            , end.Seconds
                                            , this.Errors.ToString());
        }

        private void btnStartSearch_Click(object sender, EventArgs e)
        {
            try
            {
                PrepareAmbient();
                SearchInDirectories(txtStartFolder.Text);
                EndSearch();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Input Error");
            }
        }

        private void SearchInDirectories(string startFolder)
        {
            string[] dirs = new string[] { };

            try
            {
                dirs = System.IO.Directory.GetDirectories(startFolder);
            }
            catch (Exception ex)
            {
                this.Errors++;
                Console.WriteLine(ex.Message);
            }

            int i = 0;
            progressBar1.Minimum = 0;

            foreach (string dir in dirs)
            {
                progressBar1.Maximum = dirs.Length;
                lblConsole.Text = "Looking in " + dir + "...";
                progressBar1.Value = i++;
                Application.DoEvents();
                SearchInDirectories(dir);
            }


            string[] files = new string[] { };

            try
            {
                files = System.IO.Directory.GetFiles(startFolder);
            }
            catch (Exception ex)
            {
                this.Errors++;
                Console.WriteLine(ex.Message);
            }

            foreach (string file in files)
            {
                long size = 0;
                try
                {
                    size = (System.IO.File.Open(file, System.IO.FileMode.Open).Length / 1024) / 1024;
                }
                catch (Exception ex)
                {
                    this.Errors++;
                    Console.WriteLine(ex.Message);
                }

                if (size > this.MinMb)
                {
                    string[] aux = file.Replace('\\', '#').Split('#');
                    gridResults.Rows.Add(new string[] { 
                            startFolder, 
                            aux[aux.Length - 1], 
                            size.ToString() });
                }
            }

        }

        private void btnSelectStartFolder_Click(object sender, EventArgs e)
        {
            folderBrowserDialog1.ShowDialog();
            txtStartFolder.Text = folderBrowserDialog1.SelectedPath;
        }
    }
}
