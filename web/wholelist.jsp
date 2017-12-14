<%@ page import="ua.nure.sportinventory.Inventory" %>
<%@ page import="java.util.List" %>

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
<%! List<Inventory> list; %>
<% list = (List<Inventory>) request.getAttribute("list");%>
<h1>Inventory List</h1>
<%
    for (int i = 0; i < list.size(); i++) {

%>
<h4><%=list.get(i)%>
</h4>
<%
    }
%>
<a href="${backuri}"><h3>Back</h3></a>
</body>
</html>
