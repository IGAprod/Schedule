package com.kurs.kurs.DAO;

import com.kurs.kurs.Entity.Schedule;
import com.kurs.kurs.Entity.Teacher;

import java.util.List;

public interface ScheduleDAO {
    String SQL_FIND_ALL = "select * from " + Schedule.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Schedule.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + Schedule.TABLE_NAME + " ("
            + Schedule.SUBJECT_ID + ", " + Schedule.TEACHERS_ID + ", " + Schedule.TYPE_OF_LESSON_ID + ", "
            + Schedule.GROUP_OF_STUDENTS_ID + ", " + Schedule.CLASS_HOUSE_ID + ", " + Schedule.DAYS_OF_THE_WEEK_ID + ", "
            + Schedule.FREQUENCY_ID +   ", "
            + Schedule.TIME_COLUMN +   ") values (?, ?, ?, ?, ?, ?, ?,?)";
    String SQL_UPDATE = "update " + Schedule.TABLE_NAME + " set " + Schedule.SUBJECT_ID +" = ? , "
            +  Schedule.TEACHERS_ID +" = ? , " +  Schedule.TYPE_OF_LESSON_ID +" = ? , " +  Schedule.GROUP_OF_STUDENTS_ID +" = ? , "
            +  Schedule.CLASS_HOUSE_ID +" = ? , "  +  Schedule.DAYS_OF_THE_WEEK_ID +" = ? , "
            +  Schedule.FREQUENCY_ID +" = ? , " +  Schedule.TIME_COLUMN +" = ?  where " + Schedule.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + Schedule.TABLE_NAME + " where "
            + Schedule.ID_COLUMN + " = ?";



    String SQL_FIND_ALL_JOIN = "WITH house AS (SELECT class_house.id,classroom.number,housing.name FROM class_house INNER JOIN housing ON class_house.id_house = housing.id\n" +
            "\t\t\t   INNER JOIN classroom ON class_house.id_classroom = classroom.id),\n" +
            " classfaculty AS (SELECT class.id,class.name,faculty.name AS nameFaculty FROM class INNER JOIN faculty ON class.id_faculty = faculty.id)\n" +
            "\n" +
            "            SELECT timetable.id,timetable.id_subject,timetable.id_teacher,timetable.id_type_of_lesson,\n" +
            "\t\t\ttimetable.id_class, timetable.id_class_house,timetable.id_days_of_the_week,timetable.id_frequency,\n" +
            "\t\t\tdays_of_the_week.day,subject.name AS subjectName,teacher.first_name,teacher.last_name,teacher.patronymic,\n" +
            "            type_of_lesson.name AS typeName,classfaculty.name AS className,classfaculty.nameFaculty,classfaculty.id,house.number AS classroomNumber,house.name AS house ,frequency.week AS frequency,time\n" +
            "            FROM \n" +
            "            Timetable\n" +
            "             INNER JOIN house ON Timetable.id_class_house = house.id\n" +
            "\t\t\t INNER JOIN classfaculty ON Timetable.id_class = classfaculty.id\n" +
            "             INNER JOIN class ON Timetable.id_class = class.id\n" +
            "             INNER JOIN days_of_the_week ON Timetable.id_days_of_the_week = days_of_the_week.id\n" +
            "             INNER JOIN subject ON Timetable.id_subject = subject.id\n" +
            "             INNER JOIN teacher ON Timetable.id_teacher = teacher.id\n" +
            "             INNER JOIN type_of_lesson ON Timetable.id_type_of_lesson = type_of_lesson.id\n" +
            "             INNER JOIN class_house ON Timetable.id_class_house = class_house.id\n" +
            "             INNER JOIN frequency ON Timetable.id_frequency = frequency.id\n" +
            "             ";


