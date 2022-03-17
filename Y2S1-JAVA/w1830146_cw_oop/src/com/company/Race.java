// Name   - W.A.L.H.N.Wickrama Arachchi
// IIT ID - 20200477
// UoW ID - w1830146


package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Race implements Serializable {
    private Date date;
    private ArrayList<Fomula1Driver> participatingDrivers = new ArrayList<>();
    private String [][] info;
    private int i=0;

    public Race(Date date,int n){
        this.date=date;
        this.info= new String[n][2];
    }


    public void addDriver(Fomula1Driver driver) {
        participatingDrivers.add(driver);

    }

    public void add(Race race) {
    }

    public Date getDate() {
        return date;
    }




    public ArrayList<Fomula1Driver> getParticipatingDrivers() {
        return participatingDrivers;
    }

    public void setInfo(String name,String place) {                                                                       //setter for info 2d array

        this.info[i][0] = name;
        this.info[i][1] = place;
        i++;
    }

    public String[][] getInfo() {                                                                                         //getter for info 2d array
        return info;
    }
}

