$(document).ready(function () {
    var URL = "http://localhost:8080/library/"
    // 获取当前页面id
    var params = window.location.search;
    var arr = params.substring(1).split("=");
    console.log("arr[1]= "+arr[1])
    var PageId = arr[1];

    // 个人信息
    $.ajax({
        type: 'get',
        url: URL + 'student/info/'+PageId,
        async: false,
        dataType: "json",
        success: function (data) {
            console.log(data.nickName)
            console.log($("#nickName"))
            $("#nickName").html(data.nickName)
            $("#person").html(data.id)
            $("#phone").html(data.telephone)
            $("#ema").html(data.email)
            $("#university").html(data.classes)
            $("#calendar").html(data.birth)
            $("#pin").html(data.personalityWord)
        },
        error: function () {
            console.log("失败")
        }

    })



    //书籍检索
    $("#search").click(function (e) {
        var searchContent = $("#searchInput").val();
        var selectVal = $("#selectID").val();
        var selectType
        switch (selectVal){
            case "编号":
                selectType ="id";
                break;
            case "书名":
                selectType = "name";
                break;
            case "类型":
                selectType = "type";
                break;
            default:
                break
        }
        console.log("selectType="+selectType)
        console.log("searchContent="+searchContent)
        $.ajax({
            type: 'get',
            url: URL + 'book/find/'+selectType+'/'+searchContent,
            async: false,
            dataType: "json ",
            success: function (data) {
                console.log("this 1")
                var str
                console.log("this 2")
                $.each(data, function (index, book) {
                    var a=""
                    if(book.status == 0){
                        book.status = a+"可借阅"
                    }else{
                        book.status = a+"不可借"
                    }
                    console.log("this 3")
                    str = '<tr>' +
                        '<td>' + book.id + '</td>' +
                        '<td>' + book.title + '</td>' +
                        '<td>' + book.pubhouse + '</td>' +
                        '<td>' + book.status+ '</td>' +
                        '<td>' + '<button value="借书" type="submit">借书</button>'+ '</td>' +
                        '</tr>';
                })
                console.log("this 4")
                $("#tableResult").append(str);
            },
            error: function () {
                console.log("失败")
            }

        })
    })

    // 借阅的书籍

    // $.ajax({
    //     type: 'get',
    //     url: URL + 'record/select/' + stuId,
    //     async: false,
    //     dataType: "json ",
    //     success: function (data) {
    //         var str = '<table class="table table-hover">' +
    //             '    <tr>' +
    //             '        <td>书籍编号</td>' +
    //             '        <td>书籍名称</td>' +
    //             '        <td>借阅状态</td>' +
    //             '    </tr>' +
    //             '    </table>';
    //         $.each(data, function (index, book) {
    //             str += '<tr>' +
    //                 '<td>' + book.id + '</td>' +
    //                 '<td>' + book.bookName + '</td>' +
    //                 '<td>' + book.bookPrice + '</td>' +
    //                 '<td>' + "修改 删除" + '</td>' +
    //                 '</tr>';
    //         })
    //         $("#home").html(str);
    //     },
    // })
    //
    // 还书


})