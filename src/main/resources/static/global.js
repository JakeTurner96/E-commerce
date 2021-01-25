function deleteAccount(){
    $.ajax({
        url: 'http://localhost:8080/deleteAccount',
        success: function(){
            location.href ='http://localhost:8080/';
        }
    })
}
