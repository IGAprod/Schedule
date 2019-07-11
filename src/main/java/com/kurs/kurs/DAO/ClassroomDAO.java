package com.kurs.kurs.DAO;

import com.kurs.kurs.Entity.Classroom;

import java.util.List;

public interface ClassroomDAO {
    String SQL_FIND_ALL = "select * from " + Classroom.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Classroom.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + Classroom.TABLE_NAME + " ("
            + Classroom.NUMBER_COLUMN +") values (?)";
    String SQL_UPDATE = "update " + Classroom.TABLE_NAME + " set " + Classroom.NUMBER_COLUMN +" = ? "
            + "   where " + Classroom.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + Classroom.TABLE_NAME + " where "
            + Classroom.ID_COLUMN + " = ?";



    List<Classroom> findAll();
    Classroom findById(Long id);
    void insert(Classroom classroom);
    void update(Classroom classroom);
    void delete(Classroom classroom);
    void delete(Long id);
}