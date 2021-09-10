<%--
  Created by IntelliJ IDEA.
  User: LY
  Date: 2021/9/9
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/rotation2.css">
    <link rel="stylesheet" href="css/common.css">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <title>商品详情</title>
    <style>
        /* 去下划线 */
        a {
            text-decoration: none;
            /*链接去下划线*/
            color: #000000;
        }

        /* 整体布局 */
        .detailsWidth {
            width: 1200px;
            margin: 0px auto;
        }

        /* 头部 */
        .headerDetails {
            position: relative;
            width: 1200px;
            height: 100px;
            line-height: 80px;
            font-size: 12px;
        }

        /* 中部 */
        .divDetails {
            position: relative;
            width: 1200px;
            height: 700px;
        }

        /* 中部的上半部分 */
        .divDetailsUp {
            position: relative;
            height: 320px;
        }

        /* 上左 */
        .divU1 {
            position: relative;
            width: 450px;
            height: 320px;
            float: left;
        }

        /* 上中 */
        .divU2 {
            position: relative;
            width: 450px;
            height: 320px;
            float: left;
        }

        .divU2 p {
            height: 50px;
            line-height: 50px;
        }

        /* 上右 */
        .divU3 {
            position: relative;
            width: 300px;
            height: 320px;
            float: left;
            text-align: center;
        }

        .GM {
            font-size: 30px;
        }

        /* 中部的下半部分 */
        .divDetailsDown {
            position: relative;
            height: 600px;
        }

        /* 下左 */
        .divD1 {
            position: relative;
            width: 900px;
            height: 300px;
            float: left;
        }

        /* 下中 */
        .divD2 {
            position: relative;
            width: 400px;
            height: 400px;
            float: left;
            left:150px;
        }

        /* 下右 */
        .divD3 {
            position: relative;
            width: 300px;
            height: 300px;
            float: left;
        }

        /* 尾部 */
        .footerDetails {
            position: relative;
            width: 1200px;
            height: 150px;
            padding: 30px 0;
        }


        /* 字体样式 */
        /* 上左 */
        .fontSU1 {
            font: 16px "MiscroftYahei";
            color: #8d8d8d;
        }

        /* 上中 */
        .fontSU2 {
            font: 26px "MiscroftYahei";
            color: #e0832c;
        }

        /* 上右 */
        .fontSU3 {
            font: 10px "MiscroftYahei";
            color: #000000;
        }

        .fontSD1 {
            font: 15px "MiscroftYahei";
            color: #000000;
        }

        .fontSD2 {
            font: 700 30px "MiscroftYahei";
            text-indent: 0em;
            color: #000000;
        }

        .fontSD3 {
            font: 20px/50px "MiscroftYahei";
            text-indent: 1em;
            color: #000000;
        }
        .fontSD4 {
            font: 20px / 35px "MiscroftYahei";
            text-indent: 6em;
            color: #000000;
        }



        /* 图片样式 */
        .user-photoS-1 {
            width: 100px;
            height: 100px;
            margin-top: 15px;
            border-radius: 50%;
            /*圆形*/
        }

        .user-photoS-2 {
            width: 30px;
            height: 30px;
        }

        .user-photoS-3 {
            width: 100px;
            height: 100px;
        }

        .logoS {
            width: 50px;
            height: 50px;
        }

        .logoS-2 {
            width: 90px;
            height: 90px;
            border-radius: 50%;
        }

        .logoS-3 {
            width: 60px;
            height: 60px;
            border-radius: 50%;
        }

        .logoS-4 {
            position: absolute;
            width: 60px;
            height: 60px;
            display: none;
        }


        /* 按钮 */
        .buttonS2 {
            width: 100px;
            height: 30px;
            font-size: 10px;
            top: 0px;
        }
    </style>
</head>

<body>
<div id="header"></div>
<script>
    $("#header").load("header.jsp");
</script>



<!-- 网页主体 -->
<div class="detailsWidth divDetails">
    <!-- 上半部分 -->
    <div class="divDetailsUp">
        <!-- 上左 -->
        <div class="divU1">
