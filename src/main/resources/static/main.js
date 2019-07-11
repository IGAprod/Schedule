var currentGroupId;
var currentFacultyId;
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
                    c.push("  <table class=\"table table-dark mt-3\" id=\"chooseFaculty\"><thead> <tr><th>Название факультета</th> </tr> </thead>");

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

                    c.push("  <a href=\"#\" class=\"btn btn-default\" id=\"backToFaculty\">Назад</a> <table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> <tr><th>Название группы</th> </tr> </thead>");

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
                    $(document).find('.table').empty();
                    var c = [];

                    c.push("  <a href=\"#\" class=\"btn btn-default\" id=\"backToGroup\">Назад</a> " +
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Время</th> <th>Предмет</th><th>Преподаватель</th>  <th>Вид занятия</th> " +
                        "<th>Аудитория</th><th>Частота</th></tr> </thead>");

                    var currentday = "";
                    $.each(result.data,function (i,schedule) {

                        if(schedule.daysOfTheWeek.day.toString() == currentday){
                            c.push('<tr><td></td>');
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
                    $(document).find('.table').empty();
                    var c = [];

                    c.push("  <a href=\"#\" class=\"btn btn-default\" id=\"backToFaculty\">Назад</a> " +
                        "<table class=\"table table-dark mt-3\" id=\"chooseGroup\"><thead> " +
                        "<tr><th>День</th> <th>Время</th> <th>Предмет</th><th>Преподаватель</th>  <th>Вид занятия</th> " +
                        "<th>Аудитория</th><th>Частота</th></tr> </thead>");

                    var currentday = "";
                    $.each(result.data,function (i,schedule) {

                        if(schedule.daysOfTheWeek.day.toString() == currentday){
                            c.push('<tr><td></td>');
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

})