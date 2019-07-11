package com.kurs.kurs.Controllers;

import com.kurs.kurs.DAO.*;
import com.kurs.kurs.Entity.DaysOfTheWeek;
import com.kurs.kurs.Repository.UserRepo;
import com.kurs.kurs.domain.Response;
import com.kurs.kurs.domain.Role;
import com.kurs.kurs.domain.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tables")
@PreAuthorize("hasAuthority('ADMIN')")
public class TablesController {

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


    @GetMapping
    public String tables(){
        return "tables";
    }


    @GetMapping(value="/getTable")
    public String getTable22(Model model){
        model.addAttribute("users",userRepo.findAll());
        return "userList";
    }

}
