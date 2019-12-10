<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/updatePsd_form.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../JS/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../JS/jquery.cookie.js"></script>
</head>
<script type="text/javascript">
    $(function () {
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
    function admin_Update_Psd(){
        var ano=getCookie("ano");
        var old_psd=$("#old_psd").val();
        var new_psd=$("#new_psd").val();
        var confirm_psd=$("#confirm_psd").val();
        if((old_psd.length<0||old_psd=="")){
            alert("原密码不得为空");
            return;
        }
        if((new_psd.length<0||new_psd=="")||(confirm_psd.length<0)||(confirm_psd=="")){
            alert("输入新密码，不得为空！");
            return;
        }
        if(new_psd!=confirm_psd){
            alert("两次输入的密码不一致，请重新输入！");
            return
        }
        if(new_psd==old_psd){
            alert("新密码和旧密码不能相同，请重新输入！");
            return
        }
        var ADMIN_UPDATE_PSD_URL="http://localhost:8080/admin/admin_Update_Psd/"+ano+"/"+old_psd+"/"+new_psd;
        $.ajax({
            contentType: "application/json",
            url:ADMIN_UPDATE_PSD_URL,
            dataType: "text json",
            type:"POST",
            statusCode:{
                200:function(data){
                    alert("密码修改成功！将自动跳转到主页。")
                    window.location.href="admin_index.jsp";
                },
                404:function(){
                    alert("密码修改失败，请重试！");
                    window.location="admin_updatePsd.jsp";
                },
                406:function(){
                    alert("原密码输入错误，请重新输入！");
                    window.location="admin_updatePsd.jsp";
                }
            }
        });
    }
</script>
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="teacher_management/teacher_mana_index.jsp" class="selected"><img src="../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="/student_manage"><img src="../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="/class_management_indexServlet" ><img src="../../images/icon01.png" title="班级管理"/>
            <h2>班级管理</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="/logout">退出</a></li>
        </ul>
        <div class="user">
            <span span="span1"></span>
        </div>
    </div>
</div>

<div class="container">
    <div class="lefttop"><span></span>列表</div>

    <dl class="leftmenu">
        <dd>
            <div class="title">
                <span><img src="../images/leftico01.png"/></span>管理信息
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="admin_personalInfo.jsp">查看个人信息</a><i></i></li>
                <li><cite></cite><a href="admin_updateInfo.jsp">修改个人信息</a><i></i></li>
                <li><cite></cite><a href="admin_updatePsd.jsp">修改个人密码</a><i></i></li>
                <li><cite></cite><a href="bulkInsert.jsp">导入人员信息</a><i></i></li>
                <li><cite></cite><a href="summary_graph.jsp">实习信息统计图</a><i></i></li>
            </ul>
        </dd>
    </dl>

    <div class="main">
        <div class="form_wrap">
            <form class="form_info" id="form_info" enctype="multipart/form-data" action="/admin/AdminUpdatePsd_Servlet" method="post">
                <div >
                    <input type="file" name="file" accept=".png,.jpg,.gif" onchange="OnInput(this)" id="upHeadImg" style="display: none">
                    <label for="upHeadImg">
                        <c:if test="${not empty IamgeName}">
                            <img style="width:80px;height:80px;position:relative;right:120px;margin:20px 0px;border:1px solid black;border-radius: 100%;"id="headImg" src="../images/headpic.jpg" />
                        </c:if>
                        <c:if test="${empty IamgeName}">
                            <img style="width:80px;height:80px;position:relative;right:120px;margin:20px 0px;border:1px solid black;border-radius: 100%;"id="headImg" src="../images/headpic.jpg" />
                        </c:if>
                    </label>

                </div>
                <div><input class="input_info" type="password" id="old_psd" placeholder="请输入原始密码"><span style="padding-right: 50px;padding-top: 10px;" class="error_message">${updatePsd_message1}</span></div>
                <div><br><input class="input_info" type="password" id="new_psd" placeholder="请输入新密码"><span style="padding-top: 48px;" class="error_message">${updatePsd_message2}</span></div>
                <div><br><input class="input_info" type="password" id="confirm_psd" placeholder="请再次输入新密码"><span style="padding-right: 10px;padding-top: 40px;" class="error_message">${updatePsd_message3}</span></div>
                  <div class="confirm_button_wrap">

                    <input style="" class="confirm_button" type="button" onclick=admin_Update_Psd() value="确认"/>
                  </div>
            </form>
        </div>

    </div>
</div>
</body>

<%--Ajax来实现异步实时刷新用户头像--%>
<script>
    var str=getCookie("ano");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this,str);
        }
    };
    xhttp.open("GET", "/xml/HeadImg.xml", true);
    xhttp.send();

    function myFunction(xml,str) {
        var i;
        var xmlDoc = xml.responseXML;
        var img="";
        var x = xmlDoc.getElementsByTagName("CD");
        for (i = 0; i <x.length; i++) {

            if (str == x[i].getElementsByTagName("userName")[0].childNodes[0].nodeValue) {

                img = x[i].getElementsByTagName("Headimg")[0].childNodes[0].nodeValue + "";

                document.getElementById("headImg").src = "../images/" + img;
                break;
            }
        }
        if(i>=x.length){
            document.getElementById("headImg").src = "../images/headpic.jpg" + img;
        }
    }
</script>

<%--实现上传头像刷新界面头像--%>

<script type="text/javascript">
    // Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9
    function OnInput (obj) {
        document.getElementById("headImg").src = window.URL.createObjectURL(obj.files[0]);
        document.getElementById("form_info").action="/admin/updateHeandImg"
        document.getElementById("form_info").submit();
    }
</script>
</html>