using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace FileSizeSearcher
{
    public class File
    {
        public string Name { get; set; }

        public string Path { get; set; }

        public double Size { get; set; }

        public File(string path)
        {
            if (!System.IO.File.Exists(path))
                throw new InvalidOperationException("path is invalid");

            this.Path = path;
            this.Name = path.Substring(path.LastIndexOf('\\') + 1);

            try
            {
                FileStream stream = System.IO.File.Open(path, System.IO.FileMode.Open);
                this.Size = ((new FileInfo(path).Length / 1024f) / 1024f);
            }
            catch
            {
                Console.WriteLine("Unable to calculate " + path + "'s size");
            }
        }
    }
}
