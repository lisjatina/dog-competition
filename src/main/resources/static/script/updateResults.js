$(document).ready(() => {
    const modal = $('#addResultsModal');
    modal.on('show.bs.modal', function (event) {
        const button = $(event.relatedTarget); // Button that triggered the modal
        const resultId = button.data('resultId'); // Extract info from data-* attributes
        console.log('resultId', resultId);
        modal.find('#resultIdInput').val(resultId);
    });

    const form = modal.find('form');
    form.on('submit', event => sendData(event, form, modal));
});


function sendData(event, form, modal) {
    event.preventDefault();
    const resultId = form.find('#resultIdInput').val();
    const data = {
        dogTime: form.find('input[name="dogTime"]').val(),
        faults: form.find('input[name="faults"]').val(),
        refusals: form.find('input[name="refusals"]').val(),
        speed: form.find('input[name="speed"]').val(),
        length: form.find('input[name="length"]').val(),
        disq: form.find('input[name="disq"]').val()
    };
    $.ajax({
        contentType: "application/json",
        type: "PUT",
        url: `/api/results/${resultId}`,
        dataType: 'json',
        data: JSON.stringify(data)
    }).done(function (response) {
        console.log(response);
        $('btnSaveResult').bind('click', sendData());
        modal.hide();
    });
}
