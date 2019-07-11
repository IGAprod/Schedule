package com.kurs.kurs.Entity;

public class Schedule {
    public static final String TABLE_NAME = "Timetable";
    public static final String ID_COLUMN  = "Id";
    public static final String SUBJECT_ID = "id_subject";
    public static final String TEACHERS_ID = "id_teacher";
    public static final String TYPE_OF_LESSON_ID = "id_type_of_lesson";
    public static final String GROUP_OF_STUDENTS_ID = "id_class";
    public static final String CLASS_HOUSE_ID = "id_class_house";
    public static final String DAYS_OF_THE_WEEK_ID = "id_days_of_the_week";
    public static final String FREQUENCY_ID = "id_frequency";
    public static final String TIME_COLUMN = "time";

    private Long id;
    private Long id_subject;
    private Long id_teachers;
    private Long id_type_of_lesson;
    private Long id_class;
    private Long id_class_house;
    private Long id_days_of_the_week;
    private Long id_frequency;
    private Subject subject;
    private Teacher teacher;
    private TypeOfLesson typeOfLesson;
    private GroupOfStudents groupOfStudents;
    private Class_house class_house;
    private DaysOfTheWeek daysOfTheWeek;
    private Frequency frequency;
    private String time;

    //region get,set,constructor


    public Schedule() {
    }

    public Schedule(Long id, Long id_subject, Long id_teachers, Long id_type_of_lesson, Long id_class,
                    Long id_class_house, Long id_days_of_the_week, Long id_frequency) {
        this.id = id;
        this.id_subject = id_subject;
        this.id_teachers = id_teachers;
        this.id_type_of_lesson = id_type_of_lesson;
        this.id_class = id_class;
        this.id_class_house = id_class_house;
        this.id_days_of_the_week = id_days_of_the_week;
        this.id_frequency = id_frequency;
    }

    public Schedule(Long id, Long id_subject, Long id_teachers, Long id_type_of_lesson, Long id_class,
                    Long id_class_house, Long id_days_of_the_week, Long id_frequency, Subject subject, Teacher teacher,
                    TypeOfLesson typeOfLesson, GroupOfStudents groupOfStudents, Class_house class_house,
                    DaysOfTheWeek daysOfTheWeek, Frequency frequency, String time) {
        this.id = id;
        this.id_subject = id_subject;
        this.id_teachers = id_teachers;
        this.id_type_of_lesson = id_type_of_lesson;
        this.id_class = id_class;
        this.id_class_house = id_class_house;
        this.id_days_of_the_week = id_days_of_the_week;
        this.id_frequency = id_frequency;
        this.subject = subject;
        this.teacher = teacher;
        this.typeOfLesson = typeOfLesson;
        this.groupOfStudents = groupOfStudents;
        this.class_house = class_house;
        this.daysOfTheWeek = daysOfTheWeek;
        this.frequency = frequency;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_subject() {
        return id_subject;
    }

    public void setId_subject(Long id_subject) {
        this.id_subject = id_subject;
    }

    public Long getId_teachers() {
        return id_teachers;
    }

    public void setId_teachers(Long id_teachers) {
        this.id_teachers = id_teachers;
    }

    public Long getId_type_of_lesson() {
        return id_type_of_lesson;
    }

    public void setId_type_of_lesson(Long id_type_of_lesson) {
        this.id_type_of_lesson = id_type_of_lesson;
    }

    public Long getId_class() {
        return id_class;
    }

    public void setId_class(Long id_class) {
        this.id_class = id_class;
    }

    public Long getId_class_house() {
        return id_class_house;
    }

    public void setId_class_house(Long id_class_house) {
        this.id_class_house = id_class_house;
    }

    public Long getId_days_of_the_week() {
        return id_days_of_the_week;
    }

    public void setId_days_of_the_week(Long id_days_of_the_week) {
        this.id_days_of_the_week = id_days_of_the_week;
    }

    public Long getId_frequency() {
        return id_frequency;
    }

    public void setId_frequency(Long id_frequency) {
        this.id_frequency = id_frequency;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TypeOfLesson getTypeOfLesson() {
        return typeOfLesson;
    }

    public void setTypeOfLesson(TypeOfLesson typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }

    public GroupOfStudents getGroupOfStudents() {
        return groupOfStudents;
    }

    public void setGroupOfStudents(GroupOfStudents groupOfStudents) {
        this.groupOfStudents = groupOfStudents;
    }

    public Class_house getClass_house() {
        return class_house;
    }

    public void setClass_house(Class_house class_house) {
        this.class_house = class_house;
    }

    public DaysOfTheWeek getDaysOfTheWeek() {
        return daysOfTheWeek;
    }

    public void setDaysOfTheWeek(DaysOfTheWeek daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    //endregion
}
