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
            <span><img src="${about.logo}" height="19" width="15"/></span>
            <span>网站首页 > ></span>
            <span>关于我们</span>
        </div>
        <hr/>
    </div>
    <!--图片01-->
    <div class="about-img">
        <img src="../img/SLMF-Portada-BBD.jpg"/>
    </div>
    <div class="about-content01">${about.content1}</div>
    <div class="about-content02">${about.content2}</div>
    <hr/>
    <div class="about-exs">
        <div class="about-exs1">
            <div><img src="../img/86co.jpg" height="129" width="450"/></div>
            <div>
                <div class="about-exs-date1">2008年12月10日</div>
                <div class="about-exs-content1">任务创建更多的乐趣，自由和满足人们的生活，通过合并的生活经历，金融机会，公司成立</div>
            </div>
        </div>
        <div class="about-exs2">
            <div><img src="../img/6gl4.jpg" height="129" width="450"/></div>
            <div>
                <div class="about-exs-date2" align="right">2012年3月17日</div>
                <div class="about-exs-content2" align="right">建立世界上较好的度假和娱乐俱乐部。丰富的生活通过特殊的和负担得起的全球，地方和日常经验</div>
            </div>
        </div>
        <div class="about-exs1">
            <div><img src="../img/wx3z.jpg" height="129" width="450"/></div>
            <div>
                <div class="about-exs-date1">2016年10月10日</div>
                <div class="about-exs-content1">迈克,成功已经严重影响他的家庭生活,工作时间长、长英里,奴性的承诺下一个新的商业交易已经成为他的职业和个人生活之间的楔形。</div>
            </div>
        </div>
    </div>
</div>
<!--学员风采-->
<div class="students">
    <div class="about-stu-title">
        <div class="about-stu-title-cn">学员风采</div>
        <div class="about-stu-title-en">STUDENT SHOW</div>
    </div>
    <div class="students-pages01">
        <c:forEach items="${studentList}" var="stu" end="4">
            <span><img src="${stu.img}" height="178" width="230"/></span>
        </c:forEach>
    </div>
    <div class="students-pages02">
        <c:forEach items="${studentList}" var="stu" begin="5" end="7">
            <span><img src="${stu.img}" height="178" width="230"/></span>
        </c:forEach>
    </div>
    <div class="students-pages03">
        <c:forEach items="${studentList}" var="stu" begin="8" end="8">
            <span><img src="${stu.img}" height="178" width="230"/></span>
        </c:forEach>
    </div>
    <input type="submit" value="立即预约" name="submit">
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>
