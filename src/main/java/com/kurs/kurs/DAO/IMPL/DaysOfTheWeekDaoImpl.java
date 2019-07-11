package com.kurs.kurs.DAO.IMPL;

import com.kurs.kurs.DAO.DaysOfTheWeekDAO;
import com.kurs.kurs.Entity.DaysOfTheWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DaysOfTheWeekDaoImpl implements DaysOfTheWeekDAO {
    @Autowired
    private DataSource dataSource;

    @Override
    public List<DaysOfTheWeek> findAll() {
        List<DaysOfTheWeek> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                daysOfTheWeek.setId(rs.getLong(DaysOfTheWeek.ID_COLUMN));
                daysOfTheWeek.setDay(rs.getString(DaysOfTheWeek.DAY_COLUMN));
                result.add(daysOfTheWeek);
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
    public DaysOfTheWeek findById(Long id) {
        DaysOfTheWeek daysOfTheWeek = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                daysOfTheWeek = new DaysOfTheWeek();
                //hz id, name
                daysOfTheWeek.setId(rs.getLong(DaysOfTheWeek.ID_COLUMN));
                daysOfTheWeek.setDay(rs.getString(DaysOfTheWeek.DAY_COLUMN));
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
        return daysOfTheWeek;
    }

    @Override
    public void insert(DaysOfTheWeek daysOfTheWeek) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, daysOfTheWeek.getDay());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                daysOfTheWeek.setId(generatedKeys.getLong(1));
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
    public void update(DaysOfTheWeek daysOfTheWeek) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, daysOfTheWeek.getDay());
            statement.setLong(2, daysOfTheWeek.getId());
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
    public void delete(DaysOfTheWeek daysOfTheWeek) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, daysOfTheWeek.getId());
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
