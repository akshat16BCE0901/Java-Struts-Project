<%-- 
    Document   : login
    Created on : Mar 23, 2019, 6:48:32 PM
    Author     : Akshat Singhal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTOP Login</title>
    </head>
    <body>
        <html:form action="/login">
            <table border="0">
                <thead>
                <h3>Enter your details below</h3>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="2">
                            <bean:write name="LoginForm" property="error" filter="false"/>
                            &nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><html:text property="name" /></td>
                    </tr>
                    <tr>
                        <td>Registration Number</td>
                        <td><html:text property="regno" /></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><html:text property="phone" /></td>
                    </tr>
                    <tr>
                        <td><html:submit value="Login" /></td>
                        <td><html:reset value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
    </body>
</html>
