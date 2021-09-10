<%--
  Created by IntelliJ IDEA.
  User: LY
  Date: 2021/9/10
  Time: 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String searchContent=request.getParameter("searchContent");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>租房系统首页</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/rotation.css">
    <link rel="stylesheet" href="css/common.css">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>


<body>

<div id="header"></div>
<script>
    $("#header").load("header.jsp");
</script>


<!-- 联系客服分割线开始 -->
<div class="kefu w" style="height: 30px">
</div>
<!-- 联系客服分割线结束 -->

<!-- 房源开始 -->
<div class="house w" style="height: 1400px">
    <!-- 左侧列开始 -->
    <div class="houseleft">
        <div class="reco">
            <ul>
                <li><a href="#">推荐房源</a></li>
                <li><a href="#">最新房源</a></li>
            </ul>
        </div>
        <div class="detailinfo">
            <ul id="rent">
            </ul>
            <!--                <a href="product-details.jsp?houseid=' + rent.houseId + '">-->
            <!--                    <li>-->
            <!--                        <img src="images/小1.png">-->
            <!--                        <dl>-->
            <!--                            <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>-->
            <!--                            <dt>2室 54平方米</dt>-->
            <!--                            <dt>金桥路 海洋石油天野小区</dt>-->
            <!--                            <dt>来自经纪人：七点房产 海琳</dt>-->
            <!--                        </dl>-->
            <!--                        <span>3600元/月</span>-->
            <!--                    </li>-->
            <!--                </a>-->
        </div>

        <!-- 尾部页码开始 -->
        <div class="page">
            <ul id="pageNum"></ul>
        </div>
        <!-- 尾部页码结束 -->

    </div>
    <!-- 左侧列结束 -->
    <!-- 右侧列开始 -->
    <div class="houseright">
        <div class="retui">
            热推房源
        </div>
        <div class="retuiinfo">
            <ul id="retuiinfo">
            </ul>
            <!--                <a href="product-details.jsp?houseid=' + rent.houseId + '">-->
            <!--                    <li>-->
            <!--                        <img src="images/大2.png">-->
            <!--                        <dl>-->
            <!--                            <dt class="retuidetail">金桥开发区/金桥路/金桥开发区/金桥路</dt>-->
            <!--                            <dt class="retuidetail">3室 136.5平</dt>-->
            <!--                            <dt class="retuiprice">3000元/月</dt>-->
            <!--                        </dl>-->
            <!--                    </li>-->
            <!--                </a>-->
        </div>
    </div>
    <!-- 右侧列结束 -->

</div>
<!-- 房源结束 -->

<div id="footer"></div>
<script>
    $("#footer").load("footer.jsp");
</script>


<!-- 固定定位开始 -->
<!-- 固定定位结束 -->

</body>

<script>
    $(function () {
        var search=location.search;
        var searchContent=search.split("=")[1];
        load(searchContent,1);
    });

    function load(searchContent,currentPage) {
        var search=location.search;
        var searchContent=decodeURIComponent(search.split("=")[1]);
        $.get("search",{searchContent:searchContent,currentPage:currentPage},function (pb) {
            var lis="";
            var firstPage='<li onclick="javascript:load('+searchContent+',1)"><a href="javascript:void(0)">首页</a></li>';
            var beforeNum=pb.currentPage-1;
            if(beforeNum<=0){
                beforeNum=1;
            }
            var beforePage='<li onclick="javascript:load('+searchContent+','+beforeNum+')"><a href="javascript:void(0)">上一页</a></li>';
            lis+=firstPage;
            lis+=beforePage;
            for(var i=1;i<=pb.totalPage;i++){
                var li='<li onclick="javascript:load('+searchContent+','+i+')"><a href="javascript:void(0)">'+i+'</a></li>';
                lis+=li;
            }
            var nextNum=pb.currentPage+1;
            if(nextNum>pb.totalPage){
                nextNum=pb.totalPage;
            }
            var nextPage='<li onclick="javascript:load('+searchContent+','+nextNum+')"><a href="javascript:void(0)">下一页</a></li>';
            var lastPage='<li onclick="javascript:load('+searchContent+','+pb.totalPage+')"><a href="javascript:void(0)">尾页</a></li>';
            lis+=nextPage;
            lis+=lastPage;
            $("#pageNum").html(lis);

            var rent_lis="";
            for (var i=0;i<pb.list.length;i++) {
                var rent = pb.list[i];
                var li = '<a href="house_detail.jsp?houseid=' + rent.houseId + '">\n' +
                    '                    <li>\n' +
                    '                        <img widtg="160" height="120" src="' + rent.houseImg + '" >\n' +
                    '                        <dl>\n' +
                    '                            <dt class="title">'+rent.village+' '+rent.city+' '+rent.district+' | '+rent.type_bedroom+'室 '+rent.area+'</dt>\n' +
                    '                            <dt>'+rent.floor+'楼 / '+rent.floor_sum+'层</dt>\n' +
                    '                            <dt>'+rent.type_bedroom+'室 '+rent.type_livingroom+'厅 '+rent.type_bathroom+'卫</dt>\n' +
                    '                            <dt>'+rent.district+' '+rent.village+' '+rent.address+'</dt>\n' +
                    '                        </dl>\n' +
                    '                        <span>'+rent.price+'元/月</span>\n' +
                    '                    </li>\n' +
                    '                </a>';
                rent_lis += li;
            }
            $("#rent").html(rent_lis);

        });
    }
</script>

</html>
