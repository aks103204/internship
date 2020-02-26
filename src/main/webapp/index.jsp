<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎使用专业实习实训管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="JS/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="JS/jquery.cookie.js"></script>
    <script src="JS/cloud.js" type="text/javascript"></script>


<script language="javascript">
    $(function () {
        $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 471) / 2});
        $(window).resize(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 471) / 2});
        })
    });

    $(function(){
        //添加cookie
        var addCookie = function (name, value) {
            document.cookie = name + "=" + value;
        }
        $("#login").click(function(){
            var username=$("#username").val();
            var password=$("#password").val();
            var type=$("#select1").val();
            if((username=="" || username.length<0)||(password=="" || password.length<0)){
                alert("必须输入用户名和密码");
                return;
            }
            var ADMIN_LOGIN_URL="http://localhost:8080/admin/login/"+username+"/"+password;  //Rustful风格
            var STUDENT_LOGIN_URL="http://localhost:8080/student/login/"+username+"/"+password;  //Rustful风格
            var TEACHER_LOGIN_URL="http://localhost:8080/teacher/login/"+username+"/"+password;  //Rustful风格
            if(type=="admin"){
            $.ajax({
              contentType: "application/json",
              url:ADMIN_LOGIN_URL,
              type:"POST",
              statusCode:{
                200:function(data){
                  addCookie("ano",username);
                  window.location="admin/admin_index.jsp";
                },
                404:function(){
                  alert("用户名或密码错误！");
                  window.location="index.jsp";
                }
              }

            });
          }else if(type=="teacher"){
            $.ajax({
              contentType: "application/json",
              url:TEACHER_LOGIN_URL,
              type:"POST",
              statusCode:{
                200:function(data){
                  addCookie("tno",username);
                  window.location="admin/admin_index.jsp";
                },
                404:function(){
                  alert("用户名或密码错误！");
                  window.location="index.jsp";
                }
              }

            });
          }else if(type=="student"){
            $.ajax({
              contentType: "application/json",
              url:STUDENT_LOGIN_URL,
              type:"POST",
              statusCode:{
                200:function(data){
                  addCookie("sno",username);
                  window.location="student/student_index.jsp";
                },
                404:function(){
                  alert("用户名或密码错误！");
                  window.location="index.jsp";
                }
              }

            });
          }
        });
    });
</script>
</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>

<div class="logintop">
    <span>欢迎使用专业实习实训管理系统</span>
    <ul>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">
    <span class="systemlogo"></span>
    <div class="loginbox" style="border:1px solid black;height: 400px;">
        <form >
            <div >
                <img style="width:80px;height:80px;margin: 20px 183px;border-radius: 100%;"id="headImg" src="images/headpic.jpg" />
            </div>
            <ul >
                <li><input name="id" id="username"onkeyup="loadXMLDoc(this.value)" type="text" class="loginuser" placeholder="学号/工号"/></li>
                <li><input name="password" id="password" type="password" class="loginpwd" placeholder="密码"/></li>
                <li>
                    <select name="identity" id="select1" class="loginselect" style="margin-left: 65px;">
                        <option value="admin" id="admin">管理员</option>
                        <option value="teacher" id="teacher">教师</option>
                        <option value="student" id="student">学生</option>
                    </select>
                </li>
                <li>
                    <input style="margin-left: 85px;" type="text" id="login" class="loginbtn" value="登录"/>
                </li>
                <li>
                    <%
                        String loginmsg = (String) request.getAttribute("loginmsg");
                        if (loginmsg!=null) {%>
                            <label style="color: #ff0000"><%=loginmsg%></label>
                    <%}%>
                </li>
            </ul>
        </form>
    </div>
</div>

<div class="loginbm">学习使用</div>

</body>
<script>
    if(document.getElementById("username").value.toLowerCase()==""){
        document.getElementById("headImg").src = "images/headpic.jpg";
    }
    function loadXMLDoc(str) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                myFunction(this,str);
            }
        };
        xhttp.open("GET", "/xml/HeadImg.xml", true);
        xhttp.send();
    }
    function myFunction(xml,str) {
        var i;
        var xmlDoc = xml.responseXML;
        var img="";
        var x = xmlDoc.getElementsByTagName("CD");
        for (i = 0; i <x.length; i++) {
            if (str == x[i].getElementsByTagName("userName")[0].childNodes[0].nodeValue) {
                img = x[i].getElementsByTagName("Headimg")[0].childNodes[0].nodeValue + "";
                document.getElementById("headImg").src = "images/" + img;
                break;
            }else{
                document.getElementById("headImg").src = "images/headpic.jpg";
            }
        }
    }
</script>
</html>
