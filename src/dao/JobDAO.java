package dao;

import model.JobApplication;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JobDAO {

    public void addJob(JobApplication job) {
        String query = "INSERT INTO job_applications (company_name, role, status, applied_date, notes) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, job.getCompanyName());
            ps.setString(2, job.getRole());
            ps.setString(3, job.getStatus());
            ps.setDate(4, job.getAppliedDate());
            ps.setString(5, job.getNotes());

            ps.executeUpdate();
            System.out.println("Job added successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAllJobs() {
    	String query = "SELECT * FROM job_applications";

    	try (Connection conn = DBConnection.getConnection();
    		PreparedStatement ps = conn.prepareStatement(query);
    		ResultSet rs = ps.executeQuery()) {

    		while (rs.next()) {
    			System.out.println("ID: " + rs.getInt("id"));
    			System.out.println("Company: " + rs.getString("company_name"));
    			System.out.println("Role: " + rs.getString("role"));
    			System.out.println("Status: " + rs.getString("status"));
    			System.out.println("Date: " + rs.getDate("applied_date"));
    			System.out.println("Notes: " + rs.getString("notes"));
    			System.out.println("----------------------------");
    		}

    	} catch (Exception e) {
    		System.out.println("Error: " + e.getMessage());
    	}
    }
}