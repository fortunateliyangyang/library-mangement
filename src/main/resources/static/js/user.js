$(function () {
    var URL = "http://localhost:8080/library/"
    //添加用户
    $("#addUser").click(function(e){
        e.stopPropagation();
        e.preventDefault();
        var username=$("#inputNew").val();
        var password=$("#inputPassword3").val();
        var nickName=$("#inputNickname").val();
        console.log("name:"+username+"pwd:"+password)
        $.ajax({
            type: 'POST',
            url: URL+'manage/add/user',
            data: JSON.stringify({
               username: username,
               password: password,
               nickName: nickName,
            }),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function(msg){
                console.log(msg);
                if(eval(msg)){
                    alert("添加成功")
                }else{
                    alert("添加不成功")
                }
            },
            error:function(){
                console.log("添加失败")
            }
        })  ;
        return false

    })
    //删除用户
    $("#deleteUser").click(function(e){
        e.stopPropagation();
        e.preventDefault();
        var name=$("#deleteName").val();

        $.ajax({
            type: 'DELETE',
            url: URL+'manage/delete/'+name,
            dataType: 'text',
            success: function(msg){
                console.log(msg);
                if(eval(msg)){
                    alert("删除成功")
                }else{
                    alert("删除不成功")
                }
            },
            error:function(){
                console.log("删除失败")
            }
        })  ;
        return false

    })

})