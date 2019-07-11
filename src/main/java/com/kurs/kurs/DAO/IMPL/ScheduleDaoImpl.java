package com.kurs.kurs.DAO.IMPL;

import com.kurs.kurs.DAO.ScheduleDAO;
import com.kurs.kurs.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleDaoImpl implements ScheduleDAO {
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Schedule> findAllJoin() {
        List<Schedule> result = new ArrayList<>();


        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_JOIN);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                Frequency frequency = new Frequency();
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();
                TypeOfLesson typeOfLesson = new TypeOfLesson();
                Classroom classroom = new Classroom();
                Housing housing = new Housing();
                Class_house class_house = new Class_house();
                Faculty faculty = new Faculty();

                daysOfTheWeek.setDay(rs.getString("day"));
                subject.setName(rs.getString("subjectName"));
                teacher.setFirstname(rs.getString("first_name"));
                teacher.setLastname(rs.getString("last_name"));
                teacher.setPatronymic(rs.getString("patronymic"));
                typeOfLesson.setName(rs.getString("typeName"));
                groupOfStudents.setName(rs.getString("className"));
                classroom.setNumber(rs.getString("classroomNumber"));
                frequency.setWeek(rs.getString("frequency"));
                housing.setName(rs.getString("house"));
                faculty.setName(rs.getString("nameFaculty"));


                class_house.setHousing(housing);
                class_house.setClassroom(classroom);
                groupOfStudents.setFaculty(faculty);

                schedule.setId(rs.getLong("id"));
                schedule.setId_class_house(rs.getLong("id_class_house"));
                schedule.setId_class(rs.getLong("id_class"));
                schedule.setId_frequency(rs.getLong("id_frequency"));
                schedule.setId_teachers(rs.getLong("id_teacher"));
                schedule.setId_days_of_the_week(rs.getLong("id_days_of_the_week"));
                schedule.setId_type_of_lesson(rs.getLong("id_type_of_lesson"));
                schedule.setId_subject(rs.getLong("id_subject"));
                schedule.setDaysOfTheWeek(daysOfTheWeek);
                schedule.setSubject(subject);
                schedule.setTeacher(teacher);
                schedule.setTypeOfLesson(typeOfLesson);
                schedule.setGroupOfStudents(groupOfStudents);
                schedule.setClass_house(class_house);
                schedule.setFrequency(frequency);
                schedule.setTime(rs.getString("time"));
                System.out.println(schedule.getFrequency().getWeek());
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }



    @Override
    public List<Schedule> findAllJoin(Long id) {
        List<Schedule> result = new ArrayList<>();


        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID_JOIN);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                Frequency frequency = new Frequency();
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();
                TypeOfLesson typeOfLesson = new TypeOfLesson();
                Classroom classroom = new Classroom();
                Housing housing = new Housing();
                Class_house class_house = new Class_house();
                Faculty faculty = new Faculty();

                daysOfTheWeek.setDay(rs.getString("day"));
                subject.setName(rs.getString("subjectName"));
                teacher.setFirstname(rs.getString("first_name"));
                teacher.setLastname(rs.getString("last_name"));
                teacher.setPatronymic(rs.getString("patronymic"));
                typeOfLesson.setName(rs.getString("typeName"));
                groupOfStudents.setName(rs.getString("className"));
                classroom.setNumber(rs.getString("classroomNumber"));
                frequency.setWeek(rs.getString("frequency"));
                housing.setName(rs.getString("house"));
                faculty.setName(rs.getString("nameFaculty"));


                class_house.setHousing(housing);
                class_house.setClassroom(classroom);
                groupOfStudents.setFaculty(faculty);

                schedule.setId(rs.getLong("id"));
                schedule.setId_class_house(rs.getLong("id_class_house"));
                schedule.setId_class(rs.getLong("id_class"));
                schedule.setId_frequency(rs.getLong("id_frequency"));
                schedule.setId_teachers(rs.getLong("id_teacher"));
                schedule.setId_days_of_the_week(rs.getLong("id_days_of_the_week"));
                schedule.setId_type_of_lesson(rs.getLong("id_type_of_lesson"));
                schedule.setId_subject(rs.getLong("id_subject"));
                schedule.setDaysOfTheWeek(daysOfTheWeek);
                schedule.setSubject(subject);
                schedule.setTeacher(teacher);
                schedule.setTypeOfLesson(typeOfLesson);
                schedule.setGroupOfStudents(groupOfStudents);
                schedule.setClass_house(class_house);
                schedule.setFrequency(frequency);
                schedule.setTime(rs.getString("time"));
                System.out.println(schedule.getFrequency().getWeek());
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Schedule> findAll() {
        List<Schedule> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong(Schedule.ID_COLUMN));
                schedule.setId_subject(rs.getLong(Schedule.SUBJECT_ID));
                schedule.setId_teachers(rs.getLong(Schedule.TEACHERS_ID));
                schedule.setId_type_of_lesson(rs.getLong(Schedule.TYPE_OF_LESSON_ID));
                schedule.setId_class(rs.getLong(Schedule.GROUP_OF_STUDENTS_ID));
                schedule.setId_class_house(rs.getLong(Schedule.CLASS_HOUSE_ID));
                schedule.setId_days_of_the_week(rs.getLong(Schedule.DAYS_OF_THE_WEEK_ID));
                schedule.setId_frequency(rs.getLong(Schedule.FREQUENCY_ID));
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Schedule> findByGroup(Long id) {
        List<Schedule> result = new ArrayList<>();


        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_GROUP);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                Frequency frequency = new Frequency();
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();
                TypeOfLesson typeOfLesson = new TypeOfLesson();
                Classroom classroom = new Classroom();
                Housing housing = new Housing();
                Class_house class_house = new Class_house();

                daysOfTheWeek.setDay(rs.getString("day"));
                subject.setName(rs.getString("subjectName"));
                teacher.setFirstname(rs.getString("first_name"));
                teacher.setLastname(rs.getString("last_name"));
                teacher.setPatronymic(rs.getString("patronymic"));
                typeOfLesson.setName(rs.getString("typeName"));
                groupOfStudents.setName(rs.getString("className"));
                classroom.setNumber(rs.getString("classroomNumber"));
                frequency.setWeek(rs.getString("frequency"));
                housing.setName(rs.getString("house"));

                System.out.println(housing.getName());

                class_house.setHousing(housing);
                class_house.setClassroom(classroom);

                schedule.setId(rs.getLong("id"));
                schedule.setDaysOfTheWeek(daysOfTheWeek);
                schedule.setSubject(subject);
                schedule.setTeacher(teacher);
                schedule.setTypeOfLesson(typeOfLesson);
                schedule.setGroupOfStudents(groupOfStudents);
                schedule.setClass_house(class_house);
                schedule.setFrequency(frequency);
                schedule.setTime(rs.getString("time"));
                System.out.println(schedule.getFrequency().getWeek());
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Schedule> classroomTroubles() {
        List<Schedule> result = new ArrayList<>();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_CLASSROOM_TROUBLES);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                Frequency frequency = new Frequency();
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();
                TypeOfLesson typeOfLesson = new TypeOfLesson();
                Classroom classroom = new Classroom();

                System.out.println(rs.getString("day"));
                daysOfTheWeek.setDay(rs.getString("day"));
                subject.setName(rs.getString("subjectName"));
                teacher.setFirstname(rs.getString("first_name"));
                teacher.setLastname(rs.getString("last_name"));
                teacher.setPatronymic(rs.getString("patronymic"));
                typeOfLesson.setName(rs.getString("typeName"));
                groupOfStudents.setName(rs.getString("className"));
                classroom.setNumber(rs.getString("classroomNumber"));
                frequency.setWeek(rs.getString("frequency"));

                schedule.setDaysOfTheWeek(daysOfTheWeek);
                schedule.setSubject(subject);
                schedule.setTeacher(teacher);
                schedule.setTypeOfLesson(typeOfLesson);
                schedule.setGroupOfStudents(groupOfStudents);
            //    schedule.setClassroom(classroom);
                schedule.setFrequency(frequency);
                schedule.setTime(rs.getString("time"));
                System.out.println(schedule.getFrequency().getWeek());
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Schedule> teachersTroubles() {
        List<Schedule> result = new ArrayList<>();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_TEACHERS_TROUBLES);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                Frequency frequency = new Frequency();
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();
                TypeOfLesson typeOfLesson = new TypeOfLesson();
                Classroom classroom = new Classroom();

                System.out.println(rs.getString("day"));
                daysOfTheWeek.setDay(rs.getString("day"));
                subject.setName(rs.getString("subjectName"));
                teacher.setFirstname(rs.getString("first_name"));
                teacher.setLastname(rs.getString("last_name"));
                teacher.setPatronymic(rs.getString("patronymic"));
                typeOfLesson.setName(rs.getString("typeName"));
                groupOfStudents.setName(rs.getString("className"));
                classroom.setNumber(rs.getString("classroomNumber"));
                frequency.setWeek(rs.getString("frequency"));

                schedule.setDaysOfTheWeek(daysOfTheWeek);
                schedule.setSubject(subject);
                schedule.setTeacher(teacher);
                schedule.setTypeOfLesson(typeOfLesson);
                schedule.setGroupOfStudents(groupOfStudents);
         //       schedule.setClassroom(classroom);
                schedule.setFrequency(frequency);
                schedule.setTime(rs.getString("time"));
                System.out.println(schedule.getFrequency().getWeek());
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Schedule> groupsTeachersTroubles() {
        List<Schedule> result = new ArrayList<>();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_GROUPS_TEACHERS_TROUBLES);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                Frequency frequency = new Frequency();
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();
                TypeOfLesson typeOfLesson = new TypeOfLesson();
                Classroom classroom = new Classroom();

                System.out.println(rs.getString("day"));
                daysOfTheWeek.setDay(rs.getString("day"));
                subject.setName(rs.getString("subjectName"));
                teacher.setFirstname(rs.getString("first_name"));
                teacher.setLastname(rs.getString("last_name"));
                teacher.setPatronymic(rs.getString("patronymic"));
                typeOfLesson.setName(rs.getString("typeName"));
                groupOfStudents.setName(rs.getString("className"));
                classroom.setNumber(rs.getString("classroomNumber"));
                frequency.setWeek(rs.getString("frequency"));

                schedule.setDaysOfTheWeek(daysOfTheWeek);
                schedule.setSubject(subject);
                schedule.setTeacher(teacher);
                schedule.setTypeOfLesson(typeOfLesson);
                schedule.setGroupOfStudents(groupOfStudents);
           //     schedule.setClassroom(classroom);
                schedule.setFrequency(frequency);
                schedule.setTime(rs.getString("time"));
                System.out.println(schedule.getFrequency().getWeek());
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Schedule> groupsClassroomTroubles() {
        List<Schedule> result = new ArrayList<>();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_GROUPS_CLASSROOM_TROUBLES);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                Frequency frequency = new Frequency();
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();
                TypeOfLesson typeOfLesson = new TypeOfLesson();
                Class_house class_house = new Class_house();

                System.out.println(rs.getString("day"));
                daysOfTheWeek.setDay(rs.getString("day"));
                subject.setName(rs.getString("subjectName"));
                teacher.setFirstname(rs.getString("first_name"));
                teacher.setLastname(rs.getString("last_name"));
                teacher.setPatronymic(rs.getString("patronymic"));
                typeOfLesson.setName(rs.getString("typeName"));
                groupOfStudents.setName(rs.getString("className"));
    //            Class_house.set(rs.getString("classroomNumber"));
                frequency.setWeek(rs.getString("frequency"));

                schedule.setDaysOfTheWeek(daysOfTheWeek);
                schedule.setSubject(subject);
                schedule.setTeacher(teacher);
                schedule.setTypeOfLesson(typeOfLesson);
                schedule.setGroupOfStudents(groupOfStudents);
   //             schedule.se(classroom);
                schedule.setFrequency(frequency);
                schedule.setTime(rs.getString("time"));
                System.out.println(schedule.getFrequency().getWeek());
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Schedule> scheduleTeacher(Teacher teacher) {
        List<Schedule> result = new ArrayList<>();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_FIO);
            statement.setString(1, teacher.getFirstname());
            statement.setString(2, teacher.getLastname());
            statement.setString(3, teacher.getPatronymic());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
                Frequency frequency = new Frequency();
                GroupOfStudents groupOfStudents = new GroupOfStudents();
                Subject subject = new Subject();
                Teacher temp = new Teacher();
                TypeOfLesson typeOfLesson = new TypeOfLesson();
                Classroom classroom = new Classroom();
                Housing housing = new Housing();
                Class_house class_house = new Class_house();

                System.out.println(rs.getString("day"));
                daysOfTheWeek.setDay(rs.getString("day"));
                subject.setName(rs.getString("subjectName"));
                temp.setFirstname(rs.getString("first_name"));
                temp.setLastname(rs.getString("last_name"));
                temp.setPatronymic(rs.getString("patronymic"));
                typeOfLesson.setName(rs.getString("typeName"));
                groupOfStudents.setName(rs.getString("className"));
                classroom.setNumber(rs.getString("classroomNumber"));
                frequency.setWeek(rs.getString("frequency"));
                housing.setName(rs.getString("house"));

                class_house.setClassroom(classroom);
                class_house.setHousing(housing);

                schedule.setId(rs.getLong("id"));
                schedule.setDaysOfTheWeek(daysOfTheWeek);
                schedule.setSubject(subject);
                schedule.setTeacher(temp);
                schedule.setTypeOfLesson(typeOfLesson);
                schedule.setGroupOfStudents(groupOfStudents);
                schedule.setClass_house(class_house);
                schedule.setFrequency(frequency);
                schedule.setTime(rs.getString("time"));
                System.out.println(schedule.getFrequency().getWeek());
                result.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Schedule findById(Long id) {
        Schedule schedule = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                schedule = new Schedule();
                //hz id, name
                schedule.setId(rs.getLong(Schedule.ID_COLUMN));
                schedule.setId_subject(rs.getLong(Schedule.SUBJECT_ID));
                schedule.setId_teachers(rs.getLong(Schedule.TEACHERS_ID));
                schedule.setId_type_of_lesson(rs.getLong(Schedule.TYPE_OF_LESSON_ID));
                schedule.setId_class(rs.getLong(Schedule.GROUP_OF_STUDENTS_ID));
                schedule.setId_class_house(rs.getLong(Schedule.CLASS_HOUSE_ID));
                schedule.setId_days_of_the_week(rs.getLong(Schedule.DAYS_OF_THE_WEEK_ID));
                schedule.setId_frequency(rs.getLong(Schedule.FREQUENCY_ID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return schedule;
    }

    @Override
    public void insert(Schedule schedule) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1,schedule.getId_subject());
            statement.setLong(2,schedule.getId_teachers());
            statement.setLong(3,schedule.getId_type_of_lesson());
            statement.setLong(4,schedule.getId_class());
            statement.setLong(5,schedule.getId_class_house());
            statement.setLong(6,schedule.getId_days_of_the_week());
            statement.setLong(7,schedule.getId_frequency());
            statement.setTime(8,Time.valueOf(schedule.getTime()));
            statement.execute();
        //    Time t =new Time(1,1,1);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                schedule.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Schedule schedule) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);

            System.out.println(schedule.getId_subject().toString() + schedule.getId_teachers().toString() + schedule.getId_type_of_lesson().toString() + schedule.getId_class().toString()
                    + schedule.getId_class_house().toString() + schedule.getId_days_of_the_week().toString() + schedule.getId_frequency().toString()  +  schedule.getTime());



            statement.setLong(1,schedule.getId_subject());
            statement.setLong(2,schedule.getId_teachers());
            statement.setLong(3,schedule.getId_type_of_lesson());
            statement.setLong(4,schedule.getId_class());
            statement.setLong(5,schedule.getId_class_house());
            statement.setLong(6,schedule.getId_days_of_the_week());
            statement.setLong(7,schedule.getId_frequency());
            statement.setTime(8,Time.valueOf(schedule.getTime()));
            statement.setLong(9, schedule.getId());


            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Schedule schedule) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, schedule.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
