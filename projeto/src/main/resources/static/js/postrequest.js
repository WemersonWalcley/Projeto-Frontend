$(document).ready( () => {
    $("#btnSubmit").click((event) => {
        event.preventDefault();
        doAjax();
    });
 
});
 
function doAjax() {
 
    
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
 
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/api/file/upload",
        data: data,
        processData: false, 
        contentType: false,
        cache: false,
        success: (data) => {
            $("#listFiles").text(data);
        },
        error: (e) => {
            $("#listFiles").text(e.responseText);
        }
    });
}