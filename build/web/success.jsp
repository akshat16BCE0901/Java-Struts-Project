<%-- 
    Document   : success.jsp
    Created on : Mar 23, 2019, 11:51:28 PM
    Author     : Akshat Singhal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Success</title>
</head>
<body>
    <h1>Congratulations!</h1>

    <p>Your name is: <bean:write name="LoginForm" property="name" />.</p>
    <p>Your Registration number is: <bean:write name="LoginForm" property="regno" />.</p>
    <p>Your phone number is: <bean:write name="LoginForm" property="phone" />.</p>
</body>
</html>
