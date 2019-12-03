<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/9
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  //获取web应用根目录路径
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description"
          content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>社团课程报名管理系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="app sidebar-mini rtl">
<!-- Navbar-->
<header class="app-header"><a class="app-header__logo" href="<%=basePath%>admin/index.do">后台管理系统</a>
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i
                class="fa fa-user fa-lg"></i></a>
            <ul class="dropdown-menu settings-menu dropdown-menu-right">
                <li><a class="dropdown-item" href="<%=basePath%>student/account"><i class="fa fa-cog fa-lg"></i>
                    账号设置</a></li>
                <%--                <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-user fa-lg"></i> Profile</a></li>--%>
                <li><a class="dropdown-item" href="<%=basePath%>quit.do"><i class="fa fa-sign-out fa-lg"></i> 退出</a>
                </li>
            </ul>
        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar"
                                        src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name">${admin.id}</p>
            <p class="app-sidebar__user-designation">管理员</p>
        </div>
    </div>
    <ul class="app-menu">
        <li><a class="app-menu__item" href="<%=basePath%>admin/index.do"><i class="app-menu__icon fa fa-user"></i><span
                class="app-menu__label">欢迎</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/club.do"><i
                class="app-menu__icon fa fa fa-book"></i><span class="app-menu__label">社团管理</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/student.do"><i
                class="app-menu__icon fa fa-align-left"></i><span
                class="app-menu__label">学生管理</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/course.do"><i class="app-menu__icon fa fa-edit"></i><span
                class="app-menu__label">社团课程管理</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/StuCourse.do"><i
                class="app-menu__icon fa fa-edit"></i><span
                class="app-menu__label">选课管理</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/clubStatistics.do"><i
                class="app-menu__icon fa fa-edit"></i><span
                class="app-menu__label">统计图表</span></a></li>
    </ul>
</aside>
<%--content--%>
<main class="app-content">
    <div class="app-title">
        <div>
            <h1><i class="fa fa fa-user"></i> 学生管理</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
            <li class="breadcrumb-item"><a href="<%=basePath%>admin/student.do">学生管理</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <form class="form-group col-md-12" id="updateStudentForm" action="<%=basePath%>/admin/insertStudent.do">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-3">
                                <label>学生学号</label>
                                <input class="form-control" type="text" name="insertId" placeholder="请输入学生学号" required>
                            </div>
                            <div class="col-lg-3">
                                <label>学生姓名</label>
                                <input class="form-control" type="text" name="insertName" placeholder="请输入学生姓名"
                                       required>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-3">
                                <label>性别</label>
                                <select class="form-control" name="insertSex" required>
                                    <option disabled selected>请选择性别</option>
                                    <option>男</option>
                                    <option>女</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="tile-footer">
                        <button class="btn btn-primary" type="submit">添加</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-primary" type="button" onclick="updateStudent('<%=basePath%>');">修改
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <form class="form-group col-md-12" action="<%=basePath%>admin/queryStudent.do">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-3">
                                <label>学生学号</label>
                                <input class="form-control" type="text" name="student_id" placeholder="请输入学号">
                            </div>
                            <div class="col-lg-3">
                                <label>学生姓名</label>
                                <input class="form-control" type="text" name="student_name" placeholder="请输入学生姓名">
                            </div>
                        </div>
                    </div>
                    <div class="tile-footer">
                        <button class="btn btn-primary" type="submit">查询</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <form class="tile" id="deleteStudentForm" method="post">
                <input type="hidden" id="studentId" name="studentId"/>
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="scoreTable">
                        <thead>
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>管理</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${studentlist}" var="student" varStatus="status">
                            <tr>
                                <td>${student.id}</td>
                                <td>${student.name}</td>
                                <td>${student.sex}</td>
                                <td>
                                    <a class="btn btn-danger"
                                       href="javascript:deleteStudent('<%=basePath%>', '${student.id}');">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </div>
</main>

<!-- Essential javascripts for application to work-->
<script src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>js/popper.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="<%=basePath%>js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<!-- Data table plugin-->
<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">$('#scoreTable').DataTable();</script>
<!-- Google analytics script-->
<script type="text/javascript">
    if (document.location.hostname == 'pratikborsadiya.in') {
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-72504830-1', 'auto');
        ga('send', 'pageview');
    }
</script>

<script type="text/javascript">

    function deleteStudent(basePath, studentId) {
        var id = document.getElementById("studentId");
        id.value = studentId;
        // alert(id.value);
        var deleteClubForm = document.getElementById("deleteStudentForm");
        deleteClubForm.setAttribute("action", basePath + "admin/deleteStudent.do");
        deleteClubForm.submit();
    }

    function updateStudent(basePath) {
        var updateStudentForm = document.getElementById("updateStudentForm");
        updateStudentForm.setAttribute("action", basePath + "admin/updateStudent.do")
        updateStudentForm.submit();
    }
</script>

</body>
</html>
