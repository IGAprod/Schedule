package com.kurs.kurs.Entity;

public class Frequency{
    public static final String TABLE_NAME = "Frequency";
    public static final String ID_COLUMN  = "Id";
    public static final String WEEK_COLUMN = "week";

    private Long id;
    private String week;

    //region get,set,constructor
    public Frequency() {
    }

    public Frequency(Long id, String week) {
        this.id = id;
        this.week = week;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    //endregion
}
