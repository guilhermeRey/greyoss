using EixoX.Data;
using EixoX.Interceptors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoApp.Core.Models
{
    [CasePattern(CaseStrategy.UpperUnderscore)]
    [DatabaseTable]
    public class Titulo
    {
        [DatabaseColumn(DatabaseColumnKind.PrimaryKey)]
        public int TimeId { get; set; }
        
        [DatabaseColumn(DatabaseColumnKind.PrimaryKey)]
        public string Campeonato { get; set; }

       [DatabaseColumn(DatabaseColumnKind.PrimaryKey)]
        public int Ano { get; set; }
    }
}
