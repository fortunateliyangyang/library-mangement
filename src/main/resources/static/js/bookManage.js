$(function(){
    var URL = "http://localhost:8080/library/"
    $("#searchBookBtn").click(function (e) {
        e.stopPropagation();
        e.preventDefault();
        var name = $("#searchBook").val();
        console.log("name:"+name)
        $.ajax({
            type: 'GET',
            url: URL+'book/find/'+name ,
            dataType: 'json',
            success: function(msg){
                console.log(msg);
                console.log("name:"+msg.bookName)
                if(msg){
                    $(".searchedBook")
                        .append('<table class="table">\n' +
                            '  <tr>\n' +
                            '    <th>书名</th>\n' +
                            '    <th>作者</th>\n' +
                            '  </tr>\n' +
                            '  <tr>\n' +
                            '    <td>'+msg.bookName+'</td>\n' +
                            '    <td>'+msg.author+'</td>\n' +
                            '  </tr>\n' +
                            '</table>')
                }else{
                    $(".searchedBook").append("<p>查询无此书</p>")
                }
            },
            error:function(){
            }
        })
        return false
    })
    $("#deleteBtn").click(function(e){
        e.stopPropagation();
        e.preventDefault();
        var name=$("#deleteName").val();

        $.ajax({
            type: 'DELETE',
            url: URL+'book/delete/'+name,
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