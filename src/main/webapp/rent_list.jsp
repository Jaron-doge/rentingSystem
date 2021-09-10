<%--
  Created by IntelliJ IDEA.
  User: LY
  Date: 2021/9/7
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>\

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
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<body>

<div id="header"></div>
<script>
    $("#header").load("header.jsp");
</script>

<!-- 轮播图开始 -->
<div id="picture">
    <div id="pRatation">
        <img src="images/大+1.png" width="1200px" height="350px" />
        <img src="images/大+2.png" width="1200px" height="350px" />
        <img src="images/大+3.png" width="1200px" height="350px" />
        <img src="images/大+4.png" width="1200px" height="350px" />
    </div>
    <div id="numberD">
        <ul>
            <button class="buttonP" onclick="changeColor1A(this)" onmouseleave="changeColor1B(this)"></button>
            <button class="buttonP" onclick="changeColor2A(this)" onmouseleave="changeColor2B(this)"></button>
            <button class="buttonP" onclick="changeColor3A(this)" onmouseleave="changeColor3B(this)"></button>
            <button class="buttonP" onclick="changeColor4A(this)" onmouseleave="changeColor4B(this)"></button>
        </ul>
    </div>
</div>
<script type="text/javascript">
    var pictureRotation = document.getElementById("pRatation");
    var numberColor = document.getElementsByClassName("buttonP");
    console.log(numberColor);
    var i = 0;
    auto();
    numberColor[0].style.backgroundColor = "#969393";
    function auto() {
        time = setInterval(function () {
            i++;
            if (i <= 3) {
                pictureRotation.style.left = pictureRotation.offsetLeft - 1200 + "px";
                numberColor[i].style.backgroundColor = "#969393";
                numberColor[i - 1].style.backgroundColor = "#e7dcdc";
            }
            else {
                pictureRotation.style.left = "0px";
                numberColor[3].style.backgroundColor = "#e7dcdc";
                numberColor[0].style.backgroundColor = "#969393";
                i = 0;
            }
            console.log(i);
        }, 5000)
    }
    function changeColor1A(obj) {
        pictureRotation.style.left = "0px";
        numberColor[0].style.backgroundColor = "#969393";
        numberColor[1].style.backgroundColor = "#e7dcdc";
        numberColor[2].style.backgroundColor = "#e7dcdc";
        numberColor[3].style.backgroundColor = "#e7dcdc";
    }
    function changeColor1B(obj) {
        numberColor[0].style.backgroundColor = "#e7dcdc";
    }
    function changeColor2A(obj) {
        pictureRotation.style.left = "-1200px";
        numberColor[1].style.backgroundColor = "#969393";
        numberColor[0].style.backgroundColor = "#e7dcdc";
        numberColor[2].style.backgroundColor = "#e7dcdc";
        numberColor[3].style.backgroundColor = "#e7dcdc";
    }
    function changeColor2B(obj) {
        numberColor[1].style.backgroundColor = "#e7dcdc";
    }
    function changeColor3A(obj) {
        pictureRotation.style.left = "-2400px";
        numberColor[2].style.backgroundColor = "#969393";
        numberColor[0].style.backgroundColor = "#e7dcdc";
        numberColor[1].style.backgroundColor = "#e7dcdc";
        numberColor[3].style.backgroundColor = "#e7dcdc";
    }
    function changeColor3B(obj) {
        numberColor[2].style.backgroundColor = "#e7dcdc";
    }
    function changeColor4A(obj) {
        pictureRotation.style.left = "-3600px";
        numberColor[3].style.backgroundColor = "#969393";
        numberColor[0].style.backgroundColor = "#e7dcdc";
        numberColor[1].style.backgroundColor = "#e7dcdc";
        numberColor[2].style.backgroundColor = "#e7dcdc";
    }
    function changeColor4B(obj) {
        numberColor[3].style.backgroundColor = "#e7dcdc";

    }
</script>
<!-- 轮播图结束 -->


<!-- 范围选择开始 -->
<div class="area w" style="margin-top: 25px">
    <ul>
        <li id="city_item"></li>
        <li id="price_item"></li>
        <li id="type_bedroom_item"></li>
        <li id="houseToward_item"></li>
    </ul>
</div>
<!-- 范围选择结束 -->

<!-- 联系客服分割线开始 -->
<div class="kefu w" style="height: 30px">
</div>
<!-- 联系客服分割线结束 -->

