var currentGroupId;
var currentFacultyId;
var deleteClick = false;
$(document).ready(function () {

    loadFaculty();

    function loadFaculty() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getFaculty",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push(" <table class=\"table table-dark mt-3\" id=\"chooseFaculty\"><thead> <tr><th>Название факультета</th> </tr> </thead>");

                    $.each(result.data,function (i,faculty) {
                        c.push('<tr  value="' + faculty.name + '" id="' + faculty.id + '" ><td><span class="goFacultyButton" > <a href="#" class="btn btn-link " >' + faculty.name + '</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#Table').html(c.join(""));
                }

                else{
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }


    $(document).on('click', '.goFacultyButton', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');


        var id = tbl_row.attr('id');
        var value = tbl_row.attr('value');
        currentFacultyId = id;
        loadGroups(id);

    });

    function loadGroups(facultyID) {

        var formData = {
            id_faculty : facultyID
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/getGroupsByFacultyId",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];

                    c.push("  <a href=\"#\" class=\"btn btn-default\" id=\"backToFaculty\">Назад</a> <table class=\"table table-dark mt-3\" id=\"chooseGroup\">" +
                        " <table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> <tr><th>Название группы</th> </tr> </thead>");

                    $.each(result.data,function (i,group) {
                        c.push('<tr value="' + group.name + '" id="' + group.id + '" ><td><span class="goGroupsButton" > <a href="#" class="btn btn-link " >' + group.name + '</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#Table').html(c.join(""));
                }

                else{
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    $(document).on('click', '#backToFaculty', function(event)
    {
        event.preventDefault();
        loadFaculty();
    });

    $(document).on('click', '.goGroupsButton', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');


        var id = tbl_row.attr('id');
        var value = tbl_row.attr('value');
        currentGroupId = id;
        loadSchudele(id);


    });

    $(document).on('click', '#backToGroup', function(event)
    {
        event.preventDefault();
        loadGroups(currentFacultyId);
    });


    function loadSchudele(groupId) {

        var formData = {
            id_group : groupId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/getScheduleByGroupId",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('#Table').empty();
                    var c = [];

                    c.push("  <a href=\"#\" class=\"btn btn-default\" id=\"backToGroup\">Назад</a><a href=\"#\" class=\"btn btn-default\" id=\"addSchedule\">Добавить запись</a> " +
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Время</th> <th>Предмет</th><th>Преподаватель</th>  <th>Вид занятия</th> " +
                        "<th>Аудитория</th><th>Частота</th></tr> </thead>");

                    var currentday = "";
                    $.each(result.data,function (i,schedule) {

                        if(schedule.daysOfTheWeek.day.toString() == currentday){
                            c.push('<tr  class=\"scheduleTr\" row_id = ' + schedule.id+ ' ><td></td>');
                        }else{
                            c.push('<tr  class=\"scheduleTr\" row_id = ' + schedule.id+ '><td>' + schedule.daysOfTheWeek.day + '</td>');
                        }
                        c.push('<td>' + schedule.time.substring(0,5) + '</td>');
                        c.push('<td>' + schedule.subject.name + '</td>');
                        c.push('<td>' + schedule.teacher.firstname + " " + schedule.teacher.lastname.charAt(0) + "."
                            + schedule.teacher.patronymic.charAt(0) +  '</td>');
                        c.push('<td>' + schedule.typeOfLesson.name + '</td>');
                        c.push('<td>' + schedule.class_house.classroom.number + " - к." + schedule.class_house.housing.name + '</td>');
                        c.push('<td>' + schedule.frequency.week + '</td>');
                        c.push('<td><span class="btn_delete"> <a href="#" class="btn btn-link" row_id="' + schedule.id + '"> Delete</a> </span></td></tr>');


                        currentday = schedule.daysOfTheWeek.day;
                    });
                    c.push('</table>')
                    $('#Table').html(c.join(""));
                }

                else{
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }


    $(document).on('click', '.scheduleTeacher', function(event)
    {
        event.preventDefault();
        var firstName = $('input[name="first_name"]').val();
        var lastName = $('input[name="last_name"]').val();
        var patronymic = $('input[name="patronymic"]').val();
        loadSchudeleTeacher(firstName,lastName,patronymic);
    });



    function loadSchudeleTeacher(firstName,lastName,Patronymic) {

        var formData = {
            first_name : firstName,
            last_name : lastName,
            patronymic : Patronymic
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/scheduleTeacher",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('#Table').empty();
                    var c = [];

                    c.push("  <a href=\"#\" class=\"btn btn-default\" id=\"backToFaculty\">Назад</a><a href=\"#\" class=\"btn btn-default\" id=\"addSchedule\">Добавить запись</a> " +
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Время</th> <th>Предмет</th><th>Преподаватель</th>  <th>Вид занятия</th> " +
                        "<th>Аудитория</th><th>Частота</th></tr> </thead>");

                    var currentday = "";
                    $.each(result.data,function (i,schedule) {

                        if(schedule.daysOfTheWeek.day.toString() == currentday){
                            c.push('<tr ><td></td>');
                        }else{
                            c.push('<tr><td>' + schedule.daysOfTheWeek.day + '</td>');
                        }
                        c.push('<td>' + schedule.time.substring(0,5) + '</td>');
                        c.push('<td>' + schedule.subject.name + '</td>');
                        c.push('<td>' + schedule.teacher.firstname + " " + schedule.teacher.lastname.charAt(0) + "."
                            + schedule.teacher.patronymic.charAt(0) +  '</td>');
                        c.push('<td>' + schedule.typeOfLesson.name + '</td>');
                        c.push('<td>' + schedule.class_house.classroom.number + " - к." + schedule.class_house.housing.name + '</td>');
                        c.push('<td>' + schedule.frequency.week + '</td></tr>');


                        currentday = schedule.daysOfTheWeek.day;
                    });
                    c.push('</table>')
                    $('#Table').html(c.join(""));
                }

                else{
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    $(document).on('click', '.btn_delete', function(event)
    {
        event.preventDefault();
        deleteClick = true;
        var tbl_row = $(this).closest('tr');
        var row_id = tbl_row.attr('row_id');
        alert(row_id);

        udalitDw(row_id);

    });


    $(document).on('click', '.scheduleTr', function(event)
    {
        event.preventDefault();
        if(deleteClick === false){
            var tbl_row = $(this).closest('tr');
            var row_id = tbl_row.attr('row_id');
             //location.href = 'http://www.yandex.ru/';
                loadMas(row_id);
        }

    });


    $(document).on('click', '.btn-changeRow', function(event)
    {
        event.preventDefault();
        var changeId = $( "#changeRowId" ).val();
        var subject = $( "#subject option:selected" ).val();
        var teacher =  $( "#teacher option:selected" ).val();
        var typeOfLesson = $( "#typeOfLesson option:selected" ).val();
        var group = $( "#class option:selected" ).val();
        var class_house = $( "#class_house option:selected" ).val();
        var days_of_the_week = $( "#days_of_the_week option:selected" ).val();
        var frequency = $( "#frequency option:selected" ).val();
        var time = $( "#changeTime" ).val() + ':00';
        console.log(changeId,subject,teacher,typeOfLesson,group,class_house,days_of_the_week,frequency,time);
        changeRow(changeId,subject,teacher,typeOfLesson,group,class_house,days_of_the_week,frequency,time);

    });


    function changeRow(changeId,subject,teacher,typeOfLesson,group,class_house,days_of_the_week,frequency,time) {

        var formData = {
            id : changeId,
            id_subject : subject,
            id_teacher : teacher,
            id_type_of_lesson : typeOfLesson,
            id_class : group,
            id_class_house : class_house,
            id_days_of_the_week : days_of_the_week,
            id_frequency : frequency,
            time : time

        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/changeSchedule",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
                deleteClick = false;
            },
            error: function (e) {
                loadSchudele(currentGroupId);
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.btn-addRow', function(event)
    {
        event.preventDefault();
        var subject = $( "#subject option:selected" ).val();
        var teacher =  $( "#teacher option:selected" ).val();
        var typeOfLesson = $( "#typeOfLesson option:selected" ).val();
        var group = $( "#class option:selected" ).val();
        var class_house = $( "#class_house option:selected" ).val();
        var days_of_the_week = $( "#days_of_the_week option:selected" ).val();
        var frequency = $( "#frequency option:selected" ).val();
        var time = $( "#changeTime" ).val() + ':00';
        console.log(subject,teacher,typeOfLesson,group,class_house,days_of_the_week,frequency,time);
        addRow(subject,teacher,typeOfLesson,group,class_house,days_of_the_week,frequency,time);

    });

    function addRow(subject,teacher,typeOfLesson,group,class_house,days_of_the_week,frequency,time) {

        var formData = {
            id_subject : subject,
            id_teacher : teacher,
            id_type_of_lesson : typeOfLesson,
            id_class : group,
            id_class_house : class_house,
            id_days_of_the_week : days_of_the_week,
            id_frequency : frequency,
            time : time

        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/addSchedule",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
                deleteClick = false;
            },
            error: function (e) {
                loadSchudele(currentGroupId);
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '#backToSchedule', function(event)
    {
        event.preventDefault();
        loadSchudele(currentGroupId);


    });

    $(document).on('click', '#addSchedule', function(event)
    {
        event.preventDefault();
        if(deleteClick === false){
            //location.href = 'http://www.yandex.ru/';
            loadAdd();
        }

    });


    function loadAdd() {


        $.ajax({

            url: "http://localhost:8080/getAllTables",

            success: function(result){
                if(result.status === "Done"){
                    $(document).find('#Table').empty();
                    var c = [];

                    c.push(" <div style='margin-top:20px' ><a class=\"btn btn-outline-primary\"  href='#' class='btn btn-default' id='backToSchedule'>Назад</a></div>")
                    c.push(" <div style='margin-top: 5px' ><select  class=\"browser-default custom-select\"  id=\"subject\" name=\"subject\">\n" +
                        "    </select></div>");
                    c.push("<div style='margin-top: 5px' ><select  class=\"browser-default custom-select\" id=\"teacher\" name=\"teacher\">\n" +
                        "    </select></div>\n");
                    c.push(" <div style='margin-top: 5px' ><select  class=\"browser-default custom-select\" id=\"typeOfLesson\" name=\"typeOfLesson\">\n" +
                        "    </select></div>\n");
                    c.push("<div style='margin-top: 5px' ><select  class=\"browser-default custom-select\" id=\"class\" name=\"class\">\n" +
                        "    </select></div>");
                    c.push("<div style='margin-top: 5px' ><select  class=\"browser-default custom-select\" id=\"class_house\" name=\"class_house\">\n" +
                        "    </select></div>");
                    c.push("\n" +
                        "    <div style='margin-top: 5px' ><select  class=\"browser-default custom-select\" id=\"days_of_the_week\" name=\"days_of_the_week\">\n" +
                        "    </select></div>\n");
                    c.push("\n" +
                        "    <div style='margin-top: 5px' ><select  class=\"browser-default custom-select\" id=\"frequency\" name=\"frequency\">\n" +
                        "    </select></div>");
                    c.push("<div><input style='margin-top: 20px' id='changeTime'  type=\"time\" value=\"08:00\">")
                    c.push("<input style='margin-left: 20px' class=\"btn btn-addRow\" type=\"submit\" value=\"Добавить\">")
                    $('#Table').append(c.join(""));



                    c = [];
                    $.each(result.data.subjects,function (i,subject) {
                        c.push("<option value="+ subject.id +">" + subject.name+ "</option>");
                    });
                    $('#subject').append(c.join(""));


                    c = [];
                    $.each(result.data.teachers,function (i,teacher) {
                        c.push("<option value="+ teacher.id +">" + teacher.firstname + "  " + teacher.lastname
                                + "   " + teacher.patronymic   +  "</option>");
                    });
                    $('#teacher').append(c.join(""));


                    c = [];
                    $.each(result.data.typeOfLessons,function (i,typeOfLesson) {
                        c.push("<option value="+ typeOfLesson.id +">" + typeOfLesson.name+ "</option>");
                    });
                    $('#typeOfLesson').append(c.join(""));

                    c = [];
                    $.each(result.data.class,function (i,groupOfStudent) {
                        c.push("<option value="+ groupOfStudent.id +">" + groupOfStudent.name+ "  "
                                + groupOfStudent.faculty.name+ "</option>");
                    });

                    $('#class').append(c.join(""));

                    c = [];
                    $.each(result.data.class_house,function (i,classHouse) {
                        c.push("<option value="+ classHouse.id +">" + classHouse.classroom.number+ "  "
                            + classHouse.housing.name+ "</option>");
                    });
                    $('#class_house').append(c.join(""));

                    c = [];
                    $.each(result.data.daysOfTheWeeks,function (i,dayOfTheWeek) {
                            c.push("<option value="+ dayOfTheWeek.id +">" + dayOfTheWeek.day+ "</option>");
                    });
                    $('#days_of_the_week').append(c.join(""));

                    c = [];
                    $.each(result.data.frequency,function (i,freq) {
                            c.push("<option value="+ freq.id +">" + freq.week+ "</option>");
                    });
                    $('#frequency').append(c.join(""));

                }

                else{
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }


    function loadMas(idSchedule) {

        var formData = {
            id : idSchedule
        }


        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/getMasTables",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('#Table').empty();
                    var c = [];

                    c.push(" <div  style='margin-top: 20px'><a class=\"btn btn-outline-primary\" href='#' class='btn btn-default' id='backToSchedule'>Назад</a><input type=\"hidden\" name=\"rowId\" id='changeRowId' value=" +  result.data.schedule[0].id + "></div>")
                    c.push(" <div style='margin-top: 5px' ><select class=\"browser-default custom-select\"  id=\"subject\" name=\"subject\">\n" +
                        "        <option value=" + result.data.schedule[0].id_subject + "> " +  result.data.schedule[0].subject.name + "</option> \n" +
                        "    </select></div>");
                    c.push("<div style='margin-top: 5px' ><select class=\"browser-default custom-select\"  id=\"teacher\" name=\"teacher\">\n" +
                        "          <option value="+ result.data.schedule[0].id_teachers + ">" + result.data.schedule[0].teacher.firstname
                        + "  " + result.data.schedule[0].teacher.lastname + "  " +  result.data.schedule[0].teacher.patronymic + " </option> \n" +
                        "    </select></div>\n");
                    c.push(" <div style='margin-top: 5px' ><select class=\"browser-default custom-select\" id=\"typeOfLesson\" name=\"typeOfLesson\">\n" +
                        "     <option value=" + result.data.schedule[0].id_type_of_lesson + ">" +result.data.schedule[0].typeOfLesson.name + "</option> \n" +
                        "    </select></div>\n");
                    c.push("<div style='margin-top: 5px' ><select  class=\"browser-default custom-select\" id=\"class\" name=\"class\">\n" +
                        "          <option value="+ result.data.schedule[0].id_class +">" + result.data.schedule[0].groupOfStudents.name + "  "
                        + result.data.schedule[0].groupOfStudents.faculty.name + "</option> \n" +
                        "    </select></div>");
                    c.push("<div style='margin-top: 5px' ><select class=\"browser-default custom-select\"  id=\"class_house\" name=\"class_house\">\n" +
                        "           <option value="+ result.data.schedule[0].id_class_house +">"+ result.data.schedule[0].class_house.classroom.number
                        + "  " + result.data.schedule[0].class_house.housing.name +"</option> \n" +
                        "    </select></div>");
                    c.push("\n" +
                        "    <div style='margin-top: 5px' ><select class=\"browser-default custom-select\"  id=\"days_of_the_week\" name=\"days_of_the_week\">\n" +
                        "           <option value="+ result.data.schedule[0].id_days_of_the_week + "> " +
                        result.data.schedule[0].daysOfTheWeek.day+"</option> \n" +
                        "    </select></div>\n");
                    c.push("\n" +
                        "    <div style='margin-top: 5px' ><select class=\"browser-default custom-select\"  id=\"frequency\" name=\"frequency\">\n" +
                        "          <option value="+ result.data.schedule[0].id_frequency +">"+
                        result.data.schedule[0].frequency.week+"</option> \n" +
                        "    </select></div>");
                    c.push("<div><input style='margin-top: 20px' id='changeTime'  type=\"time\" value="+ result.data.schedule[0].time.substring(0,5)  + ">")
                    c.push("<input style='margin-left: 20px' class=\"btn btn-changeRow\" type=\"submit\" value=\"Изменить\">")
                    $('#Table').append(c.join(""));



                    c = [];
                    $.each(result.data.subjects,function (i,subject) {

                        if(subject.id !== result.data.schedule[0].id_subject){
                            c.push("<option value="+ subject.id +">" + subject.name+ "</option>");
                        }
                    });
                    $('#subject').append(c.join(""));


                    c = [];
                    $.each(result.data.teachers,function (i,teacher) {

                        if(teacher.id !== result.data.schedule[0].id_teachers){
                            c.push("<option value="+ teacher.id +">" + teacher.firstname + "  " + teacher.lastname
                                + "   " + teacher.patronymic   +  "</option>");
                        }
                    });
                    $('#teacher').append(c.join(""));


                    c = [];
                    $.each(result.data.typeOfLessons,function (i,typeOfLesson) {
                        if(typeOfLesson.id !== result.data.schedule[0].id_type_of_lesson){
                            c.push("<option value="+ typeOfLesson.id +">" + typeOfLesson.name+ "</option>");
                        }
                    });
                    $('#typeOfLesson').append(c.join(""));

                    c = [];
                    $.each(result.data.class,function (i,groupOfStudent) {
                        if(groupOfStudent.id !== result.data.schedule[0].id_class){
                            c.push("<option value="+ groupOfStudent.id +">" + groupOfStudent.name+ "  "
                                + groupOfStudent.faculty.name+ "</option>");
                        }
                    });

                    $('#class').append(c.join(""));

                    c = [];
                    $.each(result.data.class_house,function (i,classHouse) {
                        if(classHouse.id !== result.data.schedule[0].id_class_house){
                            c.push("<option value="+ classHouse.id +">" + classHouse.classroom.number+ "  "
                                + classHouse.housing.name+ "</option>");
                        }
                    });
                    $('#class_house').append(c.join(""));

                    c = [];
                    $.each(result.data.daysOfTheWeeks,function (i,dayOfTheWeek) {
                        if(dayOfTheWeek.id !== result.data.schedule[0].id_days_of_the_week){
                            c.push("<option value="+ dayOfTheWeek.id +">" + dayOfTheWeek.day+ "</option>");
                        }
                    });
                    $('#days_of_the_week').append(c.join(""));

                    c = [];
                    $.each(result.data.frequency,function (i,freq) {
                        if(freq.id !== result.data.schedule[0].id_frequency){
                            c.push("<option value="+ freq.id +">" + freq.week+ "</option>");
                        }
                    });
                    $('#frequency').append(c.join(""));


                }

                else{
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    function udalitDw(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteSchedule",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
                deleteClick = false;
            },
            error: function (e) {
                deleteClick = false;
                loadSchudele(currentGroupId);
                console.log("ERROR: ", e);
            }
        });

    }



})