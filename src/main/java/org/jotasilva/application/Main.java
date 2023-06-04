package org.jotasilva.application;

import org.jotasilva.dao.SellerDao;
import org.jotasilva.dao.factory.DaoFactory;
import org.jotasilva.entities.Department;
import org.jotasilva.entities.Seller;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}