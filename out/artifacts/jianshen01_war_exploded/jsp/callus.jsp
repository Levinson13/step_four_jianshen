<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/3
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>联系我们</title>
    <link rel="stylesheet" href="../css/callus.css">
    <link rel="stylesheet" href="../css/common.css">
    <script src="../js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=2Y3jMSe6V5fRncmM1YeX3imkEiiPXQRa"></script>
</head>
<body>
<jsp:include page="top.jsp"/>
<!--    小导航栏-->
<div class="dh">
    <div>
        <span><img src="../img/p7up.png" height="19" width="15"/></span>
        <span>网站首页 > ></span>
        <span>联系我们</span>
    </div>
    <hr/>
</div>
<div class="ditu">
    <div id="ditu"></div>
    <div class="tubiao">

        <div>
            <c:forEach items="${callUsList}" var="callus" end="1">
                <div>
                    <div><img src="${callus.img}" height="60" width="60"/></div>
                    <div>${callus.content}</div>
                </div>
            </c:forEach>
        </div>
        <div>
            <c:forEach items="${callUsList}" var="callus" begin="2" end="3">
                <div>
                    <div><img src="${callus.img}" height="60" width="60"/></div>
                    <div>${callus.content}</div>
                </div>
            </c:forEach>
        </div>
        <div>
            <c:forEach items="${callUsList}" var="callus" begin="4" end="5">
                <div>
                    <div><img src="${callus.img}" height="60" width="60"/></div>
                    <div>${callus.content}</div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
<script>
    $(function () {
        $("#topHtml").load("top.html");
        $("#footHtml").load("foot.html");
        // 百度地图API功能
        var map = new BMap.Map("ditu");    // 创建Map实例
        map.centerAndZoom(new BMap.Point(104.066421,30.579585), 11);  // 初始化地图,设置中心点坐标和地图级别
        //添加地图类型控件
        map.addControl(new BMap.MapTypeControl({
            mapTypes:[
                BMAP_NORMAL_MAP,
                BMAP_HYBRID_MAP
            ]}));
        map.setCurrentCity("成都");          // 设置地图显示的城市 此项是必须设置的
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    })
</script>
</html>
