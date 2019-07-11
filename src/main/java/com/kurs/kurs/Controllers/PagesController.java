package com.kurs.kurs.Controllers;

import com.kurs.kurs.DAO.*;
import com.kurs.kurs.Entity.*;
import com.kurs.kurs.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class PagesController {

    @Autowired
    private DataSource dataSource;


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ClassroomDAO classroomDAO;

    @Autowired
    private DaysOfTheWeekDAO daysOfTheWeekDAO;

    @Autowired
    private FacultyDAO facultyDAO;

    @Autowired
    private FrequencyDAO frequencyDAO;

    @Autowired
    private GroupOfStudentsDAO groupOfStudentsDAO;

    @Autowired
    private HousingDAO housingDAO;

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private TypeOfLessonDAO typeOfLessonDAO;


    @GetMapping(value="/main")
    public String main(){
        return "/main";
    }

    @GetMapping(value="/index")
    public String index(){
        return "/index";
    }

    @GetMapping(value="/troubles")
    public String troubles(){
        return "/troubles";
    }

    @GetMapping(value="/addRow")
    public String getaddRow(){
        return "/addRow";
    }

    @GetMapping(value="/addFaculty")
    public String getAddFaculty(){
        return "/addFaculty";
    }

    @GetMapping(value="/addFrequency")
    public String getAddFrequency(){
        return "/addFrequency";
    }

    @GetMapping(value="/addHousing")
    public String getAddHousing(){
        return "/addHousing";
    }

    @GetMapping(value="/addSubject")
    public String getAddSubject(){
        return "/addSubject";
    }

    @GetMapping(value="/addTeacher")
    public String getAddTeacher(){
        return "/addTeacher";
    }

    @GetMapping(value="/addTypeOfLesson")
    public String getAddTypeOfLesson(){
        return "/addTypeOfLesson";
    }

    @GetMapping(value="/changeTimetable")
    public String changeTimetable(){
        return "/changeTimetable";
    }



    @PostMapping(value="/addRow")
    public String addRow(@RequestParam String day){

        DaysOfTheWeek daysOfTheWeek = new DaysOfTheWeek();
        daysOfTheWeek.setDay(day);
        daysOfTheWeekDAO.insert(daysOfTheWeek);
        return "redirect:/addRow";
    }

    @PostMapping(value="/addFaculty")
    public String addFaculty(@RequestParam String name){

        Faculty faculty = new Faculty();
        faculty.setName(name);
        facultyDAO.insert(faculty);
        return "redirect:/addFaculty";
    }

    @PostMapping(value="/addFrequency")
    public String addFrequency(@RequestParam String week){

        Frequency frequency = new Frequency();
        frequency.setWeek(week);
        frequencyDAO.insert(frequency);
        return "redirect:/addFrequency";
    }

    @PostMapping(value="/addHousing")
    public String addHousing(@RequestParam String name){

        Housing housing = new Housing();
        housing.setName(name);
        housingDAO.insert(housing);
        return "redirect:/addHousing";
    }

    @PostMapping(value="/addSubject")
    public String addSubject(@RequestParam String name){

        Subject subject = new Subject();
        subject.setName(name);
        subjectDAO.insert(subject);
        return "redirect:/addSubject";
    }

    @PostMapping(value="/addTeacher")
    public String addTeacher(
            @RequestParam String first_name,
            @RequestParam String last_name,
            @RequestParam String patronymic){

        Teacher teacher = new Teacher();
        teacher.setFirstname(first_name);
        teacher.setLastname(last_name);
        teacher.setPatronymic(patronymic);
        teacherDAO.insert(teacher);
        return "redirect:/addTeacher";
    }

    @PostMapping(value="/addTypeOfLesson")
    public String addTypeOfLesson(@RequestParam String name){

        TypeOfLesson typeOfLesson = new TypeOfLesson();
        typeOfLesson.setName(name);
        typeOfLessonDAO.insert(typeOfLesson);
        return "redirect:/addTypeOfLesson";
    }



    private ArrayList<String> firstName = new ArrayList<>();

    private ArrayList<String> lastName = new ArrayList<>();

    private ArrayList<String> patronymic = new ArrayList<>();

    public void filledTableDb(ArrayList<String> fname, ArrayList<String> lname, ArrayList<String> patr) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO fio(firstName,lastName,Patronymic) VALUES(?,?,?)";
        Connection connection = null;
        connection = dataSource.getConnection();
        PreparedStatement preparedStatement =  connection.prepareStatement(insert);
        try {
            connection.setAutoCommit(false);

            int fsize = fname.size();
            int lsize = lname.size();
            int psize = patr.size();
            String f;
            String l;
            String p;

            int batchTotal=0;
            Random rnd = new Random(System.currentTimeMillis());
            for  (int i = 0; i < 100000; i++) {

                int fn = 0 + rnd.nextInt(fsize);
                f = fname.get(fn);
                int ln = 0 + rnd.nextInt(lsize);
                l = lname.get(ln);
                int pn = 0 + rnd.nextInt(psize);
                p = patr.get(pn);

                preparedStatement.setString(1, f);
                preparedStatement.setString(2, l);
                preparedStatement.setString(3, p);
                preparedStatement.addBatch();
                System.out.println(i);
                if (batchTotal++ == 4096) {
                    int[] result = preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                    batchTotal=0;
                }
            }
            if (batchTotal > 0) {
                int[] result = preparedStatement.executeBatch();
            }

            connection.commit();
        }  finally {
            preparedStatement.close();
        }

    }

    public void filledTable() {
        filledData();
        try {

            filledTableDb(firstName,lastName,patronymic);
        } catch (SQLException e) {
         e.getStackTrace();
        } catch (ClassNotFoundException e) {
           e.getStackTrace();
        }
    }

    public void filledData(){
        try{
            FileInputStream fstream = new FileInputStream("C:/Users/killp/OneDrive/Рабочий стол/Kravets_lab_1/data/names.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream,"UTF-8"));
            String strLine;
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);
                firstName.add(strLine);
            }

            //    C:\Users\killp\OneDrive\Рабочий стол\Kravets_lab_1\data
            fstream = new FileInputStream("C:/Users/killp/OneDrive/Рабочий стол/Kravets_lab_1/data/familia.txt");
            br = new BufferedReader(new InputStreamReader(fstream,"UTF-8"));
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);
                lastName.add(strLine);
            }

            fstream = new FileInputStream("C:/Users/killp/OneDrive/Рабочий стол/Kravets_lab_1/data/lastNames.txt");
            br = new BufferedReader(new InputStreamReader(fstream,"UTF-8"));
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);
                patronymic.add(strLine);
            }

        }catch (IOException e){

            System.out.println("Ошибка");
            e.getStackTrace();
        }
    }

}
