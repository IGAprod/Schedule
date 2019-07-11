package com.kurs.kurs.Entity;

public class Teacher {
    public static final String TABLE_NAME = "Teacher";
    public static final String ID_COLUMN  = "Id";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";
    public static final String PATRONYMIC_COLUMN = "patronymic";

    private Long id;
    private String firstname;
    private String lastname;
    private String patronymic;

    //region get,set,constructor
    public Teacher(){}

    public Teacher(Long id, String firstname, String lastname, String patronymic) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    //endregion
}
