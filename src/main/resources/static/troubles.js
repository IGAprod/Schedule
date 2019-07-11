
$(document).ready(function () {



    $(document).on('click', '.btn-classroom', function(event)
    {
        event.preventDefault();
      //  classRoomTroubles();
        loadSchudele();

    });

    $(document).on('click', '.btn-teachers', function(event)
    {
        event.preventDefault();
   //     teachersTroubles();
        loadTroublesTeachers();

    });

    $(document).on('click', '.btn-groupsClass', function(event)
    {
        event.preventDefault();
    //    groupClassTroubles();
        loadTroublesGroupClassRoom();

    });

    $(document).on('click', '.btn-btn-groupsTeachers', function(event)
    {
        event.preventDefault();
        groupTeachersTroubles();
    });



    function loadTroublesGroupClassRoom() {


        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getTroublesGroupClassRoom",
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];

                    c.push(
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Время</th> <th>Группа</th> <th>Предмет</th><th>Преподаватель</th>  <th>Вид занятия</th> " +
                        "<th>Аудитория</th><th>Частота</th></tr> </thead>");

                    var currentday = "";
                    $.each(result.data,function (i,schedule) {

                        if(schedule.daysOfTheWeek.day.toString() == currentday){
                            c.push('<tr><td></td>');
                        }else{
                            c.push('<tr><td>' + schedule.daysOfTheWeek.day + '</td>');
                        }
                        c.push('<td>' + schedule.time.substring(0,5) + '</td>');
                        c.push('<td>' + schedule.groupOfStudents.name + '  ' + schedule.groupOfStudents.faculty.name + '</td>');
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


    function loadTroublesTeachers() {


        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getTroublesTeachers",
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];

                    c.push(
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Время</th> <th>Группа</th> <th>Предмет</th><th>Преподаватель</th>  <th>Вид занятия</th> " +
                        "<th>Аудитория</th><th>Частота</th></tr> </thead>");

                    var currentday = "";
                    $.each(result.data,function (i,schedule) {

                        if(schedule.daysOfTheWeek.day.toString() == currentday){
                            c.push('<tr><td></td>');
                        }else{
                            c.push('<tr><td>' + schedule.daysOfTheWeek.day + '</td>');
                        }
                        c.push('<td>' + schedule.time.substring(0,5) + '</td>');
                        c.push('<td>' + schedule.groupOfStudents.name + '  ' + schedule.groupOfStudents.faculty.name + '</td>');
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


    function loadSchudele() {


        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getTroublesClassRoom",
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];

                    c.push(
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Время</th> <th>Группа</th> <th>Предмет</th><th>Преподаватель</th>  <th>Вид занятия</th> " +
                        "<th>Аудитория</th><th>Частота</th></tr> </thead>");

                    var currentday = "";
                    $.each(result.data,function (i,schedule) {

                        if(schedule.daysOfTheWeek.day.toString() == currentday){
                            c.push('<tr><td></td>');
                        }else{
                            c.push('<tr><td>' + schedule.daysOfTheWeek.day + '</td>');
                        }
                        c.push('<td>' + schedule.time.substring(0,5) + '</td>');
                        c.push('<td>' + schedule.groupOfStudents.name + '  ' + schedule.groupOfStudents.faculty.name + '</td>');
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


    function groupClassTroubles() {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/groupClassTroubles",
            dataType: 'json',
            success: function (result) {
                if (result.status === "Done") {
                    $(document).find('.table').empty();
                    var c = [];

                    c.push(
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Предмет</th> <th>Преподаватель</th>> <th>Вид занятия</th> " +
                        "<th>Группа</th><th>Аудитория</th><th>Частота</th><th>Время</th></tr> </thead>");

                    $.each(result.data, function (i, schedule) {
                        c.push('<tr><td>' + schedule.daysOfTheWeek.day + '</td>');
                        c.push('<td>' + schedule.subject.name + '</td>');
                        c.push('<td>' + schedule.teacher.firstname + '</td>');
                        c.push('<td>' + schedule.typeOfLesson.name + '</td>');
                        c.push('<td>' + schedule.groupOfStudents.name + '</td>');
                        c.push('<td>' + schedule.classroom.number + '</td>');
                        c.push('<td>' + schedule.frequency.week + '</td>');
                        c.push('<td>' + schedule.time + '</td></tr>');

                    });
                    c.push('</table>')
                    $('#Table').html(c.join(""));
                } else {
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    function groupTeachersTroubles() {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/groupTeachersTroubles",
            dataType: 'json',
            success: function (result) {
                if (result.status === "Done") {
                    $(document).find('.table').empty();
                    var c = [];

                    c.push(
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Предмет</th> <th>Преподаватель</th>> <th>Вид занятия</th> " +
                        "<th>Группа</th><th>Аудитория</th><th>Частота</th><th>Время</th></tr> </thead>");

                    $.each(result.data, function (i, schedule) {
                        c.push('<tr><td>' + schedule.daysOfTheWeek.day + '</td>');
                        c.push('<td>' + schedule.subject.name + '</td>');
                        c.push('<td>' + schedule.teacher.firstname + '</td>');
                        c.push('<td>' + schedule.typeOfLesson.name + '</td>');
                        c.push('<td>' + schedule.groupOfStudents.name + '</td>');
                        c.push('<td>' + schedule.classroom.number + '</td>');
                        c.push('<td>' + schedule.frequency.week + '</td>');
                        c.push('<td>' + schedule.time + '</td></tr>');

                    });
                    c.push('</table>')
                    $('#Table').html(c.join(""));
                } else {
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }

    function classRoomTroubles() {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/classRoomTroubles",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('#Table').empty();
                    var c = [];

                    c.push(
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Предмет</th> <th>Преподаватель</th>> <th>Вид занятия</th> " +
                        "<th>Группа</th><th>Аудитория</th><th>Частота</th><th>Время</th></tr> </thead>");

                    $.each(result.data,function (i,schedule) {
                        c.push('<tr><td>' + schedule.daysOfTheWeek.day + '</td>');
                        c.push('<td>' + schedule.subject.name + '</td>');
                        c.push('<td>' + schedule.teacher.firstname + '</td>');
                        c.push('<td>' + schedule.typeOfLesson.name + '</td>');
                        c.push('<td>' + schedule.groupOfStudents.name + '</td>');
                        c.push('<td>' + schedule.classroom.number + '</td>');
                        c.push('<td>' + schedule.frequency.week + '</td>');
                        c.push('<td>' + schedule.time + '</td></tr>');

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

    function teachersTroubles() {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/teachersTroubles",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];

                    c.push(
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Предмет</th> <th>Преподаватель</th>> <th>Вид занятия</th> " +
                        "<th>Группа</th><th>Аудитория</th><th>Частота</th><th>Время</th></tr> </thead>");

                    $.each(result.data,function (i,schedule) {
                        c.push('<tr><td>' + schedule.daysOfTheWeek.day + '</td>');
                        c.push('<td>' + schedule.subject.name + '</td>');
                        c.push('<td>' + schedule.teacher.firstname + '</td>');
                        c.push('<td>' + schedule.typeOfLesson.name + '</td>');
                        c.push('<td>' + schedule.groupOfStudents.name + '</td>');
                        c.push('<td>' + schedule.classroom.number + '</td>');
                        c.push('<td>' + schedule.frequency.week + '</td>');
                        c.push('<td>' + schedule.time + '</td></tr>');

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


})