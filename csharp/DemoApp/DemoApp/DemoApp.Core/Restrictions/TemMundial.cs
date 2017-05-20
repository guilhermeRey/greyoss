using EixoX.Restrictions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoApp.Core.Restrictions
{
    [Serializable]
    [AttributeUsage(AttributeTargets.Field | AttributeTargets.Property, AllowMultiple = false, Inherited = true)]
    public class TemMundial : Attribute, Restriction
    {
        public bool Validate(object input)
        {
            string value = input.ToString();
            return !value.Equals("palmeiras", StringComparison.OrdinalIgnoreCase);
        }

        public string RestrictionMessageFormat
        {
            get { return "Palmeiras não tem mundial!"; }
        }
    }
}
