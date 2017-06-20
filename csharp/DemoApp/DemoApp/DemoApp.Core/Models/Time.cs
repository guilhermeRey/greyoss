using EixoX.Data;
using EixoX.Interceptors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoApp.Core
{
    [CasePattern(CaseStrategy.UpperUnderscore)]
    [DatabaseTable]
    public class Time
    {
        [DatabaseColumn(ColumnKind = DatabaseColumnKind.Identity)]
        public int TimeId { get; set; }
        [DatabaseColumn]
        public string Nome { get; set; }
        [DatabaseColumn]
        public string Descricao { get; set; }
    }
}
