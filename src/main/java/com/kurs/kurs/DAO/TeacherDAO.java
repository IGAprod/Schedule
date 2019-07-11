package com.kurs.kurs.DAO;


import com.kurs.kurs.Entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    String SQL_FIND_ALL = "select * from " + Teacher.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Teacher.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + Teacher.TABLE_NAME + " (" + Teacher.FIRST_NAME_COLUMN
            + ", " + Teacher.LAST_NAME_COLUMN  + ", " + Teacher.PATRONYMIC_COLUMN + ") values (?, ?, ?)";
    String SQL_UPDATE = "update " + Teacher.TABLE_NAME + " set " + Teacher.FIRST_NAME_COLUMN +" = ? , "
            +  Teacher.LAST_NAME_COLUMN +" = ? , "  +  Teacher.PATRONYMIC_COLUMN +" = ?  where " + Teacher.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + Teacher.TABLE_NAME + " where " + Teacher.ID_COLUMN + " = ?";



    List<Teacher> findAll();
    Teacher findById(Long id);
    void insert(Teacher teacher);
    void update(Teacher teacher);
    void delete(Teacher teacher);
    void delete(Long id);

}