    String SQL_FIND_BY_ID_JOIN = "WITH house AS (SELECT class_house.id,classroom.number,housing.name FROM class_house INNER JOIN housing ON class_house.id_house = housing.id\n" +
            "\t\t\t   INNER JOIN classroom ON class_house.id_classroom = classroom.id),\n" +
            " classfaculty AS (SELECT class.id,class.name,faculty.name AS nameFaculty FROM class INNER JOIN faculty ON class.id_faculty = faculty.id)\n" +
            "\n" +
            "            SELECT timetable.id,timetable.id_subject,timetable.id_teacher,timetable.id_type_of_lesson,\n" +
            "\t\t\ttimetable.id_class, timetable.id_class_house,timetable.id_days_of_the_week,timetable.id_frequency,\n" +
            "\t\t\tdays_of_the_week.day,subject.name AS subjectName,teacher.first_name,teacher.last_name,teacher.patronymic,\n" +
            "            type_of_lesson.name AS typeName,classfaculty.name AS className,classfaculty.nameFaculty,classfaculty.id,house.number AS classroomNumber,house.name AS house ,frequency.week AS frequency,time\n" +
            "            FROM \n" +
            "            Timetable\n" +
            "             INNER JOIN house ON Timetable.id_class_house = house.id\n" +
            "\t\t\t INNER JOIN classfaculty ON Timetable.id_class = classfaculty.id\n" +
            "             INNER JOIN class ON Timetable.id_class = class.id\n" +
            "             INNER JOIN days_of_the_week ON Timetable.id_days_of_the_week = days_of_the_week.id\n" +
            "             INNER JOIN subject ON Timetable.id_subject = subject.id\n" +
            "             INNER JOIN teacher ON Timetable.id_teacher = teacher.id\n" +
            "             INNER JOIN type_of_lesson ON Timetable.id_type_of_lesson = type_of_lesson.id\n" +
            "             INNER JOIN class_house ON Timetable.id_class_house = class_house.id\n" +
            "             INNER JOIN frequency ON Timetable.id_frequency = frequency.id\n" +
            "             WHERE timetable.id = ?;";

    String SQL_FIND_BY_GROUP= " WITH house AS (SELECT class_house.id,classroom.number,housing.name FROM class_house INNER JOIN housing ON class_house.id_house = housing.id\n" +
            "\t\t\t   INNER JOIN classroom ON class_house.id_classroom = classroom.id)\n" +
            "          \n" +
            "            SELECT Timetable.id,days_of_the_week.day,subject.name AS subjectName,teacher.first_name,teacher.last_name,teacher.patronymic,\n" +
            "            type_of_lesson.name AS typeName,class.name AS className,house.number AS classroomNumber,house.name AS house ,frequency.week AS frequency,time\n" +
            "            FROM \n" +
            "            Timetable\n" +
            "             INNER JOIN house ON Timetable.id_class_house = house.id\n" +
            "             INNER JOIN class ON Timetable.id_class = class.id\n" +
            "             INNER JOIN days_of_the_week ON Timetable.id_days_of_the_week = days_of_the_week.id\n" +
            "             INNER JOIN subject ON Timetable.id_subject = subject.id\n" +
            "             INNER JOIN teacher ON Timetable.id_teacher = teacher.id\n" +
            "             INNER JOIN type_of_lesson ON Timetable.id_type_of_lesson = type_of_lesson.id\n" +
            "             INNER JOIN class_house ON Timetable.id_class_house = class_house.id\n" +
            "             INNER JOIN frequency ON Timetable.id_frequency = frequency.id\n" +
            "            WHERE id_class= ? ORDER BY id_days_of_the_week,time";

