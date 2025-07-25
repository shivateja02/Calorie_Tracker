package com.trackcalories.servlet;

import com.trackcalories.dao.DailyLogDao;
import com.trackcalories.model.DailyLog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Time;

@WebServlet("/dailyLog")
public class DailyLogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DailyLogDao dailyLogDao;

    public void init() {
        dailyLogDao = new DailyLogDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Static user (you can later set from session)
            int userId = 1;
            String userName = "User";

            DailyLog log = new DailyLog();
            log.setUserId(userId);
            log.setWakeupTime(Time.valueOf(request.getParameter("wakeup_time") + ":00"));
            log.setExerciseType(request.getParameter("exercise_type"));
            log.setExerciseDuration(Integer.parseInt(request.getParameter("exercise_duration")));
            log.setWaterIntake(Double.parseDouble(request.getParameter("water_intake")));
            log.setBreakfastType(request.getParameter("breakfast_type"));
            log.setLunchType(request.getParameter("lunch_type"));
            log.setDinnerType(request.getParameter("dinner_type"));
            log.setJunkFood(request.getParameter("junk_food"));
            log.setNotes(request.getParameter("notes"));

            // Estimate calories
            int calories = estimateCalories(log);
            log.setCaloriesEstimated(calories);

            boolean success = dailyLogDao.saveLog(log);

            if (success) {
                String message = "<div class='fade-in'>"
                        + "<p class='summary-line'>👋 Dear <strong>" + userName + "</strong>,</p>"
                        + "<p class='summary-line'>🔥 You approximately consumed <strong>" + calories + " calories</strong> today.</p>"
                        + "<p class='summary-line'>💪 Keep up the great work!</p><br>"
                        + "<p class='summary-line'>🏃 Exercise Type: <strong>" + log.getExerciseType() + "</strong></p>"
                        + "<p class='summary-line'>🕒 Duration: <strong>" + log.getExerciseDuration() + " minutes</strong></p>"
                        + "<p class='summary-line'>💧 Water Intake: <strong>" + log.getWaterIntake() + " L</strong></p>"
                        + "<p class='summary-line'>🍳 Breakfast: <strong>" + log.getBreakfastType() + "</strong></p>"
                        + "<p class='summary-line'>🍱 Lunch: <strong>" + log.getLunchType() + "</strong></p>"
                        + "<p class='summary-line'>🍲 Dinner: <strong>" + log.getDinnerType() + "</strong></p>"
                        + "<p class='summary-line'>🍟 Junk Food: <strong>" + (log.getJunkFood().isEmpty() ? "None" : log.getJunkFood()) + "</strong></p>"
                        + "</div>";

                request.setAttribute("message", message);
            } else {
                request.setAttribute("message", "<div class='fade-in error'>❌ Failed to save your daily log. Please try again.</div>");
            }

            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "<div class='fade-in error'>⚠️ An error occurred while processing your log.</div>");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }

    private int estimateCalories(DailyLog log) {
        int base = 1200;

        switch (log.getBreakfastType()) {
            case "moderate": base += 200; break;
            case "heavy": base += 400; break;
        }

        switch (log.getLunchType()) {
            case "moderate": base += 300; break;
            case "heavy": base += 500; break;
        }

        switch (log.getDinnerType()) {
            case "moderate": base += 300; break;
            case "heavy": base += 500; break;
        }

        if (log.getJunkFood() != null && !log.getJunkFood().trim().isEmpty()) {
            base += 300;
        }

        base -= log.getExerciseDuration() * 5;
        return Math.max(base, 1000);
    }
}
