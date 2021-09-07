<%--
  Created by IntelliJ IDEA.
  User: 29193
  Date: 2021/9/7
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <base href="<%=basePath %>"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>发布租房</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/house_releasing.css">
</head>

<body>
<header class="nav w">
    <div class="fl">
        <ul>
            <li class="logo">Logo</li>
            <!-- <li class="cc">选择城市</li> -->
            <!-- <li class="province"><a href="#">省份</a></li>
            <li class="city"><a href="#">城市</a></li> -->
            <div class="search">
                <input type="search" name="" placeholder="请输入搜索内容">
                <img src="images/搜索 (1).png"></img>
            </div>
        </ul>
    </div>
    <div class="fr">
        <ul>
            <li class="release"><a>发布租房</a></li>
            <li class="login">
                <a><img src="images/登录.png">登录</a>
            </li>
            <li class="register">
                <a><img src="images/注册 (选中).png">注册</a>
            </li>
        </ul>
    </div>
</header>
<!-- 基本信息开始 -->
<form action="/rentingSystem/house_add" method="post">
<div class="jiben w">
    <p>基本信息</p>
</div>

<div class="basic w">

    <ul>

        <li class="b1">
            <p>小区名称</p>

            <input type="text"name="village" id ="village"placeholder="请输入小区">
        </li>
        <li class="b2">
            <p>楼层信息</p>
            <div class="b2-input"><span>第</span><input type="number" name="floor" id="floor" placeholder=""><span>层</span>
            </div>
            <div class="b2-input"><span>共</span><input type="number" name="floor_sum" id="floor_sum" placeholder=""><span>层</span>
            </div>
        </li>
        <li class="b3">
            <p>小区位置</p>
            <div class="b3-input"><input type="text" name="city" id="city" placeholder=""><span>区</span></div>
            <div class="b3-input"><input type="text" name="district" id="district" placeholder=""><span>街道</span></div>
        </li>
        <li class="b4">
            <p>房屋户型</p>
            <div class="b4-input"><input type="number" name="type_bedroom" id="type_bedroom"placeholder=""><span>室</span></div>
            <div class="b4-input"><input type="number" name="type_livingroom" id="type_livingroom"placeholder=""><span>厅</span></div>
            <div class="b4-input"><input type="number" name="type_bathroom" id="type_bathroom"placeholder=""><span>卫</span></div>
            <div class="b4-input"><input type="number" name="area" id="area"placeholder=""><span>m²</span></div>
            </select>
        </li>
        <li class="b5">
            <p>详细地址</p>
            <input type="text" name="address" id="address"/>
        </li>
        <li class="b6">
            <p>房屋朝向</p>
            <select name="houseToward" id="houseToward">
                <option value="朝向不限">朝向不限</option>
                <option value="东">东</option>
                <option value="南">南</option>
                <option value="西">西</option>
                <option value="北">北</option>
                <option value="南北">南北</option>
                <option value="东西">东西</option>
                <option value="东南">东南</option>
                <option value="西南">西南</option>
                <option value="东北">东北</option>
                <option value="西北">西北</option>
            </select>
        </li>
    </ul>
</div>
<!-- 基本信息结束 -->
<!-- 租金信息开始 -->
<div class="zujin w">
    租金信息
</div>
<div class="rent w">
    <p>月租金</p>
    <div class="rent-1">
        <input class="clearfix" type="number" name="price" id="price">
        <span class="clearfix">元/月</span>
    </div>
    <select name="payMethod" id="payMethod">
        <option value="">请选择付款方式</option>
        <option value="">付1押1</option>
        <option value="">付3押1</option>
        <option value="">半年付</option>
        <option value="">年付</option>
    </select>
</div>
<!-- 租金信息结束 -->
<!-- 详细信息开始 -->
<div class="xiangxi w">
    详细介绍
