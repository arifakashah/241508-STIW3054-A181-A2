package com.assignment2;


public class Student {
    private String number;
    private String name;
    private String fideID;
    private String fed;
    private String rating;
    private String city;

    public Student() {
    }

    public String toString() {
        return String.format("%-5s %-70s %-15s %-15s %-7s %-35s %n", number, name, fideID, fed, rating, city);
    }

    public Student(String number, String name, String fideID, String fed, String rating, String city) {
        this.number = number;
        this.name = name;
        this.fideID = fideID;
        this.fed = fed;
        this.rating = rating;
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFideID() {
        return fideID;
    }

    public void setFideID(String fideID) {
        this.fideID = fideID;
    }

    public String getFed() {
        return fed;
    }

    public void setFed(String fed) {
        this.fed = fed;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}



