//not working
function deleteData() {

    let settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/update/results",
        "method": "DELETE",
        "headers": {
            "cache-control": "no-cache",
        }
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}
