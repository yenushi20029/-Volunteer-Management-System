package app;

import app.model.Donation;
import app.view.*;
import app.view.EventManagementFrame;
import app.view.FeedbackFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

             LandingFrame frame = new LandingFrame();

           frame.setVisible(true);
        });
    }
}
