package com.kurs.kurs.Entity;

import java.util.HashSet;
import java.util.Set;

public class Faculty{
    public static final String TABLE_NAME = "Faculty";
    public static final String ID_COLUMN  = "Id";
    public static final String NAME_COLUMN = "Name";

    private Long id;
    private String name;
    private Set<GroupOfStudents> items = new HashSet<>();

    //region set,get,constructor

    public Faculty() {}

    public Faculty(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Faculty(Long id, String name, Set<GroupOfStudents> items) {
        this.id = id;
        this.name = name;
        this.items = items;
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

    public Set<GroupOfStudents> getItems() {
        return items;
    }

    public void setItems(Set<GroupOfStudents> items) {
        this.items = items;
    }
    //endregion
}
