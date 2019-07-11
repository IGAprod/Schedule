package com.kurs.kurs.DAO;

import com.kurs.kurs.Entity.Class_house;

import java.util.List;

public interface Class_houseDAO {
    String SQL_FIND_ALL = "select * from " + Class_house.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Class_house.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + Class_house.TABLE_NAME + " ("
            + Class_house.CLASSROOM_ID__COLUMN + ", " + Class_house.HOUSING_ID_COLUMN + ") values (?, ?)";
    String SQL_UPDATE = "update " + Class_house.TABLE_NAME + " set " + Class_house.CLASSROOM_ID__COLUMN +" = ? , "
            + Class_house.HOUSING_ID_COLUMN +" = ?  where " + Class_house.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + Class_house.TABLE_NAME + " where "
            + Class_house.ID_COLUMN + " = ?";
    String SQL_FIND_ALL_JOIN = "SELECT class_house.id,classroom.number AS classroomNumber,housing.name AS housingName\n" +
            "FROM \n" +
            "class_house\n" +
            " INNER JOIN classroom ON class_house.id_classroom = classroom.id\n" +
            " INNER JOIN housing ON class_house.id_house = housing.id";

    List<Class_house> findAllJoin();
    List<Class_house> findAll();
    Class_house findById(Long id);
    void insert(Class_house class_house);
    void update(Class_house class_house);
    void delete(Class_house class_house);
    void delete(Long id);
}