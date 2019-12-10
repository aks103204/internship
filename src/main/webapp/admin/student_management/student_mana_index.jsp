<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../JS/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../../JS/jquery.cookie.js"></script>

<script type="text/javascript">
    $(function () {
        $("#bold").css("font-weight","bold");$("#bold").css("font-weight","bold");
        //顶部导航切换
        $(".nav li a").click(function () {
            $(".nav li a.selected").removeClass("selected");
            $(this).addClass("selected");
        })
        if(getCookie("ano")==null){
            $("#span1").html("游客");
        }else{
            $("#span1").html(getCookie("ano"));
        }
    })
</script>
<script type="text/javascript">
    $(function () {
        //导航切换
        $(".menuson li").click(function () {
            $(".menuson li.active").removeClass("active");
            $(this).addClass("active");
        });

        $('.title').click(function () {
            var $ul = $(this).next('ul');
            $('dd').find('ul').slideUp();
            if ($ul.is(':visible')) {
                $(this).next('ul').slideUp();
            } else {
                $(this).next('ul').slideDown();
            }
        });

    })
    var getCookie = function (name) {
        //获取当前所有cookie
        var strCookies = document.cookie;
        //截取变成cookie数组
        var array = strCookies.split(';');
        //循环每个cookie
        for (var i = 0; i < array.length; i++) {
            //将cookie截取成两部分
            var item = array[i].split("=");
            //判断cookie的name 是否相等
            if (item[0] == name) {
                return item[1];
            }
        }
        return null;
    }

    $(function () {
        var TEACHER_INFO_URL="http://localhost:8080/admin/student_Info";
        $.ajax({
            contentType: "application/json",
            url:TEACHER_INFO_URL,
            dataType: "text json",
            type:"post",
            statusCode:{
                200:function(data){
                    var str="";
                    $(data).each(function (index, value) {
                        str += "<tr><td width='200' class='main'>" + value.sno + "</td>"+
                                    "<td width='200'>" + value.cno   + "</td>" +
                                    "<td width='200'>"  + value.name  + "</td>" +
                                    "<td width='200'>" + value.phone + "</td>" +
                                    "<td width='200'>" + value.qq     + "</td>" +
                                    "<td>"+
                                    "<input type='button'  onclick='edit("+value.sno+")' value='操作'/>"+
                                    "</td></tr>";
                    });
                    $("#msg").append(str);
                },
                404:function(){
                    alert("获取信息失败！");
                    window.location="index.jsp";
                }
            }
        });
    });
    function edit(sno) {
        window.location="student_info.jsp?sno="+sno;
    }
</script>

</head>
<body style="background:url('../../images/topbg.gif') repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="../teacher_management/teacher_mana_index.jsp"><img src="../../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="../student_management/student_mana_index.jsp" class="selected"><img src="../../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="../class_management/class_mana_index.jsp"><img src="../../images/icon01.png" title="班级管理"/>
            <h2>班级管理</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="/logout">退出</a></li>
        </ul>
        <div class="user">
            <span id="span1"></span>
        </div>
    </div>
</div>

<div class="container">
    <div class="lefttop"><span></span>列表</div>

    <dl class="leftmenu">
        <dd>
            <div class="title">
                <span><img src="../../images/leftico01.png"/></span>管理信息
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="student_add.jsp">增加学生</a><i></i></li>
            </ul>
        </dd>
    </dl>

    <div class="main">
        <div style="padding-left: 187px;width: 50%;margin: 0 auto;">
            <div style="height:40px;line-height:40px;">
                <div style="color: #000;text-align: center;">
                    <table id="msg">
                        <tbody>
                        <tr id="bold">
                            <td width="200" id="sno"  >学号</td>
                            <td width="200" id="cno">班级</td>
                            <td width="200" id="name">姓名</td>
                            <td width="200" id="phone">手机号</td>
                            <td width="200" id="qq">QQ</td>
                            <td width="200" colspan="2">操作</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
