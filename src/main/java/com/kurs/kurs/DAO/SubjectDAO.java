package com.kurs.kurs.DAO;

import com.kurs.kurs.Entity.Subject;

import java.util.List;

public interface SubjectDAO {
    String SQL_FIND_ALL = "select * from " + Subject.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Subject.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + Subject.TABLE_NAME + " (" + Subject.NAME_COLUMN  + ") values (?)";
    String SQL_UPDATE = "update " + Subject.TABLE_NAME + " set " + Subject.NAME_COLUMN + " = ? " + " where "
            + Subject.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + Subject.TABLE_NAME + " where " + Subject.ID_COLUMN + " = ?";

    List<Subject> findAll();
    Subject findById(Long id);
    void insert(Subject subject);
    void update(Subject subject);
    void delete(Subject subject);
    void delete(Long id);

}
