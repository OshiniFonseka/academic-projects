package oopcw;

import java.util.Date;

public class Consultation {
    private Date consulatationDate;
    private int consultationTime;
    private double cost;
    private String notes;
    
    //creating getters and setters
    public void setConsulatationDate(Date consulatationDate) {
        this.consulatationDate = consulatationDate;
    }

    public Date getConsulatationDate() {
        return consulatationDate;
    }

    public void setConsultationTime(int consultationTime) {
        this.consultationTime = consultationTime;
    }

    public int getConsultationTime() {
        return consultationTime;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
    
}