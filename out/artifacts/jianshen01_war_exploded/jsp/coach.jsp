<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>私教预约</title>
    <link rel="stylesheet" href="../css/coach.css">
    <link rel="stylesheet" href="../css/common.css">
</head>
<body>
<jsp:include page="top.jsp"/>
<!--    小导航栏-->
<div class="dh">
    <div>
        <span><img src="../img/p7up.png" height="19" width="15"/></span>
        <span>网站首页 > ></span>
        <span>私人教练</span>
    </div>
    <hr/>
</div>
<div class="coach">
    <div align="center">
        <div>私人教练</div>
        <div>OUR TEAM</div>
    </div>
    <div class="images">
        <c:forEach items="${coachDto.coachModelList}" var="coach">
            <div>
                <div><img src="${coach.coachModel.coachImg}" height="291" width="317"/></div>
                <div class="coach-num-name">${coach.coachModel.coachName}</div>
                <c:forEach items="${coachDto.coachPostModelList}" var="post">
                    <c:if test="${coach.coachModel.coachPost == post.id}">
                        <div class="coach-num-post">${post.post}</div>
                    </c:if>
                </c:forEach>

            </div>
        </c:forEach>
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
                <div >
                    <input class="info-table-submit" type="submit" name="submit" value="提交">
                </div>
                <div class="info-table-thanks">THANKS</div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>
