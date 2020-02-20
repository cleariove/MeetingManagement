// var xmlHttp = false;
//
// function initAJAX() {
//     if(window.XMLHttpRequest) {
//         xmlHttp = new XMLHttpRequest();
//     }
//     else if(window.ActiveXObject){
//         try{
//             xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
//         }catch (e){
//             try{
//                 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
//             }catch (e){
//                 window.alert("不支持ajax")
//             }
//         }
//     }
// }

function signUp()//注册
{
    var name = document.getElementsByName("name")[0].value;
    var nickname = document.getElementsByName("nickname")[0].value;
    var password = document.getElementsByName("password")[0].value;
    var gender = document.getElementsByName("gender")[0].value;
    var job = document.getElementsByName("job")[0].value;
    var tel = document.getElementsByName("tel")[0].value;
    // var formParam = $("form.signUp").serialize();
    if(name === "" ||nickname === ""||password === ""||gender === ""||job === ""||tel === "")
        alert("请填写完整信息！");
    else if(password.length < 6)
        alert("密码太短");
    else if(!confirmPassword())
        alert("两次输入密码不一致");
    else
    {
        $.ajax({
            type:"post",
            url:"/addUser",
            dataType:"json",
            data:
                {
                    "name":name,
                    "nickname":nickname,
                    "password":password,
                    "gender":gender,
                    "job":job,
                    "tel":tel
                },
            success:function (data) {
                location.href=(data);
            },
            error:function () {
                alert("注册失败，请稍后重试！");
            },
        });
    }
}

