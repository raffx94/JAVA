<%@page import="java.sql.ResultSet"%>
<%@ page import="java.util.*" %>


<html>
    <body>
        <title> history database </title>
        <%
            ResultSet styles = (ResultSet) request.getAttribute("bean");

            while (styles.next()) {

                int id = styles.getInt("ID");
                String name = styles.getString("STRING");
                Double dd = styles.getDouble("WYNIK");
                out.println("the number in DB: [ " + id + " ] the string text [ " + name + " ]  the score of the calculating [ " + dd + " ] " + " <br>");
                id = 0;
                name = " ";
                dd = 0.0;

            }
        %>


    </body>
</html>
