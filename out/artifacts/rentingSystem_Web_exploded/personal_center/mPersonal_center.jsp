<%@ page import="com.example.rent.entity.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.rent.entity.Manager" %><%--
Created by IntelliJ IDEA.
User: 29193
Date: 2021/9/6
Time: 16:54
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

<head>
    <base href="http://localhost:8080/rentingSystem/personal_center/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="robots" content="noindex,nofollow" />
    <link rel="icon" href="./img/logo.ico.png" type="image/ico" />
    <link rel="stylesheet" rev="stylesheet" href="../css/personal_center.css" type="text/css" />
    <script src="../js/jquery_old.js"></script>
    <title>个人中心界面</title>
</head>

<body>
<%
    Manager manager = (Manager) session.getAttribute("manager");
%>
<!-- 个人界面顶部栏定义区域 -->
<div class="header-mod">
    <div class="header clearfix">
        <!-- 插入项目logo -->
        <img src="../img/top.png" width="350" alt="">
        <!--定义房源管理按钮-->
        <button class="releaseBtn" onclick="$.get('https://www.baidu.com');">房源管理</button>
        <!-- 定义退出按钮 -->
        <a href="javascript:void(0)" class="quit"><img src="../img/icon/shutdown.png" alt=""> <span>退出</span></a>
    </div>
</div>
<!-- 个人界面次顶部栏定义区域 -->
<div class="headerSub-mod">
    <div class="headerSub clearfix">
        <!-- 插入用户头像 -->
        <img src="<%=manager.getManagerIcon()%>" class="user-photo" alt="用户头像">

        <div class="user-info">
            <div class="info-sup clearfix">
                <!-- 定义打招呼信息 -->
                <span class="hello">
            <span>欢迎登录，亲~</span>
                    </span>
            </div>

            <div class="info-sub clearfix">
                <ul>
                    <li class="user-account">账户名：<span><%=manager.getName()%></span> </li>
                    <li style="color: gray;">&nbsp;&nbsp; | &nbsp;&nbsp;</li>
                    <li class="user-type"><span>管理员</span></li>
                    <li style="color: gray;">&nbsp;&nbsp; | &nbsp;&nbsp;</li>
                    <li class="last-time">上次登录：<span class="day">2021-09-02 17:31:33</span></li>
                </ul>
            </div>
        </div>

        <a class="info-modify" href="javascript:void(0);"><button>修改资料</button></a>
    </div>
</div>

