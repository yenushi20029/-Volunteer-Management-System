package app.dao;

import app.config.dbConnection;
import app.model.Feedback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    public void addFeedback(Feedback feedback) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "INSERT INTO feedback (message, feedback_date) VALUES (?, ?)";


        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date parsedDate = null;

        try {
            parsedDate = originalFormat.parse(feedback.getFeedbackDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }



        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, feedback.getMessage());
        ps.setString(2, feedback.getFeedbackDate());
        ps.executeUpdate();
        connection.close();
    }


    public List<Feedback> getAllFeedbacks() throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        Connection connection = dbConnection.getConnection();
        String query = "SELECT * FROM feedback";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Feedback feedback = new Feedback(rs.getInt("F_ID"), rs.getString("message"), rs.getString("feedback_date"));
            feedbacks.add(feedback);
        }
        connection.close();
        return feedbacks;
    }


    public void updateFeedback(Feedback feedback) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "UPDATE feedback SET message = ?, feedback_date = ? WHERE F_ID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, feedback.getMessage());
        ps.setString(2, feedback.getFeedbackDate());
        ps.setInt(3, feedback.getF_ID());
        ps.executeUpdate();
        connection.close();
    }


    public void deleteFeedback(int feedbackId) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "DELETE FROM feedback WHERE F_ID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, feedbackId);
        ps.executeUpdate();
        connection.close();
    }
}

