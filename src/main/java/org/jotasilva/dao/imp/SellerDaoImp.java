package org.jotasilva.dao.imp;

import org.jotasilva.dao.SellerDao;
import org.jotasilva.db.Db;
import org.jotasilva.db.DbException;
import org.jotasilva.entities.Department;
import org.jotasilva.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoImp implements SellerDao {
    private Connection connection;

    public SellerDaoImp(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Seller entity) {

    }

    @Override
    public void update(Seller department) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT seller.*, department.Name as DepName " +
                "FROM seller INNER JOIN department " +
                "ON seller.DepartmentId = departmentId " +
                "WHERE seller.Id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Department department = new Department();
                department.setId(resultSet.getInt("DepartmentId"));
                department.setName(resultSet.getString("depName"));

                Seller seller = new Seller();
                seller.setId(resultSet.getInt("Id"));
                seller.setName(resultSet.getString("Name"));
                seller.setEmail(resultSet.getString("Email"));
                seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
                seller.setBirthDate(resultSet.getDate("BirthDate").toLocalDate());
                seller.setDepartment(department);

                return seller;
            }
            return null;
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(preparedStatement);
            Db.closeResultSet(resultSet);
        }

    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
