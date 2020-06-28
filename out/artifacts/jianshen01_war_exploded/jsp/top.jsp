<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="about-top">
    <!--    导航logo部分-->
    <div class="about-top-background">
        <div class="about-nav">
            <!--      导航图片logo-->
            <div class="about-logo-img"><img src="${companyModel.logo}" height="59.05" width="95"/></div>
            <div class="about-zi">
                <!-- 中文名称-->
                <div class="about-zi-cn">某某健身</div>
                <!-- 英文名称-->
                <div class="about-zi-en">FITNESS</div>
            </div>
            <div class="about-nav-parts">
                <c:forEach items="${homeDto.navModelList}" var="nav">
                    <a href="${nav.href}"><div>${nav.name}</div></a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>