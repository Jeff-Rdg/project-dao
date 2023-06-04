package org.jotasilva.application;

import org.jotasilva.entities.Department;

public class Main {
    public static void main(String[] args) {
        Department department = new Department();
        department.setId(1);
        department.setName("Compras");

        System.out.println(department);

    }
}