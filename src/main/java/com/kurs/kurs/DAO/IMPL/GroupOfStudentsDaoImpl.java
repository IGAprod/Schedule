package com.kurs.kurs.DAO.IMPL;

import com.kurs.kurs.DAO.GroupOfStudentsDAO;
import com.kurs.kurs.Entity.Classroom;
import com.kurs.kurs.Entity.Faculty;
import com.kurs.kurs.Entity.GroupOfStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class GroupOfStudentsDaoImpl implements GroupOfStudentsDAO {
    @Autowired
    private DataSource dataSource;

    @Override
    public List<GroupOfStudents> findAllJoin() {
        List<GroupOfStudents> result = new ArrayList<>();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_JOIN);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Faculty faculty = new Faculty();
                groupOfStudents.setId(rs.getLong("id"));
                groupOfStudents.setName(rs.getString("name"));
                faculty.setName(rs.getString("namefaculty"));
                groupOfStudents.setFaculty(faculty);
                result.add(groupOfStudents);
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
    public List<GroupOfStudents> findAll() {
        List<GroupOfStudents> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                groupOfStudents.setId(rs.getLong(GroupOfStudents.ID_COLUMN));
                groupOfStudents.setName(rs.getString(GroupOfStudents.NAME_COLUMN));
                groupOfStudents.setId_faculty(rs.getLong(GroupOfStudents.FACULTY_ID_COLUMN));
                result.add(groupOfStudents);
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
    public List<GroupOfStudents> findByName(String name) {
        List<GroupOfStudents> result = new ArrayList<>();
        GroupOfStudents groupOfStudents = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_NAME);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                groupOfStudents = new GroupOfStudents();
                //hz id, name
                groupOfStudents.setId(rs.getLong(GroupOfStudents.ID_COLUMN));
                groupOfStudents.setName(rs.getString(GroupOfStudents.NAME_COLUMN));
                groupOfStudents.setId_faculty(rs.getLong(GroupOfStudents.FACULTY_ID_COLUMN));
                result.add(groupOfStudents);
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
    public List<GroupOfStudents> findByFaculty(Long id) {
        List<GroupOfStudents> result = new ArrayList<>();
        GroupOfStudents groupOfStudents = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID_FACULTY);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                groupOfStudents = new GroupOfStudents();
                //hz id, name
                groupOfStudents.setId(rs.getLong(GroupOfStudents.ID_COLUMN));
                groupOfStudents.setName(rs.getString(GroupOfStudents.NAME_COLUMN));
                groupOfStudents.setId_faculty(rs.getLong(GroupOfStudents.FACULTY_ID_COLUMN));
                result.add(groupOfStudents);
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
    public GroupOfStudents findById(Long id) {
        GroupOfStudents groupOfStudents = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                groupOfStudents = new GroupOfStudents();
                //hz id, name
                groupOfStudents.setId(rs.getLong(GroupOfStudents.ID_COLUMN));
                groupOfStudents.setName(rs.getString(GroupOfStudents.NAME_COLUMN));
                groupOfStudents.setId_faculty(rs.getLong(GroupOfStudents.FACULTY_ID_COLUMN));
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
        return groupOfStudents;
    }

    @Override
    public void insert(GroupOfStudents groupOfStudents) {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, groupOfStudents.getName());
            statement.setLong(3,groupOfStudents.getId_faculty());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                groupOfStudents.setId(generatedKeys.getLong(1));
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
    public void update(GroupOfStudents groupOfStudents) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, groupOfStudents.getName());
            statement.setLong(3, groupOfStudents.getId_faculty());
            statement.setLong(4, groupOfStudents.getId());
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
    public void delete(GroupOfStudents groupOfStudents) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, groupOfStudents.getId());
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
