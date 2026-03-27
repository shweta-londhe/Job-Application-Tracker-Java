package model;

import java.sql.Date;

public class JobApplication {
    private String companyName;
    private String role;
    private String status;
    private Date appliedDate;
    private String notes;

    public JobApplication(String companyName, String role, String status, Date appliedDate, String notes) {
        this.companyName = companyName;
        this.role = role;
        this.status = status;
        this.appliedDate = appliedDate;
        this.notes = notes;
    }

    public String getCompanyName() { return companyName; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
    public Date getAppliedDate() { return appliedDate; }
    public String getNotes() { return notes; }
}