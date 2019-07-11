package com.kurs.kurs.DAO;

import com.kurs.kurs.Entity.Classroom;
import com.kurs.kurs.Entity.GroupOfStudents;


import java.util.List;

public interface GroupOfStudentsDAO {
    String SQL_FIND_ALL = "select * from " + GroupOfStudents.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + GroupOfStudents.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + GroupOfStudents.TABLE_NAME + " ("
            + GroupOfStudents.NAME_COLUMN  + ", " + GroupOfStudents.FACULTY_ID_COLUMN + ") values (?, ?, ?)";
    String SQL_UPDATE = "update " + GroupOfStudents.TABLE_NAME + " set " + GroupOfStudents.NAME_COLUMN +" = ? , "
             +  GroupOfStudents.FACULTY_ID_COLUMN +" = ?  where " + GroupOfStudents.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + GroupOfStudents.TABLE_NAME + " where "
            + GroupOfStudents.ID_COLUMN + " = ?";
    String SQL_FIND_BY_NAME = "select " + GroupOfStudents.NAME_COLUMN + " from " + GroupOfStudents.TABLE_NAME + " where "
            + GroupOfStudents.NAME_COLUMN
            + " = ?";
    String SQL_FIND_BY_ID_FACULTY = "select * from " + GroupOfStudents.TABLE_NAME
            + " where " + GroupOfStudents.FACULTY_ID_COLUMN
            + " = ?";
    String SQL_FIND_ALL_JOIN = "SELECT class.id,class.name,faculty.name AS nameFaculty\n" +
            "FROM \n" +
            "class\n" +
            " INNER JOIN faculty ON class.id_faculty = faculty.id";

    List<GroupOfStudents> findAllJoin();
    List<GroupOfStudents> findAll();
    List<GroupOfStudents> findByName(String name);
    List<GroupOfStudents> findByFaculty(Long id);
    GroupOfStudents findById(Long id);
    void insert(GroupOfStudents groupOfStudents);
    void update(GroupOfStudents groupOfStudents);
    void delete(GroupOfStudents groupOfStudents);
    void delete(Long id);

}