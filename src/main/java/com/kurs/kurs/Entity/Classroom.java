package com.kurs.kurs.Entity;

public class Classroom {
    public static final String TABLE_NAME = "Classroom";
    public static final String ID_COLUMN  = "Id";
    public static final String NUMBER_COLUMN = "number";

    private Long id;
    private String number;


    //region get,set,constructor

    public Classroom() {
    }

    public Classroom(Long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


//endregion

}
