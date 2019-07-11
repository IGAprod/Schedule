package com.kurs.kurs.Entity;

import java.util.HashSet;
import java.util.Set;

public class GroupOfStudents {
    public static final String TABLE_NAME = "Class";
    public static final String ID_COLUMN  = "Id";
    public static final String NAME_COLUMN = "name";
    public static final String FACULTY_ID_COLUMN = "id_faculty";

    private Long id;
    private String name;
    private Long id_faculty;
    private Faculty faculty;

    //region get,set,constructor

    public GroupOfStudents() {}

    public GroupOfStudents(Long id, String name, Long id_faculty) {
        this.id = id;
        this.name = name;
        this.id_faculty = id_faculty;
    }

    public GroupOfStudents(Long id, String name, Long id_faculty, Faculty faculty) {
        this.id = id;
        this.name = name;
        this.id_faculty = id_faculty;
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(Long id_faculty) {
        this.id_faculty = id_faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    //endregion
}
