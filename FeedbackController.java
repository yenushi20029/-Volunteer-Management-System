package app.controller;

import app.model.Feedback;
import app.dao.FeedbackDAO;

import java.sql.SQLException;
import java.util.List;

public class FeedbackController {
    private final FeedbackDAO feedbackDAO;

    public FeedbackController() {
        feedbackDAO = new FeedbackDAO();
    }

    public void addFeedback(Feedback feedback) {
        try {
            feedbackDAO.addFeedback(feedback);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Feedback> getAllFeedbacks() {
        try {
            return feedbackDAO.getAllFeedbacks();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateFeedback(Feedback feedback) {
        try {
            feedbackDAO.updateFeedback(feedback);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteFeedback(int feedbackId) {
        try {
            feedbackDAO.deleteFeedback(feedbackId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
