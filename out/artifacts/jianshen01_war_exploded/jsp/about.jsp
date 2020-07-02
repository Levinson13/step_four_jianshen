<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/3
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>关于我们</title>
    <link rel="stylesheet" href="../css/about.css">
</head>
<body>
<jsp:include page="top.jsp"/>
<!--关于我们-->
<div class="about">
    <!--    小导航栏-->
    <div class="about-dh">
        <div>
            <span><img src="" height="19" width="15"/></span>
            <span>网站首页 > ></span>
            <span>关于我们</span>
        </div>
        <hr/>
    </div>
    <!--图片01-->
    <div class="about-img">
        <img src="${aboutDto.aboutModelList[0].img}"/>
    </div>
    <div class="about-content01">${aboutDto.aboutModelList[0].content}</div>
    <div class="about-content02">${aboutDto.aboutModelList[1].content}</div>
    <hr/>
    <div class="about-exs">
        <c:forEach items="${aboutDto.aboutModelList}" var="about" varStatus="idx">
            <c:if test="${idx.count % 2 == 0}">
                <div class="about-exs1">
                    <div><img src="${about.img}" height="129" width="450"/></div>
                    <div>
                        <div class="about-exs-date1">${about.createTime}</div>
                        <div class="about-exs-content1">${about.content}</div>
                    </div>
                </div>
            </c:if>
            <c:if test="${idx.count % 2 != 0}">
                <div class="about-exs2">
                    <div><img src="${about.img}" height="129" width="450"/></div>
                    <div>
                        <div class="about-exs-date2">${about.createTime}</div>
                        <div class="about-exs-content2">${about.content}</div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<!--学员风采-->
<div class="students">
    <div class="about-stu-title">
        <div class="about-stu-title-cn">学员风采</div>
        <div class="about-stu-title-en">STUDENT SHOW</div>
    </div>
    <div class="students-pages01">
        <c:forEach items="${aboutDto.studentModelList}" var="stu" end="4">
            <span><img src="${stu.stuImg}" height="178" width="230"/></span>
        </c:forEach>
    </div>
    <div class="students-pages02">
        <c:forEach items="${aboutDto.studentModelList}" var="stu" begin="5" end="7">
            <span><img src="${stu.stuImg}" height="178" width="230"/></span>
        </c:forEach>
    </div>
    <div class="students-pages03">
        <c:forEach items="${aboutDto.studentModelList}" var="stu" begin="8" end="8">
            <span><img src="${stu.stuImg}" height="178" width="230"/></span>
        </c:forEach>
    </div>
    <input type="submit" value="立即预约" name="submit">
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>
