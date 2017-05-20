using DemoApp.Core.Restrictions;
using EixoX;
using EixoX.Restrictions;
using EixoX.UI;
using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Linq;
using System.Text;

namespace DemoApp.Core
{
    public class TimeCreate
    {
        public TimeCreate()
        {
            this.Time = new Time();
        }

        public Time Time { get; private set; }

        [Required]
        [MinLength(3)]
        [TemMundial]
        [UISingleline]
        public string Nome { 
            get { return this.Time.Nome; } 
            set { this.Time.Nome = value; }
        }

        [Required]
        [UIMultiline("Descrição", "Digite a descrição do seu time do coração")]
        public string Descricao { 
            get { return this.Time.Descricao; } 
            set { this.Time.Descricao = value; } 
        }

        public void Execute(UsecaseResult result)
        {
            if (!RestrictionAspect<TimeCreate>.Instance.Validate(this))
            {
                result.ResultType = UsecaseResultType.Restrictions_Failed;
                result.Message = "OPS, DEU RUIM";
                return;
            }

            DemoappDb<Time>.Instance.Insert(this.Time);
            result.ResultType = UsecaseResultType.Sucess;
            result.Message = "TIME CADASTRADO! AE!";
        }
    }
}
