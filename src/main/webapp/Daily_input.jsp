<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Daily Calorie Input</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <h2>Daily Calorie Tracker</h2>
        <form action="dailyLog" method="post">
            <label>Wakeup Time:</label>
            <input type="time" name="wakeup_time" required>

            <label>Exercise Type:</label>
            <select name="exercise_type">
                <option value="None">None</option>
                <option value="Walking">Walking</option>
                <option value="Running">Running</option>
                <option value="Yoga">Yoga</option>
                <option value="Gym">Gym</option>
            </select>

            <label>Exercise Duration (minutes):</label>
            <input type="number" name="exercise_duration" min="0" required>

            <label>Water Intake (liters):</label>
            <input type="number" step="0.1" name="water_intake" required>

            <label>Breakfast Type:</label>
            <select name="breakfast_type">
                <option value="light">Light</option>
                <option value="moderate">Moderate</option>
                <option value="heavy">Heavy</option>
            </select>

            <label>Lunch Type:</label>
            <select name="lunch_type">
                <option value="light">Light</option>
                <option value="moderate">Moderate</option>
                <option value="heavy">Heavy</option>
            </select>

            <label>Dinner Type:</label>
            <select name="dinner_type">
                <option value="light">Light</option>
                <option value="moderate">Moderate</option>
                <option value="heavy">Heavy</option>
            </select>

            <label>Junk Food Intake (if any):</label>
            <input type="text" name="junk_food">

            <label>Additional Notes:</label>
            <textarea name="notes" rows="3" style="width:100%; border-radius:6px; border:1px solid #ccc;"></textarea>

            <br><br>
            <input type="submit" value="Submit Daily Log">
        </form>
    </div>
</body>
</html>
