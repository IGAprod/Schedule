package com.kurs.kurs.DAO;


import com.kurs.kurs.Entity.Frequency;

import java.util.List;

public interface FrequencyDAO {
    String SQL_FIND_ALL = "select * from " + Frequency.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Frequency.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + Frequency.TABLE_NAME + " (" + Frequency.WEEK_COLUMN  + ") values (?)";
    String SQL_UPDATE = "update " + Frequency.TABLE_NAME + " set " + Frequency.WEEK_COLUMN + " = ? " + " where " + Frequency.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + Frequency.TABLE_NAME + " where " + Frequency.ID_COLUMN + " = ?";

    List<Frequency> findAll();
    Frequency findById(Long id);
    void insert(Frequency frequency);
    void update(Frequency frequency);
    void delete(Frequency frequency);
    void delete(Long id);

}
