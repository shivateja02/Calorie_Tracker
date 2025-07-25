<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Daily Summary</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h2>Daily Summary</h2>
        <div class="message">
            <%= request.getAttribute("message") == null ? "No message received." : request.getAttribute("message") %>
        </div>

        <br><br>
        <a href="daily_inputs.jsp"><button>Log Again</button></a>
    </div>
</body>
</html>