    String SQL_CLASSROOM_TROUBLES = "WITH GRUP AS (SELECT id_days_of_the_week, time,id_classroom\n" +
            "\t\t\t  from schedule group by id_days_of_the_week, time, id_classroom having count(*)>1), TROUBLE AS (SELECT Schedule.id,Schedule.id_subject,Schedule.id_teachers,\n" +
            "Schedule.id_type_of_lesson,Schedule.id_class,GRUP.id_classroom,GRUP.id_days_of_the_week,Schedule.id_frequency,Schedule.time\n" +
            "FROM Schedule\n" +
            "INNER JOIN GRUP ON GRUP.id_classroom = Schedule.id_classroom\n" +
            "WHERE Schedule.id_days_of_the_week = GRUP.id_days_of_the_week AND Schedule.time = GRUP.time),\n" +
            "\n" +
            "RES AS (SELECT TROUBLE.id_days_of_the_week, TROUBLE.time,TROUBLE.id_classroom,TROUBLE.id_frequency,COUNT(TROUBLE.id_frequency) AS countFreq\n" +
            "\t\t\t  from  TROUBLE group by TROUBLE.id_days_of_the_week, TROUBLE.time,TROUBLE.id_classroom,TROUBLE.id_frequency \n" +
            "\t\t\t  having (id_frequency = 1 AND count(id_frequency) > 0) OR\n" +
            "\t\t\t  (id_frequency = 2 AND count(id_frequency) > 1) OR (id_frequency = 3 AND count(id_frequency) > 1))\n" +
            "\t\t\t  \n" +
            "SELECT days_of_the_week.day,subject.name AS subjectName,teacher.first_name,teacher.last_name,teacher.patronymic,\n" +
            "type_of_lesson.name AS typeName,class.name AS className,classroom.number AS classroomNumber,frequency.week AS frequency,\n" +
            "schedule.time\n" +
            "FROM Schedule\n" +
            "INNER JOIN RES ON RES.id_classroom = Schedule.id_classroom\n" +
            " INNER JOIN class ON Schedule.id_class = class.id\n" +
            " INNER JOIN days_of_the_week ON Schedule.id_days_of_the_week = days_of_the_week.id\n" +
            " INNER JOIN subject ON Schedule.id_subject = subject.id\n" +
            " INNER JOIN teacher ON Schedule.id_teachers = teacher.id\n" +
            " INNER JOIN type_of_lesson ON Schedule.id_type_of_lesson = type_of_lesson.id\n" +
            " INNER JOIN classroom ON Schedule.id_classroom = classroom.id\n" +
            "INNER JOIN frequency ON Schedule.id_frequency = frequency.id\n" +
            "WHERE Schedule.id_days_of_the_week = RES.id_days_of_the_week AND Schedule.time = RES.time " +
            "AND Schedule.id_frequency = RES.id_frequency\n";

    String SQL_FIND_BY_FIO = "\n" +
            "\n" +
            " WITH house AS (SELECT class_house.id,classroom.number,housing.name FROM class_house INNER JOIN housing ON class_house.id_house = housing.id\n" +
            "\t\t\t   INNER JOIN classroom ON class_house.id_classroom = classroom.id)\n" +
            "          \n" +
            "            SELECT Timetable.id ,days_of_the_week.day,subject.name AS subjectName,teacher.first_name,teacher.last_name,teacher.patronymic,\n" +
            "            type_of_lesson.name AS typeName,class.name AS className,house.number AS classroomNumber,house.name AS house ,frequency.week AS frequency,time\n" +
            "            FROM \n" +
            "            Timetable\n" +
            "             INNER JOIN house ON Timetable.id_class_house = house.id\n" +
            "             INNER JOIN class ON Timetable.id_class = class.id\n" +
            "             INNER JOIN days_of_the_week ON Timetable.id_days_of_the_week = days_of_the_week.id\n" +
            "             INNER JOIN subject ON Timetable.id_subject = subject.id\n" +
            "             INNER JOIN teacher ON Timetable.id_teacher = teacher.id\n" +
            "             INNER JOIN type_of_lesson ON Timetable.id_type_of_lesson = type_of_lesson.id\n" +
            "             INNER JOIN class_house ON Timetable.id_class_house = class_house.id\n" +
            "             INNER JOIN frequency ON Timetable.id_frequency = frequency.id\n" +
            "             WHERE  teacher.first_name = ? AND teacher.last_name = ? AND teacher.patronymic = ? ORDER BY id_days_of_the_week,time;\n" +
            "\n";

