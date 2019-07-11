package com.kurs.kurs.DAO.IMPL;

import com.kurs.kurs.DAO.TeacherDAO;
import com.kurs.kurs.Entity.Teacher;
import com.kurs.kurs.Entity.TypeOfLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherDaoImpl implements TeacherDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Teacher> findAll() {
        List<Teacher> result = new ArrayList<Teacher>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong(Teacher.ID_COLUMN));
                teacher.setFirstname(rs.getString(Teacher.FIRST_NAME_COLUMN));
                teacher.setLastname(rs.getString(Teacher.LAST_NAME_COLUMN));
                teacher.setPatronymic(rs.getString(Teacher.PATRONYMIC_COLUMN));
                result.add(teacher);
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
    public Teacher findById(Long id) {
        Teacher teacher = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                teacher = new Teacher();
                //hz id, name
                teacher.setId(rs.getLong(Teacher.ID_COLUMN));
                teacher.setFirstname(rs.getString(Teacher.FIRST_NAME_COLUMN));
                teacher.setLastname(rs.getString(Teacher.LAST_NAME_COLUMN));
                teacher.setPatronymic(rs.getString(Teacher.PATRONYMIC_COLUMN));
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
        return teacher;
    }

    @Override
    public void insert(Teacher teacher) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, teacher.getFirstname());
            statement.setString(2, teacher.getLastname());
            statement.setString(3, teacher.getPatronymic());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                teacher.setId(generatedKeys.getLong(1));
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
    public void update(Teacher teacher) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, teacher.getFirstname());
            statement.setString(2, teacher.getLastname());
            statement.setString(3, teacher.getPatronymic());
            statement.setLong(4, teacher.getId());
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
    public void delete(Teacher teacher) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, teacher.getId());
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
