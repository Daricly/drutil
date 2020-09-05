package model;

public class LeadModel {

    public int id;

    public String date;

    public double avg_lead_price;

    public double avg_was_bat_price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAvg_lead_price() {
        return avg_lead_price;
    }

    public void setAvg_lead_price(double avg_lead_price) {
        this.avg_lead_price = avg_lead_price;
    }

    public double getAvg_was_bat_price() {
        return avg_was_bat_price;
    }

    public void setAvg_was_bat_price(double avg_was_bat_price) {
        this.avg_was_bat_price = avg_was_bat_price;
    }
}
