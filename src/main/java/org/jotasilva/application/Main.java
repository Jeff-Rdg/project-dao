package org.jotasilva.application;

import org.jotasilva.dao.SellerDao;
import org.jotasilva.dao.factory.DaoFactory;
import org.jotasilva.entities.Department;
import org.jotasilva.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("Seller findByDepartment");

        Department department = new Department(2, null);

        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list
        ) {
            System.out.println(obj);
        }

        System.out.println("Seller findAll");
        list = sellerDao.findAll();

        for (Seller obj : list
        ) {
            System.out.println(obj);
        }

        System.out.println("Seller insert");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.00, department);
        sellerDao.insert(newSeller);

        System.out.println("Inserted! new Id: " + newSeller.getId());

        System.out.println("Seller update");
        seller = sellerDao.findById(1);
        System.out.println(seller);
        seller.setName("Martha wayne");
        sellerDao.update(seller);

        System.out.println(seller);

        System.out.println("Seller Delete");
        System.out.println("Enter id for delete test: ");
        int id = scanner.nextInt();
        sellerDao.deleteById(id);

        System.out.println("Delete completed");
        scanner.close();
    }
}