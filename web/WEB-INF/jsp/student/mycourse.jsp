<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/19
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  //获取web应用根目录路径
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=basePath%>css/club.css" type="text/css">
    <title>我的课程</title>
</head>
<body>
<div class="body">
    <jsp:include page="../../../jsp/header.jsp"/>
    <div class="content">
        <div id="clubs_h">
            <div class="decoration_block"></div>
            <div class="decoration_note">${term}学期</div>
        </div>
        <div id="club_course">
            <ul id="course_list">
                <c:forEach var="course" items="${courselist}" varStatus="status">
                    <li class="course_item">
                        <div class="course">
                            <a href="#">
                                <div class="course_name">
                                        ${course.course_name}&nbsp|&nbsp${course.term}
                                </div>
                            </a>
                            <a href="<%=basePath%>student/myCourse.do?option=delete&courseId=${course.course_id}">
                                <div class="select_button">删除</div>
                            </a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>