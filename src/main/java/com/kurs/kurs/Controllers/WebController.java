package com.kurs.kurs.Controllers;


import com.kurs.kurs.DAO.*;
import com.kurs.kurs.Entity.*;
import com.kurs.kurs.Repository.UserRepo;
import com.kurs.kurs.domain.Response;
import com.kurs.kurs.domain.Role;
import com.kurs.kurs.domain.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebController {

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

    @Autowired
    private Class_houseDAO class_houseDAO;

    @GetMapping("/getDaysOfTheWeek")
    public Response Request() throws IOException {
        Response response = new Response("Done", daysOfTheWeekDAO.findAll());
        return response;
    }

    @GetMapping("/getFaculty")
    public Response getFaculty() throws IOException {
        Response response = new Response("Done", facultyDAO.findAll());
        return response;
    }


    @GetMapping("/getFrequecny")
    public Response getFrequecny() throws IOException {
        Response response = new Response("Done", frequencyDAO.findAll());
        return response;
    }

    @GetMapping("/getHousing")
    public Response getHousing() throws IOException {
        Response response = new Response("Done", housingDAO.findAll());
        return response;
    }

    @GetMapping("/getSubject")
    public Response getSubject() throws IOException {
        Response response = new Response("Done", subjectDAO.findAll());
        return response;
    }


    @GetMapping("/getTeacher")
    public Response getTeacher() throws IOException {
        Response response = new Response("Done", teacherDAO.findAll());
        return response;
    }

    @GetMapping("/getTypeOfLesson")
    public Response getTypeOfLesson() throws IOException {
        Response response = new Response("Done", typeOfLessonDAO.findAll());
        return response;
    }

    @GetMapping("/getGroups")
    public Response getGroups() throws IOException {
        Response response = new Response("Done", groupOfStudentsDAO.findAll());
        return response;
    }

    @GetMapping("/getClassroom")
    public Response getClassroom() throws IOException {
        Response response = new Response("Done", classroomDAO.findAll());
        return response;
    }

    @GetMapping("/classRoomTroubles")
    public Response classRoomTroubles() throws IOException {
        Response response = new Response("Done", scheduleDAO.classroomTroubles());
        return response;
    }

    @GetMapping("/teachersTroubles")
    public Response teachersTroubles() throws IOException {
        Response response = new Response("Done", scheduleDAO.teachersTroubles());
        return response;
    }


    @GetMapping("/groupTeachersTroubles")
    public Response groupTeachersTroubles() throws IOException {
        Response response = new Response("Done", scheduleDAO.groupsTeachersTroubles());
        return response;
    }


    @GetMapping("/groupClassTroubles")
    public Response groupClassTroubles() throws IOException {
        Response response = new Response("Done", scheduleDAO.groupsClassroomTroubles());
        return response;
    }


  /*  @GetMapping("/getMasTables")
    public Response getMasTables() throws IOException {

        ArrayList<String[][]> list =  new ArrayList<>();
        String[][] tableClassroom = new String[100][100];
        Response response = new Response("Done", scheduleDAO.groupsClassroomTroubles());
        return response;
    }*/


  /*  @GetMapping("/getMasTabless")
    public Response getMasTablses() throws IOException, JSONException {

        List<Subject> subjects = subjectDAO.findAll();
        List<Teacher> teachers = teacherDAO.findAll();
        List<TypeOfLesson> typeOfLessons = typeOfLessonDAO.findAll();
        List<GroupOfStudents> groupOfStudents = groupOfStudentsDAO.findAllJoin();
        List<DaysOfTheWeek> daysOfTheWeeks = daysOfTheWeekDAO.findAll();
        List<Frequency> frequencies = frequencyDAO.findAll();
        List<Class_house> class_houses = class_houseDAO.findAllJoin();
        List<Schedule> schedules = scheduleDAO.findAllJoin();
        HashMap<String,List> hashMap = new HashMap<>();
        hashMap.put("subjects",subjects);
        hashMap.put("teachers",teachers);
        hashMap.put("typeOfLessons",typeOfLessons);
        hashMap.put("class",groupOfStudents);
        hashMap.put("daysOfTheWeeks",daysOfTheWeeks);
        hashMap.put("frequency",frequencies);
        hashMap.put("class_house",class_houses);

        Response response = new Response("Done", hashMap);
        return response;
    }*/



    @GetMapping("/getAllTables")
    public Response getAllTables() throws IOException, JSONException {

        List<Subject> subjects = subjectDAO.findAll();
        List<Teacher> teachers = teacherDAO.findAll();
        List<TypeOfLesson> typeOfLessons = typeOfLessonDAO.findAll();
        List<GroupOfStudents> groupOfStudents = groupOfStudentsDAO.findAllJoin();
        List<DaysOfTheWeek> daysOfTheWeeks = daysOfTheWeekDAO.findAll();
        List<Frequency> frequencies = frequencyDAO.findAll();
        List<Class_house> class_houses = class_houseDAO.findAllJoin();
        HashMap<String,List> hashMap = new HashMap<>();
        hashMap.put("subjects",subjects);
        hashMap.put("teachers",teachers);
        hashMap.put("typeOfLessons",typeOfLessons);
        hashMap.put("class",groupOfStudents);
        hashMap.put("daysOfTheWeeks",daysOfTheWeeks);
        hashMap.put("frequency",frequencies);
        hashMap.put("class_house",class_houses);
        return new Response("Done", hashMap);

    }


    @PostMapping("/getMasTables")
    public Response getMasTables(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));

        List<Subject> subjects = subjectDAO.findAll();
        List<Teacher> teachers = teacherDAO.findAll();
        List<TypeOfLesson> typeOfLessons = typeOfLessonDAO.findAll();
        List<GroupOfStudents> groupOfStudents = groupOfStudentsDAO.findAllJoin();
        List<DaysOfTheWeek> daysOfTheWeeks = daysOfTheWeekDAO.findAll();
        List<Frequency> frequencies = frequencyDAO.findAll();
        List<Class_house> class_houses = class_houseDAO.findAllJoin();
        List<Schedule> schedules = scheduleDAO.findAllJoin(id);
        HashMap<String,List> hashMap = new HashMap<>();
        hashMap.put("subjects",subjects);
        hashMap.put("teachers",teachers);
        hashMap.put("typeOfLessons",typeOfLessons);
        hashMap.put("class",groupOfStudents);
        hashMap.put("daysOfTheWeeks",daysOfTheWeeks);
        hashMap.put("frequency",frequencies);
        hashMap.put("class_house",class_houses);
        hashMap.put("schedule",schedules);

        return new Response("Done", hashMap);

    }
    @PostMapping("/addSchedule")
    public void addSchedule(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id_subject = JSON.getLong("id_subject");
        Long id_teacher = JSON.getLong("id_teacher");
        Long id_type_of_lesson = JSON.getLong("id_type_of_lesson");
        Long id_class = JSON.getLong("id_class");
        Long id_class_house = JSON.getLong("id_class_house");
        Long id_days_of_the_week = JSON.getLong("id_days_of_the_week");
        Long id_frequency = JSON.getLong("id_frequency");
        String time = JSON.getString("time");
        Schedule schedule = new Schedule();
        schedule.setId_subject(id_subject);
        schedule.setId_teachers(id_teacher);
        schedule.setId_type_of_lesson(id_type_of_lesson);
        schedule.setId_class(id_class);
        schedule.setId_class_house(id_class_house);
        schedule.setId_days_of_the_week(id_days_of_the_week);
        schedule.setId_frequency(id_frequency);
        schedule.setTime(time);
        System.out.println(schedule.getTime());

        System.out.println("dasdasdasdas");

        scheduleDAO.insert(schedule);

    }


    @PostMapping("/changeSchedule")
    public void changeSchedule(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        Long id_subject = JSON.getLong("id_subject");
        Long id_teacher = JSON.getLong("id_teacher");
        Long id_type_of_lesson = JSON.getLong("id_type_of_lesson");
        Long id_class = JSON.getLong("id_class");
        Long id_class_house = JSON.getLong("id_class_house");
        Long id_days_of_the_week = JSON.getLong("id_days_of_the_week");
        Long id_frequency = JSON.getLong("id_frequency");
        String time = JSON.getString("time");
        Schedule schedule = new Schedule();
        schedule.setId(id);
        schedule.setId_subject(id_subject);
        schedule.setId_teachers(id_teacher);
        schedule.setId_type_of_lesson(id_type_of_lesson);
        schedule.setId_class(id_class);
        schedule.setId_class_house(id_class_house);
        schedule.setId_days_of_the_week(id_days_of_the_week);
        schedule.setId_frequency(id_frequency);
        schedule.setTime(time);
        System.out.println(schedule.getTime());

        System.out.println("dasdasdasdas");

        scheduleDAO.update(schedule);

    }



    @PostMapping("/update")
    public void update(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String day = JSON.getString("day");
        DaysOfTheWeek dw = new DaysOfTheWeek(id,day);

        daysOfTheWeekDAO.update(dw);

    }

    @PostMapping("/updateFaculty")
    public void updateFaculty(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String name = JSON.getString("name");
        Faculty dw = new Faculty(id,name);

        facultyDAO.update(dw);

    }

    @PostMapping("/updateFrequency")
    public void updateFrequecny(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String week = JSON.getString("week");
        Frequency fr = new Frequency(id,week);
        frequencyDAO.update(fr);
    }

    @PostMapping("/updateHousing")
    public void updateHousing(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String name = JSON.getString("name");
        Housing housing = new Housing(id,name);

        housingDAO.update(housing);

    }

    @PostMapping("/updateSubject")
    public void updateSubject(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String name = JSON.getString("name");
        Subject subject = new Subject(id,name);

        subjectDAO.update(subject);

    }

    @PostMapping("/updateTeacher")
    public void updateTeahcer(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String first_name = JSON.getString("first_name");
        String last_name = JSON.getString("last_name");
        String patronymic = JSON.getString("patronymic");

        Teacher teacher = new Teacher(id,first_name,last_name,patronymic);

        teacherDAO.update(teacher);

    }

    @PostMapping("/updateGroups")
    public void updateGroups(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String name = JSON.getString("name");
        Long id_faculty = JSON.getLong("id_faculty");


        GroupOfStudents groupOfStudents = new GroupOfStudents(id,name,id_faculty);
        groupOfStudentsDAO.update(groupOfStudents);

    }

    @PostMapping("/updateTypeOfLesson")
    public void updateTypeOfLesson(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String name = JSON.getString("name");
        TypeOfLesson typeOfLesson = new TypeOfLesson(id,name);

        typeOfLessonDAO.update(typeOfLesson);

    }

    @PostMapping("/updateClassroom")
    public void updateClassroom(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);

        Long id = Long.parseLong(JSON.getString("id"));
        String name = JSON.getString("name");
        Classroom classroom = new Classroom(id,name);
        classroomDAO.update(classroom);
    }



    @PostMapping("/deleteGroups")
    public void deleteGroups(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        groupOfStudentsDAO.delete(id);
    }


    @PostMapping("/deleteClassroom")
    public void deleteClassroom(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        classroomDAO.delete(id);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        daysOfTheWeekDAO.delete(id);
    }


    @PostMapping("/deleteFaculty")
    public void deleteFaculty(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        facultyDAO.delete(id);
    }

    @PostMapping("/deleteFrequency")
    public void deleteFrequency(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        frequencyDAO.delete(id);
    }

    @PostMapping("/deleteHousing")
    public void     deleteHousing(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        housingDAO.delete(id);
    }

    @PostMapping("/deleteSubject")
    public void deleteSubject(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        subjectDAO.delete(id);
    }


    @PostMapping("/deleteTeacher")
    public void deleteTeacher(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        teacherDAO.delete(id);
    }

    @PostMapping("/deleteSchedule")
    public void deleteSchedule(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        scheduleDAO.delete(id);
    }

    @PostMapping("/deleteTypeOfLesson")
    public void deleteTypeOfLesson(@RequestBody String request) throws IOException, JSONException {

        JSONObject JSON = new JSONObject(request);
        Long id = Long.parseLong(JSON.getString("id"));
        typeOfLessonDAO.delete(id);
    }


    @PostMapping("/getGroupsByName")
    public Response getGroupsByName(@RequestBody String request) throws IOException, JSONException {
        JSONObject JSON = new JSONObject(request);
        String name = JSON.getString("name");
        Response response = new Response("Done", groupOfStudentsDAO.findByName(name));
        return response;
    }

    @PostMapping("/getGroupsByFacultyId")
    public Response getGroupsByFacultyId(@RequestBody String request) throws IOException, JSONException {
        JSONObject JSON = new JSONObject(request);
        Long faucltyId = Long.parseLong(JSON.getString("id_faculty"));
        Response response = new Response("Done", groupOfStudentsDAO.findByFaculty(faucltyId));
        return response;
    }

    @PostMapping("/getScheduleByGroupId")
    public Response getScheduleByGroupId(@RequestBody String request) throws IOException, JSONException {
        JSONObject JSON = new JSONObject(request);
        Long groupId = Long.parseLong(JSON.getString("id_group"));
        Response response = new Response("Done", scheduleDAO.findByGroup(groupId));
        return response;
    }



  /*  @PostMapping Mapping("/getGroupsByName")
    public Response getGroupsByName(RequestBody String request) throws IOException {
        Response response = new Response("Done", groupOfStudentsDAO.findByName());
        return response;
    }*/

    public Boolean check( ArrayList<Schedule> check, Schedule schedule){
        for (Schedule value : check) {
            if (schedule.getTime().equals(value.getTime()) &&
                    schedule.getId_class_house().equals(value.getId_class_house()) &&
                    schedule.getId_days_of_the_week().equals(value.getId_days_of_the_week())) {

                return true;
            }
        }
        return false;
    }

    public Boolean checkTimeDay( ArrayList<Schedule> check, Schedule schedule){
        for (Schedule value : check) {
            if (schedule.getTime().equals(value.getTime()) &&
                    schedule.getId_days_of_the_week().equals(value.getId_days_of_the_week())) {

                return true;
            }
        }
        return false;
    }



    @GetMapping(value = "/getTroublesGroupClassRoom")
    public Response getTroublesGroupClassRoom(){

        ArrayList<Schedule> list =  (ArrayList<Schedule>)scheduleDAO.findAllJoin();
        List<Schedule> result = new ArrayList<>();
        ArrayList<Schedule> check = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){

            if(!checkTimeDay(check, list.get(i))) {
                check.add(list.get(i));
                int countEvrTime = 0, countOneWeek = 0, countTwoWeek = 0;
                Long idClassHouse = list.get(i).getId_class_house();
                Long idDay = list.get(i).getId_days_of_the_week();
                String time = list.get(i).getTime();
                System.out.println(list.get(i).getId());

                for (Schedule value : list) {

                    if (
                            list.get(i).getId_days_of_the_week().equals(value.getId_days_of_the_week()) &&
                            list.get(i).getTime().equals(value.getTime()) &&
                            list.get(i).getId_class().equals(value.getId_class())) {

                        if (value.getId_frequency() == 1) {
                            countEvrTime++;
                        }
                        if (value.getId_frequency() == 2) {
                            countOneWeek++;
                        }
                        if (value.getId_frequency() == 3) {
                            countTwoWeek++;
                        }
                    }
                }


                if(countEvrTime > 1 || (countEvrTime == 1 && countOneWeek > 0) || (countEvrTime == 1 && countTwoWeek > 0)){
                    for (Schedule schedule : list) {
                        if (
                                list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                list.get(i).getTime().equals(schedule.getTime()) &&
                                list.get(i).getId_class().equals(schedule.getId_class())) {
                            result.add(schedule);
                        }
                    }
                }else {
                    if (countEvrTime == 0 && countOneWeek > 1) {
                        for (Schedule schedule : list) {
                            if (
                                    list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                    list.get(i).getTime().equals(schedule.getTime()) &&
                                    list.get(i).getId_class().equals(schedule.getId_class()) &&
                                    schedule.getId_frequency() == 2) {
                                result.add(schedule);
                            }
                        }
                    }
                    if (countEvrTime == 0 && countTwoWeek > 1) {
                        for (Schedule schedule : list) {
                            if (
                                    list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                    list.get(i).getTime().equals(schedule.getTime()) &&
                                    list.get(i).getId_class().equals(schedule.getId_class()) &&
                                    schedule.getId_frequency() == 3) {
                                result.add(schedule);
                            }
                        }
                    }
                }
            }




         /*   for(int p = 0; p < list.size(); p++){
                if(list.get(p).getId_class_house().equals(idClassHouse)
                        && list.get(p).getId_days_of_the_week().equals(idDay) && list.get(p).getTime().equals(time)){
                    System.out.println("delete" + list.get(p).getId());
                        list.remove(list.get(p));
                }
            }*/

        }

        System.out.println("fsasdf");
        for (Schedule value : result) {

            System.out.println(value.getId());
        }




        Response response = new Response("Done", result);
        return response;


    }




    @GetMapping(value = "/getTroublesTeachers")
    public Response getTroublesTeachers(){

        ArrayList<Schedule> list =  (ArrayList<Schedule>)scheduleDAO.findAllJoin();
        List<Schedule> result = new ArrayList<>();
        ArrayList<Schedule> check = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){

            if(!checkTimeDay(check, list.get(i))) {
                check.add(list.get(i));
                int countEvrTime = 0, countOneWeek = 0, countTwoWeek = 0;
                Long idClassHouse = list.get(i).getId_class_house();
                Long idDay = list.get(i).getId_days_of_the_week();
                String time = list.get(i).getTime();
                System.out.println(list.get(i).getId());

                for (Schedule value : list) {

                    if (    list.get(i).getId_days_of_the_week().equals(value.getId_days_of_the_week()) &&
                            list.get(i).getTime().equals(value.getTime()) &&
                            list.get(i).getId_teachers().equals(value.getId_teachers())) {

                        if (value.getId_frequency() == 1) {
                            countEvrTime++;
                        }
                        if (value.getId_frequency() == 2) {
                            countOneWeek++;
                        }
                        if (value.getId_frequency() == 3) {
                            countTwoWeek++;
                        }
                    }
                }


                if(countEvrTime > 1 || (countEvrTime == 1 && countOneWeek > 0) || (countEvrTime == 1 && countTwoWeek > 0)){
                    for (Schedule schedule : list) {
                        if (
                                list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                list.get(i).getTime().equals(schedule.getTime()) &&
                                list.get(i).getId_teachers().equals(schedule.getId_teachers())) {
                            result.add(schedule);
                        }
                    }
                }else {
                    if (countEvrTime == 0 && countOneWeek > 1) {
                        for (Schedule schedule : list) {
                            if (
                                    list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                    list.get(i).getTime().equals(schedule.getTime()) &&
                                    list.get(i).getId_teachers().equals(schedule.getId_teachers()) &&
                                    schedule.getId_frequency() == 2) {
                                result.add(schedule);
                            }
                        }
                    }
                    if (countEvrTime == 0 && countTwoWeek > 1) {
                        for (Schedule schedule : list) {
                            if (
                                    list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                    list.get(i).getTime().equals(schedule.getTime()) &&
                                    list.get(i).getId_teachers().equals(schedule.getId_teachers()) &&
                                    schedule.getId_frequency() == 3) {
                                result.add(schedule);
                            }
                        }
                    }
                }
            }




         /*   for(int p = 0; p < list.size(); p++){
                if(list.get(p).getId_class_house().equals(idClassHouse)
                        && list.get(p).getId_days_of_the_week().equals(idDay) && list.get(p).getTime().equals(time)){
                    System.out.println("delete" + list.get(p).getId());
                        list.remove(list.get(p));
                }
            }*/

        }

        System.out.println("fsasdf");
        for (Schedule value : result) {

            System.out.println(value.getId());
        }




        Response response = new Response("Done", result);
        return response;


    }


    @GetMapping(value = "/getTroublesClassRoom")
    public Response getTroublesClassRoom(){

        ArrayList<Schedule> list =  (ArrayList<Schedule>)scheduleDAO.findAllJoin();
        List<Schedule> result = new ArrayList<>();
        ArrayList<Schedule> check = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){

                if(!check(check, list.get(i))) {
                    check.add(list.get(i));
                    int countEvrTime = 0, countOneWeek = 0, countTwoWeek = 0;
                    Long idClassHouse = list.get(i).getId_class_house();
                    Long idDay = list.get(i).getId_days_of_the_week();
                    String time = list.get(i).getTime();
                    System.out.println(list.get(i).getId());

                    for (Schedule value : list) {

                        if (list.get(i).getId_class_house().equals(value.getId_class_house()) &&
                                list.get(i).getId_days_of_the_week().equals(value.getId_days_of_the_week()) &&
                                list.get(i).getTime().equals(value.getTime())) {

                            if (value.getId_frequency() == 1) {
                                countEvrTime++;
                            }
                            if (value.getId_frequency() == 2) {
                                countOneWeek++;
                            }
                            if (value.getId_frequency() == 3) {
                                countTwoWeek++;
                            }
                        }
                    }


                    if(countEvrTime > 1 || (countEvrTime == 1 && countOneWeek > 0) || (countEvrTime == 1 && countTwoWeek > 0)){
                        for (Schedule schedule : list) {
                            if (list.get(i).getId_class_house().equals(schedule.getId_class_house()) &&
                                    list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                    list.get(i).getTime().equals(schedule.getTime())) {
                                result.add(schedule);
                            }
                        }
                    }else {
                        if (countEvrTime == 0 && countOneWeek > 1) {
                            for (Schedule schedule : list) {
                                if (list.get(i).getId_class_house().equals(schedule.getId_class_house()) &&
                                        list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                        list.get(i).getTime().equals(schedule.getTime()) && schedule.getId_frequency() == 2) {
                                    result.add(schedule);
                                }
                            }
                        }
                        if (countEvrTime == 0 && countTwoWeek > 1) {
                            for (Schedule schedule : list) {
                                if (list.get(i).getId_class_house().equals(schedule.getId_class_house()) &&
                                        list.get(i).getId_days_of_the_week().equals(schedule.getId_days_of_the_week()) &&
                                        list.get(i).getTime().equals(schedule.getTime()) && schedule.getId_frequency() == 3) {
                                    result.add(schedule);
                                }
                            }
                        }
                    }
                }




         /*   for(int p = 0; p < list.size(); p++){
                if(list.get(p).getId_class_house().equals(idClassHouse)
                        && list.get(p).getId_days_of_the_week().equals(idDay) && list.get(p).getTime().equals(time)){
                    System.out.println("delete" + list.get(p).getId());
                        list.remove(list.get(p));
                }
            }*/

        }

        System.out.println("fsasdf");
        for (Schedule value : result) {

            System.out.println(value.getId());
        }




        Response response = new Response("Done", result);
        return response;


    }

    @PostMapping(value="/scheduleTeacher")
    public Response scheduleTeacher(@RequestBody String request) throws JSONException {
        JSONObject JSON = new JSONObject(request);
        String first_name = JSON.getString("first_name");
        String last_name = JSON.getString("last_name");
        String patronymic = JSON.getString("patronymic");
        Teacher teacher = new Teacher();
        teacher.setFirstname(first_name);
        teacher.setLastname(last_name);
        teacher.setPatronymic(patronymic);
        Response response = new Response("Done", scheduleDAO.scheduleTeacher(teacher));
        return response;
    }


}
