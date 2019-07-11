package com.kurs.kurs.Entity;

public class TypeOfLesson {
    public static final String TABLE_NAME = "Type_of_lesson";
    public static final String ID_COLUMN  = "Id";
    public static final String NAME_COLUMN = "name";

    private Long id;
    private String name;

    //region get,set,constructor
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

    public TypeOfLesson(){}

    public TypeOfLesson(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    //endregion
}
