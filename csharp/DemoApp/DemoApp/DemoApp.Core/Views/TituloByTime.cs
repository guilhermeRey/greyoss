using EixoX.Data;
using EixoX.Interceptors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoApp.Core.Views
{
    [CasePattern(CaseStrategy.UpperUnderscore)]
    [DatabaseTable]
    public class TituloByTime
    {
        [DatabaseColumn]
        public int TimeId { get; set; }
        [DatabaseColumn]
        public string Nome { get; set; }
        [DatabaseColumn]
        public int Titulos { get; set; }
    }
}
