package com.kurs.kurs.DAO;


import com.kurs.kurs.Entity.DaysOfTheWeek;

import java.util.List;

public interface DaysOfTheWeekDAO {
    String SQL_FIND_ALL = "select * from " + DaysOfTheWeek.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + DaysOfTheWeek.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + DaysOfTheWeek.TABLE_NAME + " (" + DaysOfTheWeek.DAY_COLUMN + ") values (?)";
    String SQL_UPDATE = "update " + DaysOfTheWeek.TABLE_NAME + " set " + DaysOfTheWeek.DAY_COLUMN + " = ? " + " where "
            + DaysOfTheWeek.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + DaysOfTheWeek.TABLE_NAME + " where " + DaysOfTheWeek.ID_COLUMN + " = ?";

    List<DaysOfTheWeek> findAll();
    DaysOfTheWeek findById(Long id);
    void insert(DaysOfTheWeek daysOfTheWeek);
    void update(DaysOfTheWeek daysOfTheWeek);
    void delete(DaysOfTheWeek daysOfTheWeek);
    void delete(Long id);

}
