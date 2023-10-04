
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Laptop"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
    </head>
    <body>
        <table border="1px">
            <thead>
            <th>Name</th>
            <th>Price</th>
            <th>Color</th>
        </thead>
        <tbody>
            <%
                List<Laptop> laptops = (List<Laptop>)request.getAttribute("laptops");
                for (Laptop laptop : laptops) {
            %>
            <tr>
                <td><%=laptop.getName()%></td>
                <td><%=laptop.getPrice()%></td>
                <td><%=laptop.getColor()%></td>
                <td>
                    <form action="edit">
                        <input type="hidden" name="id" value="<%=laptop.getId()%>">
                        <input type="submit" value="edit">
                    </form>
                    <form action="delete">
                        <input type="hidden" name="id" value="<%=laptop.getId()%>">
                        <input type="submit" value="delete">
                    </form>           
                </td>
            </tr>
            <%
                }
            %>
        </tbody>    
        <tfoot>
            <tr>
                <td colspan="4">
                    <form action="insert">
                        <input type="submit" value="insert">
                    </form>
                </td>
            </tr>
        </tfoot>
    </table>
</body>
</html>