<%--            <div id="picture">--%>
<%--                <div id="pRatation">--%>
<%--                    <img src="images/rotationA1.png" width="400px" height="300px" />--%>
<%--                </div>--%>
<%--            </div>--%>
    <div id="picture">
        <div id="pRatation">
            <img src="images/rotationA1.png" width="400px" height="300px" id="imageimage" />

        </div>

        <button class="left"><img src="images/切换器左.png" width="32" height="32"></button>
        <button class="right"><img src="images/切换器右.png" width="32" height="32"></button>
    </div>
        </div>
        <!-- 上中 -->
        <div class="divU2 fontSU1" id="fontS2-1">
            <!--                <p class="fontSU2">2680元/月</p>-->
            <!--                <p>租赁方式：合租</p>-->
            <!--                <p>房屋类型：3室1厅1卫 朝南 20平 精装修</p>-->
            <!--                <p>房屋类型：中层/25层</p>-->
            <!--                <p>所在小区：首科花园（D区）</p>-->
            <!--                <p>所属区域：丰台 六里桥距离地铁9号线六里桥东站1511米</p>-->
            <!--                <p>详细地址：西局东街</p>-->
        </div>
        <!-- 上右 -->
        <div class="divU3 fontSU3" fontS2-3 id="fontS2-3">
            <!--                <img src="images/user.png" class="user-photoS-1"><br />-->
            <!--                <p>XXXXXXX有限公司</p>-->
            <!--                <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">电话</button></p>-->
            <!--                <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">管理房屋</button></p>-->
            <!--                <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">企业信息及投诉记录</button></p>-->
        </div>
    </div>

    <!-- 联系客服分割线开始 -->
    <div class="kefu w">
    </div>
    <!-- 联系客服分割线结束 -->

    <!-- 下半部分 -->
    <div class="divDetailsDown">
        <!-- 下左 -->
        <div class="divD1 fontSD3" id="fontSD3">
            <!--                <li class="fontSD2">房源详情</li>-->
            <!--                <li>&nbsp;卧室设置&nbsp;&nbsp;<img src="images/logo-chuang.png" class="logoS"><img src="images/logo-kongtiao.png" class="logoS"><img-->
            <!--                        src="images/logo-yigui.png" class="logoS"><img src="images/logo-dianshi.png" class="logoS"><img src="images/logo-nuanqi.png" class="logoS"><img-->
            <!--                        src="images/logo-yangtai.png" class="logoS"><img src="images/logo-weishengjian.png" class="logoS"><img src="images/logo-zhinengmensuo.png"-->
            <!--                                                                                                                               class="logoS"><br /></li>-->

            <!--                <li>&nbsp;公共设施&nbsp;&nbsp;<img src="images/logo-bingxiang.png" class="logoS"><img src="images/logo-xiyiji.png" class="logoS"><img-->
            <!--                        src="images/logo-shafa.png" class="logoS"><img src="images/logo-youyanji.png" class="logoS"><img src="images/logo-kezuofan.png" class="logoS"><img-->
            <!--                        src="images/logo-kuandai.png" class="logoS"><img src="images/logo-reshuiqi.png" class="logoS"><img src="images/logo-ranqizao.png" class="logoS"><img-->
            <!--                        src="images/logo-dianti.png" class="logoS"></li>-->

            <!--                <li>&nbsp;出租要求&nbsp;&nbsp;&nbsp;租户稳定 作息正常 禁养宠物</li>-->

            <!--                <li>&nbsp;房源描述&nbsp;&nbsp;&nbsp;环境：小区环境优美，安静祥和</li>-->
            <!--                <li class="fontSD4">家配套：配备品牌家具家电、配套床垫、抱枕、台灯、壁灯、减轻疲劳桌椅、</li>-->
            <!--                <li class="fontSD4">衣柜、空调、洗衣机、冰箱和厨房，高速宽带</li>-->
            <!--                <li class="fontSD4">该房源真实，良心价格，可月付</li>-->
            <!--                <li class="fontSD4">室内配置：配备品牌家具家电、配套床垫、抱枕、台灯、桌椅、衣柜、空调、</li>-->
            <!--                <li class="fontSD4">洗衣机、冰箱和宽带</li>-->
            <!--                <li class="fontSD4">定期保洁阿姨上门清理卫生，拒绝脏乱差</li>-->
        </div>

        <!-- 下右 -->
        <div class="divD3 fontSD1" id="fontSD1">
            <!--                <p class="fontSD2">小区详情</p>-->
            <!--                <img src="images/user.png" class="user-photoS-3">-->
            <!--                <p>小区：林肯公园C区</p>-->
            <!--                <p>小区地址：西环北路</p>-->
            <!--                <a href="#">-->
            <!--                    <p>在租房源：111</p>-->
            <!--                </a>-->
            <!--                <p>建筑年代： 2008</p>-->
            <!--                <p>建筑类型： 高层</p>-->
            <!--                <p>物业公司： 北京晟邦物业管理有限公司</p>-->
            <!--                <p>物业费用： 3.60元/平米/月</p>-->
            <!--                <p>所属商圈： 大兴 / 亦庄</p>-->
        </div>
    </div>




</div>
<!-- 主体结束 -->

<div id="footer"></div>
<script>
    $("#footer").load("footer.jsp");
</script>
</body>

