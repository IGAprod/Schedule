$(document).ready(function () {

    loadDaysOfTheWeek("DaysOfTheWeekTab");
    $("#Classroom").click(function (event) {
        event.preventDefault();

    });

    $("#DaysOfTheWeekTab").click(function (event) {
        event.preventDefault();
        loadDaysOfTheWeek("DaysOfTheWeekTab");
    });

    $("#Faculty").click(function (event) {
        event.preventDefault();

    });

    $("#Frequency").click(function (event) {
        event.preventDefault();

    });

    $("#GroupOfStudents").click(function (event) {
        event.preventDefault();

    });

    $("#Housing").click(function (event) {
        event.preventDefault();

    });

    $("#Schedule").click(function (event) {
        event.preventDefault();

    });

    $("#Subject").click(function (event) {
        event.preventDefault();

    });

    $("#Teacher").click(function (event) {
        event.preventDefault();

    });

    $("#TypeOfLesson").click(function (event) {
        event.preventDefault();

    });



    function loadDaysOfTheWeek(tableName) {

        var formData = {
            table : tableName
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/getDaysOfTheWeek",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result){
                if(result.status === "Done"){
                    $('#DaysOfTheWeekTable').empty();
                    var c = [];
                    c.push("<thead> <tr><th>День</th> </tr> </thead>");

                    $.each(result.data,function (i,days) {
                        c.push("<tr row_id = " + days.id + "><td style='display: none'><div type='hidden' class='row_data' edit_type='click' col_name='id'>" + days.id + "</div></td>");
                        c.push("<td><div class='row_data' edit_type='click' col_name='day'>" + days.day + "</div></td><td>");
                        c.push('<span class="btn_edit" > <a href="#" class="btn btn-link " row_id="' + days.id + '" > Edit</a> </span>');
                        c.push('<span class="btn_save"> <a href="#" class="btn btn-link"  row_id="' + days.id + '"> Save</a> | </span>');
                        c.push('<span class="btn_cancel"> <a href="#" class="btn btn-link" row_id="' + days.id + '"> Cancel</a> | </span></td></tr>');
                    });
                    c.push('</table>')
                    $('#DaysOfTheWeekTable').html(c.join(""));

                    $(document).find('.btn_save').hide();
                    $(document).find('.btn_cancel').hide();

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

    //--->button > edit > start
    $(document).on('click', '.btn_edit', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('row_id');

        tbl_row.find('.btn_save').show();
        tbl_row.find('.btn_cancel').show();

        //hide edit button
        tbl_row.find('.btn_edit').hide();

        //make the whole row editable
        tbl_row.find('.row_data')
            .attr('contenteditable', 'true')
            .attr('edit_type', 'button')
            .addClass('bg-warning')
            .css('padding','3px')

        //--->add the original entry > start
        tbl_row.find('.row_data').each(function(index, val)
        {
            //this will help in case user decided to click on cancel button
            $(this).attr('original_entry', $(this).html());
        });
        //--->add the original entry > end

    });
//--->button > edit > end

    //--->button > cancel > start
    $(document).on('click', '.btn_cancel', function(event)
    {
        event.preventDefault();

        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('row_id');

        //hide save and cacel buttons
        tbl_row.find('.btn_save').hide();
        tbl_row.find('.btn_cancel').hide();

        //show edit button
        tbl_row.find('.btn_edit').show();

        //make the whole row editable
        tbl_row.find('.row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        tbl_row.find('.row_data').each(function(index, val)
        {
            $(this).html( $(this).attr('original_entry') );
        });
    });
//--->button > cancel > end


    //--->save whole row entery > start
    $(document).on('click', '.btn_save', function(event)
    {
        event.preventDefault();
        var tbl_row = $(this).closest('tr');

        var row_id = tbl_row.attr('row_id');


        //hide save and cacel buttons
        tbl_row.find('.btn_save').hide();
        tbl_row.find('.btn_cancel').hide();

        //show edit button
        tbl_row.find('.btn_edit').show();


        //make the whole row editable
        tbl_row.find('.row_data')
            .attr('edit_type', 'click')
            .removeClass('bg-warning')
            .css('padding','')

        //--->get row data > start
        var arr = {};
        tbl_row.find('.row_data').each(function(index, val)
        {
            var col_name = $(this).attr('col_name');
            var col_val  =  $(this).html();
            arr[col_name] = col_val;
        });
        //--->get row data > end

        //use the "arr"	object for your ajax call
        $.extend(arr, {row_id:row_id});

        var arrPost = {};
        arrPost[0] = row_id;
        arrPost[1] = arr["day"];

        save(arrPost)
        // //out put to show
        // $('.post_msg').html( '<pre class="bg-success">'+JSON.stringify(arr, null, 2) +'</pre>')

    });
//--->save whole row entery > end

    function save(arr) {

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
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

    }


})