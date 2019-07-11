package com.kurs.kurs.Controllers;


import com.kurs.kurs.DAO.*;
import com.kurs.kurs.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tableUser")
@PreAuthorize("hasAuthority('USER')")
public class TablesUserController {

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
        return "tableUser";
    }

}
