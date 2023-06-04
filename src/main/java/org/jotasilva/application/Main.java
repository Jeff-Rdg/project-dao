package org.jotasilva.application;

import org.jotasilva.dao.SellerDao;
import org.jotasilva.dao.factory.DaoFactory;
import org.jotasilva.entities.Department;
import org.jotasilva.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("Seller findByDepartment");

        Department department = new Department(2, null);

        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj: list
             ) {
            System.out.println(obj);
        }
    }
}