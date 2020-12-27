package com.epam.example.jdbc.model;

public class Bus {
    private int id;
    private String number;
    private int issueYear;
    private int markId;
    private int colorId;

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public int getMarkId() {
        return markId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Override
    public String toString() {
        return "Bus " +
                "id = " + id +
                ", number = '" + number +
                ", issueYear = " + issueYear +
                ", markId = " + markId +
                ", colorId = " + colorId;
    }
}
