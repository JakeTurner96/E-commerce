$(document).ready(function(){
    $('#newPassword, #confirmNewPassword').keyup(function(){
        if ($('#newPassword').val() != $('#confirmNewPassword').val()) {
            $('#submitBtn').prop('disabled', true);
            $("#msg").html("Passwords do not match").css("color","red");
        }else if($('#password').val() == $('#confirmPassword').val()){
            $('#submitBtn').prop('disabled', false);
            $("#msg").html("");
        }
    });
 });

 function changePassword(){
   location.href = 'http://localhost:8080/changePassword';
 }