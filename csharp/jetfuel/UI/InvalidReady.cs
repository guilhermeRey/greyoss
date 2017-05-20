using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace EixoX.UI
{
    public class InvalidReady
    {
        public Dictionary<object, string> Invalidated { get; private set; }

        public void Invalidate(object prop, string message)
        {
            this.Invalidated.Add(prop, message);
        }

        public InvalidReady()
        {
            this.Invalidated = new Dictionary<object, string>();
        }
    }
}