<!-- 个人界面主内容区域定义部分 -->
<div class="container">
    <div class="content clearfix">
        <!-- 侧边栏 -->
        <div class="side-menu">
            <ul class="menu-list">
                <li>
                    <a href="javascript:void(0);" class="cur"><img src="../img/icon/mess.png">&nbsp;&nbsp;&nbsp;&nbsp;消息一览 </a>
                </li>
                <li>
                    <a href="javascript:void(0);" class=""><img src="../img/icon/person.png">&nbsp;&nbsp;&nbsp;&nbsp;个人资料</a>
                </li>
                <li>
                    <a href="javascript:void(0);" class=""><img src="../img/icon/ques.png">&nbsp;&nbsp;&nbsp;&nbsp;问答社区</a>
                </li>
                <li>
                    <a href="javascript:void(0);" class=""><img src="../img/icon/his.png">&nbsp;&nbsp;&nbsp;&nbsp;看房记录</a>
                </li>
            </ul>


            <div class="tool-list">
                <h4 class="t-title">小工具</h4>
                <p>
                    <a href="javascript:void(0);" target="_blank">估房价</a>
                    <a href="javascript:void(0);" target="_blank">房贷计算器</a>
                </p>
            </div>
        </div>
        <div class="right-content">
            <div class="right-cont">
                <ul class="tab-list clearfix">
                    <li><a href="javascript:void(0);" class="cur">设置栏</a></li>
                </ul>




                <div class="qie">
                    <!-- "消息一览界面" -->
                    <div class="no-msg item">
                            <span class="no-msg-content">
      <span class="no-msg-text"><img src="../img/que.png" style="width: 80px;" ><br>您还没有消息哟~</span>
                            </span>
                    </div>

                    <!-- "个人资料"界面 -->
                    <div class="profile item">
                        <!-- 标题 -->
                        <div class="profile-title">
                            <span>基本个人资料设置</span>
                        </div>
                        <!-- 资料列表 -->
                        <ul class="profile-list">

                            <li class="photo">
                                <span class="key">头像</span>
                                <img src="<%=manager.getManagerIcon()%>" alt="你的头像">
                                <a href="javascript:void(0);" class="operate-btn">修改</a>
                            </li>

                            <li class="account">
                                <span class="key">帐号</span>
                                <span class="value"><%=manager.getManagerId()%></span>
                            </li>

                            <li class="name">
                                <span class="key">昵称</span>
                                <span class="value"><%=manager.getName()%></span>
                                <button class="operate-btn">修改</button>
                            </li>

                            <li class="email">
                                <span class="key">邮箱</span>
                                <span class="value">helongzhu@bupt.edu.cn</span>
                                <a class="operate-btn" href="javascript:void(0);">绑定</a>
                            </li>

                            <li class="phone">
                                <span class="key">手机</span>
                                <span class="value"><%=manager.getManagerId()%></span>
                                <a class="operate-btn" href="javascript:void(0);">修改</a>
                            </li>

                            <li class="password">
                                <span class="key">密码</span>
                                <span class="value">******</span>
                                <a class="operate-btn" href="javascript:void(0);">修改</a>
                            </li>
                        </ul>
                    </div>

                    <div class="item"></div>
                    <div class="item"></div>
                </div>


            </div>

            <!-- 推荐房源 -->
            <div class="recommend-house">
                <div class="rh-area">
                    <p class="rh-title">您可能感兴趣的房源</p>
                    <ul class="rh-items">
                        <li class="rh-item">
                            <a href="javascript:void(0);" class="rh-item-content" target="_blank">
                                <img src="https://pic1.ajkimg.com/display/hj/27f051cfc840c62a8ff592b130478062/240x180c.jpg?t=1" width="182" height="135">
                                <span class="community-area"></span>
                                <span class="community-text">绿苑二邨</span>
                                <p class="item-title">房东急售 近11号线300米 价格可谈 20万精装送家电</p>
                                <p class="item-info"><span class="item-price">76万</span><span class="item-info-sub">2室2厅，56平米</span></p>
                            </a>
                        </li>
                        <li class="rh-item">
                            <a href="javascript:void(0);" class="rh-item-content" target="_blank">
                                <img src="https://pic1.ajkimg.com/display/hj/ae042353eff864004c3d55a6ff0f3d6c/240x180c.jpg?t=1" width="182" height="135">
                                <span class="community-area"></span>
                                <span class="community-text">塘东小区</span>
                                <p class="item-title">中秋节特惠 塘桥蓝村地铁口 电梯精装两房 居家装修 业主诚售</p>
                                <p class="item-info"><span class="item-price">345万</span><span class="item-info-sub">1室2厅，56平米</span></p>
                            </a>
                        </li>
                        <li class="rh-item">
                            <a href="javascript:void(0);" class="rh-item-content" target="_blank">
                                <img src="https://pic1.ajkimg.com/display/hj/86eb8a5cb5f728ccd948100197d161b2/240x180c.jpg?t=1" width="182" height="135">
                                <span class="community-area"></span>
                                <span class="community-text">复地爱伦坡(二期)</span>
                                <p class="item-title">爱伦坡 双拼255平 大花园 精装 价格实惠 随时好看 急急</p>
                                <p class="item-info"><span class="item-price">998万</span><span class="item-info-sub">2室5厅，255平米</span></p>
                            </a>
                        </li>
                        <li class="rh-item">
                            <a href="javascript:void(0);" class="rh-item-content" target="_blank">
                                <img src="https://pic1.ajkimg.com/display/hj/51dc65ebeab90a263988f0e9f7e727b4/240x180c.jpg?t=1" width="182" height="135">
                                <span class="community-area"></span>
                                <span class="community-text">虹桥乐庭</span>
                                <p class="item-title">交大附小學区全南大两房，中央空调带地暖，刷卡到户，紧邻学校</p>
                                <p class="item-info"><span class="item-price">1190万</span><span class="item-info-sub">2室2厅，123.22平米</span></p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 底部栏定义部分 -->
