<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../JS/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../../JS/jquery.cookie.js"></script>

    <script type="text/javascript">
      $(function () {
        //顶部导航切换
        $(".nav li a").click(function () {
          $(".nav li a.selected").removeClass("selected");
          $(this).addClass("selected");
        })
        if(getCookie("ano")==null){
          alert("请先登陆后访问此网页！");
          window.location="../../index.jsp"
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
      var delCookie = function (name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        //获取cookie是否存在
        var value = getCookie(name);
        if (value != null) {
          document.cookie = name + "=" + escape("") + ";expires="+ exp.toUTCString()+ ";path=/";
        }
      }
      function quit() {
        delCookie("ano");
      }
      $(function () {
        var sno=<%=request.getParameter("sno")%>;
        var STUDENT_TEACHER_DETAILS_URL="http://localhost:8080/admin/student_Teacher_Details/"+sno;
        $.ajax({
          contentType: "application/json",
          url:STUDENT_TEACHER_DETAILS_URL,
          dataType: "text json",
          type:"post",
          statusCode:{
            200:function(data){
              var str="";
              $(data).each(function (index, value) {
                str += "<tr><td width='200' class='main'>" + value.tno + "</td>" +
                    "<td width='200'>" + value.tname + "</td>" +
                    "<td width='200'>" + value.tphone + "</td>" +
                    "<td width='200'>" + value.tqq + "</td>" +
                    "<td width='200'>" + value.tprofession+"</td>"+
                    "<td>"+
                    "<input type='button'  onclick='teacher_students("+value.tno+")' value='详情'/>"+
                    "</td></tr>";
              });
              $("#msg").append(str);
            },
            404:function(){
              alert("获取信息失败！");
            }
          }
        });
      });
      function teacher_students(tno){
        window.location="../teacher_management/teacher_student_details.jsp?tno="+tno;
      }
    </script>
    <style>
        .show{width:100%;overflow:hidden;}
        .show .show-wrap{margin: 0 auto;}
        .per-info{
            font-size: 25px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;
            line-height:50px;height:50px;width:250px;text-align: center
        }
        .per-input{
            margin-left:5%;height: 100%; overflow: hidden;float: left;margin-bottom: 8px;border: 1px #aaa solid;border-radius: 4px;background: 0 0;text-align: left;font-size: 20px;width: 438px;height: 50px;line-height: 2.4;padding: 0 20px;
        }
        .per-text{
            float:left;width: 80px;height: 30px;padding-top: 20px;font-size: 20px;
        }
    </style>
</head>
<body style="background:url(../../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="../teacher_management/teacher_mana_index.jsp" class="selected"><img src="../../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="../student_management/student_mana_index.jsp"><img src="../../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="../class_management/class_mana_index.jsp"><img src="../../images/icon01.png" title="班级管理"/>
            <h2>班级管理</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="../../index.jsp" onclick="quit()">退出</a></li>
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
                <li class="active"><cite></cite><a href="../teacher_management/teacher_mana_index.jsp">教师管理首页</a><i></i></li>
                <li><cite></cite><a href="../teacher_management/teacher_add.jsp">添加教师信息</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">
        <div style="padding-left: 0px;width: 80%;margin: 0 auto;">
            <div style="height:40px;line-height:40px;">
                <div style="color: #000;text-align: center;">
                    <table id="msg">
                        <tbody>
                        <tr id="bold">
                            <td width="200" id="id"  >id</td>
                            <td width="200" id="name">姓名</td>
                            <td width="200" id="phone">手机号</td>
                            <td width="200" id="qq">QQ</td>
                            <td width="200" id="profession">专业</td>
                            <td width="600">该老师所教学生</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</div>
</body>
</html>
