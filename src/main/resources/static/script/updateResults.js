$(document).ready(() => {
    $('.btn-add-results').bind('click', function (obj)
    {
     let modal = new bootstrap.Modal(document.getElementById('addResultsModal'));
     modal.show();
        console.log($(obj.currentTarget).attr('data-result-id'));
        $('#resultIdInput').val($(obj.currentTarget).attr('data-result-id'));
    });

    $('#btnSaveResult').bind('click',function ()
    {
        const resultId = $('#resultIdInput').val();
        console.log(resultId);
        const data = {
            dogTime: $('#dogTime').val(),
            faults: $('#faults').val(),
            refusals: $('#refusals').val(),
            // speed: $('#speed').val(),
            // length: $('#length').val(),
            disq: $('#disq').val()
        };
        $.ajax({
            contentType: "application/json",
            type: "PUT",
            url: `/api/results/${resultId}`,
            dataType: 'json',
            data: JSON.stringify(data)
        }).done(function (response) {
            console.log(response);
            let modal2 = bootstrap.Modal.getInstance(document.getElementById('addResultsModal'));
            modal2.hide();
        });
    });
});

// course button
$(document).ready(() => {
    $('.btn-save-course').bind('click', function (obj)
    {
        let modal = new bootstrap.Modal(document.getElementById('saveCourse'));
        modal.show();
      });

    $('#btnSaveCourse').bind('click',function ()
    {
        const data = {
            courseSpeed: $('#courseSpeed').val(),
            courseLength: $('#courseLength').val(),
        };
        $.ajax({
            contentType: "application/json",
            type: "PUT",
            url: `/api/results`,
            dataType: 'json',
            data: JSON.stringify(data)
        }).done(function (response) {
            console.log(response);
            let modal2 = bootstrap.Modal.getInstance(document.getElementById('saveCourse'));
            modal2.hide();
        });
    });
});

