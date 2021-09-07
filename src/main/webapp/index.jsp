<%--
  Created by IntelliJ IDEA.
  User: YYH
  Date: 2021/9/3
  Time: 16:23
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
                <input type="search" name="" id="" placeholder="请输入搜索内容">
                <img src="images/搜索 (1).png"></img>
            </div>
        </ul>
    </div>
    <div class="fr">
        <ul>
            <li class="release"><a>发布租房</a></li>
            <li class="login"><a><img src="images/登陆.png">登录</a></li>
            <li class="register"><a><img src="images/注册 (选中).png">注册</a></li>
        </ul>
    </div>
</header>
<!-- 导航栏模块结束 -->
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
<!-- 服务模块开始 -->
<div class="service w">
    <ul>
        <li><a>公寓</a></li>
        <li><a>商铺</a></li>
        <li><a>写字楼</a></li>
        <li><a>厂房</a></li>
        <li><a>仓库</a></li>
    </ul>
</div>
<!-- 服务模块结束 -->
<!-- 范围选择开始 -->
<div class="area w">
    <ul>
        <li>
            <span>租金：</span>
            <span><a href="#">600</a></span>
            <span><a href="#">600-1000</a></span>
            <span><a href="#">1000-2000</a></span>
            <span><a href="#">2000-3000</a></span>
            <span><a href="#">3000-5000</a></span>
            <span><a href="#">5000-8000</a></span>
            <span><a href="#">8000以上</a></span>
        </li>
        <li>
            <span>厅室：</span>
            <span><a href="#">一室</a></span>
            <span><a href="#">两室</a></span>
            <span><a href="#">三室</a></span>
            <span><a href="#">四室</a></span>
            <span><a href="#">四室以上</a></span>
        </li>
        <li>
            <span>方式：</span>
            <span><a href="#">整套出租</a></span>
            <span><a href="#">单间出租</a></span>
        </li>
        <li>
            <span>其他：</span>
            <span><a href="#">朝向不限</a></span>
            <span><a href="#">装修不限</a></span>
            <span><a href="#">只看有图</a></span>
        </li>
    </ul>
</div>
<!-- 范围选择结束 -->
<!-- 联系客服分割线开始 -->
<div class="kefu w">
    <a href="#">联系客服</a>
</div>
<!-- 联系客服分割线结束 -->
<!-- 房源开始 -->
<div class="house w">
    <!-- 左侧列开始 -->
    <div class="houseleft">
        <div class="reco">
            <ul>
                <li><a href="#">推荐房源</a></li>
                <li><a href="#">最新房源</a></li>
            </ul>
        </div>
        <div class="detailinfo">
            <ul>
                <li>
                    <img src="images/小1.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小2.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小3.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小1.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小3.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小1.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小2.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小2.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小1.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
                <li>
                    <img src="images/小2.png">
                    <dl>
                        <dt class="title"><a href="#">整租 | 海洋石油天野小区 天野佳园 元和国际 拎包入住 好停</a></dt>
                        <dt>2室 54平方米</dt>
                        <dt>金桥路 海洋石油天野小区</dt>
                        <dt>来自经纪人：七点房产 海琳</dt>
                    </dl>
                    <span>3600元/月</span>
                </li>
            </ul>
        </div>
        <!-- 尾部页码开始 -->
        <div class="page">
            <ul>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">...</a></li>
                <li><a href="#">70</a></li>
                <li><a href="#">下一页</a></li>

            </ul>
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
            <ul>
                <li>
                    <img src="images/大2.png">
                    <dl>
                        <dt class="retuidetail">金桥开发区/金桥路/金桥开发区/金桥路</dt>
                        <dt class="retuidetail">3室 136.5平</dt>
                        <dt class="retuiprice">3000元/月</dt>
                    </dl>
                </li>
                <li>
                    <img src="images/大2.png">
                    <dl>
                        <dt class="retuidetail">金桥开发区/金桥路/金桥开发区/金桥路</dt>
                        <dt class="retuidetail">3室 136.5平</dt>
                        <dt class="retuiprice">3000元/月</dt>
                    </dl>
                </li>
                <li>
                    <img src="images/大3.png">
                    <dl>
                        <dt class="retuidetail">金桥开发区/金桥路/金桥开发区/金桥路</dt>
                        <dt class="retuidetail">3室 136.5平</dt>
                        <dt class="retuiprice">3000元/月</dt>
                    </dl>
                </li>
                <li>
                    <img src="images/大2.png">
                    <dl>
                        <dt class="retuidetail">金桥开发区/金桥路/金桥开发区/金桥路</dt>
                        <dt class="retuidetail">3室 136.5平</dt>
                        <dt class="retuiprice">3000元/月</dt>
                    </dl>
                </li>
                <li>
                    <img src="images/大3.png">
                    <dl>
                        <dt class="retuidetail">金桥开发区/金桥路/金桥开发区/金桥路</dt>
                        <dt class="retuidetail">3室 136.5平</dt>
                        <dt class="retuiprice">3000元/月</dt>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!-- 右侧列结束 -->

</div>
<!-- 房源结束 -->
<!-- 友情链接开始 -->
<div class="blogroll w">
    <h1>
        友情链接
    </h1>
    <ul>
        <li><a href="#">https://www.bupt.edu.cn/</a></li>
        <li><a href="#">https://www.bupt.edu.cn/</a></li>
        <li><a href="#">https://www.bupt.edu.cn/</a></li>
        <li><a href="#">https://www.bupt.edu.cn/</a></li>
    </ul>
</div>
<!-- 友情链接结束 -->
<!-- footer开始 -->
<div class="footer w">
    <div class="footerl">
        <img src="images/footer_logo.png" alt="">
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
            <li><img src="images/wei_xin.png" alt=""></li>
            <li><img src="images/sina.png" alt=""></li>
            <li><img src="images/mail.png" alt=""></li>
        </ul>
    </div>
</div>
<!-- footer结束 -->
<!-- 固定定位开始 -->
<div class="fix">
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<!-- 固定定位结束 -->
</body>

</html>