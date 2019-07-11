package com.kurs.kurs.Entity;

public class DaysOfTheWeek {
    public static final String TABLE_NAME = "Days_of_the_week";
    public static final String ID_COLUMN  = "Id";
    public static final String DAY_COLUMN = "day";

    private Long id;
    private String day;

    //region set,get,constructor

    public DaysOfTheWeek() {}

    public DaysOfTheWeek(Long id, String day) {
        this.id = id;
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    //endregion
}
