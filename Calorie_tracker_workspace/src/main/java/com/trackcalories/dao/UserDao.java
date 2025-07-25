package com.trackcalories.dao;

import com.trackcalories.model.User;
import java.sql.*;

public class UserDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/trackcalories?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "ksteja"; // <-- replace with your actual MySQL password

    private static final String INSERT_USER_SQL = 
        "INSERT INTO users (name, age, gender, height, weight, target_weight) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String GET_USER_ID_SQL =
        "SELECT id FROM users WHERE name = ? LIMIT 1";

    // Register user
    public int registerUser(User user) throws ClassNotFoundException {
        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getGender());
            statement.setInt(4, user.getHeight());
            statement.setInt(5, user.getWeight());
            statement.setInt(6, user.getTargetWeight());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Get user ID by name
    public int getUserIdByName(String name) {
        int id = -1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                 PreparedStatement stmt = conn.prepareStatement(GET_USER_ID_SQL)) {

                stmt.setString(1, name);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    id = rs.getInt("id");
                }

                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}