<script type="text/javascript">
    $(function () {
        var search=location.search;
        var houseid=search.split("=")[1];
        $.get("rentDetail",{houseId:houseid},function (housedetail) {

            var btn1 = document.querySelector('.left');
            var btn2 = document.querySelector('.right');
            var img = document.getElementById('imageimage')
            var imgs = (housedetail.house.houseImg).split(";");
            alert(imgs);
            var i = 0;
            if (i == 0) {
                btn1.className = 'leftnone';
            } else {
                btn1.className = 'left';
            };
            if (i == 3) {
                btn2.className = 'rightnone';
            } else {
                btn2.className = 'right';
            };
            btn1.onclick = function () {
                i--;
                img.src = imgs[i]
                if (i == 0) {
                    btn1.className = 'leftnone';
                } else {
                    btn1.className = 'left';
                };
                if (i == 3) {
                    btn2.className = 'rightnone';
                } else {
                    btn2.className = 'right';
                };

            }
            btn2.onclick = function () {
                i++
                img.src = imgs[i]
                if (i == 0) {
                    btn1.className = 'leftnone';
                } else {
                    btn1.className = 'left';
                };
                if (i == 3) {
                    btn2.className = 'rightnone';
                } else {
                    btn2.className = 'right';
                };

            }

            var lis2='<p class="fontS2-2" style="font-size: 30px; color: #f59a23;">'+housedetail.house.price+'元/月</p>\n' +
                '    <p>房屋类型：'+housedetail.house.type_bedroom+'室'+housedetail.house.type_livingroom+'厅'+housedetail.house.type_bathroom+'卫 '+housedetail.house.houseToward+' '+housedetail.house.area+'平 精装修</p>\n' +
                '    <p>房屋楼层：'+housedetail.house.floor+'层/'+housedetail.house.floor_sum+'层</p>\n' +
                '    <p>所在小区：'+housedetail.house.village+'</p>\n' +
                '    <p>所属区域：'+housedetail.house.city+' '+housedetail.house.district+'</p>\n' +
                '    <p>详细地址：'+housedetail.house.address+' </p>';
            $("#fontS2-1").html(lis2);

            // var lis3='<li class="fontSD2">房源详情</li> \n' +
            //     '            <li>&nbsp;房屋设置&nbsp;&nbsp;';
            //
            var roomfacility=housedetail.house.facilities;

            var roomfacilitieslist=roomfacility.split(";");

            var roomrequirement=housedetail.house.requirement;

            var roomrequirementlist=roomrequirement.split(";");
            //
            // for (var i=0;i<roomfacilitieslist.length;i++) {
            //     li=''+roomfacilitieslist[i]+';';
            //     lis3+=li;
            // }
            // lis3+='<br /></li>\n' +
            //     '            <li>&nbsp;出租要求&nbsp;&nbsp;&nbsp;';
            // for (var i=0;i<roomrequirementlist.length;i++) {
            //     li=''+roomrequirementlist[i]+' ';
            //     lis3+=li;
            // }
            // lis3+='</li>\n' +
            //     '            <li class="fontSD4">'+housedetail.house.description+'</li>';

            // <li class="fontSD2">房源详情</li>
            // <li>&nbsp;房屋设置&nbsp;&nbsp;1 2 3 4 5<br /></li>
            // <li>&nbsp;出租要求&nbsp;&nbsp;&nbsp;租户稳定 作息正常 禁养宠物</li>
            // <li>&nbsp;房源描述&nbsp;&nbsp;&nbsp;环境：小区环境优美，安静祥和</li>
            // <li class="fontSD4">家配套：配备品牌家具家电、配套床垫、抱枕、台灯、壁灯、减轻疲劳桌椅</li>


            var lis3=' <li class="fontSD2">房源详情</li>\n' +
                '                <li>&nbsp;房屋设置&nbsp;&nbsp;'+roomfacility+'<br /></li>\n' +
                '                <li>&nbsp;出租要求&nbsp;&nbsp;&nbsp;'+roomrequirement+'</li>\n' +
                '                <li>&nbsp;房源描述&nbsp;&nbsp;&nbsp;'+housedetail.house.description+'</li>';
            $("#fontSD3").html(lis3);

            var lis4='<p class="fontSD2">小区详情</p>\n' +
                    '                <p>小区：'+housedetail.house.village+'</p>\n' +
                '                <p>小区地址：'+housedetail.house.city+','+housedetail.house.district+','+housedetail.house.address+'</p>\n' +
                '                <p>在租房源：111</p>\n' +
                '                <p>建筑年代：2008</p>\n' +
                '                <p>建筑类型：高层</p>\n' +
                '                <p>物业费用：3.60元/平米/月</p>\n';
            $("#fontSD1").html(lis4);

            // var lis5='<a href="agent.jsp?managerid='+housedetail.manager.managerId+'">\n'
            //     '    <img src="'+housedetail.manager.managerIcon+'" class="user-photoS-1"><br />\n' +
            //     '    <p>XXXXXXX有限公司</p>\n' +
            //     '    <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">'+housedetail.manager.telephone+'</button></p>\n' +
            //     '    <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">'+housedetail.manager.name+'</button></p>\n' +
            //     '    <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">企业信息及投诉记录</button></p>\n' +
            //     '</a>';
            var lis5='<a href="agent.jsp?managerid='+housedetail.manager.managerId+'"> <img src="images/user.png" class="user-photoS-1"><br /> <p class="GM">管理员</p> <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">'+housedetail.manager.telephone+'</button></p> <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">'+housedetail.manager.name+'</button></p> <p><img src="images/user.png" class="user-photoS-2"> <button class="buttonS2">企业信息及投诉记录</button></p> </a>';
            $("#fontS2-3").html(lis5);

        });

    });
</script>
</html>
