let columnDefs = [
    {headerName: "Place", field: "id", filter: true, sortable: true},
    {headerName: "Dog", field: "dog", filter: true, sortable: true},
    {headerName: "Handler", field: "dog", filter: true, sortable: true},
    {headerName: "Time (s)", field: "time", filter: true, sortable: true},
    {headerName: "Speed (m/s)", field: "speed", filter: true, sortable: true},
    {headerName: "Mistakes", field: "mistakes", filter: true, sortable: true},
    {headerName: "Time faults", field: "timeFaults", filter: true, sortable: true},
    {headerName: "Total faults", field: "totalFaults", filter: true, sortable: true},
    {headerName: "Disq", field: "disq", filter: true, sortable: true}
];




// let the grid know which columns and what data to use
var gridOptions = {
    columnDefs: columnDefs,
    rowSelection: 'single',
   onSelectionChanged: onSelectionChanged
};

// // let the grid know which columns and what data to use
// var gridOptions = {
//     columnDefs: columnDefs,
//     // rowData: rowData
// };

// agGrid.simpleHttpRequest({url: 'http://localhost:8080/api/res'}).then(data => {
//     gridOptions.api.setRowData(data);
// });

// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', function () {
    var gridDiv = document.querySelector('#myGrid');
    new agGrid.Grid(gridDiv, gridOptions);
});


function onSelectionChanged() {
    var selectedRows = gridOptions.api.getSelectedRows();

    if (selectedRows.length === 1) {
        $('#selectedResult').text(selectedRows[0].time);

        $('#btnEdit').prop("disabled", false);
    }

    // document.querySelector('#selectedRows').innerHTML =
    //     selectedRows.length === 1 ? selectedRows[0].athlete : '';
}

//it returns all the results from DB in Json format
$(function () {
    var gridDiv = document.querySelector('#resultList');
    new agGrid.Grid(gridDiv, gridOptions);

    agGrid.simpleHttpRequest({url: 'http://localhost:8080/api/res'}).then(function (data) {
        gridOptions.api.setRowData(data);

        //$('#loader').css('display','none');
    });
});

//
    $('#btnEdit').bind('click', function () {
        var selectedRows = gridOptions.api.getSelectedRows();
        if (selectedRows.length === 1) {
            console.log(selectedRows[0].id);

            let editModal = new bootstrap.Modal(document.getElementById('resultEditModal'));
            editModal.show();

            let settings = {
                // "timeout": 3000,
                "async": true,
                "crossDomain": true,
                "url": "http://localhost:8080/results/" + selectedRows[0].id,
                "method": "GET",
                "headers": {
                    "cache-control": "no-cache"
                }
            }

//
//             $.ajax(settings).done(function (response) {
//
//                 $('#txtTime').val(response.time);
//                 $('#txtSpeed').val(response.speed);
//                 //$('#txtMistakes').val(response.mistakes);
//
//                 console.log(response);
//             });
        }
    });