function logIn()//登录
{
    var account = document.getElementsByName("account")[0].value;
    var password = document.getElementsByName("password")[0].value;
    $.ajax(
        {
            type:"post",
            url: "/login",
            dataType: "json",
            data:
                {
                    "account":account,
                    "password":password
                },
            success:function(info)
            {
                var span = $("#tipSpan");
                if(info === "false")
                {
                    span.css("color","red");
                    span.text("密码错误");
                }
                else if(info === "nullAccount")
                {
                    span.css("color","red");
                    span.text("用户不存在");
                }
                else
                {
                    location.href=info;
                }
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function findAllUser() //查看所有用户
{
    $.ajax(
        {
            url:"/findAllUser",
            dataType:"json",
            type:"post",
            success:function (data)
            {
                var content = "<thead>\n" +
                    "<tr>\n" +
                    "<th>用户id</th>\n" +
                    "<th>用户姓名</th>\n" +
                    "<th>用户性别</th>\n" +
                    "<th>用户电话</th>\n" +
                    "<th>用户工作</th>\n" +
                    "<th>用户昵称</th>\n" +
                    "<th>用户权限</th>\n" +
                    "<th>权限操作</th>\n" +
                    "<th>账户操作</th>\n" +
                    "</tr>\n</thead>";
                for(var i in data)
                {
                    content += "<tr>\n" +
                        "<td>" + data[i].id + "</td>\n" +
                        "<td>" + data[i].name + "</td>\n" +
                        "<td>" + data[i].gender + "</td>\n" +
                        "<td>" + data[i].tel + "</td>\n" +
                        "<td>" + data[i].job + "</td>\n" +
                        "<td>" + data[i].nickname + "</td>\n" +
                        "<td>" + data[i].position + "</td>\n";
                        if(data[i].position == "1")
                        {
                            content += "<td><button onclick='accountManage("+
                                data[i].id + "," + true + ")'>" +
                                "提升" +
                                "</button></td>\n";
                        }
                        else if(data[i].position == "3")
                        {
                            content += "<td><button onclick='accountManage(" +
                                data[i].id + "," + false + ")'>" +
                                "降低" +
                                "</button></td>\n"
                        }
                        else
                        {
                            content += "<td><button onclick='accountManage(" +
                                data[i].id + "," + true + ")'>" +
                                "提升" +
                                "</button>" +
                                "<button onclick='accountManage(" +
                                data[i].id + "," + false + ")'>" +
                                "降低" +
                                "</button></td>\n"
                        }
                        content += "<td><button onclick='deleteUser("+
                            data[i].id + ")'>" +
                            "删除" +
                            "</button></td>\n" +
                            "</tr>";
                }
                $("#allUser").html(content);
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function deleteUser(id)//删除某用户
{
    $.ajax(
        {
            type:"post",
            data:{"id" : id},
            url:"/deleteUser",
            success:function ()
            {
                alert("删除成功！");
                location.reload();
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function accountManage(id,change)//修改用户权限
{
    $.ajax(
        {
            url:"/accountManage",
            data:
                {
                    "id":id,
                    "change":change
                },
            type:"post",
            success:function ()
            {
                alert("调整成功！");
                location.reload();
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function findMyOrganize()//查看我组织的会议
{
    $.ajax(
        {
            type:"post",
            url:"/findMyOrganize",
            dataType:"json",
            success:function (meetings)
            {
                var list = "<thead>\n" +
                    "<tr>\n" +
                    "<th>会议id</th>\n" +
                    "<th>会议名称</th>\n" +
                    "<th>查看参与者</th>\n";
                for(var i in meetings)
                {
                    list += "<tr>\n" +
                        "<td>" + meetings[i].id + "</td>\n" +
                        "<td>" + meetings[i].name + "</td>\n" +
                        "<td><button onclick='showAttendingUser("+meetings[i].id+")'>" +
                        "查看</button></td>" + "</tr>";
                }
                $("#findMyOrganize").html(list);
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function showAttendingUser(id) //查看参与会议的用户
{
    $.ajax(
        {
            data:{"id":id},
            type:"post",
            url:"/showAttendingUser",
            dataType:"json",
            success:function (data)
            {
                var content = "<thead>\n" +
                    "<tr>\n" +
                    "<th>用户id</th>\n" +
                    "<th>用户姓名</th>\n" +
                    "<th>用户工作</th>\n";
                for(var i in data)
                {
                    content += "<tr>\n" +
                        "<td>" + data[i].id + "</td>\n" +
                        "<td>" + data[i].name + "</td>\n" +
                        "<td>" + data[i].job + "</td>\n" +
                        "</tr>";
                }
                downloadUser(data)
                $("#findMyOrganize").html(content);
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function addMeeting()//申请会议
{
    var name = document.getElementsByName("name")[0].value;
    var date = document.getElementsByName("date")[0].value;
    var address = document.getElementsByName("address")[0].value;
    var content = document.getElementsByName("content")[0].value;
    var accommodation = document.getElementsByName("accommodation")[0].value;
    var needName = document.getElementsByName("needName")[0].value;
    var needJob = document.getElementsByName("needJob")[0].value;
    var needGender = document.getElementsByName("needGender")[0].value;
    var needTel = document.getElementsByName("needTel")[0].value;
    var organizer = getUser().name;
    $.ajax(
        {
            url:"/addMeeting",
            type:"post",
            data:
                {
                    "name":name,
                    "date":date,
                    "address":address,
                    "content":content,
                    "accommodation":accommodation,
                    "needName":needName,
                    "needGender":needGender,
                    "needJob":needJob,
                    "needTel":needTel,
                    "organizer":organizer
                },
            success:function ()
            {
                alert("申请会议成功，请等待审核");
                location.reload();
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function showAllMeeting()//查看所有会议
{
    $.ajax(
        {
            url: "/showAllMeeting",
            type: "post",
            dataType: "json",
            success:function (meetings)
            {
                var user = getUser();
                var list = "<thead>\n" +
                            "<tr>\n" +
                            "<th>会议id</th>\n" +
                            "<th>会议名称</th>\n" +
                            "<th>会议地点</th>\n" +
                            "<th>会议时间</th>\n" +
                            "<th>会议住宿</th>\n" +
                            "<th>详细信息</th>\n" +
                            "<th>组织者</th>\n" +
                            "<th>二维码</th>\n";
                if(user.position > "1")
                {
                    list += "<th>审核</th>\n"
                }
                list += "</tr>\n</thead>";
                for(var i in meetings)
                {
                    list +="<tr>\n" +
                        "<td>"+meetings[i].id+"</td>\n" +
                        "<td>"+meetings[i].name+"</td>\n" +
                        "<td>"+meetings[i].address+"</td>\n" +
                        "<td>"+meetings[i].date+"</td>\n" +
                        "<td>"+meetings[i].accommodation+"</td>\n" +
                        "<td>"+meetings[i].content+"</td>\n" +
                        "<td>"+meetings[i].organizer+"</td>\n" +
                        "<td><button onclick='showQRCode(" +
                        meetings[i].id + ")'>" +
                        "查看" +
                        "</button></td>\n";
                    if(user.position > "1")
                    {
                        if(meetings[i].status)
                            list += "<td>已通过\n" +
                                "<button onclick='auditMeeting("+meetings[i].id+","+false+")'>" +
                                "撤销</button></td>";
                        else
                        {
                            list +="<td><button onclick='auditMeeting("+meetings[i].id+","+true+")'>" +
                                "同意</button>" +
                                "<button onclick='auditMeeting("+meetings[i].id+","+false+")'>" +
                                "否决</button></td>";
                        }
                    }
                    list  += "</tr>";
                }
                $("#findAllMeeting").html(list);
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
    // xmlHttp.open("post","/showAllMeeting",true);
    // xmlHttp.onreadystatechange = function()
    // {
    //     if(xmlHttp.readyState === 4)
    //     {
    //         var data = xmlHttp.responseText;
    //         var meetings = JSON.parse(data);
    //         var list = "<thead>\n" +
    //             "<tr>\n" +
    //             "<th>会议id</th>\n" +
    //             "<th>会议名称</th>\n" +
    //             "<th>会议地点</th>\n" +
    //             "<th>会议时间</th>\n" +
    //             "<th>会议住宿</th>\n" +
    //             "<th>详细信息</th>\n" +
    //             "</tr>\n" +
    //             "</thead>";
    //         for (var i in meetings)
    //         {
    //             list +="<tr>\n" +
    //                 "<td>"+meetings[i].id+"</td>\n" +
    //                 "<td>"+meetings[i].name+"</td>\n" +
    //                 "<td>"+meetings[i].address+"</td>\n" +
    //                 "<td>"+meetings[i].date+"</td>\n" +
    //                 "<td>"+meetings[i].accommodation+"</td>\n" +
    //                 "<td>"+meetings[i].content+"</td>\n" +
    //                 "</tr>"
    //         }
    //     }
    //     $("table").html(list);
    // }
    // xmlHttp.send();
}

function showQRCode(id)//通过二维码查看会议信息
{
    $.ajax(
        {
            data:{"id":id},
            type:"post",
            dataType:"json",
            url:"/showQRCode",
            success:function (data)
            {
                // var outputimg = document.createElement('img');
                // outputimg.src = 'data:image/jpg;base64,' + data;
                // $("#image").html(outputimg);
                document.getElementById("image").src = 'data:image/jpg;base64,' + data;
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
    // var text = document.createElement("img");
    // text.src = "web/images/"+getUser().id+".jpg";
    // var image = new Image();
    // image.src="web/images/"+getUser().id+".jpg";
    // var text = "<img src="
    // +"C:\\Users\\me\\IdeaProjects\\meeting\\web\\images\\"+getUser().id+id+".jpg>";
    //
    // document.getElementById("image").src = "web/images/"+getUser().id+id+".jpg"
}

function attendMeeting(id)//参加某会议
{
    var needRoom = document.getElementsByName("needRoom")[0].value;
    $.ajax(
        {
            type:"post",
            url:"/attendMeeting",
            data:{
                "meetingId":id,
                "needRoom":needRoom,
            },
            success:function ()
            {
                alert("已成功报名该会议!");
                location.reload();

            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function showCanAttendMeeting()//查看还未参加的会议
{
    $.ajax(
        {
            url: "/findCanAttendMeeting",
            type: "post",
            dataType: "json",
            success:function (meetings)
            {
                var list = "<thead>\n" +
                    "<tr>\n" +
                    "<th>会议名称</th>\n" +
                    "<th>是否需要住宿</th>\n" +
                    "<th>操作</th>\n" +
                    "</tr>\n</thead>";
                for(var i in meetings)
                {
                    list +="<tr>\n" +
                        "<td>"+meetings[i].name+"</td>\n" +
                        "<td><input type=\"radio\" value=\"true\" name='needRoom'>是" +
                        "<input type=\"radio\" value=\"false\" name='needRoom'>否</td>" +
                        "<td><input type=\"button\" onclick='attendMeeting("+meetings[i].id
                        + ")' " +
                        "value='预定'>"+
                        "</td>\n"
                        "</tr>";
                }
                $("#attendMeeting").html(list);
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function auditMeeting(id,pass)//审核会议
{
    $.ajax(
        {
            url:"/auditMeeting",
            data:
                {
                    "id":id,
                    "pass":pass
                },
            type:"post",
            success:function ()
            {
                location.reload();
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

function findAttendingMeeting()//查看参加了的会议
{
    $.ajax(
        {
            dataType:"json",
            url:"/findAttendingMeeting",
            type:"post",
            success:function (meetings)
            {
                var list = "<thead>\n" +
                    "<tr>\n" +
                    "<th>会议id</th>\n" +
                    "<th>会议名称</th>\n" +
                    "<th>会议地点</th>\n" +
                    "<th>会议时间</th>\n" +
                    "<th>会议住宿</th>\n" +
                    "<th>详细信息</th>\n" +
                    "<th>组织者</th>\n" +
                    "</tr>\n</thead>";
                for(var i in meetings)
                {
                    list += "<tr>\n" +
                        "<td>" + meetings[i].id + "</td>\n" +
                        "<td>" + meetings[i].name + "</td>\n" +
                        "<td>" + meetings[i].address + "</td>\n" +
                        "<td>" + meetings[i].date + "</td>\n" +
                        "<td>" + meetings[i].accommodation + "</td>\n" +
                        "<td>" + meetings[i].content + "</td>\n" +
                        "<td>" + meetings[i].organizer + "</td>\n" +
                        "</tr>";
                }
                downloadMeeting(meetings);
                $("#findAttendingMeeting").html(list);
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

//
// //yyyy-MM-dd HH:mm:SS
// function getDateTime(date) {
//     var year = date.getFullYear();
//     var month = date.getMonth() + 1;
//     var day = date.getDate();
//     return year + "-" + month + "-" + day;
// }
// //调用的是这个方法
// function ConvertJSONDateToJSDate(jsondate) {
//     var date = new Date(parseInt(jsondate.replace("/Date(", "").replace(")/", ""), 10));
//     getDateTime(date)
//     return date;
// }

function downloadUser(data)
{
    var str = `用户id,用户姓名,用户工作\n`;
    //增加\t为了不让表格显示科学计数法或者其他格式
    for(var i in data)
    {
        str+=data[i].id+","+data[i].name+","+data[i].job+'\n';
    }
    //encodeURIComponent解决中文乱码
    var uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(str);
    //通过创建a标签实现
    var link = document.createElement("a");
    link.href = uri;
    //对下载的文件命名
    link.download =  "会议人员.csv";
    link.innerHTML="点击此处下载";
    document.body.appendChild(link);
}

function downloadMeeting(data)
{
    var str = `会议id,会议名称,会议地点,会议时间,会议住宿,详细信息,组织者\n`;
    //增加\t为了不让表格显示科学计数法或者其他格式
    for(var i in data)
    {
        str+=data[i].id+","+data[i].name+","+data[i].address+","+data[i].date+","+
            data[i].accommodation+","+data[i].content+","+data[i].organizer+'\n';
    }
    //encodeURIComponent解决中文乱码
    var uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(str);
    //通过创建a标签实现
    var link = document.createElement("a");
    link.href = uri;
    //对下载的文件命名
    link.download =  "我的会议.csv";
    link.innerHTML="点击此处下载";
    document.body.appendChild(link);
}

function getUser()//获得当前登录的账号
{
    var user='';
    $.ajax(
        {
            async:false,
            url:"/getUser",
            dataType:"json",
            type:"post",
            success:function (data)
            {
                user = data;
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    );
    return user;
}

function confirmPassword()//确认密码
{
    var password = document.getElementById("psd").value;
    var confirm = document.getElementById("confirm").value;
    var span = document.getElementById("confirmSpan");
    if(password !== confirm)
    {
        span.style.color = "red";
        span.innerHTML = "密码不一致";
        return false;
    }
    else
    {
        span.style.color = "green";
        span.innerHTML = "密码一致";
        return true;
    }
}