<div id="footer" class="footer" style="text-align: center;">
    <img src="../img/di1.png" width="100" />
    <br>
    <img src="../img/di.png" width="300" />
    <ul class="links">
        <li><a rel="nofollow" href="javascript:void(0);">关于我们</a></li>
        <li><a rel="nofollow" href="javascript:void(0);">联系我们</a></li>
        <li><a rel="nofollow" href="javascript:void(0);">用户协议</a></li>
        <li><a rel="nofollow" href="javascript:void(0);">友情链接</a></li>
        <li><a href="javascript:void(0);">最新问答</a></li>
    </ul>
</div>


<!-- 退出弹出框 -->
<div id="quit1">
    <a class="close"><img src="../img/icon/close.png" style="width: 30px;"></a>
    <div class="content">
        <img src="../img/icon/bear.png" style="width: 30px;">
        <span style="font-size:30px; font-weight: bolder; color: #333; margin: 20px 0 20px;">您是否要退出？</span>
        <div class="inputBox">
            <input type="submit" value="确定" class="yes">
        </div>
    </div>
</div>

<!-- 修改头像弹出框 -->
<div id="photo">
    <a class="close"><img src="../img/icon/close.png" style="width: 30px;"></a>
    <div class="content">
        <img src="../img/icon/bear.png" style="width: 30px;">
        <span style="font-size:30px; font-weight: bolder; color: #333; margin: 20px 0 20px;">上传头像</span>
        <div class="inputBox">
            <input type="file" id="fileSelector">
        </div>
        <div class="inputBox">
            <input type="submit" placeholder="提交" class="yes">
        </div>
    </div>
</div>

<!-- 修改昵称弹出框 -->
<div id="name">
    <a class="close"><img src="../img/icon/close.png" style="width: 30px;"></a>
    <div class="content">
        <img src="../img/icon/bear.png" style="width: 30px;">
        <span style="font-size:30px; font-weight: bolder; color: #333; margin: 20px 0 20px;">修改昵称</span>
        <div class="inputBox">
            <input type="text" placeholder="请输入您的昵称" id="input-name">
        </div>
        <div class="inputBox">
            <input type="submit" placeholder="提交" class="yes">
        </div>
    </div>
</div>

<!-- 修改邮箱弹出框 -->
<div id="email">
    <a class="close"><img src="../img/icon/close.png" style="width: 30px;"></a>
    <div class="content">
        <img src="../img/icon/bear.png" style="width: 30px;">
        <span style="font-size:30px; font-weight: bolder; color: #333; margin: 20px 0 20px;">修改邮箱</span>
        <div class="inputBox">
            <input type="email" placeholder="请输入您的邮箱账号">
        </div>
        <div class="inputBox">
            <input type="submit" placeholder="提交" class="yes">
        </div>
    </div>
</div>

<!-- 修改手机号码弹出框 -->
<div id="phone">
    <a class="close"><img src="../img/icon/close.png" style="width: 30px;"></a>
    <div class="content">
        <img src="../img/icon/bear.png" style="width: 30px;">
        <span style="font-size:30px; font-weight: bolder; color: #333; margin: 20px 0 20px;">修改手机号码</span>
        <div class="inputBox">
            <input type="number" placeholder="请输入您的手机号码" id="input-telNo">
        </div>
        <div class="inputBox">
            <input type="submit" placeholder="提交" class="yes">
        </div>
    </div>
</div>

<!-- 修改密码弹出框 -->
<div id="password">
    <a class="close"><img src="../img/icon/close.png" style="width: 30px;"></a>
    <div class="content">
        <img src="../img/icon/bear.png" style="width: 30px;">
        <span style="font-size:30px; font-weight: bolder; color: #333; margin: 20px 0 20px;">修改密码</span>
        <div class="inputBox">
            <input type="password" placeholder="请输入您的密码" id="input-pwd">
        </div>
        <div class="inputBox">
            <input type="submit" placeholder="提交" class="yes">
        </div>
    </div>
</div>

