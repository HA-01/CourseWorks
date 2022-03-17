// Name   - W.A.L.H.N.Wickrama Arachchi
// IIT ID - 20200477
// UoW ID - w1830146

package com.company;

import java.io.Serializable;

abstract class Driver implements Serializable {
    private String Name;
    private String location;
    private String Team;

    private int NoOfFirstPositions=0;
    private int NoOfSecondPositions=0;
    private int NoOfThirdPositions=0;
    private int NoOfPoints=0;
    private int NoOfRaces=0;
    private int place=0;


    public Driver(String Name,String location,String Team){                                                      //driver class constructor
        this.Name=Name;
        this.location=location;
        this.Team=Team;
    }

    public abstract void calcPoints(int place);



    //------------------------------------------------------------getters--------------------------------------------------------------

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return location;
    }

    public String getTeam() {
        return Team;
    }

    public int getNoOfFirstPositions() {
        return NoOfFirstPositions;
    }

    public int getNoOfSecondPositions() {
        return NoOfSecondPositions;
    }

    public int getNoOfThirdPositions() {
        return NoOfThirdPositions;
    }

    public int getNoOfPoints() {
        return NoOfPoints;
    }

    public int getNoOfRaces() {
        return NoOfRaces;
    }

    public int getPlace(){
        return place;
    }

    //-----------------------------------------------------------setters------------------------------------------------------------------

    public void setName(String name) {
        Name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public void setNoOfFirstPositions(int noOfFirstPositions) {
        this.NoOfFirstPositions ++  ;                                            //to add 1 for the positions
    }

    public void setNoOfSecondPositions(int noOfSecondPositions) {
        this.NoOfSecondPositions ++;
    }

    public void setNoOfThirdPositions(int noOfThirdPositions) {
        this.NoOfThirdPositions ++;

    }

    public void setNoOfPoints(int noOfPoints) {
        NoOfPoints += noOfPoints;
    }

    public void setNoOfRaces(int noOfRaces) {
        NoOfRaces = noOfRaces;
    }

    public void setPlace(int place){

    }


}
