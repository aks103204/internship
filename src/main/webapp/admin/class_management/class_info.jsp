<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../JS/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../../JS/jquery.cookie.js"></script>
</head>
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
      var cno=<%=request.getParameter("cno")%>;
      var CLASS_INFOBYCNO_URL="http://localhost:8080/admin/class_InfoById/"+cno;
      $.ajax({
        contentType: "application/json",
        url:CLASS_INFOBYCNO_URL,
        dataType: "text json",
        type:"post",
        statusCode:{
          200:function(data){
            var str="";
            $(data).each(function (index, value) {
              str += "<tr><td width='200' class='main'>" + value.sno + "</td>"+
                  "<td width='200'>" + value.cno   + "</td>" +
                  "<td width='1000'>"  + value.sname  + "</td>" +
                  "<td width='200'>" + value.sphone + "</td>" +
                  "<td width='200'>" + value.qq     + "</td>" +
                  "<td>"+
                  "<input type='button'  onclick='teacher_students("+value.sno+")' value='详情'/>"+
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
    function teacher_students(sno){
      window.location="../student_management/student_teacher_details.jsp?sno="+sno;
    }
</script>
<body style="background:url(../../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="../teacher_management/teacher_mana_index.jsp" ><img src="../../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="../student_management/student_mana_index.jsp"><img src="../../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="../class_management/class_mana_index.jsp"class="selected"><img src="../../images/icon01.png" title="班级管理"/>
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
                <li class="active"><cite></cite><a href="class_mana_index.jsp">班级管理</a><i></i></li>
                <li><cite></cite><a href="class_manage.jsp">班级信息导入</a><i></i></li>
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
                            <td width="200" id="sno" >学号</td>
                            <td width="200" id="cno">班级</td>
                            <td width="1000" id="name">姓名</td>
                            <td width="200" id="phone">手机号</td>
                            <td width="200" id="qq">QQ</td>
                            <td width="600">该学生任课老师</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- 动态生成页面跳转标签 -->
        <div style="padding-left:187px;width: 88.5%;overflow: hidden;margin: 0 auto;border: 1px solid #000;position: absolute;top: 88.5%;background-color: #3cc3f6;color: #fff;">
            <div style="height:30px;line-height:30px;">
                <div style="padding-left: 15.5%;height:30px;line-height:30px;width: 80px;float: left;"><%="第 "%>${current_page}<%=" 页"%></div>
                <div style="height:30px;line-height:30px;width: 80px;float: left;"><%="共 "%>${page_num}<%=" 页"%></div>
                <div style="float: left">
                    <a style="padding-left: 40px;" href="/student_ListServlet?current_page=${1}&count=${count}&cno=${cno}">首页</a>
                    <a style="padding-left: 10px;padding-right: 10px;" href="/student_ListServlet?current_page=${current_page>1 ? current_page-1:1}&count=${count}&cno=${cno}"><%="上一页 "%></a>
                    <c:forEach step="1" begin="1" end="${page_num}"  varStatus="status">
                        <c:if test="${status.current==current_page}">
                            <a style="color:#a00" href="/student_ListServlet?current_page=${status.current}&count=${count}&cno=${cno}"><%=" "%>${status.current}<%=" "%></a>
                        </c:if>
                        <c:if test="${status.current!=current_page}">
                            <a href="/student_ListServlet?current_page=${status.current}&count=${count}&cno=${cno}"><%=" "%>${status.current}<%=" "%></a>
                        </c:if>
                    </c:forEach>
                    <a style="padding-left: 10px;padding-right: 10px;"  href="/student_ListServlet?current_page=${current_page<page_num ? current_page+1:page_num}&count=${count}&cno=${cno}"><%=" 下一页"%></a>
                    <a  href="/student_ListServlet?current_page=${page_num}&count=${count}&cno=${cno}">尾页</a>
                </div>
                <div style="height:30px;line-height:30px;width: 120px;float: left;padding-left: 50px;">
                    <div style="float: left;"><%="到"%></div>
                    <div style="float: left;padding-right: 10px;"><%="第"%></div>
                    <div style="float: left;">
                        <form style="padding-top: 2.5px;line-height:30px;height: 25px;width: 25px;float:left" action="/student_ListServlet?cno=${cno}&count=${count}" method="post" name="form1">
                                <input type="text" name="current_page" style="border:1px solid #000;line-height:30px;height: 25px;width: 25px;text-align: center">
                        </form>
                    </div>
                    <div style="float: left;padding-right: 10px;padding-left: 10px;"><%="  页"%></div>
                    <a style="border: 1px solid #fcf5f5" href="javascript:void(0)" onclick="form1.submit()">确定</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
