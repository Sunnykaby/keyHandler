<%--
  Created by IntelliJ IDEA.
  User: shidian
  Date: 2016/10/27
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div id="loginContener">
        <fieldset>
            <legend>
                Login
            </legend>
            <form action="login.execute" id="login">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="userName"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password"></td>
                    </tr>
                </table>
                <br>
                <br>
                <button type="submit" >login</button>
            </form>
        </fieldset>
    </div>
</body>
</html>
