package com.kurs.kurs.DAO;

import com.kurs.kurs.Entity.TypeOfLesson;

import java.util.List;

public interface TypeOfLessonDAO {
    String SQL_FIND_ALL = "select * from " + TypeOfLesson.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + TypeOfLesson.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + TypeOfLesson.TABLE_NAME + " (" + TypeOfLesson.NAME_COLUMN  + ") values (?)";
    String SQL_UPDATE = "update " + TypeOfLesson.TABLE_NAME + " set " + TypeOfLesson.NAME_COLUMN + " = ? " + " where "
            + TypeOfLesson.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + TypeOfLesson.TABLE_NAME + " where " + TypeOfLesson.ID_COLUMN + " = ?";

    List<TypeOfLesson> findAll();
    TypeOfLesson findById(Long id);
    void insert(TypeOfLesson typeOfLesson);
    void update(TypeOfLesson typeOfLesson);
    void delete(TypeOfLesson typeOfLesson);
    void delete(Long id);

}
