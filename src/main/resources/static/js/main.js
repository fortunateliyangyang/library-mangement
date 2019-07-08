$(document).ready(function(){
    console.log("hello")
    var URL = "http://localhost:8080/library/manage/"
    $("#user").click(function(){
        // var username=$("#inputId").val();
        // var password=$("#inputPassword").val();
        //
        // console.log("name:"+username+"pwd:"+password)
        // $.ajax({
        //     type: 'PUT',
        //     url: URL+'login/' + username + "/" + password,
        //     dataType: 'text',
        //     success: function(msg){
        //         console.log(msg);
        //         if(msg==true){
        //
        //         }else{
        //             console.log("password is wrong")
        //             alert("用户名/密码不正确")
        //         }
        //     },
        //     error:function(){
        //         console.log("登录失败")
        //
        //     }
        // })  ;
        $(location).attr("href","http://localhost:8080/library/login/user.html")
    })
    $("#book").click(function(){
        $(location).attr("href","http://localhost:8080/library/login/bookMange.html")
    })

});