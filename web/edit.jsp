
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <form action="edit" method="post">
            <%
               String id = (String)request.getAttribute("id");
            %>
            <input type="hidden" name="id" value="<%=id%>">
            Name: <input type="text" name="name">
            <br>
            Price: <input type="text" name="price">
            <br>
            Color: <input type="text" name="color">
            <br>
            <input type="submit" value="edit">
        </form>
    </body>
</html>
