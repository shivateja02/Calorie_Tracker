<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <h2>User Registration</h2>
        <form action="register" method="post">

            <label>Name:</label>
            <input type="text" name="name" required>

            <label>Age:</label>
            <input type="number" name="age" required>

            <label>Gender:</label>
            <select name="gender" required>
                <option value="">--Select--</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>

            <label>Height (in cm):</label>
            <input type="number" name="height" required>

            <label>Weight (in kg):</label>
            <input type="number" name="weight" required>

            <label>Target Weight (in kg):</label>
            <input type="number" name="target_weight" required>

            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
