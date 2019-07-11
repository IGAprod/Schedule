package com.kurs.kurs.DAO.IMPL;


import com.kurs.kurs.DAO.Class_houseDAO;
import com.kurs.kurs.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Class_houseDaoImpl implements Class_houseDAO {
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Class_house> findAllJoin() {
        List<Class_house> result = new ArrayList<>();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_JOIN);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Class_house class_house = new Class_house();
                Classroom classroom = new Classroom();
                Housing housing = new Housing();
                class_house.setId(rs.getLong("id"));
                classroom.setNumber(rs.getString("classroomnumber"));
                housing.setName(rs.getString("housingname"));
                class_house.setClassroom(classroom);
                class_house.setHousing(housing);
                result.add(class_house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Class_house> findAll() {
        List<Class_house> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Class_house class_house = new Class_house();
                class_house.setId(rs.getLong(Class_house.ID_COLUMN));
                class_house.setId_classroom(rs.getLong(Class_house.CLASSROOM_ID__COLUMN));
                class_house.setId_housing(rs.getLong(Class_house.HOUSING_ID_COLUMN));
                result.add(class_house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Class_house findById(Long id) {
        Class_house class_house = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                class_house = new Class_house();
                //hz id, name
                class_house.setId(rs.getLong(Class_house.ID_COLUMN));
                class_house.setId_classroom(rs.getLong(Class_house.CLASSROOM_ID__COLUMN));
                class_house.setId_housing(rs.getLong(Class_house.HOUSING_ID_COLUMN));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return class_house;
    }

    @Override
    public void insert(Class_house class_house) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, class_house.getId_classroom());
            statement.setLong(2,class_house.getId_housing());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                class_house.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Class_house class_house) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setLong(1, class_house.getId_classroom());
            statement.setLong(2, class_house.getId_housing());
            statement.setLong(3, class_house.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Class_house class_house) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, class_house.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
