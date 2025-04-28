// arithematic.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Arithmetic Operations</title>
</head>
<body>
    <%
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    out.println("<p>Error: Division by zero is not allowed.</p>");
                }
                break;
            default:
                out.println("<p>Invalid operation.</p>");
                break;
        }
    %>

    <h1>Arithmetic Operation Result</h1>
    <p>Number 1: <%= num1 %></p>
    <p>Number 2: <%= num2 %></p>
    <p>Operation: <%= operation %></p>
    <p>Result: <%= result %></p>
</body>
</html>
