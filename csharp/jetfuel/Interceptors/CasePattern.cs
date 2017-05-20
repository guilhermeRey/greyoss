using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace EixoX.Interceptors
{
    [Serializable]
    [AttributeUsage(AttributeTargets.Class, AllowMultiple = true, Inherited = true)]
    public class CasePattern : Attribute, Interceptor
    {
        public CaseStrategy Strategy { get; private set; }

        public CasePattern(CaseStrategy strategy)
        {
            this.Strategy = strategy;
        }

        public CasePattern()
        {
            this.Strategy = CaseStrategy.Default;
        }

        public static string Intercept(object input, CaseStrategy strategy)
        {
            if (input == null) return String.Empty;

            string str = input.ToString();
            StringBuilder aux = new StringBuilder();
            switch (strategy)
            {
                case CaseStrategy.Default:
                    return str;
                case CaseStrategy.LowerCamelCase:
                    return Char.ToLower(str[0]) + str.Substring(1);
                case CaseStrategy.UpperCamelCase:
                    return Char.ToUpper(str[0]) + str.Substring(1);
                case CaseStrategy.UpperUnderscore:
                case CaseStrategy.LowerUnderscore:
                    for (int i = 0; i < str.Length; i++)
                    {
                        char c = str[i];
                        if (i > 0 && Char.IsUpper(c)) aux.Append("_");

                        aux.Append(strategy == CaseStrategy.UpperUnderscore ? Char.ToUpper(c) : Char.ToLower(c));
                    }
                    return aux.ToString();
            }
            return str;
        }

        public static string ToWhiteSpaceFormat(object input, CaseStrategy fromStrategy)
        {
            switch (fromStrategy)
            {
                case CaseStrategy.Default:
                case CaseStrategy.UpperUnderscore:
                case CaseStrategy.LowerUnderscore:
                default:
                    return input.ToString();

                case CaseStrategy.LowerCamelCase:
                case CaseStrategy.UpperCamelCase:
                    StringBuilder sb = new StringBuilder();
                    string str = input.ToString();
                    sb.Append(Char.ToUpper(str[0]));
                    for (int i = 1; i < str.Length; i++)
                    {
                        if (Char.IsUpper(str[i]))
                        {
                            sb.Append(" ");
                            sb.Append(Char.ToUpper(str[i]));
                        }
                        else
                            sb.Append(Char.ToLower(str[i]));
                    }

                    return sb.ToString();
            }
        }

        public object Intercept(object input)
        {
            return Intercept(input, this.Strategy);
        }
    }
}
