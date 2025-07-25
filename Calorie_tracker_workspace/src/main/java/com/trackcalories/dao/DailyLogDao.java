package com.trackcalories.dao;

import com.trackcalories.model.DailyLog;

import java.sql.*;
import java.time.LocalDate;

public class DailyLogDao {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/trackcalories?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "ksteja";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Save daily log into the database
    public boolean saveLog(DailyLog log) {
        String sql = "INSERT INTO daily_log (user_id, log_date, wakeup_time, exercise_type, exercise_duration, " +
                     "water_intake, breakfast_type, lunch_type, dinner_type, junk_food, notes, calories_estimated) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, log.getUserId());
            stmt.setDate(2, Date.valueOf(LocalDate.now())); // today's date
            stmt.setTime(3, log.getWakeupTime());
            stmt.setString(4, log.getExerciseType());
            stmt.setInt(5, log.getExerciseDuration());
            stmt.setDouble(6, log.getWaterIntake());
            stmt.setString(7, log.getBreakfastType());
            stmt.setString(8, log.getLunchType());
            stmt.setString(9, log.getDinnerType());
            stmt.setString(10, log.getJunkFood());
            stmt.setString(11, log.getNotes());
            stmt.setInt(12, log.getCaloriesEstimated());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fetch user ID by username
    public int getUserIdByName(String name) {
        int id = -1;
        String sql = "SELECT id FROM users WHERE name = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
