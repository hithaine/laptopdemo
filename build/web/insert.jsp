
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
    </head>
    <body>
        <form action="insert" method="post">
            Name: <input type="text" name="name">
            <br>
            Price: <input type="text" name="price">
            <br>
            Color: <input type="text" name="color">
            <br>
            <input type="submit" value="insert">
        </form>
    </body>
</html>
