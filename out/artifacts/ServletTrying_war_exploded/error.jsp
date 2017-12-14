<%--
  Created by IntelliJ IDEA.
  User: skraim
  Date: 13.12.2017
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wrong Input!</title>
    <style type="text/css">
        body {
            background-color: #d2b48c;
            margin-left: 20%;
            margin-right: 20%;
            border: 2px dotted black;
            padding: 10px 10px 10px 10px;
            font-family: sans-serif;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>ERROR!</h1>
<h3>${message}</h3>
<%--<a href="<%= request.getRequestURI() %>"><h3>Back</h3></a>--%>
<a href="${backuri}"><h3>Back</h3></a>
</body>
</html>
