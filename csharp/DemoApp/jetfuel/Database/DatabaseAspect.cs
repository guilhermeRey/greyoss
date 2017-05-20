﻿using EixoX.Interceptors;
using System;
using System.Collections.Generic;
using System.Text;

namespace EixoX.Data
{
    public class DatabaseAspect
        : DataAspect
    {
        public DatabaseAspect(Type dataType) : base(dataType) {
            
        }

        protected override string GetStoredName(Type dataType)
        {
            object[] obj = dataType.GetCustomAttributes(typeof(DatabaseTableAttribute), true);
            if (obj == null || obj.Length < 1)
                throw new ArgumentException(dataType.FullName + " needs to be annotated with a database table attribute.");

            string name = ((DatabaseTableAttribute)obj[0]).Name;
            return CasePattern.Intercept(string.IsNullOrEmpty(name) ? dataType.Name : name, this._CaseStrategy);
        }

        protected override bool CreateAspectFor(ClassAcessor acessor, out DataAspectMember member)
        {
            DatabaseColumnAttribute dca = acessor.GetAttribute<DatabaseColumnAttribute>(true);
            if (dca == null)
            {
                member = null;
                return false;
            }
            else
            {
                member = new DataAspectMember(
                    acessor,
                    string.IsNullOrEmpty(dca.StoredName) ? CasePattern.Intercept(acessor.Name, this._CaseStrategy) : dca.StoredName,
                    dca.ColumnKind == DatabaseColumnKind.Identity,
                    dca.ColumnKind == DatabaseColumnKind.Unique,
                    dca.ColumnKind == DatabaseColumnKind.PrimaryKey,
                    dca.Nullable,
                    acessor.GetAttribute<Generator>(true),
                    dca.Caption);

                return true;
            }
        }
    }

    public class DatabaseAspect<T> : DatabaseAspect
    {
        private static DatabaseAspect<T> _Instance;
        private DatabaseAspect() : base(typeof(T)) { }

        public static DatabaseAspect<T> Instance
        {
            get { return _Instance ?? (_Instance = new DatabaseAspect<T>()); }
        }
    }
}
