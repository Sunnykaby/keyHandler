<%--
  Created by IntelliJ IDEA.
  User: shidian
  Date: 2016/10/25
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.kami.app.key.model.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>KeyIndex</title>
</head>
<body>
    <jsp:useBean id="user" scope="session" class="com.kami.app.key.model.UserKeys"></jsp:useBean>
    <h2>Key Information Lists Demo</h2><a href="logout.execute">Logout</a>
    <hr size="4"/>
    <table frame="below" width="100%">
        <tr>
            <th align="center">key Id</th>
            <th align="center">key Name</th>
            <th align="center">key Value</th>
            <th></th>
        </tr>
        <%
            List<KeyInfo> lists = user.getKeys();
            for (KeyInfo currentKey:
                 lists) {
                %>
        <tr>
            <td align="center"><%=currentKey.getKeyId()%></td>
            <td align="center"><%=currentKey.getKeyName()%></td>
            <td align="center"><%=currentKey.getKeyValue()%></td>
            <td align="center"><a href="removeKey.execute?keyId=<%=currentKey.getKeyId()%>">Delete</a></td>
        </tr>
<%            }
        %>
    </table>
    <br>
    <br>
    <br>
    <fieldset>
        <legend><b>Add Key</b></legend>
        <form action="addKey.execute">
            <table>
                <tr>
                    <td>Key Name</td>
                    <td><input type="text" size="30" name="name"></td>
                </tr>
                <tr>
                    <td>Key Value</td>
                    <td><input type="text" size="30" name="value"></td>
                </tr>
            </table>
            <br>
            <input type="submit" name="addKey" value="Add">
        </form>
    </fieldset>
    
</body>
</html>
