<%--
  Created by IntelliJ IDEA.
  User: LY
  Date: 2021/9/8
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>经纪人管理房屋</title>
    <link rel="stylesheet" href="css/selectPage.css">
    <link rel="stylesheet" href="css/agent.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/base.css">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>
<%
    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
    Object user= session.getAttribute("user");
%>

<body>
<header class="nav w">
    <div class="fl">
        <ul>
            <li class="logo">Logo</li>
        </ul>
    </div>
    <div class="fr">
        <ul>
            <c:if test="${empty user}">
                <li class="login"><a><img src="images/登陆.png">登录</a></li>
                <li class="register"><a><img src="images/注册%20(选中).png">注册</a></li>
            </c:if>
            <c:if test="${not empty user}">
                <li class="login"><a><img src="images/登陆.png">个人中心</a></li>
                <li class="register"><img src="images/退出.png">退出</li>
            </c:if>
        </ul>
    </div>
</header>

<div class="detailsWidth divMainU" id="managerDetail">
<%--    <div class="divMainUL">--%>
<%--        <img src="images/user.png" class="photoAgent">--%>
<%--    </div>--%>
<%--    <div class="divMainUR">--%>
<%--        <ul>--%>
<%--            <li>XXXXXXX有限公司</li>--%>
<%--            <li><label>电话</label></li>--%>
<%--            <li><label>被投诉：0次</label></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
</div>

<div class="detailsWidth selectPage">
    <nav>
        <a href="javascript:;" data-cont="button1" class="buttonClick">当前在租贴</a>
        <a href="javascript:;" data-cont="button2">近期平台投诉记录</a>
        <a href="javascript:;" data-cont="button3">监管部门处罚记录</a>
    </nav>

    <section class="cout detailinfo" id="button1">
            <div class="detailinfo">
                <ul id="houseDetail">
<%--                                <li>--%>
<%--                                    <img src="images/houseA1.png">--%>
<%--                                    <dl>--%>
<%--                                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>--%>
<%--                                        <dt>2室 54平方米</dt>--%>
<%--                                        <dt>金桥路 海洋石油天野小区</dt>--%>
<%--                                        <dt>来自经纪人：七点房产 海琳</dt>--%>
<%--                                    </dl>--%>
<%--                                    <span>3600元/月</span>--%>
<%--                                </li>--%>
                </ul>
            </div>

            <!-- 尾部页码开始 -->
            <div class="page">
                <ul id="pageNum"></ul>
            </div>
            <!-- 尾部页码结束 -->
    </section>

    <section class="cout" id="button2">
        <ul>
            <li class="pageFont2">暂无投诉记录</li>
        </ul>
    </section>
    <section class="cout" id="button3">
        <table class="tableFont">
            <thead>
            <tr>
                <th>决定日期</th>
                <th>经纪机构</th>
                <th>处理/处罚事由</th>
                <th>处理/处罚结果</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>暂无投诉记录</td>
            </tr>
            </tbody>
        </table>
    </section>
</div>


<div id="footer"></div>
<script>
    $("#footer").load("footer.jsp");
</script>

</body>
<script>
    var navs = document.querySelectorAll(".selectPage nav a");
    document.getElementById("button1").style.display = "block";//显示第一个选择标签
    document.getElementById("button2").style.display = "none";//不显示二、三标签
    document.getElementById("button3").style.display = "none";
    for (var i = 0; i < navs.length; i++) {
        navs[i].onclick = function () {
            var beforeNav = document.querySelector(".buttonClick")
            var beforeId = beforeNav.dataset["cont"];
            document.querySelector("#" + beforeId).style.display = "none";
            for (var j = 0; j < navs.length; j++) {
                navs[j].classList.remove("buttonClick");
            }
            this.classList.add("buttonClick");
            var secId = this.dataset["cont"];
            document.querySelector("#" + secId).style.display = "block";
        }
    }

    $(function () {
        var search=location.search;
        var managerid=search.split("=")[1];
        //加载经理信息
        load(managerid);
        //加载租房管理信息
        load_list(managerid,1);
    });

    function load(managerid) {
        $.get("manager", {managerId: managerid}, function (manager) {
            var lis = '<div class="divMainUL">\n' +
                '        <img src="images/user.png" class="photoAgent">\n' +
                '    </div>\n' +
                '    <div class="divMainUR">\n' +
                '        <ul>\n' +
                '            <li>管理员</li>\n' +
                '            <li><label>' + manager.telephone + '</label></li>\n' +
                '            <li><label>' + manager.name + '</label></li>\n' +
                '            <li><label>被投诉：0次</label></li>\n' +
                '        </ul>\n' +
                '    </div>';
            $("#managerDetail").html(lis);

        });
    }

        function load_list(managerid, currentPage) {
            $.get("managerDetail", {managerId: managerid, currentPage: currentPage}, function (mb) {
                var rent_lis = "";
                for (var i = 0; i < mb.list.length; i++) {
                    var rent = mb.list[i];
                    var li = '<a href="house_detail.jsp?houseid='+rent.houseId+'">\n' +
                        '                    <li>\n' +
                        '                        <img widtg="160" height="120" src="' + rent.houseImg + '" >\n' +
                        '                        <dl>\n' +
                        '                            <dt class="title">' + rent.village + ' ' + rent.city + ' ' + rent.district + ' | ' + rent.type_bedroom + '室 ' + rent.area + '</dt>\n' +
                        '                            <dt>' + rent.floor + '楼 / ' + rent.floor_sum + '层</dt>\n' +
                        '                            <dt>' + rent.type_bedroom + '室 ' + rent.type_livingroom + '厅 ' + rent.type_bathroom + '卫</dt>\n' +
                        '                            <dt>' + rent.district + ' ' + rent.village + ' ' + rent.address + '</dt>\n' +
                        '                        </dl>\n' +
                        '                        <span>' + rent.price + '元/月</span>\n' +
                        '                    </li>\n' +
                        '                </a>';
                    rent_lis += li;
                }
                $("#houseDetail").html(rent_lis);

            });
        }
</script>
</html>