using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FileSizeSearcher
{
    public interface Viewee
    {
        void Log(string message);

        void OnException(Exception ex);
    }
}
