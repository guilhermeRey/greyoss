using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FileSizeSearcher
{
    public class Dir
    {
        public string Name { get; set; }
        public string Path { get; set; }
        private SortedList<string, Dir> SubDirs { get; set; }
        public int FileCount { get; set; }
        public double Size { get; set; }

        public Dir(string path)
        {
            if (!System.IO.Directory.Exists(path))
                throw new InvalidOperationException("path is invalid");

            this.Path = path;
            this.Name = this.Path.Substring(this.Path.LastIndexOf('\\') + 1);
            this.SubDirs = new SortedList<string, Dir>();
            this.FileCount = 0;
        }

        public IEnumerable<File> GetFiles()
        {
            this.FileCount = 0;
            foreach (string file in System.IO.Directory.GetFiles(this.Path))
            {
                this.FileCount++;
                yield return new File(file);
            }
        }

        public IEnumerable<Dir> GetSubDirs()
        {
            foreach (string dirpath in System.IO.Directory.GetDirectories(this.Path))
                this.SubDirs.Add(dirpath, new Dir(dirpath));

            return this.SubDirs.Values;
        }

        public void Summarize()
        {
            this.FileCount = 0;
            this.Size = 0;

            foreach (File file in this.GetFiles())
            {
                this.Size += file.Size;
                this.FileCount++;
            }
        }
    }
}
