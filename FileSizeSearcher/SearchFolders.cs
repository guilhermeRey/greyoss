using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FileSizeSearcher
{
    public class SearchFolders
    {
        public List<Dir> FoundDirs { get; set; }
        public List<Exception> Exceptions { get; set; }
        public Viewee Viewee { get; set; }

        public SearchFolders(Viewee viewee)
        {
            this.Viewee = viewee;
            this.Exceptions = new List<Exception>();
            this.FoundDirs = new List<Dir>();
        }

        public void Search(Dir dir, long minSize)
        {
            try
            {
                this.Viewee.Log("Summarizing " + dir.Name);
                dir.Summarize();

                if (dir.Size >= minSize)
                    this.FoundDirs.Add(dir);

                foreach (Dir _dir in dir.GetSubDirs())
                    Search(_dir, minSize);
            }
            catch (Exception ex)
            {
                this.Viewee.OnException(ex);
                this.Exceptions.Add(ex);
            }
        }
    }
}
