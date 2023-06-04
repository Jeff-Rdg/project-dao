package org.jotasilva.dao.imp;

import org.jotasilva.dao.DepartmentDao;
import org.jotasilva.db.Db;
import org.jotasilva.db.DbException;
import org.jotasilva.entities.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImp implements DepartmentDao {
    private Connection connection;

    public DepartmentDaoImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department entity) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Department (Name)" +
                " VALUES (?)";
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);
                    entity.setId(id);
                }
                Db.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected Error! no rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {

            Db.closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Department entity) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Department " +
                "SET Name = ? " +
                "WHERE Id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {

            Db.closeStatement(preparedStatement);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Department " +
                "WHERE Id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {

            Db.closeStatement(preparedStatement);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * " +
                "FROM Department " +
                "WHERE Id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return instantiateDepartment(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeStatement(preparedStatement);
            Db.closeResultSet(resultSet);
        }
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        Department dep = new Department();
        dep.setId(resultSet.getInt("Id"));
        dep.setName(resultSet.getString("Name"));
        return dep;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM Department";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Department> departments = new ArrayList<>();

            while (resultSet.next()) {
                Department dep = instantiateDepartment(resultSet);
                departments.add(dep);
            }
            return departments;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeStatement(preparedStatement);
            Db.closeResultSet(resultSet);
        }
    }
}
