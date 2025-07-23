package app.controller;

import app.model.Donation;
import app.dao.DonationDAO;

import java.sql.SQLException;
import java.util.List;

public class DonationController {
    private final DonationDAO donationDAO;

    public DonationController() {
        donationDAO = new DonationDAO();
    }

    // Adding  donation
   public void addDonation(Donation donation) {
        try {
            donationDAO.addDonation(donation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Donation> getAllDonations() {
        try {
            return donationDAO.getAllDonations();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public void updateDonation(Donation donation) {
        try {
            donationDAO.updateDonation(donation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a donation ID
    public void deleteDonation(int donationId) {
        try {
            donationDAO.deleteDonation(donationId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