<!-- 房源开始 -->
<div class="house w" style="height: 1480px">
    <!-- 左侧列开始 -->
    <div class="houseleft">
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
            最新房源
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
        var ccity=["不限","朝阳","海淀","昌平","丰台","大兴"];
        var cprice=["不限","600-1000","1000-1500","1500-2000","2000-3000","3000-5000"];
        var ctype_bedroom=["不限","一室","两室","三室","三室以上"];
        var chouseToward=["不限","东","南","西","北","东南","东北","西南","西北"];

        var lis1 = '<span>区域：</span>';

        //遍历数组,拼接字符串
        for (var i = 0; i < ccity.length; i++) {
            var li = '<span><a href="rent_list.jsp?ccity='+ccity[i]+'">'+ccity[i]+'</a></span>';
            lis1 += li;
        }
        $("#city_item").html(lis1);

        var lis2 = '<span>租金：</span><span><a href="rent_list.jsp?cprice=不限">不限</a></span>';
        //遍历数组,拼接字符串
        for (var i = 1; i < cprice.length; i++) {
            var li = '<span><a href="rent_list.jsp?cprice='+cprice[i]+'">'+cprice[i]+'元</a></span>';
            lis2 += li;
        }
        $("#price_item").html(lis2);

        var lis3 = '<span>厅室：</span>';
        //遍历数组,拼接字符串
        for (var i = 0; i < ctype_bedroom.length; i++) {
            var li = '<span><a href="rent_list.jsp?ctype_bedroom='+ctype_bedroom[i]+'">'+ctype_bedroom[i]+'</a></span>';
            lis3 += li;
        }
        $("#type_bedroom_item").html(lis3);

        var lis4 = '<span>朝向：</span>';
        //遍历数组,拼接字符串
        for (var i = 0; i < chouseToward.length; i++) {
            var li = '<span><a href="rent_list.jsp?chouseToward='+chouseToward[i]+'">'+chouseToward[i]+'</a></span>';
            lis4 += li;
        }
        $("#houseToward_item").html(lis4);
        load();

    });

    function load(currentPage) {
        var search=location.search;
        //alert(search);
        var ccategory=search.substring(search.indexOf("?")+1);
        var ccategory_choice=ccategory.split("=");
        //alert(ccategory_choice[0]);  //ccity
        var ccategory_name=ccategory_choice[0];
        var ccategory_content=decodeURIComponent(ccategory_choice[1]);

        $.get("rent",{category_name:ccategory_name,category_content:ccategory_content,currentPage:currentPage},function (pb) {
            var lis="";
            var firstPage='<li onclick="javascript:load(1)"><a href="javascript:void(0)">首页</a></li>';
            var beforeNum=pb.currentPage-1;
            if(beforeNum<=0){
                beforeNum=1;
            }
            var beforePage='<li onclick="javascript:load('+beforeNum+')"><a href="javascript:void(0)">上一页</a></li>';
            lis+=firstPage;
            lis+=beforePage;
            for(var i=1;i<=pb.totalPage;i++){
                var li='<li onclick="javascript:load('+i+')"><a href="javascript:void(0)">'+i+'</a></li>';
                lis+=li;
            }
            var nextNum=pb.currentPage+1;
            if(nextNum>pb.totalPage){
                nextNum=pb.totalPage;
            }
            var nextPage='<li onclick="javascript:load('+nextNum+')"><a href="javascript:void(0)">下一页</a></li>';
            var lastPage='<li onclick="javascript:load('+pb.totalPage+')"><a href="javascript:void(0)">尾页</a></li>';
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
            var right_rent_lis="";
            for (var i=0;i<pb.list2.length;i++) {
                var rent = pb.list2[i];

                var li = ' <a href="house_detail.jsp?houseid=' + rent.houseId + '">\n' +
                    '                    <li>\n' +
                    '                    <img width="300" height="170" src="' + rent.houseImg + '" >\n' +
                    '                    <dl>\n' +
                    '                    <dt class="retuidetail">'+rent.city+' '+rent.district+' '+rent.village+'</dt>\n' +
                    '                    <dt class="retuidetail">'+rent.type_bedroom+'室 '+rent.area+'平</dt>\n' +
                    '                <dt class="retuiprice">'+rent.price+'元/月</dt>\n' +
                    '                </dl>\n' +
                    '                </li>\n' +
                    '       </a>';

                right_rent_lis+= li;
            }
            $("#retuiinfo").html(right_rent_lis);
        });
    }
</script>

</html>