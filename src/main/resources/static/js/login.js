/**
 * Created by 2306-01 on 19-5-15.
 */
$(document).ready(function(){
    var $=jQuery.noConflict()
    $('#myTab a[href="#home"]').tab('show')
    // 登录页面
    var URL = "http://localhost:8080/library/"

    $("#login").click(function (e) {
        var usernameStu = $("#inputIdStu").val();
        var passwordStu = $("#InputPasswordStu").val();
        var usernameMan = $("#inputIdMan").val();
        var passwordMan = $("#InputPasswordMan").val();

        if (usernameStu != null && passwordStu != null) {

            $.ajax({
                type: 'put',
                url: URL + 'student/login/' + usernameStu + "/" + passwordStu,
                async: false,
                success: function (msg) {
                    console.log(msg);
                    if (eval(msg)) {
                        $(location).attr('href', "http://localhost:8080/library/html/students.html?id=" +usernameStu);

                        console.log("ok")
                    } else {
                        console.log("password is wrong")
                        alert("用户名/密码不正确")
                    }
                },
                error: function () {
                    console.log("登录失败")
                }
            });
        }
        if (usernameMan != null && passwordMan != null) {
            $.ajax({
                type: 'post',
                url: URL + 'manage/login/' + usernameMan + "/" + passwordMan,
                data: 'userId=' + usernameMan + '&pass=' + passwordMan,
                dataType: 'jsonp',
                success: function (msg) {
                    console.log(msg);
                    if (eval(msg)) {
                        $(location).attr("href", "http://localhost:8080/library/html/students.html?id=" + usernameMan);
                        console.log("ok")
                    } else {
                        console.log("password is wrong")
                        alert("用户名/密码不正确")
                    }
                },
                error: function () {
                    console.log("登录失败")
                }
            });

        }
    })
})

