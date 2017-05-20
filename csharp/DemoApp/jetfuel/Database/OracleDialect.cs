using EixoX.Data;
using EixoX.Log;
using Oracle.DataAccess.Client;
using System;
using System.Collections.Generic;
using System.Data;
using System.Text;

namespace EixoX.Data
{
    public class OracleDialect : AnsiDialect
    {
        public OracleDialect() : base('"', '"') { }

        public override System.Data.IDbConnection CreateConnection(string connectionString)
        {
            return new Oracle.DataAccess.Client.OracleConnection(connectionString);
        }

        public override void AppendValue(StringBuilder builder, object value)
        {
            if (value is DateTime)
            {
                builder.Append("TO_TIMESTAMP('");
                builder.Append(((DateTime)value).ToString("yyyy-MM-dd HH:mm:ss"));
                builder.Append("', 'RR-MM-DD HH24:MI:SS.FF')");
            }
            else if (value is int)
            {
                builder.Append(value);
            }
            else
            {
                base.AppendValue(builder, value);
            }
        }

        public override DatabaseCommand CreateInsert(DataAspect aspect, IEnumerable<AspectMemberValue> values, out bool hasScopeIdentity)
        {
            StringBuilder builder = new StringBuilder(512);
            StringBuilder valueBuilder = new StringBuilder(255);
            
            if (aspect.HasIdentity)
                StartCommand(builder);
            
            builder.Append("INSERT INTO  ");
            AppendName(builder, aspect.StoredName);
            builder.Append(" (");

            bool prependComma = false;
            foreach (AspectMemberValue value in values)
            {
                if (prependComma)
                {
                    builder.Append(", ");
                    valueBuilder.Append(", ");
                }
                else
                    prependComma = true;

                AppendName(builder, aspect[value.Ordinal].StoredName);
                AppendValue(valueBuilder, value.Value);
            }

            builder.Append(") VALUES (");
            builder.Append(valueBuilder);

            if (aspect.HasIdentity)
            {
                hasScopeIdentity = true;
                builder.Append(") ");
                AppendScopeIdentity(builder, aspect);
                EndCommand(builder);
            }
            else
            {
                hasScopeIdentity = false;
                builder.Append(")");
            }

            // FileLogger.Instance.WriteEvent(DateTime.Now, "SQL COMMAND LOG", builder.ToString());

            return new DatabaseCommand(
                CommandType.Text,
                builder.ToString(),
                null);
        }

        public override void AppendScopeIdentity(StringBuilder builder, DataAspect aspect)
        {
            builder.Append(" RETURNING ");
            AppendName(builder, aspect[aspect.IdentityOrdinal].StoredName);
            builder.Append(" INTO :id;");
        }

        public override void StartCommand(StringBuilder builder)
        {
            builder.Append("BEGIN \n");
        }

        public override void EndCommand(StringBuilder builder)
        {
            builder.Append(" END;");
        }

        public override DatabaseCommand CreateSelectExists(DataAspect aspect, ClassFilter filter)
        {
            StringBuilder builder = new StringBuilder(255);
            int count = aspect.Count;

            builder.Append("SELECT 1 FROM ");
            AppendName(builder, aspect.StoredName);
            builder.Append(" WHERE EXISTS (SELECT * FROM ");
            AppendName(builder, aspect.StoredName);

            if (filter != null)
            {
                builder.Append(" WHERE ");
                AppendFilter(builder, aspect, filter);
            }

            builder.Append(")");

            //  FileLogger.Instance.WriteEvent(DateTime.Now, "SQL COMMAND LOG", builder.ToString());

            return new DatabaseCommand(
                CommandType.Text,
                builder.ToString(),
                null);
        }
    }
}
