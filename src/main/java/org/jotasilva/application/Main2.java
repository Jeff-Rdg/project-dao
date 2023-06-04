package org.jotasilva.application;

import org.jotasilva.dao.DepartmentDao;
import org.jotasilva.dao.factory.DaoFactory;
import org.jotasilva.entities.Department;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("Department findAll");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();

        for (Department obj : list
        ) {
            System.out.println(obj);
        }

        System.out.println("Department insert");
        Department newDepartment = new Department(null, "Vendas");
        departmentDao.insert(newDepartment);

        System.out.println("Inserted! new Id: " + newDepartment.getId());

        System.out.println("Department update");
        department = departmentDao.findById(1);
        System.out.println(department);
        department.setName("Compras");
        departmentDao.update(department);

        System.out.println(department);

        System.out.println("Department Delete");
        System.out.println("Enter id for delete test: ");
        int id = scanner.nextInt();
        departmentDao.deleteById(id);

        System.out.println("Delete completed");
        scanner.close();
    }
}
