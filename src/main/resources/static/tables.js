
var currentTable;
$(document).ready(function () {
    currentTable = "DaysOfTheWeek";
    loadDaysOfTheWeek();
    $("#ClassroomTab").click(function (event) {
        event.preventDefault();
        currentTable = "Classroom";
        loadClassroom();
    });

    $("#DaysOfTheWeekTab").click(function (event) {
        event.preventDefault();
        currentTable = "DaysOfTheWeek";
        loadDaysOfTheWeek();
    });

    $("#FacultyTab").click(function (event) {
        event.preventDefault();
        currentTable = "Faculty";
        loadFaculty();

    });

    $("#FrequencyTab").click(function (event) {
        event.preventDefault();
        currentTable = "Frequency";;
        loadFrequency();
    });

    $("#GroupOfStudentsTab").click(function (event) {
        event.preventDefault();
        currentTable = "GroupOfStudents";
        loadGroupOfStudents();
    });

    $("#HousingTab").click(function (event) {
        event.preventDefault();
        currentTable = "Housing";
        loadHousing();
    });

    $("#ScheduleTab").click(function (event) {
        event.preventDefault();
        currentTable = "Schedule";
        loadSchedule();
    });

    $("#SubjectTab").click(function (event) {
        event.preventDefault();
        currentTable = "Subject";
        loadSubject();
    });

    $("#TeacherTab").click(function (event) {
        event.preventDefault();
        currentTable = "Teacher";
        loadTeacher();
    });

    $("#TypeOfLessonTab").click(function (event) {
        event.preventDefault();
        currentTable = "TypeOfLesson";
        loadTypeOfLesson();
    });


    function loadDaysOfTheWeek() {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getDaysOfTheWeek",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>День</th> </tr> </thead>");

                    $.each(result.data,function (i,days) {
                        c.push("<tr dw_row_id = " + days.id + "><td style='display: none'><div type='hidden' class='dw_row_data' edit_type='click' dw_col_name='id'>" + days.id + "</div></td>");
                        c.push("<td><div class='dw_row_data' edit_type='click' dw_col_name='day'>" + days.day + "</div></td><td>");
                        c.push('<span class="dw_btn_edit" > <a href="#" class="btn btn-link " dw_row_id="' + days.id + '" > Edit</a> </span>');
                        c.push('<span class="dw_btn_save"> <a href="#" class="btn btn-link"  dw_row_id="' + days.id + '"> Save</a> | </span>');
                        c.push('<span class="dw_btn_cancel"> <a href="#" class="btn btn-link" dw_row_id="' + days.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="dw_btn_delete"> <a href="#" class="btn btn-link" dw_row_id="' + days.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#DaysOfTheWeekTable').html(c.join(""));

                    $(document).find('.dw_btn_save').hide();
                    $(document).find('.dw_btn_cancel').hide();

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

    function loadFaculty() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getFaculty",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Название факультета</th> </tr> </thead>");

                    $.each(result.data,function (i,faculty) {
                        c.push("<tr f_row_id = " + faculty.id + "><td style='display: none'><div type='hidden' class='f_row_data' edit_type='click' f_col_name='id'>" + faculty.id + "</div></td>");
                        c.push("<td><div class='f_row_data' edit_type='click' f_col_name='name'>" + faculty.name + "</div></td><td>");
                        c.push('<span class="f_btn_edit" > <a href="#" class="btn btn-link " f_row_id="' + faculty.id + '" > Edit</a> </span>');
                        c.push('<span class="f_btn_save"> <a href="#" class="btn btn-link"  f_row_id="' + faculty.id + '"> Save</a> | </span>');
                        c.push('<span class="f_btn_cancel"> <a href="#" class="btn btn-link" f_row_id="' + faculty.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="f_btn_delete"> <a href="#" class="btn btn-link" f_row_id="' + faculty.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#FacultyTable').html(c.join(""));

                    $(document).find('.f_btn_save').hide();
                    $(document).find('.f_btn_cancel').hide();

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

    function loadFrequency() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getFrequecny",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Частота в неделях</th> </tr> </thead>");

                    $.each(result.data,function (i,frequency) {
                        c.push("<tr fr_row_id = " + frequency.id + "><td style='display: none'><div type='hidden' class='fr_row_data' edit_type='click' fr_col_name='id'>" + frequency.id + "</div></td>");
                        c.push("<td><div class='fr_row_data' edit_type='click' fr_col_name='week'>" + frequency.week + "</div></td><td>");
                        c.push('<span class="fr_btn_edit" > <a href="#" class="btn btn-link " fr_row_id="' + frequency.id + '" > Edit</a> </span>');
                        c.push('<span class="fr_btn_save"> <a href="#" class="btn btn-link"  fr_row_id="' + frequency.id + '"> Save</a> | </span>');
                        c.push('<span class="fr_btn_cancel"> <a href="#" class="btn btn-link" fr_row_id="' + frequency.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="fr_btn_delete"> <a href="#" class="btn btn-link" fr_row_id="' + frequency.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#FrequencyTable').html(c.join(""));

                    $(document).find('.fr_btn_save').hide();
                    $(document).find('.fr_btn_cancel').hide();

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

    function loadHousing() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getHousing",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Корпус</th> </tr> </thead>");

                    $.each(result.data,function (i,housing) {
                        c.push("<tr h_row_id = " + housing.id + "><td style='display: none'><div type='hidden' class='h_row_data' edit_type='click' h_col_name='id'>" + housing.id + "</div></td>");
                        c.push("<td><div class='h_row_data' edit_type='click' h_col_name='name'>" + housing.name + "</div></td><td>");
                        c.push('<span class="h_btn_edit" > <a href="#" class="btn btn-link " h_row_id="' + housing.id + '" > Edit</a> </span>');
                        c.push('<span class="h_btn_save"> <a href="#" class="btn btn-link"  h_row_id="' + housing.id + '"> Save</a> | </span>');
                        c.push('<span class="h_btn_cancel"> <a href="#" class="btn btn-link" h_row_id="' + housing.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="h_btn_delete"> <a href="#" class="btn btn-link" h_row_id="' + housing.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#HousingTable').html(c.join(""));

                    $(document).find('.h_btn_save').hide();
                    $(document).find('.h_btn_cancel').hide();

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

    function loadSubject() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getSubject",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Предмет</th> </tr> </thead>");

                    $.each(result.data,function (i,subject) {
                        c.push("<tr s_row_id = " + subject.id + "><td style='display: none'><div type='hidden' class='s_row_data' edit_type='click' s_col_name='id'>" + subject.id + "</div></td>");
                        c.push("<td><div class='s_row_data' edit_type='click' s_col_name='name'>" + subject.name + "</div></td><td>");
                        c.push('<span class="s_btn_edit" > <a href="#" class="btn btn-link " s_row_id="' + subject.id + '" > Edit</a> </span>');
                        c.push('<span class="s_btn_save"> <a href="#" class="btn btn-link"  s_row_id="' + subject.id + '"> Save</a> | </span>');
                        c.push('<span class="s_btn_cancel"> <a href="#" class="btn btn-link" s_row_id="' + subject.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="s_btn_delete"> <a href="#" class="btn btn-link" s_row_id="' + subject.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#SubjectTable').html(c.join(""));

                    $(document).find('.s_btn_save').hide();
                    $(document).find('.s_btn_cancel').hide();

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

    function loadTeacher() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getTeacher",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Имя</th> <th>Фамилия</th> <th>Отчество</th> </tr> </thead>");

                    $.each(result.data,function (i,teacher) {
                        c.push("<tr t_row_id = " + teacher.id + "><td style='display: none'><div type='hidden' class='t_row_data' edit_type='click' t_col_name='id'>" + teacher.id + "</div></td>");
                        c.push("<td><div class='t_row_data' edit_type='click' t_col_name='first_name'>" + teacher.firstname + "</div></td>");
                        c.push("<td><div class='t_row_data' edit_type='click' t_col_name='last_name'>" + teacher.lastname + "</div></td>");
                        c.push("<td><div class='t_row_data' edit_type='click' t_col_name='patronymic'>" + teacher.patronymic + "</div></td>");
                        c.push('<td><span class="t_btn_edit" > <a href="#" class="btn btn-link " t_row_id="' + teacher.id + '" > Edit</a> </span>');
                        c.push('<span class="t_btn_save"> <a href="#" class="btn btn-link"  t_row_id="' + teacher.id + '"> Save</a> | </span>');
                        c.push('<span class="t_btn_cancel"> <a href="#" class="btn btn-link" t_row_id="' + teacher.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="t_btn_delete"> <a href="#" class="btn btn-link" t_row_id="' + teacher.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#TeacherTable').html(c.join(""));

                    $(document).find('.t_btn_save').hide();
                    $(document).find('.t_btn_cancel').hide();

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

    function loadTypeOfLesson() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getTypeOfLesson",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Вид занятия</th></tr> </thead>");

                    $.each(result.data,function (i,teacher) {
                        c.push("<tr ty_row_id = " + teacher.id + "><td style='display: none'><div type='hidden' class='ty_row_data' edit_type='click' ty_col_name='id'>" + teacher.id + "</div></td>");
                        c.push("<td><div class='ty_row_data' edit_type='click' ty_col_name='name'>" + teacher.name + "</div></td>");
                        c.push('<td><span class="ty_btn_edit" > <a href="#" class="btn btn-link " ty_row_id="' + teacher.id + '" > Edit</a> </span>');
                        c.push('<span class="ty_btn_save"> <a href="#" class="btn btn-link"  ty_row_id="' + teacher.id + '"> Save</a> | </span>');
                        c.push('<span class="ty_btn_cancel"> <a href="#" class="btn btn-link" ty_row_id="' + teacher.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="ty_btn_delete"> <a href="#" class="btn btn-link" ty_row_id="' + teacher.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#TypeOfLessonTable').html(c.join(""));

                    $(document).find('.ty_btn_save').hide();
                    $(document).find('.ty_btn_cancel').hide();

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

    function loadClassroom() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getClassroom",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Номер</th></tr> </thead>");

                    $.each(result.data,function (i,classroom) {
                        c.push("<tr cl_row_id = " + classroom.id + "><td style='display: none'><div type='hidden' class='cl_row_data' edit_type='click' cl_col_name='id'>" + classroom.id + "</div></td>");
                        c.push("<td><div class='cl_row_data' edit_type='click' cl_col_name='name'>" + classroom.number + "</div></td>");
                        c.push('<td><span class="cl_btn_edit" > <a href="#" class="btn btn-link " cl_row_id="' + classroom.id + '" > Edit</a> </span>');
                        c.push('<span class="cl_btn_save"> <a href="#" class="btn btn-link"  cl_row_id="' + classroom.id + '"> Save</a> | </span>');
                        c.push('<span class="cl_btn_cancel"> <a href="#" class="btn btn-link" cl_row_id="' + classroom.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="cl_btn_delete"> <a href="#" class="btn btn-link" cl_row_id="' + classroom.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#ClassroomTable').html(c.join(""));

                    $(document).find('.cl_btn_save').hide();
                    $(document).find('.cl_btn_cancel').hide();

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


    function loadSchedule() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getClassroom",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Номер</th><th>ID корпуса</th></tr> </thead>");

                    $.each(result.data,function (i,classroom) {
                        c.push("<tr cl_row_id = " + classroom.id + "><td style='display: none'><div type='hidden' class='cl_row_data' edit_type='click' cl_col_name='id'>" + classroom.id + "</div></td>");
                        c.push("<td><div class='cl_row_data' edit_type='click' cl_col_name='name'>" + classroom.number + "</div></td>");
                        c.push("<td><div class='cl_row_data' edit_type='click' cl_col_name='idHousing'>" + classroom.id_housing + "</div></td>");
                        c.push('<td><span class="cl_btn_edit" > <a href="#" class="btn btn-link " cl_row_id="' + classroom.id + '" > Edit</a> </span>');
                        c.push('<span class="cl_btn_save"> <a href="#" class="btn btn-link"  cl_row_id="' + classroom.id + '"> Save</a> | </span>');
                        c.push('<span class="cl_btn_cancel"> <a href="#" class="btn btn-link" cl_row_id="' + classroom.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="cl_btn_delete"> <a href="#" class="btn btn-link" cl_row_id="' + classroom.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#ClassroomTable').html(c.join(""));

                    $(document).find('.cl_btn_save').hide();
                    $(document).find('.cl_btn_cancel').hide();

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


    function loadGroupOfStudents() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/getGroups",
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $(document).find('.table').empty();
                    var c = [];
                    c.push("<thead> <tr><th>Название</th><th>id факультета</th></tr> </thead>");

                    $.each(result.data,function (i,group) {
                        c.push("<tr gr_row_id = " + group.id + "><td style='display: none'><div type='hidden' class='gr_row_data' edit_type='click' gr_col_name='id'>" + group.id + "</div></td>");
                        c.push("<td><div class='gr_row_data' edit_type='click' gr_col_name='name'>" + group.name + "</div></td>");
                        c.push("<td><div class='gr_row_data' edit_type='click' gr_col_name='idHousing'>" + group.id_faculty + "</div></td>");
                        c.push('<td><span class="gr_btn_edit" > <a href="#" class="btn btn-link " gr_row_id="' + group.id + '" > Edit</a> </span>');
                        c.push('<span class="gr_btn_save"> <a href="#" class="btn btn-link"  gr_row_id="' + group.id + '"> Save</a> | </span>');
                        c.push('<span class="gr_btn_cancel"> <a href="#" class="btn btn-link" gr_row_id="' + group.id + '"> Cancel</a> | </span></td>');
                        c.push('<td><span class="gr_btn_delete"> <a href="#" class="btn btn-link" gr_row_id="' + group.id + '"> Delete</a> </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#GroupOfStudentsTable').html(c.join(""));

                    $(document).find('.gr_btn_save').hide();
                    $(document).find('.gr_btn_cancel').hide();

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

    //GroupsOfStudents

    $(document).on('click', '.gr_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('gr_row_id');

        tbl_row.find('.gr_btn_save').show();
        tbl_row.find('.gr_btn_cancel').show();


        tbl_row.find('.gr_btn_edit').hide();

        tbl_row.find('.gr_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.gr_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.gr_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('gr_row_id');

        tbl_row.find('.gr_btn_save').hide();
        tbl_row.find('.gr_btn_cancel').hide();

        tbl_row.find('.gr_btn_edit').show();

        tbl_row.find('.gr_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.gr_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.gr_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('gr_row_id');


        tbl_row.find('.gr_btn_save').hide();
        tbl_row.find('.gr_btn_cancel').hide();

        //show edit button
        tbl_row.find('.gr_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.gr_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.gr_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('gr_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });

        $.extend(arr, {row_id:row_id});

        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["name"];
        arrPost[2] = arr["id_faculty"];

        saveDw(arrPost);
    });

    function saveDw(arr) {

        var formData = {
            id : arr[0],
            name : arr[1],
            id_faculty : arr[0]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateGroups",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.gr_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('gr_row_id');

        udalitDw(row_id);

    });

    function udalitDw(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteGroups",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadGroupOfStudents("GroupOfStudents");
                console.log("ERROR: ", e);
            }
        });

    }


    //DaysOfTheWeek

    $(document).on('click', '.dw_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('dw_row_id');

        tbl_row.find('.dw_btn_save').show();
        tbl_row.find('.dw_btn_cancel').show();


        tbl_row.find('.dw_btn_edit').hide();

        tbl_row.find('.dw_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.dw_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.dw_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('dw_row_id');

        tbl_row.find('.dw_btn_save').hide();
        tbl_row.find('.dw_btn_cancel').hide();

        tbl_row.find('.dw_btn_edit').show();

        tbl_row.find('.dw_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.dw_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.dw_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('dw_row_id');


        tbl_row.find('.dw_btn_save').hide();
        tbl_row.find('.dw_btn_cancel').hide();

        //show edit button
        tbl_row.find('.dw_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.dw_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.dw_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('dw_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });

        $.extend(arr, {row_id:row_id});

        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["day"];

        saveDw(arrPost);
    });

    function saveDw(arr) {

        var formData = {
            id : arr[0],
            day : arr[1]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/update",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.dw_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('dw_row_id');

        udalitDw(row_id);

    });

    function udalitDw(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/delete",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadDaysOfTheWeek("DaysOfTheWeekTab");
                console.log("ERROR: ", e);
            }
        });

    }




    //Faculty

    $(document).on('click', '.f_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('f_row_id');

        tbl_row.find('.f_btn_save').show();
        tbl_row.find('.f_btn_cancel').show();


        tbl_row.find('.f_btn_edit').hide();

        tbl_row.find('.f_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.f_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.f_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('f_row_id');

        tbl_row.find('.f_btn_save').hide();
        tbl_row.find('.f_btn_cancel').hide();

        tbl_row.find('.f_btn_edit').show();

        tbl_row.find('.f_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.f_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.f_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('f_row_id');


        tbl_row.find('.f_btn_save').hide();
        tbl_row.find('.f_btn_cancel').hide();

        //show edit button
        tbl_row.find('.f_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.f_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.f_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('f_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });


        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["name"];

        saveF(arrPost);
    });

    function saveF(arr) {

        var formData = {
            id : arr[0],
            name : arr[1]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateFaculty",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.f_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('f_row_id');

        udalitF(row_id);

    });

    function udalitF(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteFaculty",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadFaculty();
                console.log("ERROR: ", e);
            }
        });

    }




    //Frequency

    $(document).on('click', '.fr_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('fr_row_id');

        tbl_row.find('.fr_btn_save').show();
        tbl_row.find('.fr_btn_cancel').show();


        tbl_row.find('.fr_btn_edit').hide();

        tbl_row.find('.fr_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.fr_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.fr_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('fr_row_id');

        tbl_row.find('.fr_btn_save').hide();
        tbl_row.find('.fr_btn_cancel').hide();

        tbl_row.find('.fr_btn_edit').show();

        tbl_row.find('.fr_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.fr_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.fr_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('fr_row_id');


        tbl_row.find('.fr_btn_save').hide();
        tbl_row.find('.fr_btn_cancel').hide();

        //show edit button
        tbl_row.find('.fr_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.fr_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.fr_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('fr_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });


        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["week"];

        saveFr(arrPost);
    });

    function saveFr(arr) {

        var formData = {
            id : arr[0],
            week : arr[1]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateFrequency",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.fr_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('fr_row_id');

        udalitFr(row_id);

    });

    function udalitFr(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteFrequency",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadFrequency();
                console.log("ERROR: ", e);
            }
        });

    }



    //Housing

    $(document).on('click', '.h_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('h_row_id');

        tbl_row.find('.h_btn_save').show();
        tbl_row.find('.h_btn_cancel').show();


        tbl_row.find('.h_btn_edit').hide();

        tbl_row.find('.h_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.h_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.h_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('h_row_id');

        tbl_row.find('.h_btn_save').hide();
        tbl_row.find('.h_btn_cancel').hide();

        tbl_row.find('.h_btn_edit').show();

        tbl_row.find('.h_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.h_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.h_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('h_row_id');


        tbl_row.find('.h_btn_save').hide();
        tbl_row.find('.h_btn_cancel').hide();

        //show edit button
        tbl_row.find('.h_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.h_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.h_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('h_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });


        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["name"];

        saveH(arrPost);
    });

    function saveH(arr) {

        var formData = {
            id : arr[0],
            name : arr[1]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateHousing",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.h_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('h_row_id');

        udalitH(row_id);

    });

    function udalitH(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteHousing",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadHousing();
                console.log("ERROR: ", e);
            }
        });

    }


    //Subject

    $(document).on('click', '.s_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('s_row_id');

        tbl_row.find('.s_btn_save').show();
        tbl_row.find('.s_btn_cancel').show();


        tbl_row.find('.s_btn_edit').hide();

        tbl_row.find('.s_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.s_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.s_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('s_row_id');

        tbl_row.find('.s_btn_save').hide();
        tbl_row.find('.s_btn_cancel').hide();

        tbl_row.find('.s_btn_edit').show();

        tbl_row.find('.s_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.s_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.s_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('s_row_id');


        tbl_row.find('.s_btn_save').hide();
        tbl_row.find('.s_btn_cancel').hide();

        //show edit button
        tbl_row.find('.s_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.s_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.s_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('s_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });


        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["name"];

        saveS(arrPost);
    });

    function saveS(arr) {

        var formData = {
            id : arr[0],
            name : arr[1]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateSubject",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.s_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('s_row_id');

        udalitS(row_id);

    });

    function udalitS(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteSubject",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadSubject();
                console.log("ERROR: ", e);
            }
        });

    }


    //Teacher

    $(document).on('click', '.t_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('t_row_id');

        tbl_row.find('.t_btn_save').show();
        tbl_row.find('.t_btn_cancel').show();


        tbl_row.find('.t_btn_edit').hide();

        tbl_row.find('.t_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.t_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.t_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('t_row_id');

        tbl_row.find('.t_btn_save').hide();
        tbl_row.find('.t_btn_cancel').hide();

        tbl_row.find('.t_btn_edit').show();

        tbl_row.find('.t_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.t_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.t_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('t_row_id');


        tbl_row.find('.t_btn_save').hide();
        tbl_row.find('.t_btn_cancel').hide();

        //show edit button
        tbl_row.find('.t_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.t_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.t_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('t_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });


        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["first_name"];
        arrPost[2] = arr["last_name"];
        arrPost[3] = arr["patronymic"];

        saveT(arrPost);
    });

    function saveT(arr) {

        var formData = {
            id : arr[0],
            first_name : arr[1],
            last_name : arr[2],
            patronymic : arr[3]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateTeacher",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.t_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('t_row_id');

        udalitT(row_id);

    });

    function udalitT(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteTeacher",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadTeacher();
                console.log("ERROR: ", e);
            }
        });

    }


    //TypeOfLesson

    $(document).on('click', '.ty_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('ty_row_id');

        tbl_row.find('.ty_btn_save').show();
        tbl_row.find('.ty_btn_cancel').show();


        tbl_row.find('.ty_btn_edit').hide();

        tbl_row.find('.ty_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.ty_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.ty_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('ty_row_id');

        tbl_row.find('.ty_btn_save').hide();
        tbl_row.find('.ty_btn_cancel').hide();

        tbl_row.find('.ty_btn_edit').show();

        tbl_row.find('.ty_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.ty_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.ty_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('ty_row_id');


        tbl_row.find('.ty_btn_save').hide();
        tbl_row.find('.ty_btn_cancel').hide();

        //show edit button
        tbl_row.find('.ty_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.ty_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.ty_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('ty_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });


        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["name"];

        saveTy(arrPost);
    });

    function saveTy(arr) {

        var formData = {
            id : arr[0],
            name : arr[1]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateTypeOfLesson",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.ty_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('ty_row_id');

        udalitTy(row_id);

    });

    function udalitTy(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteTypeOfLesson",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadTypeOfLesson();
                console.log("ERROR: ", e);
            }
        });

    }

    //Classroom

    $(document).on('click', '.cl_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('cl_row_id');

        tbl_row.find('.cl_btn_save').show();
        tbl_row.find('.cl_btn_cancel').show();


        tbl_row.find('.cl_btn_edit').hide();

        tbl_row.find('.cl_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.cl_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.cl_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('cl_row_id');

        tbl_row.find('.cl_btn_save').hide();
        tbl_row.find('.cl_btn_cancel').hide();

        tbl_row.find('.cl_btn_edit').show();

        tbl_row.find('.cl_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.cl_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.cl_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('cl_row_id');


        tbl_row.find('.cl_btn_save').hide();
        tbl_row.find('.cl_btn_cancel').hide();

        //show edit button
        tbl_row.find('.cl_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.cl_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.cl_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('cl_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });


        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["name"];
        arrPost[2] = arr["idHousing"];

        saveTy(arrPost);
    });

    function saveTy(arr) {

        var formData = {
            id : arr[0],
            name : arr[1],
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateClassroom",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.cl_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('cl_row_id');

        udalitTy(row_id);

    });

    function udalitTy(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteClassroom",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadTypeOfLesson();
                console.log("ERROR: ", e);
            }
        });

    }


    //Schedule
    $(document).on('click', '.cl_btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('cl_row_id');

        tbl_row.find('.cl_btn_save').show();
        tbl_row.find('.cl_btn_cancel').show();


        tbl_row.find('.cl_btn_edit').hide();

        tbl_row.find('.cl_row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        tbl_row.find('.cl_row_data').each(function(index, val)
        {

            $(this).attr('original_entry', $(this).html());
        });


    });

    $(document).on('click', '.cl_btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('cl_row_id');

        tbl_row.find('.cl_btn_save').hide();
        tbl_row.find('.cl_btn_cancel').hide();

        tbl_row.find('.cl_btn_edit').show();

        tbl_row.find('.cl_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.cl_row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });

    $(document).on('click', '.cl_btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('cl_row_id');


        tbl_row.find('.cl_btn_save').hide();
        tbl_row.find('.cl_btn_cancel').hide();

        //show edit button
        tbl_row.find('.cl_btn_edit').show();


        //make the whole row editable
        tbl_row.find('.cl_row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        var arr = {};
        tbl_row.find('.cl_row_data').each(function(index, val)
        {
            var col_name = $(this).attr('cl_col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });


        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["name"];
        arrPost[2] = arr["idHousing"];

        saveTy(arrPost);
    });

    function saveTy(arr) {

        var formData = {
            id : arr[0],
            name : arr[1],
            id_housing : arr[2]
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/updateClassroom",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });

    }

    $(document).on('click', '.cl_btn_delete', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('cl_row_id');

        udalitTy(row_id);

    });

    function udalitTy(RowId) {

        var formData = {
            id : RowId
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/deleteClassroom",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                console.log(result);
            },
            error: function (e) {
                loadTypeOfLesson();
                console.log("ERROR: ", e);
            }
        });

    }






})