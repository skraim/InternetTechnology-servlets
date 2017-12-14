<%--
  Created by IntelliJ IDEA.
  User: skraim
  Date: 11.12.2017
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sport Inventory</title>
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
<h1><b>Sport Inventory rent</b></h1>
<form action="${pageContext.request.contextPath}/inventorylist" method="get">
    <input type="submit" value="Get Whole List" name="inventoryList">
    <%--Get Inventory list by id: <input type="text" name="listById">--%>
    <%--Get price by id: <input type="text" value="getPriceInADay">--%>
</form>
<form action="${pageContext.request.contextPath}/aboutinventory" method="get">
    Get Inventory by id <input type="text" value="id" name="inventory">
    <input type="submit" value="Get Inventory">
    <%--Get Inventory list by id: <input type="text" name="listById">--%>
    <%--Get price by id: <input type="text" value="getPriceInADay">--%>
</form>
<form action="${pageContext.request.contextPath}/inadayprice" method="get">
    Get price in a day by id <input type="text" value="id" name="priceInADay">
    <input type="submit" value="Get Price">
</form>
<form action="${pageContext.request.contextPath}/inahourprice" method="get">
    Get price in a hour by id <input type="text" value="id" name="priceInAHour">
    <input type="submit" value="Get Price">
</form>
<form action="${pageContext.request.contextPath}/typelist" method="get">
    Get inventories by type <input type="text" value="type" name="type">
    <input type="submit" value="Get List">
</form>
</body>
</html>