    String SQL_TEACHERS_TROUBLES = "WITH GRUP AS (SELECT id_days_of_the_week, time,id_teachers\n" +
            "\t\t\t  from schedule group by id_days_of_the_week, time, id_teachers having count(*)>1), TROUBLE AS (SELECT Schedule.id,Schedule.id_subject,Schedule.id_classroom,\n" +
            "Schedule.id_type_of_lesson,Schedule.id_class,GRUP.id_teachers,GRUP.id_days_of_the_week,Schedule.id_frequency,Schedule.time\n" +
            "FROM Schedule\n" +
            "INNER JOIN GRUP ON GRUP.id_teachers = Schedule.id_teachers\n" +
            "WHERE Schedule.id_days_of_the_week = GRUP.id_days_of_the_week AND Schedule.time = GRUP.time),\n" +
            "\n" +
            "RES AS (SELECT TROUBLE.id_days_of_the_week, TROUBLE.time,TROUBLE.id_teachers,TROUBLE.id_frequency,COUNT(TROUBLE.id_frequency) AS countFreq\n" +
            "\t\t\t  from  TROUBLE group by TROUBLE.id_days_of_the_week, TROUBLE.time,TROUBLE.id_teachers,TROUBLE.id_frequency \n" +
            "\t\t\t  having (id_frequency = 1 AND count(id_frequency) > 0) OR\n" +
            "\t\t\t  (id_frequency = 2 AND count(id_frequency) > 1) OR (id_frequency = 3 AND count(id_frequency) > 1))\n" +
            "\t\t\t  \n" +
            "SELECT days_of_the_week.day,subject.name AS subjectName,teacher.first_name,teacher.last_name,teacher.patronymic,\n" +
            "type_of_lesson.name AS typeName,class.name AS className,classroom.number AS classroomNumber,frequency.week AS frequency,\n" +
            "schedule.time\n" +
            "FROM Schedule\n" +
            "INNER JOIN RES ON RES.id_teachers = Schedule.id_teachers\n" +
            " INNER JOIN class ON Schedule.id_class = class.id\n" +
            " INNER JOIN days_of_the_week ON Schedule.id_days_of_the_week = days_of_the_week.id\n" +
            " INNER JOIN subject ON Schedule.id_subject = subject.id\n" +
            " INNER JOIN teacher ON Schedule.id_teachers = teacher.id\n" +
            " INNER JOIN type_of_lesson ON Schedule.id_type_of_lesson = type_of_lesson.id\n" +
            " INNER JOIN classroom ON Schedule.id_classroom = classroom.id\n" +
            "INNER JOIN frequency ON Schedule.id_frequency = frequency.id\n" +
            "WHERE Schedule.id_days_of_the_week = RES.id_days_of_the_week AND Schedule.time = RES.time AND Schedule.id_frequency = RES.id_frequency";

    String SQL_GROUPS_TEACHERS_TROUBLES ="WITH GRUP AS (SELECT id_days_of_the_week, time,id_teachers,id_class,id_frequency\n" +
            "\t\t\t  from schedule group by id_days_of_the_week, time, id_teachers, id_class,id_frequency having count(*)>1), TROUBLE AS (SELECT Schedule.id,Schedule.id_subject,Schedule.id_classroom,\n" +
            "Schedule.id_type_of_lesson,GRUP.id_class,GRUP.id_teachers,GRUP.id_days_of_the_week,GRUP.id_frequency,Schedule.time\n" +
            "FROM Schedule\n" +
            "INNER JOIN GRUP ON GRUP.id_class = Schedule.id_class\n" +
            "WHERE Schedule.id_days_of_the_week = GRUP.id_days_of_the_week AND Schedule.time = GRUP.time AND Schedule.id_teachers = GRUP.id_teachers AND Schedule.id_frequency = GRUP.id_frequency),\n" +
            "\n" +
            "RES AS (SELECT TROUBLE.id_days_of_the_week, TROUBLE.time,TROUBLE.id_teachers,TROUBLE.id_frequency,TROUBLE.id_class,COUNT(TROUBLE.id_frequency) AS countFreq\n" +
            "\t\t\t  from  TROUBLE group by TROUBLE.id_days_of_the_week, TROUBLE.time,TROUBLE.id_teachers,TROUBLE.id_frequency ,TROUBLE.id_class\n" +
            "\t\t\t  having (id_frequency = 1 AND count(id_frequency) > 0) OR\n" +
            "\t\t\t  (id_frequency = 2 AND count(id_frequency) > 1) OR (id_frequency = 3 AND count(id_frequency) > 1))\n" +
            "\t\t\t  \n" +
            "SELECT days_of_the_week.day,subject.name AS subjectName,teacher.first_name,teacher.last_name,teacher.patronymic,\n" +
            "type_of_lesson.name AS typeName,class.name AS className,classroom.number AS classroomNumber,frequency.week AS frequency,\n" +
            "schedule.time\n" +
            "FROM Schedule\n" +
            "INNER JOIN RES ON RES.id_class = Schedule.id_class\n" +
            " INNER JOIN class ON Schedule.id_class = class.id\n" +
            " INNER JOIN days_of_the_week ON Schedule.id_days_of_the_week = days_of_the_week.id\n" +
            " INNER JOIN subject ON Schedule.id_subject = subject.id\n" +
            " INNER JOIN teacher ON Schedule.id_teachers = teacher.id\n" +
            " INNER JOIN type_of_lesson ON Schedule.id_type_of_lesson = type_of_lesson.id\n" +
            " INNER JOIN classroom ON Schedule.id_classroom = classroom.id\n" +
            "INNER JOIN frequency ON Schedule.id_frequency = frequency.id\n" +
            "WHERE Schedule.id_days_of_the_week = RES.id_days_of_the_week AND Schedule.time = RES.time AND Schedule.id_frequency = RES.id_frequency\n" +
            "AND Schedule.id_teachers = RES.id_teachers AND Schedule.id_frequency = RES.id_frequency";