<div id="delete">
    <a class="close"><img src="../img/icon/close.png" style="width: 30px;"></a>
    <div class="content">
        <img src="../img/icon/bear.png" style="width: 30px;">
        <span style="font-size:30px; font-weight: bolder; color: #333; margin: 20px 0 20px;">您是否要删除？</span>
        <div class="inputBox">
            <input type="submit" value="确定" class="yes">
        </div>
    </div>
</div>


<script src="https://unpkg.com/cos-js-sdk-v5/dist/cos-js-sdk-v5.min.js"></script>
<script>
    var selectedFile;
    var filename;
    $("#fileSelector").change(function() {
        selectedFile = document.getElementById('fileSelector').files[0];
        filename = selectedFile.name;
    });
    // 控制“退出”弹出框
    $('.header-mod .quit').click(function() {
        $('#quit1').show();
    })
    $('#quit1 .close').click(function() {
        $('#quit1').hide();
    })
    $('#quit1 .yes').click(function() {
        $.get("/rentingSystem/managerExitServlet");
        window.location.href = "../index.jsp";
        $('#quit1').hide();
    })

    // 控制“头像”弹出框
    $('.photo .operate-btn').click(function() {
        $('#photo').show();
    })
    $('#photo .close').click(function() {
        $('#photo').hide();
    })
    $('#photo .yes').click(function() {
        var cos = new COS({
            SecretId: 'AKIDsZ1GSO31Su6D6k9uCLp19IBpGk0nJQSc',
            SecretKey: 'EDuNccQ3g8UjtxqCLNTN8gzHJAnBNpZM',
        })

        cos.putObject({
            Bucket: 'jaron-doge-1305669952',
            Region: 'ap-beijing',
            Key: "rentingSystem/userIcon/" + filename,
            StorageClass: 'STANDARD',
            Body: selectedFile, // 上传文件对象
            onProgress: function(progressData) {
                console.log(JSON.stringify(progressData));
            }
        }, function(err, data) {
            console.log(data.Location);
            $.get("/rentingSystem/modifyIconServlet", {icon: data.Location});
        });
        $('#photo').hide();
        location.reload();
    })

    // 控制“昵称”弹出框
    $('.name .operate-btn').click(function() {
        $('#name').show();
    })
    $('#name .close').click(function() {
        $('#name').hide();
    })
    $('#name .yes').click(function() {
        $.get("/rentingSystem/modifyNameServlet", {name: $('#input-name').val()});
        location.reload();
        $('#name').hide();
    })

    // 控制“邮箱”弹出框
    $('.email .operate-btn').click(function() {
        $('#email').show();
    })
    $('#email .close').click(function() {
        $('#email').hide();
    })
    $('#email .yes').click(function() {
        $('#email').hide();
    })


    // 控制“手机”弹出框
    $('.phone .operate-btn').click(function() {
        $('#phone').show();
    })
    $('#phone .close').click(function() {
        $('#phone').hide();
    })
    $('#phone .yes').click(function() {
        // 先暂停修改id功能
         $.get("/rentingSystem/modifyTelNoServlet", {telNo: $('#input-telNo').val()});
        location.reload();
        $('#phone').hide();
    })

    // 控制“密码”弹出框
    $('.password .operate-btn').click(function() {
        $('#password').show();
    })
    $('#password .close').click(function() {
        $('#password').hide();
    })
    $('#password .yes').click(function() {
        $.get("/rentingSystem/modifyPwdServlet", {pwd: $('#input-pwd').val()});
        location.reload();
        $('#password').hide();
    })

    // 控制“删除”弹出框
    $('.house-delete').click(function() {
        $('#delete').show();
    })
    $('#delete .close').click(function() {
        $('#delete').hide();
    })
    $('#delete .yes').click(function() {
        // 要传一个houseId
        $.get("/rentingSystem/houseDeleteServlet", {houseId: $('#input-pwd').val()});
        location.reload();
        $('#delete').hide();
    })

    $(function() {
        $(".menu-list li").click(function() {
            // 链式编程
            $(this).children("a").addClass("cur").parent("li").siblings("li").children().removeClass("cur");
            // 得到当前li的索引号
            var index = $(this).index();
            // 让下面相应索引号的item显示，其它隐藏
            $(".qie .item").eq(index).show().siblings().hide();
        });
    });
</script>

</body>

</html>
