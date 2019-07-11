package com.kurs.kurs.Entity;

public class Subject {
    public static final String TABLE_NAME = "Subject";
    public static final String ID_COLUMN  = "Id";
    public static final String NAME_COLUMN = "name";

    private Long id;
    private String name;

    //region get,set,constructor
    public  Subject(){}

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
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
    //endregion

}
