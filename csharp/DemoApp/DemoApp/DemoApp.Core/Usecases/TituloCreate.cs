using DemoApp.Core.Models;
using System;
using EixoX.Restrictions;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using EixoX.UI;
using EixoX;

namespace DemoApp.Core.Usecases
{
    public class TituloCreate
    {

        public TituloCreate(int id)
        {
            this.Titulo = new Titulo();
            this.TimeId = id;
            this.time = DemoappDb<Time>.Instance.WithIdentity(id);
        }

        public TituloCreate()
        {
            this.Titulo = new Titulo();
        }

        public void LoadTime(){
            this.time = DemoappDb<Time>.Instance.WithIdentity(TimeId);
        }

        public Time time { get; set; }
        

        public Titulo Titulo { get; set; }
        [Required]
        [UIHidden]
        public int TimeId
        {
            get { return this.Titulo.TimeId; }
            set { this.Titulo.TimeId = value; }
        }
        [Required]
        [UISingleline]
        public string campeonato
        {
            get { return this.Titulo.Campeonato; }
            set { this.Titulo.Campeonato = value; }
        }
        [Required]
        [UISingleline]
        public int ano
        {
            get { return this.Titulo.Ano; }
            set { this.Titulo.Ano = value; }
        }

        public void Execute(UsecaseResult useCase)
        {
            if (!RestrictionAspect<TituloCreate>.Instance.Validate(this))
            {
                useCase.ResultType = UsecaseResultType.Restrictions_Failed;

                useCase.Message = "Eta cuzaum, deu ruim tiow";
                return;
            }
            if (time == null) {
                useCase.ResultType = UsecaseResultType.Failed;
                useCase.Message = "IMpossivel incluir time nao cadastrado!";
                return;
            }

            DemoappDb<Titulo>.Instance.Insert(this.Titulo);
            useCase.ResultType = UsecaseResultType.Sucess;
            useCase.Message = "Sucesso - Cadastrado";
        }
    }
}