</div>
<div class="detail w">
    <ul>
        <li>
            <p>房屋配置</p>
            <label><input type="checkbox" name="facilities" value="冰箱" placeholder="">冰箱</label>
            <label><input type="checkbox" name="facilities"  value="电视" placeholder="">电视</label>
            <label><input type="checkbox" name="facilities"  value="洗衣机"placeholder="">洗衣机</label>
            <label><input type="checkbox" name="facilities" value="热水器" placeholder="">热水器</label>
            <label><input type="checkbox" name="facilities" value="空调" placeholder="">空调</label>
            <label><input type="checkbox" name="facilities" value="宽带" placeholder="">宽带</label>
            <label><input type="checkbox" name="facilities" value="沙发" placeholder="">沙发</label>
            <label><input type="checkbox" name="facilities" value="床" placeholder="">床</label>
            <label><input type="checkbox" name="facilities" value="暖气" placeholder="">暖气</label>
            <label><input type="checkbox" name="facilities" value="衣柜" placeholder="">衣柜</label>
            <label><input type="checkbox" name="facilities" value="可做饭" placeholder="">可做饭</label>
            <label><input type="checkbox" name="facilities" value="卫生间" placeholder="">卫生间</label>
            <label><input type="checkbox" name="facilities" value="阳台" placeholder="">阳台</label>
            <label><input type="checkbox" name="facilities" value="智能门锁" placeholder="">智能门锁</label>
            <label><input type="checkbox" name="facilities" value="油烟机" placeholder="">油烟机</label>
            <label><input type="checkbox" name="facilities" value="燃气灶" placeholder="">燃气灶</label>
        </li>
        <li>
            <p>出租要求</p>
            <label><input type="checkbox" name="requirement" value="只限女生" placeholder="">只限女生</label>
            <label><input type="checkbox" name="requirement" value="一家人" placeholder="">一家人</label>
            <label><input type="checkbox" name="requirement" value="禁止养宠物" placeholder="">禁止养宠物</label>
            <label><input type="checkbox" name="requirement" value="半年起租" placeholder="">半年起租</label>
            <label><input type="checkbox" name="requirement" value="一年起租" placeholder="">一年起租</label>
            <label><input type="checkbox" name="requirement" value="租户稳定" placeholder="">租户稳定</label>
            <label><input type="checkbox" name="requirement" value="作息正常" placeholder="">作息正常</label>
            <label><input type="checkbox" name="requirement" value="禁烟" placeholder="">禁烟</label>
        </li>
        <li>
            <p>房源描述</p>
            <textarea name="" cols="30" rows="10" placeholder="可以介绍一下房源亮点，交通，周边环境，可以入住的时间和对租客的要求等等" draggable="false"></textarea>
        </li>
    </ul>
</div>
<!-- 详细信息结束 -->
<!-- 房源图片开始 -->
<div class="fangyuan w">
    房源图片
</div>
<div class="housesource w">
    <div>
        <p class="word">上传图片</p>
        <p class="ess">请上传清晰、实拍的室内图片，请不要在图片上添加文字、数字、网址等内容，切勿上传名片、 二维码、自拍照、风景照等与房源无关的图片，最多上传12张，每张最大10M
        </p>
    </div>
    <div class="uploading">
        <img src="./images/uploadimg.png" alt="">
        <h1>本地上传</h1>
        <p>图片拖拽到这里或点击上传</p>
        <input type="file" name="houseImg" id="houseImg"
        accept="image/gif,image/png,image/jpeg,image.bmp"/>
    </div>
</div>
<!-- 房源图片结束 -->
<!-- 联系信息开始 -->
<div class="lianxi w">
    联系信息
</div>
<div class="contact w">
    <ul>
        <li>
            <p>昵称</p><input class="c-input" type="text">
        </li>
        <li>如需修改请到个人中心修改</li>
        <li>
            <p>联系电话</p><input class="c-input" type="text" name="managerId" id="managerId">
        </li>
        <li><label>
            <input type="checkbox">
            <span>开启中介勿扰，将有效减少中介来电</span>
        </label></li>
    </ul>
</div>

<!-- 联系信息结束 -->
    <!-- 发布按钮开始 -->
    <div class="release w">
        <button type="submit" >发布</button>
    </div>
</form>


<!-- 发布按钮结束 -->
<!-- footer开始 -->
<div class="footer w">
    <div class="footerl">
        <img src="images/footerlogo.png" alt="">
        <ul>
            <li><a href="#">网站首页</a></li>
            <li><a href="#">帮助中心</a></li>
            <li><a href="#">联系我们</a></li>
            <li><a href="#">招聘信息</a></li>
            <li><a href="#">客户服务</a></li>
            <li><a href="#">隐私政策</a></li>
            <li><a href="#">广告服务</a></li>
            <li><a href="#">网站地图</a></li>
            <li><a href="#">意见反馈</a> </li>
        </ul>
    </div>
    <span><img src="images/call.png">24小时客服热线400-000-0000</span>
    <div class="footerr">
        <ul>
            <li><img src="images/weixin.png" alt=""></li>
            <li><img src="images/sina.png" alt=""></li>
            <li><img src="images/mail.png" alt=""></li>
        </ul>
    </div>
</div>
<!-- footer结束 -->



</body>

</html>