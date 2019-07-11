package com.kurs.kurs.DAO;

import com.kurs.kurs.Entity.Faculty;

import java.util.List;

public interface FacultyDAO {
    String SQL_FIND_ALL = "select * from " + Faculty.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Faculty.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + Faculty.TABLE_NAME + " (" + Faculty.NAME_COLUMN  + ") values (?)";
    String SQL_UPDATE = "update " + Faculty.TABLE_NAME + " set " + Faculty.NAME_COLUMN + " = ? " + " where "
            + Faculty.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + Faculty.TABLE_NAME + " where " + Faculty.ID_COLUMN + " = ?";

    List<Faculty> findAll();
    Faculty findById(Long id);
    void insert(Faculty faculty);
    void update(Faculty faculty);
    void delete(Faculty faculty);
    void delete(Long id);

}
