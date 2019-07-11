package com.kurs.kurs.Entity;

public class Class_house {
    public static final String TABLE_NAME = "class_house";
    public static final String ID_COLUMN  = "Id";
    public static final String CLASSROOM_ID__COLUMN = "id_classroom";
    public static final String HOUSING_ID_COLUMN = "id_housing";

    private Long id;
    private Long id_classroom;
    private Long id_housing;
    private Classroom classroom;
    private Housing housing;

    //region get,set,constructor

    public Class_house() {
    }

    public Class_house(Long id, Long id_classroom, Long id_housing, Classroom classroom, Housing housing) {
        this.id = id;
        this.id_classroom = id_classroom;
        this.id_housing = id_housing;
        this.classroom = classroom;
        this.housing = housing;
    }

    public Class_house(Long id, Long id_classroom, Long id_housing) {
        this.id = id;
        this.id_classroom = id_classroom;
        this.id_housing = id_housing;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_classroom() {
        return id_classroom;
    }

    public void setId_classroom(Long id_classroom) {
        this.id_classroom = id_classroom;
    }

    public Long getId_housing() {
        return id_housing;
    }

    public void setId_housing(Long id_housing) {
        this.id_housing = id_housing;
    }


//endregion

}
