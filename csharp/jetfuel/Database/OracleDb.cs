using Oracle.DataAccess.Client;
using System;
using System.Collections.Generic;
using System.Data;
using System.Text;

namespace EixoX.Data
{
    public class OracleDb : Database
    {
        public OracleDb(string connectionString) : base(new OracleDialect(), connectionString) { }

        public override int Insert(DataAspect aspect, IEnumerable<AspectMemberValue> values, out object identityValue)
        {
            using (IDbConnection conn = this.Dialect.CreateConnection(this.ConnectionString))
            {
                OracleConnection _conn = (OracleConnection)conn;
                _conn.Open();
                bool hasIdentity;
                DatabaseCommand _cmd = this.Dialect.CreateInsert(aspect, values, out hasIdentity);

                using (OracleCommand cmd = _conn.CreateCommand())
                {
                    try
                    {
                        cmd.CommandText = _cmd.CommandText;
                        if (hasIdentity)
                        {
                            OracleParameter outputParameter = new OracleParameter("id", OracleDbType.Int64);
                            outputParameter.Direction = ParameterDirection.Output;
                            cmd.Parameters.Add(outputParameter);

                            cmd.ExecuteNonQuery();
                            identityValue = Convert.ToDecimal(outputParameter.Value.ToString());
                        }
                        else
                        {
                            identityValue = null;
                            cmd.ExecuteNonQuery();
                        }

                        return 1;
                    }
                    finally
                    {
                        _conn.Close();
                    }
                }
            }
        }

    }
}
