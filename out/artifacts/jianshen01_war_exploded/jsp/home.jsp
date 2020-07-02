<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>网站首页</title>
    <link rel="stylesheet" href="../css/home.css">
    <link rel="stylesheet" href="../css/common.css">
</head>
<body>
<!--    首页导航-->
<jsp:include page="top.jsp"/>
<div class="interval-01"></div>
<!--    关于我们-->
<div class="about">
    <div class="about-text">
        <div class="about-text-cn">关于我们</div>
        <div class="about-text-en">ABOUT US</div>
        <div class="about-text-content">${homeDto.aboutModelList[0]}</div>
    </div>
</div>
<!--    首页公司介绍-->
<div class="company">
    <div class="company-parts">
        <div class="company-content"><${homeDto.aboutModelList[1]}></div>
        <!--        <div class="company-fh">＋</div>-->
    </div>
</div>
<!--    私人教练-->
<div class="coach">
    <div class="coach-part1">
        <div class="coach-title">
            <div align="center" class="coach-zi-cn">私人教练</div>
            <div align="center" class="coach-zi-en">OUR TEAM</div>
        </div>
        <div class="coach-nums">
            <c:forEach items="${homeDto.coachModelList}" var="coach" end="2">
                <div class="coach-num1" align="center">
                    <div><img src="${coach.coachModel.coachImg}" height="291" width="317"/></div>
                    <div class="coach-num-name">${coach.coachModel.coachName}</div>
                    <div class="coach-num-post">${coach.post}</div>
                </div>
            </c:forEach>
        </div>
        <div class="coach-more" align="center">MORE+</div>
    </div>
    <div class="coach-part2">
        <div class="coach-part2-content">
            <div class="coach-part2-content1">
                与其计划明天 不如从今天开始
            </div>
            <div class="coach-part2-content2">
                It is better to start today than to plan tomorrow
            </div>
        </div>
        <div class="coach-more1" align="center">MORE+</div>
    </div>
</div>
<!--    新闻资讯-->
<div class="news">
    <div class="news-title" align="center">
        <div class="news-title-cn">新闻资讯</div>
        <div class="news-title-en">NEWS</div>
    </div>
    <div class="news-contents" align="center">
        <div class="news-fresh-contents">
            <c:forEach items="${homeDto.newsModelList}" var="news" end="2">
                <div>
                    <div><img src="${news.newsModel.newsImg}" height="291" width="317"/></div>
                    <div class="news-contents-title dhyc">${news.type}</div>
                    <div class="news-contents-date">${news.newsModel.createDate} </div>
                    <div class="news-contents-content dhyc1">${news.newsModel.newsContent}</div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="news-more" align="center">
        <div>MORE+</div>
    </div>
</div>
<!--    表格填写-->
<div class="info">
    <div class="info-img01">
        <div class="info-img02"><img src="../img/acfa5605108c3150158055c03e58b035.png" height="455" width="562"/></div>
        <div class="info-table">
            <div class="info-table-01">填表格可在私教带领下免费体验一次!</div>
            <div class="info-table-02">请仔细填写好下方预约表格，我们的客服人员会在24小时内与您联系，谢谢您的支持与关注!</div>
            <div class="info-table-input">
                <div>
                    <div>姓名</div>
                    <input class="info-table-name" name="name" type="text">
                </div>
                <div>
                    <div>电话</div>
                    <input class="info-table-phone" name="phone" type="text">
                </div>
                <div>
                    <div>邮箱</div>
                    <input class="info-table-email" name="email" type="text">
                </div>
                <div>
                    <div>内容</div>
                    <input class="info-table-content" name="content" type="text">
                </div>
            </div>
            <div>
                <input class="info-table-submit" type="submit" name="submit" value="提交">
            </div>
            <div class="info-table-thanks">THANKS</div>
        </div>
    </div>
</div>
<!--    页脚-->
<jsp:include page="foot.jsp"/>
</body>
</html>