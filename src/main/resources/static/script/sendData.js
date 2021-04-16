// function sendData() {
//     $.ajax({
//         type: "POST",
//         url: "/results/update",
//         success: function (data) {
//             let obj = JSON.parse(data);
//             obj.forEach(element => $('#serverData').append(element.user));
//             console.log(data);
//         },
//     });
// }
//
// $('#btnSaveResult').bind('click', sendData()){
//     console.log('button clicked')
// };