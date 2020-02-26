<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
            $(".nav li a.selected").removeClass("selected")
            $(this).addClass("selected");
        })
      if(getCookie("sno")==null){
        alert("请先登陆后访问此网页！");
        window.location="../index.jsp"
      }else{
        $("#span1").html(getCookie("sno"));
      }
    })
</script>
<script type="text/javascript">
    $(function () {
        //导航切换
        $(".menuson li").click(function () {
            $(".menuson li.active").removeClass("active")
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
      delCookie("sno");
    }
    function student_Update_Psd(){
      var sno=getCookie("sno");
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
      var STUDENT_UPDATE_PSD_URL="http://localhost:8080/student/student_Update_Psd/"+sno+"/"+old_psd+"/"+new_psd;
      $.ajax({
        contentType: "application/json",
        url:STUDENT_UPDATE_PSD_URL,
        dataType: "text json",
        type:"POST",
        statusCode:{
          200:function(data){
            alert("密码修改成功,请重新输入密码登陆！")
            window.location.href="../index.jsp";
          },
          404:function(){
            alert("密码修改失败，请重试！");
            window.location="student_updatePsd.jsp";
          },
          406:function(){
            alert("原密码输入错误，请重新输入！");
            window.location="student_updatePsd.jsp";
          }
        }
      });
    }
</script>
<style>
    /*.main .font_size{font-size: 25px;}
    .main input  {background: #ddfff8;  !*设置输入框背景色*!font-size: 25px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;line-height:50px;height:50px;width:250px;text-align: center}
    .main button  {background: #ddfff8;  !*设置输入框背景色*!font-size: 20px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;margin-top: 10px;width: 50px;}
*/ .main input  {font-size: 10px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;line-height:50px;height:30px;width:150px;text-align: center}
    .main button  {background: #ddfff8;  /*设置输入框背景色*/font-size: 20px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;margin-top: 10px;width: 50px;}
    .main .ul .li{margin-top: 20px}
</style>
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="student_index.jsp"><img src="../images/home.png" width="64" height="64" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/student/student_index.jsp" class="selected"><img src="../images/icon02.png" title="1"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/student/loadTask"><img src="../images/icon03.png" title="2"/>
            <h2>任务模块</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="../index.jsp" target="_parent">退出</a></li>
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
                <span><img src="../images/leftico01.png"/></span>管理信息
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="/student/student_personnalInfo.jsp">查找信息</a><i></i></li>
                <li class="active"><cite></cite><a href="/student/student_updatePsd.jsp">修改密码</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">
        <div class="form_wrap">
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
            <div><input class="input_info" type="password" id="old_psd" placeholder="请输入原始密码"><span style="padding-right: 50px;padding-top: 10px;" class="error_message"></span></div>
            <div><br><input class="input_info" type="password" id="new_psd" placeholder="请输入新密码"><span style="padding-top: 48px;" class="error_message"></span></div>
            <div><br><input class="input_info" type="password" id="confirm_psd" placeholder="请再次输入新密码"><span style="padding-right: 10px;padding-top: 40px;" class="error_message"></span></div>
            <div class="confirm_button_wrap">

                <input style="" class="confirm_button" type="button" onclick=student_Update_Psd() value="确认"/>
            </div>
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