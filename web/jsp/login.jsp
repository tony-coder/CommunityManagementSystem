<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/8
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  //获取web应用根目录路径
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎登录</title>
    <link rel="stylesheet" href="<%=basePath%>css/login.css" type="text/css">
</head>
<body>
<div class="wrap">
    <div id="logo">
        <a href="../index.jsp"><img width="298" height="60" alt="logo"
                                    src="<%=basePath%>images/logo.jpg"></a>
    </div>
</div>
<div id="content">
    <div class="login_wrap">
        <div class="login_banner">
            <div class="mask"></div>
            <div class="slogan"></div>
            <video src="<%=basePath%>videos/login_video.mp4" width="1366" height="476"
                   loop="" autoplay="">浏览器不支持MPEG4视频
            </video>
            <div class="login_part">
                <div class="login_form">
                    <form action="<%=basePath%>login.do" method="post">
                        <h1>
                            学社会员
                            <h1>
                                <div class="name">
                                    <label class="name_label"></label>
                                    <input class="text" type="text" name="username" id="username" placeholder="账号"/>
                                </div>
                                <div class="psd">
                                    <label class="psd_label"></label>
                                    <input class="text" type="password" name="password" id="password" placeholder="密码"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label"> 登录类型 </label>
                                    <%--<input class="form-control" type="text" placeholder="Email" autofocus>--%>
                                    <select class="form-control" id="type" name="type">
                                        <option disabled selected>请选择用户类型</option>
                                        <option value="管理员">管理员</option>
                                        <option value="学生">学生</option>
                                    </select>
                                </div>
                                <div class="auto_login">
                                    <input type="checkbox">自动登录
                                    <label>${message}</label>
                                </div>
                                <div class="button">
                                    <div class="button_bg">
                                        <input type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"
                                               onClick="return check()"/>
                                    </div>
                                </div>
                                <div class="tips">
                                    注意：默认密码为学号,登录后请及时修改
                                </div>
                            </h1>
                        </h1>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<jsp:include page="footer.jsp"></jsp:include>--%>

<script type="text/javascript">
    function check() {
        var username = document.getElementById('username');
        var password = document.getElementById('password');
        var select = document.getElementById("type");
        var index = select.selectedIndex;

        if (username.value == "") {
            alert("请输入学号！");
            return false;
        } else if (password.value == "") {
            alert("请输入密码！");
            return false;
        } else if (select.options[index].value == "请选择用户类型") {
            alert("请选择用户类型");
            return false;
        }
    }
</script>
</body>
</html>