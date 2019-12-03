<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/18
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  //获取web应用根目录路径
%>
<html>
<head>
    <title>${club.name}-详情</title>
    <link rel="stylesheet" href="<%=basePath%>css/club.css" type="text/css">
</head>
<body>
<div class="body">
    <jsp:include page="header.jsp"/>

    <div class="content_wrap">
        <div class="content">
            <div class="clubs_h">
                <div class="decoration_block"></div>
                <div class="decoration_note">社团名称</div>
            </div>
            <div id="club_name">${club.name}</div>
            <div class="clubs_h">
                <div class="decoration_block"></div>
                <div class="decoration_note">社团简介</div>
            </div>
            <div id="club_about">${club.description}
            </div>
            <div class="clubs_h">
                <div class="decoration_block"></div>
                <div class="decoration_note">可选课程</div>
            </div>
            <div class="club_course">
                <ul name="course_list">
                    <c:forEach var="unselectedCourse" items="${unselectedCourseList}" varStatus="status">
                        <li class="course_item">
                            <div class="course">
                                <a href="#">
                                    <div class="course_name">
                                            ${unselectedCourse.course_name}
                                    </div>
                                </a>
                                <a href="<%=basePath%>student/studentCourseServlet.do?option=select&courseId=${unselectedCourse.course_id}&clubId=${club.id}">
                                    <div class="select_button">选择</div>
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div id="clubs_h">
                <div class="decoration_block"></div>
                <div class="decoration_note">已选课程</div>
            </div>
            <div id="club_course">
                <ul id="course_list">
                    <c:forEach var="selectedCourse" items="${selectedCourseList}" varStatus="status">
                        <li class="course_item">
                            <div class="course">
                                <a href="#">
                                    <div class="course_name">
                                            ${selectedCourse.course_name}
                                    </div>
                                </a>
                                <a href="<%=basePath%>student/studentCourseServlet.do?option=delete&courseId=${selectedCourse.course_id}&clubId=${club.id}">
                                    <div class="select_button">删除</div>
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
