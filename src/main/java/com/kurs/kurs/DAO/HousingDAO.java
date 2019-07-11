package com.kurs.kurs.DAO;

import com.kurs.kurs.Entity.Housing;

import java.util.List;

public interface HousingDAO {
    String SQL_FIND_ALL = "select * from " + Housing.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Housing.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + Housing.TABLE_NAME + " (" + Housing.NAME_COLUMN  + ") values (?)";
    String SQL_UPDATE = "update " + Housing.TABLE_NAME + " set " + Housing.NAME_COLUMN + " = ? " + " where "
            + Housing.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + Housing.TABLE_NAME + " where " + Housing.ID_COLUMN + " = ?";

    List<Housing> findAll();
    Housing findById(Long id);
    void insert(Housing housing);
    void update(Housing housing);
    void delete(Housing housing);
    void delete(Long id);

}
