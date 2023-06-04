package org.jotasilva.dao.factory;

import org.jotasilva.dao.SellerDao;
import org.jotasilva.dao.imp.SellerDaoImp;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoImp();
    }
}
