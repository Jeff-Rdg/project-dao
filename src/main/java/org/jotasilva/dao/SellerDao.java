package org.jotasilva.dao;

import org.jotasilva.entities.Department;
import org.jotasilva.entities.Seller;

import java.util.List;


public interface SellerDao extends BaseDao<Seller> {
    List<Seller> findByDepartment(Department department);
}
