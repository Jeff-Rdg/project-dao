package org.jotasilva.application;

import org.jotasilva.entities.Department;
import org.jotasilva.entities.Seller;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Department department = new Department();
        department.setId(1);
        department.setName("Compras");

        System.out.println(department);

        Seller seller = new Seller(1, "João","João@gmail.com", LocalDate.of(1995, 2, 3),4000.0, department );
        System.out.println(seller);
    }
}