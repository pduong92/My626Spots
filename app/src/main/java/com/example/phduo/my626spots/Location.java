package com.example.phduo.my626spots;

import android.util.Log;

import java.net.URL;

/**
 * Created by phduo on 3/12/2017.
 */

public class Location {

    private String name;
    private String street;
    private String city;
    private String state;
    private int zipcode;
    private String number;
    private double[][] bussinessHours;
    private URL site;
    private int imageID;

    private final int NOIMAGE = 0;


    public Location(String name, String street, String city, String state, int zipcode, String number) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.number = number;
        this.bussinessHours = new double[7][2];

        //For Test Purposes
        for(int i = 0; i < this.bussinessHours.length; i++) {
            if(i == 0 || i == 6) {
                this.bussinessHours[i][0] = 12;
                this.bussinessHours[i][1] = 20;
            }
            else {
                this.bussinessHours[i][0] = 9.5;
                this.bussinessHours[i][1] = 22;
            }
        }

        this.site = null;
        this.imageID = NOIMAGE;

    }

    public Location(String name, String street, String city, String state, String zipcode, String number) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = Integer.parseInt(zipcode);
        this.number = number;
        this.bussinessHours = new double[7][2];

        //For Test Purposes
        for(int i = 0; i < this.bussinessHours.length; i++) {
            if(i == 0 || i == 6) {
                this.bussinessHours[i][0] = 12;
                this.bussinessHours[i][1] = 20;
            }
            else {
                this.bussinessHours[i][0] = 9.5;
                this.bussinessHours[i][1] = 22;
            }
        }

        this.site = null;
        this.imageID = NOIMAGE;

    }

    public Location(String name, String street, String city, String state, int zipcode, String number, double[][] hours, URL site, int imageID) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.number = number;
        this.bussinessHours = hours;
        this.site = site;
        this.imageID = imageID;
    }

    public void updateHours(String day, double open, double close) {
        day = day.toUpperCase();

        switch(day) {
            case "SUNDAY":
                bussinessHours[0][0] = open;
                bussinessHours[0][1] = close;
                break;
            case "MONDAY":
                bussinessHours[1][0] = open;
                bussinessHours[1][1] = close;
                break;
            case "TUESDAY":
                bussinessHours[2][0] = open;
                bussinessHours[2][1] = close;
                break;
            case "WEDNESDAY":
                bussinessHours[3][0] = open;
                bussinessHours[3][1] = close;
                break;
            case "THURSDAY":
                bussinessHours[4][0] = open;
                bussinessHours[4][1] = close;
                break;
            case "FRIDAY":
                bussinessHours[5][0] = open;
                bussinessHours[5][1] = close;
                break;
            case "SATURDAY":
                bussinessHours[6][0] = open;
                bussinessHours[6][0] = close;
                break;
            default:
                Log.e("updateHours() METHOD", "Invalid day entered.");
        }
    }

    public void updateHours(int day, double open, double close) {
        if(day < 0 || day > 6)
            Log.e("getOpenHours() METHOD", "Invalid day value entered.");
        else {
            bussinessHours[day][0] = open;
            bussinessHours[day][1] = close;
        }
    }

    public void updateHours(double[][] newhours) {
        bussinessHours = newhours;
    }

    public void updateURL(URL urlsite) {
        site = urlsite;
    }

    public void updateImageID(int newImageID) {
        imageID = newImageID;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getAddress() {
        return street + ", " + city + ", " + state + " " + zipcode;
    }

    public String getAddressStreet() { return street; }

    public String getAddressCity() { return city + ", " + state + " " + zipcode; }

    public String getNumber() {
        return "(" + number.substring(0, 3) + ") " + number.substring(3);
    }

    //OC paramenter is whether close or open, 0 for open, 1 for close
    public String getHours(int day, int OC) {
        String hours = null;

        if(day < 0 || day > 6)
            Log.e("getOpenHours() METHOD", "Invalid day value entered.");
        else{
            String period;
            double time = bussinessHours[day][OC];
            double mins = time%1;
            double hrs = time = mins;
            mins = 60*mins;
            if(hrs >= 12) {
                hrs = hrs - 12;
                period = "PM";
                if(hrs  == 0) {
                    hrs = 12;
                }
            }
            else
                period = "AM";

            hours = hrs + ":" + mins + " " + period;
        }
        return hours;
    }

    public URL getSite() {
        return site;
    }

    public int getImageID() {
        return imageID;
    }

    //To check if the location has an image
    public boolean hasImage() {
        if(imageID == NOIMAGE)
            return false;
        else
            return true;
    }
}
