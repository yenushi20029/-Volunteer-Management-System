package app.dao;

import app.config.dbConnection;
import app.model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    public void addEvent(Event event) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "INSERT INTO events (name, location, date) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, event.getName());
        ps.setString(2, event.getLocation());
        ps.setString(3, event.getDate());
        ps.executeUpdate();
        connection.close();
    }

    public List<Event> getAllEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        Connection connection = dbConnection.getConnection();
        String query = "SELECT * FROM events";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Event event = new Event(rs.getInt("id"), rs.getString("name"), rs.getString("location"),
                    rs.getString("date"));
            events.add(event);
        }
        connection.close();
        return events;
    }

    public void updateEvent(Event event) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "UPDATE events SET name = ?, location = ?, date = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, event.getName());
        ps.setString(2, event.getLocation());
        ps.setString(3, event.getDate());
        ps.setInt(4, event.getId());
        ps.executeUpdate();
        connection.close();
    }

    // Delete Event
    public void deleteEvent(int eventId) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "DELETE FROM events WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, eventId);
        ps.executeUpdate();
        connection.close();
    }
}