    String SQL_GROUPS_CLASSROOM_TROUBLES = "WITH GRUP AS (SELECT id_days_of_the_week, time,id_classroom,id_class,id_frequency\n" +
            "\t\t\t  from schedule group by id_days_of_the_week, time, id_classroom, id_class,id_frequency having count(*)>1), TROUBLE AS (SELECT Schedule.id,Schedule.id_subject,GRUP.id_classroom,\n" +
            "Schedule.id_type_of_lesson,GRUP.id_class,Schedule.id_teachers,GRUP.id_days_of_the_week,GRUP.id_frequency,Schedule.time\n" +
            "FROM Schedule\n" +
            "INNER JOIN GRUP ON GRUP.id_class = Schedule.id_class\n" +
            "WHERE Schedule.id_days_of_the_week = GRUP.id_days_of_the_week AND Schedule.time = GRUP.time AND Schedule.id_classroom = GRUP.id_classroom AND Schedule.id_frequency = GRUP.id_frequency),\n" +
            "\n" +
            "RES AS (SELECT TROUBLE.id_days_of_the_week, TROUBLE.time,TROUBLE.id_classroom,TROUBLE.id_frequency,TROUBLE.id_class,COUNT(TROUBLE.id_frequency) AS countFreq\n" +
            "\t\t\t  from  TROUBLE group by TROUBLE.id_days_of_the_week, TROUBLE.time,TROUBLE.id_classroom,TROUBLE.id_frequency ,TROUBLE.id_class\n" +
            "\t\t\t  having (id_frequency = 1 AND count(id_frequency) > 0) OR\n" +
            "\t\t\t  (id_frequency = 2 AND count(id_frequency) > 1) OR (id_frequency = 3 AND count(id_frequency) > 1))\n" +
            "\t\t\t  \n" +
            "SELECT days_of_the_week.day,subject.name AS subjectName,teacher.first_name,teacher.last_name,teacher.patronymic,\n" +
            "type_of_lesson.name AS typeName,class.name AS className,classroom.number AS classroomNumber,frequency.week AS frequency,\n" +
            "schedule.time\n" +
            "FROM Schedule\n" +
            "INNER JOIN RES ON RES.id_class = Schedule.id_class\n" +
            " INNER JOIN class ON Schedule.id_class = class.id\n" +
            " INNER JOIN days_of_the_week ON Schedule.id_days_of_the_week = days_of_the_week.id\n" +
            " INNER JOIN subject ON Schedule.id_subject = subject.id\n" +
            " INNER JOIN teacher ON Schedule.id_teachers = teacher.id\n" +
            " INNER JOIN type_of_lesson ON Schedule.id_type_of_lesson = type_of_lesson.id\n" +
            " INNER JOIN classroom ON Schedule.id_classroom = classroom.id\n" +
            "INNER JOIN frequency ON Schedule.id_frequency = frequency.id\n" +
            "WHERE Schedule.id_days_of_the_week = RES.id_days_of_the_week AND Schedule.time = RES.time AND Schedule.id_frequency = RES.id_frequency\n" +
            "AND Schedule.id_classroom = RES.id_classroom AND Schedule.id_frequency = RES.id_frequency";



    List<Schedule> findAllJoin();
    List<Schedule> findAllJoin(Long id);
    List<Schedule> findAll();
    List<Schedule> findByGroup(Long id);
    List<Schedule> classroomTroubles();
    List<Schedule> teachersTroubles();
    List<Schedule> groupsTeachersTroubles();
    List<Schedule> groupsClassroomTroubles();
    List<Schedule> scheduleTeacher(Teacher teacher);
    Schedule findById(Long id);
    void insert(Schedule schedule);
    void update(Schedule schedule);
    void delete(Schedule schedule);
    void delete(Long id);
}