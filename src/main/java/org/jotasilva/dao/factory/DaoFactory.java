package org.jotasilva.dao.factory;

import org.jotasilva.dao.DepartmentDao;
import org.jotasilva.dao.SellerDao;
import org.jotasilva.dao.imp.DepartmentDaoImp;
import org.jotasilva.dao.imp.SellerDaoImp;
import org.jotasilva.db.Db;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoImp(Db.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoImp(Db.getConnection());
    }
}
