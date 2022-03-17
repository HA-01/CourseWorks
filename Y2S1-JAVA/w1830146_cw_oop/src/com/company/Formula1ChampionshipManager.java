// Name   - W.A.L.H.N.Wickrama Arachchi
// IIT ID - 20200477
// UoW ID - w1830146


package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager{
    public Race getRace;
    private ArrayList<Fomula1Driver> f1Drivers =new ArrayList<>();                  //arraylist from the class Fomula1Driver
    private ArrayList<Race> races= new ArrayList<Race>();                              //arraylist from the class Race
    private ArrayList <Fomula1Driver> participatingDrivers = new ArrayList<>();     //arraylist from the class Fomula1Driver

    static Scanner input=new Scanner(System.in);                                    //creating scanner object


    public ArrayList<Race> getRaces() {
        return races;
    }                              //getter for arraylist races



    public static void main(String[] args)  {

        boolean flag = true;

        Formula1ChampionshipManager obj= new Formula1ChampionshipManager();    //<<<<<<<<<<<<<<<<<<<< Formula1ChampionshipManager object to call methods


        while (flag = true) {
            System.out.println(" ");
            System.out.println(                                                         //to print the menu
                    "1-Create a new driver\n" +
                            "2-Delete a driver\n" +
                            "3-Change a driver\n" +
                            "4-Display statistics\n" +
                            "5-Display drivers in a table\n" +
                            "6-Add a race\n" +
                            "7-Save the file\n" +
                            "8-Load the file\n"+
                            "9-GUI table\n"+
                            "**--------------Enter your choice-----------**\n");
            int choice =input.nextInt();

            switch (choice) {
                case 1:
                    obj.createDriver();
                    break;
                case 2:
                    obj.deleteDriver();
                    break;
                case 3:
                    obj.changeDriver();
                    break;
                case 4:
                    obj.displayStat();
                    break;
                case 5:
                    obj.displayDriverTable();
                    break;
                case 6:
                    obj.addRace();
                    break;
                case 7:
                    obj.saveFile();
                    break;
                case 8:
                    obj.loadFile();
                    break;
                case 9:
                    GUI guiObject= new GUI(obj);                  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<object of FormulaChampionshipManager given as parameter to GUI class constructor
                    break;
                default:
                    System.out.println("enter a valid number");
                    flag = false;
                    break;
            }

        }


    }

    public ArrayList<Fomula1Driver> getF1Drivers() {                                                   //getter method to access the private arraylist
        return f1Drivers;
    }

    @Override
    public void createDriver(){
        System.out.print("enter driver name: ");
        String driverName = input.next();
        System.out.print("enter driver team: ");
        String driverTeam = input.next();
        System.out.print("enter driver location: ");
        String driverLocation = input.next();



        boolean flag1= true;
        for (Fomula1Driver temp : f1Drivers) {
            if(temp.getTeam().equals(driverTeam)) {
                flag1=false;
            }
        }
        if(flag1) {
            f1Drivers.add(new Fomula1Driver(driverName,driverLocation,driverTeam));                          //adding object to arraylist f1Drivers
            System.out.println("driver "+ driverName+ " is added to "+ driverTeam);
        }

    }

    @Override
    public void deleteDriver() {

        System.out.print("enter driver name: ");
        String driverName = input.next();
        System.out.print("enter driver team: ");
        String driverTeam = input.next();

        try {
            for (Fomula1Driver temp : f1Drivers) {

                if (temp.getName().equals(driverName) && temp.getTeam().equals(driverTeam)) {

                    f1Drivers.remove(temp);                                                                   //removing object from arraylist
                    System.out.println("driver " + temp.getName() + " in " + temp.getTeam() + " is removed");
                    break;
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeDriver () {

        try {

            System.out.print("Enter driver team you want to change the driver : ");
            String driverTeam = input.next();
            for (Driver temp : f1Drivers) {
                if (temp.getTeam().equals(driverTeam)) {
                    System.out.print("Enter driver name: ");
                    String driverName = input.next();
                    System.out.println("new driver name for the team " + driverTeam + " is " + driverName);
                    temp.setName(driverName);

                }

            }
        } catch (Exception a) {
            a.printStackTrace();                                                                             //print the error without stopping the programme
        }
    }

    @Override
    public void displayStat () {
        try {
            System.out.print("enter driver name: ");
            String driverName = input.next();
            System.out.print("enter driver team: ");
            String driverTeam = input.next();

            boolean flag6 = false;


            for (Fomula1Driver temp : f1Drivers) {
                if (temp.getName().equals(driverName)) {

                    if (temp.getTeam().equals(driverTeam)) {
                        System.out.println("name:" + temp.getName() + "\n" +
                                "team: " + temp.getTeam() + "\n" +
                                "location: " + temp.getLocation() + "\n" +
                                "NoOfFirstPositions: " + temp.getNoOfFirstPositions() + "\n" +
                                "NoOfThirdPositions: " + temp.getNoOfSecondPositions() + "\n" +
                                "NoOfThirdPositions: " + temp.getNoOfThirdPositions() + "\n"
                        );
                    } else
                        System.out.println("check the team and try again");
                    flag6 = true;
                }

            }
            if (flag6 = false)
                System.out.println("check the name and try again");
        } catch (Exception c) {
            c.printStackTrace();                                                          //print the error without stopping the programme
        }
    }


    @Override
    public void displayDriverTable () {
        try {


            Collections.sort(f1Drivers, new driverComparator());
            System.out.println("Driver name" + "\t\t" + "Driver team" + "\t\t\t\t" + "location" + "\t\t\t" + "No of first places" + "\t\t\t" +
                    "No of second places" + "\t\t\t" + "No of third places" + "\t\t\t" + "No of points" + "\t\t\t");
            for (Driver temp : f1Drivers) {

                System.out.println(temp.getName() + "\t\t\t\t\t\t" + temp.getTeam() + "\t\t\t\t\t" + temp.getLocation() + "\t\t\t\t\t\t" + temp.getNoOfFirstPositions()
                        + "\t\t\t\t\t\t\t" + temp.getNoOfSecondPositions() + "\t\t\t\t\t\t\t" + temp.getNoOfThirdPositions() + "\t\t\t\t\t\t" + temp.getNoOfPoints());
            }

        }catch (Exception b){
            b.printStackTrace();                                                            //print the error without stopping the programme
        }
    }



    @Override
    public void addRace (){
        System.out.print("enter race date in the format dd/MM/yyy: " );
        String raceDate=input.next();                                                 //create SimpleDateFormat object with the pattern(
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyy");         //(obtaiined via: https://www.javatpoint.com/java-string-to-date)

        Race race = null;                                                             //create Race object


        try {                                                                         //to handle parseException
            race = new Race(formatter.parse(raceDate),f1Drivers.size());
            races.add(race);                                                          //add race object to Races arraylist
        } catch (ParseException e) {
            e.printStackTrace();                                                       //print the error without stopping the programme
        }



        for (Fomula1Driver temp : f1Drivers) {
            System.out.print(temp.getName()+ " was in the race?"  );
            String inOrNot = input.next();

            if (inOrNot.equals("yes") )
            {


                System.out.print("enter the race position:");
                int place = input.nextInt();

                if (place == 1)
                {
                    temp.setNoOfFirstPositions(1);
                }
                else if (place == 2)
                {
                    temp.setNoOfSecondPositions(1);
                }
                else if (place == 3)
                {
                    temp.setNoOfThirdPositions(1);
                }

                temp.calcPoints(place);

                race.addDriver(temp);                                                //add to participating drivers  arraylist
                race.setInfo(temp.getName(), String.valueOf(place));                 //calling setInfo method in race class

            }

        }

    }

    @Override
    public void saveFile () {

        try {
            File hh = new File("saveFile.txt");
            hh.createNewFile();


            FileOutputStream saveFile = new FileOutputStream(hh);                  // Open a file to write to

            ObjectOutputStream save = new ObjectOutputStream(saveFile);            // Create an ObjectOutputStream to put objects into save file.


            save.writeObject(f1Drivers);                                            //write  objects
            save.writeObject(races);

            saveFile.close();
            save.close();

        }catch (IOException E){
            E.printStackTrace();                                                  //print the error without stopping the programme
        }

    }


    @Override
    public void loadFile()  {
        try{
            FileInputStream saveFile = new FileInputStream("saveFile.txt");
            ObjectInputStream restore = new ObjectInputStream(saveFile);

            f1Drivers = (ArrayList<Fomula1Driver>) restore.readObject();             //(CASTING into type arraylist)
            races= (ArrayList<Race>) restore.readObject();

        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();                                                 //print the error without stopping the programme
        }


    }

}
