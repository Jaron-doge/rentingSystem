<%--
  Created by IntelliJ IDEA.
  User: 29193
  Date: 2021/9/6
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    if (session.getAttribute("user")!=null) {
%>
<jsp:forward page = "/personal_center/uPersonal_center.jsp"/>
<%
}else if (session.getAttribute("manager")!=null) {
%>
<jsp:forward page = "/personal_center/mPersonal_center.jsp"/>
<%
}else {
%>
<jsp:forward page = "/personal_center/uPersonal_center.jsp" />
<%
    }
%>
</body>
</html>
