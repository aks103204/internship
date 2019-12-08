<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/other.css" rel="stylesheet" type="text/css"/>
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
        $("#submit1").click(function(){
            var type = $("input[name=type]:checked").val();
            var file = document.getElementById("peopleFiletext");
            if (file.value == "") {
                alert("请选择您需要上传的文件！");
            }//获得上传文件
            var form = new FormData();//初始化formDate对象
            //将两个变量通过append方法添加到formdata中，append方法中的第一个参数必须与后端请求的一致，第二个参数就是我们获取到的值
            form.append("type",type);
            form.append("file",file);
            var ADMIN_UPDATE_INFO_URL="http://localhost:8080/admin/admin_Insert_Info/";
            $.ajax({
                contentType: "application/json",
                url :ADMIN_UPDATE_INFO_URL ,
                dataType: "text json",
                type : "POST",
                data : form,
                async : true,
                cache : false,
                contentType : false,
                processData : false,
                success : function(data) {
                    alert(data)
                },
                404:function(){
                    alert("文件上传失败，请重新上传！");
                    window.location="bulkInsert.jsp";
                }
            });
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
    $("#submit1").click(function(){
        alert(111);
        var type = $("input[name=type]:checked").val();
        var file = $("#file")[0].files[0];//获得上传文件
        var form = new FormData();//初始化formDate对象
        //将两个变量通过append方法添加到formdata中，append方法中的第一个参数必须与后端请求的一致，第二个参数就是我们获取到的值
        form.append("type",type);
        form.append("file",file);
        alert(222);
        var ADMIN_UPDATE_INFO_URL="http://localhost:8080/admin/admin_Insert_Info/";
        $.ajax({
            type : "POST",
            url :ADMIN_UPDATE_INFO_URL ,
            data : form,
            async : true,
            cache : false,
            contentType : false,
            processData : false,
            success : function(data) {
                alert(data)
            },
            404:function(){
                alert("文件上传失败，请重新上传！");
                window.location="bulkInsert.jsp";
            }
        });
    })
</script>
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/teacher_mana_indexServlet" class="selected"><img src="../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="/student_manage"><img src="../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="/class_management_indexServlet" ><img src="../images/icon01.png" title="班级管理"/>
            <h2>班级管理</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
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
        <form id="uploadfile"class="fileUpload" enctype="multipart/form-data">
            <p>
                <input type="text" id="peopleFiletext" class="peopleFiletext" disabled>
                <input type="file" id="file" name="file" class="peopleInfoUpload" value="选择文件(支持xls,xlsx)" accept=".xls,.xlsx" onchange="showfile()"/>
            </p>
            <p>
                <input type="radio" name="type" id="teacher" value="teacher" checked/>
                <label class="radio-text">教师</label>
                <input type="radio" name="type" id="student" value="student"/>
                <label class="radio-text">学生</label>
            </p>
            <p>
                <input type="button" class="fileButton" value="提交" id="submit1"/>
                <input type="reset" class="fileButton" value="重置" id="reset"/>
            </p>
        </form>
    </div>
    <script type="text/javascript">
        function showfile() {
            var obj=document.getElementById("file");
            var len=obj.files.length;
            var fileName="";
            for (var i=0;i<len;i++){
                var path=obj.files[i].name;
                var temp=path.substring(path.lastIndexOf("\\")+1);
                if(i==0){
                    fileName=temp;
                }else{
                    fileName=fileName+","+temp;
                }
            }
            document.getElementById("peopleFiletext").value=fileName;
        }
    </script>
</div>
</body>
</html>
