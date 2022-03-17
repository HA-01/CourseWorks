// Name   - W.A.L.H.N.Wickrama Arachchi
// IIT ID - 20200477
// UoW ID - w1830146



package com.company;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class GUI extends JFrame {


    String[] tableColumnHeadings = {"NAME", "TEAM", "LOCATION", "FIRST POSITIONS", "SECOND POSITIONS", "THIRD POSITIONS", "POINTS"};           //array for column headings
    private String[][] data;                                                                                                                   //2d array for the j table

    JTable table;                                                                                           //table to view driver details in descending order of points
    JScrollPane scrollPane;                                                                                 //scroll pane to add Table
    JButton btn;                                                                                            //button to Sort according to points of drivers in ascending order
    JButton fPlaceSorter;                                                                                   //button to Sort in descending order of no of first places

    JButton newRace;                                                                                        //button to create random races
    JLabel dateLabel;                                                                                       //label to display date
    JTable randomTable;                                                                                     //label to display date
    JScrollPane scrollPane2;                                                                                //scroll pane to add randomTable
    JLabel dateOfRace;                                                                                      //label for the text"Date of the race"

    JButton winProbBtn;                                                                                     //button to select winning probabilities with starting point
    JLabel dateLabel2;                                                                                      //label to display date
    JTable randomTable2;                                                                                    //table to display name, place,start place
    JScrollPane scrollPane3;                                                                                //scroll pane to add randomTable2
    JLabel raceDate;                                                                                        //label to display date

    JButton viewRaces;                                                                                      //button to select the option view races
    JTable raceTable;                                                                                       //table to store race and number of participants
    JScrollPane scrollPane4;                                                                                //scroll pane to add raceTable

    JButton searchBtn;                                                                                      //button to search
    JTextField inputName;                                                                                   //label to enter name
    JTable showInfo;                                                                                        //table with date and place
    JScrollPane scrollPane5;                                                                                //scroll pane to add showInfo
    JLabel nameLable;                                                                                       //label to display name
    JLabel driverNameInTheCompetition;                                                                      //label to carry the string driver name


    public GUI(Formula1ChampionshipManager guiObject) {                                                         //GUI class constructor.Every method implemented inside the constructor



        //-------------------------------------------------------------------------TASK 3 POINT 1--------------------------------------------------------------------------------------------------------------------------------------

        data = new String[guiObject.getF1Drivers().size()][7];                                                  //2 D Array to store driver details
        Collections.sort(guiObject.getF1Drivers(), new driverComparator());                                     //ordering the rows in descending order of the points obtained by drivers
        createGuiTable(guiObject.getF1Drivers());                                                               //Calling of the method "createGuiTable"

        table = new JTable(data, tableColumnHeadings);                                                          //create JTable object
        table.setDefaultEditor(Object.class, null);                                                       //to avoid editing ability of the table
        table.setGridColor(Color.blue);                                                                         //calling the method to set grid border colors of the table to blue


        JTableHeader Header = table.getTableHeader();                                                          //create JTableHeader object and set colour
        Header.setBackground(Color.yellow);
        //(Obtained via: https://www.tutorialspoint.com/how-to-change-header-background-color-of-a-table-in-java )

        scrollPane = new JScrollPane(table);                                                                    //create scroll pane object and add table into a scroll pane

        scrollPane.setBounds(100, 100, 1000, 200);





        //----------------------------------------------------------------------TASK 3 POINT 2-----------------------------------------------------------------------------------------------------------------------------




        // sort drivers in ascending order of points

        btn = new JButton("Sort according to points of drivers in ascending order");
        btn.setBounds(100, 300, 550, 50);
        btn.setBackground(Color.black);                                                                         // set background of the button to black
        btn.setForeground(Color.white);                                                                         // set text colour into white
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));                                                // set font style and size
        // https://www.bing.com/videos/search?q=HOW+TO+CUREVE+THE+MARGIN+OF+A+BUTTON+IN+JAVA&docid=608030140802035526&mid=980CAF3BA5D546117635980CAF3BA5D546117635&view=detail&FORM=VIRE


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(guiObject.getF1Drivers(), new driverAscComparator());                          // ordering the rows in ascending order of the points obtained by drivers
                createGuiTable(guiObject.getF1Drivers());                                                       // calling method to fill the driver table
                table.repaint();                                                                                // to reload the changes into the table


            }
        });



        //--------------------------------------------------------------------TASK 3 POINT 3-------------------------------------------------------------------------------------------------------------------------------------------------------


        // sort drivers in descending order of their no of first places

        fPlaceSorter = new JButton("Sort in descending order of no of first places");                       // create JButton object
        fPlaceSorter.setBounds(700, 300, 400, 50);                                             // method to decide the position and size of the button
        fPlaceSorter.setBackground(Color.black);                                                                // set background of the button to black
        fPlaceSorter.setForeground(Color.white);                                                                // set foreground(text) into white
        fPlaceSorter.setFont(new Font("Tahoma", Font.BOLD, 16));                                       // set font style and size


        fPlaceSorter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(guiObject.getF1Drivers(), new firstPlaceComparator());                         // to Sort in descending order of no of first places
                createGuiTable(guiObject.getF1Drivers());                                                       // calling method to fill the driver table
                table.repaint();                                                                                // to reload the changes into the table

            }
        });


        //-----------------------------------------------------------TASK 3 POINT 4-------------------------------------------------------------------------------------------------------------------------------------------

        String[] columnRand = {"NAME", "PLACE"};                                                                // array to display topics name and place
        String[][] rowRand = new String[guiObject.getF1Drivers().size()][2];                                    // 2d array to enter values for name and random place


        // create random races and display
        dateLabel = new JLabel();                                                                               // label to display date

        dateOfRace = new JLabel("Date of the race:");                                                        // label for the text "Date of the race"
        dateOfRace.setBounds(1500, 300, 100, 50);                                                 // method to decide the position and size of the button

        newRace = new JButton("Create new race");                                                           // create button object
        newRace.setBackground(Color.blue);                                                                      // set background of the button to blue
        newRace.setForeground(Color.white);                                                                     // set foreground(text) into white
        newRace.setBounds(1200, 300, 250, 50);                                                 // method to decide the position and size of the button
        newRace.setFont(new Font("Tahoma", Font.BOLD, 14));


        newRace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {                                              // things to happen in button click are included in this method;update driver table,creating randomTable,filling the randomTable,setting text to dateLabel,adding new table to scrollPane2

                createGuiTable(guiObject.getF1Drivers());                                                        // to update the table
                table.repaint();                                                                                 // to reload the changes into the table

                String date = randomRace(guiObject.getF1Drivers(), guiObject.getRaces(), rowRand);               // calling the randomRace method to fill the 2d array and assigning its return value to a var called date

                dateLabel.setBounds(1600, 300, 100, 50);                                        // method to decide the position and size of the label
                dateLabel.setBackground(Color.DARK_GRAY);
                dateLabel.setText(date);                                                                         // set date into label

                randomTable = new JTable(rowRand, columnRand);                                                   // crete new table to display name and randomly generated position(created in button click)
                randomTable.setDefaultEditor(Object.class, null);                                          // to avoid editing ability of the table
                randomTable.setGridColor(Color.blue);                                                            // calling the method to set grid border colors of the table to blue

                JTableHeader tableHeader = randomTable.getTableHeader();                                         //create JTableHeader object and set colour
                tableHeader.setBackground(Color.yellow);

                scrollPane2 = new JScrollPane(randomTable);                                                      // create scroll pane object (to appear table when clicked)
                scrollPane2.setBounds(1200, 100, 600, 200);                                    // method to decide the position and size of the scroll pane
                add(scrollPane2);


            }

        });
        add(dateLabel);



        //---------------------------------------------------------TASK 3 POINT 5----------------------------------------------------------------------------------------------------------------------------------------------------------


        String[] columnStart = {"NAME", "PLACE IN RACE", "START PLACE"};
        String[][] rowStart = new String[guiObject.getF1Drivers().size()][3];                                 // 2d array to enter values for name and random place

        dateLabel2 = new JLabel();                                                                              //create JLabel object

        raceDate = new JLabel("Date of the race: ");                                                       //create JLabel object
        raceDate.setBounds(1300, 600, 100, 50);                                                  // method to decide the position and size of the label

        //button to create races where starting places decide the probability of winning

        winProbBtn = new JButton("Create new race with random winning possibility");
        winProbBtn.setBackground(Color.blue);                                                                 // set background of the button to blue
        winProbBtn.setForeground(Color.white);                                                                // set foreground(text) into white
        winProbBtn.setBounds(1300, 500, 500, 50);                                            // method to decide the position and size of the button
        winProbBtn.setFont(new Font("Tahoma", Font.BOLD, 16));                                       // method to decide the font and size


        winProbBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String date = randomRace2(guiObject.getF1Drivers(), guiObject.getRaces(), rowStart);            //calling randomRace2 method and assigning its return value into date

                dateLabel2.setText(date);                                                                       //set date into dateLabel2

                randomTable2 = new JTable(rowStart, columnStart);                                               //crete new table to display name and randomly generated position(created in button click)
                randomTable2.setDefaultEditor(Object.class, null);                                        //to avoid editing ability of the table
                randomTable2.setGridColor(Color.blue);                                                          //calling the method to set grid border colors of the table to blue
                JTableHeader tableHeader = randomTable2.getTableHeader();                                       //create JTableHeader object and set colour
                tableHeader.setBackground(Color.yellow);

                createGuiTable(guiObject.getF1Drivers());                                                       //to update the table
                table.repaint();

                scrollPane3 = new JScrollPane(randomTable2);                                                    // shift table into scroll pane
                scrollPane3.setBounds(1300, 700, 500, 200);                                    // method to decide the position and size of the scroll pane
                add(scrollPane3);                                                                               //add scrollPane3 into JFrame
            }
        });
        add(dateLabel2);                                                                                        //add scrollPane2 into JFrame
        dateLabel2.setBounds(1400, 600, 100, 50);                                              // method to decide the position and size of the scroll pane





        //-------------------------------------------------------------------TASK 3 POINT 6-------------------------------------------------------------------------------------------------------------------------------------------------


        String[] columnRaces = {"DATE", "NO OF PARTICIPANTS"};                                                  //array to store date and number of participants for the table raceTable


        viewRaces = new JButton("View races in ascending order of dates");
        viewRaces.setBackground(Color.blue);
        viewRaces.setForeground(Color.white);
        viewRaces.setBounds(100, 500, 500, 50);
        viewRaces.setFont(new Font("Tahoma", Font.BOLD, 16));


        viewRaces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Collections.sort(guiObject.getRaces(), new DateComparator());                                   //method to order races in descending order of dates
                String[][] rowRaces = new String[guiObject.getRaces().size()][2];                               //2D array to fill the table raceTable
                displayRacesByDate(guiObject, rowRaces);                                                        //calling method to fill the table

                raceTable = new JTable(rowRaces, columnRaces);
                raceTable.setDefaultEditor(Object.class, null);
                raceTable.setGridColor(Color.blue);

                JTableHeader tableHeader = raceTable.getTableHeader();                                          //set color to table headings
                tableHeader.setBackground(Color.yellow);

                scrollPane4 = new JScrollPane(raceTable);
                scrollPane4.setBounds(100, 600, 500, 300);
                add(scrollPane4);

            }
        });



        //-----------------------------------------TASK 3 POINT 7--------------------------------------------------------------------------------------------------------------------------------------------------------------

        nameLable = new JLabel();
        nameLable.setBounds(900, 600, 150, 50);


        inputName = new JTextField();
        inputName.setBounds(1100, 500, 50, 50);                                                //text field to input name
        inputName.setHorizontalAlignment(JLabel.CENTER);
        //(obtained from: https://www.bing.com/videos/search?q=how+to+curve+the+borders+of+buttons+in+java+swing&docid=608013218636049537&mid=496C9E0D2E663CF7FFD6496C9E0D2E663CF7FFD6&view=detail&FORM=VIRE )

        driverNameInTheCompetition = new JLabel("Name of the driver:");                                     //label to display driver's name
        driverNameInTheCompetition.setBounds(700, 600, 200, 50);


        searchBtn = new JButton("Search for all the races participated");
        searchBtn.setBounds(700, 500, 400, 50);
        searchBtn.setBackground(Color.blue);
        searchBtn.setForeground(Color.white);
        searchBtn.setFont(new Font("Tahoma", Font.BOLD, 16));

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] infoColumns = {"DATE", "PLACE"};                                                          //Arraylist for table columns
                String[][] infoRows = new String[guiObject.getRaces().size()][2];                                  //2d array to store table rows

                nameLable.setText(inputName.getText());                                                            //set the name of the textfield into the label
                displayInfo(inputName.getText(), guiObject.getRaces(), infoRows);


                showInfo = new JTable(infoRows, infoColumns);                                                       //fill the table
                showInfo.setDefaultEditor(Object.class, null);
                showInfo.setGridColor(Color.blue);
                JTableHeader tableHeader = showInfo.getTableHeader();                                                //set color to table headings
                tableHeader.setBackground(Color.yellow);

                scrollPane5 = new JScrollPane(showInfo);
                scrollPane5.setBounds(700, 700, 500, 200);
                add(scrollPane5);


            }
        });


        add(scrollPane);                            //scroll pane to view the driver Table
        add(btn);                                   //button to Sort according to points of drivers in ascending order
        add(fPlaceSorter);                          //button to Sort in descending order of no of first places
        add(newRace);                               //button to create new race
        add(winProbBtn);                            //button to create new race with random winning possibility
        add(viewRaces);                             //button to View races in descending order of dates
        add(searchBtn);                             //button to Search for all the races a given driver participated
        add(inputName);                             //text field to input name
        add(nameLable);                             //label to display name
        add(driverNameInTheCompetition);            //label to display driver names
        add(raceDate);                              //label to carry race date
        add(dateOfRace);                            //label to display race date



        setTitle("GUI");                                                        //jframe creation
        setBounds(100, 200, 800, 500);
        setLayout(null);
        setVisible(true);                                                       //mandatory to make the frame visible
        setDefaultCloseOperation(EXIT_ON_CLOSE);                                //set on close facility

    }



    public void createGuiTable(ArrayList<Fomula1Driver> f1Drivers) {                     //method to fill the table with driver details

        int i = 0;
        for (Fomula1Driver temp : f1Drivers) {
            data[i][0] = temp.getName();
            data[i][1] = temp.getTeam();
            data[i][2] = temp.getLocation();
            data[i][3] = String.valueOf(temp.getNoOfFirstPositions());
            data[i][4] = String.valueOf(temp.getNoOfSecondPositions());
            data[i][5] = String.valueOf(temp.getNoOfThirdPositions());
            data[i][6] = String.valueOf(temp.getNoOfPoints());
            i++;

        }

    }


    public String randomRace(ArrayList<Fomula1Driver> f1Drivers, ArrayList<Race> races, String[][] rowRand) {

        ArrayList<Integer> validityChecker = new ArrayList<>();                         //arraylist to store random positions

        //creating a random date

        int month = (int) (Math.random() * 12) + 1;                                     //randomly generate month

        Calendar calendar = Calendar.getInstance();                                     //creating calender object
        calendar.set(2021, month, 0);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);                           //return the days of a generated month

        int day = (int) (Math.random() * dayOfMonth) + 1;                               //creating a random date within maximum no.of days for a month and 1

        String dateFormatted = (day + "/" + month + "/" + 2021);                        //formatted date


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");          //create SimpleDateFormat object with the pattern(https://www.javatpoint.com/java-string-to-date)
        //random date created


        Date date = null;
        try {                                                                           //to handle parseException
            date = formatter.parse(dateFormatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Race race = new Race(date, f1Drivers.size());
        races.add(race);                                                                //add race object to races arraylist


        int j = 0;
        for (Fomula1Driver temp : f1Drivers) {

            int randomPlace;
            race.addDriver(temp);                                                       //add driver

            while (true) {                                                              //check whether the first random number is in validityChecker array
                randomPlace = (int) (Math.random() * f1Drivers.size()) + 1;
                if (validityChecker.isEmpty()) {
                    validityChecker.add(randomPlace);
                    break;
                } else if (!validityChecker.contains(randomPlace)) {
                    validityChecker.add(randomPlace);
                    break;

                }

            }
            if (randomPlace == 1) {
                temp.setNoOfFirstPositions(1);
            } else if (randomPlace == 2) {
                temp.setNoOfSecondPositions(1);
            } else if (randomPlace == 3) {
                temp.setNoOfThirdPositions(1);
            }
            temp.setPlace(randomPlace);
            temp.calcPoints(randomPlace);                                               //assign points
            race.setInfo(temp.getName(), String.valueOf(randomPlace));                  //calling setInfo method in race class


            rowRand[j][0] = temp.getName();
            rowRand[j][1] = String.valueOf(randomPlace);
            j++;


        }
        return dateFormatted;
    }


    private String randomRace2(ArrayList<Fomula1Driver> f1Drivers, ArrayList<Race> races, String[][] rowStart) {

        System.out.println(f1Drivers.size());
        ArrayList<Integer> Checker = new ArrayList<>();                                            //arraylist to store random positions
        boolean wonOrNot;
        int place;
        int random;
        boolean gotFirstPosition = false;                                                          //Since this programme is made for one season of the championship year was not generated as a random.


        //creating a random date

        int month = (int) (Math.random() * 12) + 1;                                                //randomly generate a month

        Calendar calendar = Calendar.getInstance();                                                //creating calender object
        calendar.set(2021, month, 0);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);                                      //return the days of a generated month

        int day = (int) (Math.random() * dayOfMonth) + 1;                                          //creating a random date within maximum no.of days for a month and 1

        String dateFormatted = (day + "/" + month + "/" + 2021);                                    //formatted date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
                                                                        //create SimpleDateFormat object with the pattern(https://www.javatpoint.com/java-string-to-date)
        //random date created


        Date date = null;

        try {                                                                                      //to handle parseException
            date = formatter.parse(dateFormatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Race race = new Race(date, f1Drivers.size());
        races.add(race);                                                                           //add race object to races arraylist
        Collections.shuffle(f1Drivers);                                                            //Getting random starting positions by shuffling the drivers

        int x = 0;
        for (Fomula1Driver temp : f1Drivers) {
            race.addDriver(temp);


            int start = f1Drivers.indexOf(temp) + 1;                                                //starting position = index of the shuffled races

            while (true) {                                                                          //to assign winning prob according to starting place

                random = (int) (Math.random() * 100) + 1;
                wonOrNot = false;

                if (start == 1) {
                    if (random >= 1 && random <= 40) {
                        wonOrNot = true;
                    }
                } else if (start == 2) {
                    if (random >= 40 && random <= 70) {
                        wonOrNot = true;
                    }
                } else if (start == 3 || start == 4) {
                    if (random >= 70 && random <= 80) {
                        wonOrNot = true;
                    }
                } else if (start >= 5 && start < 9) {
                    if (random == 100 || random == 99) {
                        wonOrNot = true;
                    }

                } else if (start == 9) {
                    wonOrNot = true;

                }
                if (wonOrNot && !gotFirstPosition || (f1Drivers.size() < 9 && start == f1Drivers.size() - 1 && !gotFirstPosition) || f1Drivers.size() == 1) {

                    place = 1;
                    gotFirstPosition = true;
                } else {

                    place = (int) (Math.random() * f1Drivers.size() - 1) + 2;
                    System.out.println(place);
                }
                //winning prob assigned


                if (Checker.isEmpty()) {
                    Checker.add(place);
                    break;
                } else if (!Checker.contains(place)) {
                    Checker.add(place);
                    break;
                }

            }
            temp.calcPoints(place);                                                                                               //assign points


            if (place == 1) {                                                                                                     //incrementing the number of positions  according to place
                temp.setNoOfFirstPositions(1);
            } else if (place == 2) {
                temp.setNoOfSecondPositions(1);
            } else if (place == 3) {
                temp.setNoOfThirdPositions(1);
            }
            temp.setPlace(place);

            race.setInfo(temp.getName(), String.valueOf(place));                                                                  //calling setInfo method in race class

            rowStart[x][0] = temp.getName();                                                                                      //method to fill the name,place and starting place of the table
            rowStart[x][1] = String.valueOf(place);
            rowStart[x][2] = String.valueOf(start);
            x++;
        }
        return dateFormatted;

    }





    public void displayRacesByDate(Formula1ChampionshipManager guiObject, String[][] rowRaces) {                                  //method to display races with dates
        int y = 0;
        for (Race temp : guiObject.getRaces()) {
            rowRaces[y][0] = String.valueOf(temp.getDate()).substring(0, 10) + " 2021";                                            //substrings used to seperate string parts
            rowRaces[y][1] = String.valueOf(temp.getParticipatingDrivers().size());
            y++;
        }
    }




    public void displayInfo(String name, ArrayList<Race> races, String[][] data) {
        int i = 0;
        for (Race temp : races) {                                                                                                 //selecting one race from races arraylist
            for (String[] temp2 : temp.getInfo()) {                                                                               //selecting the 2d arraylist for the selected object
                if (temp2[0] != null && temp2[0].equals(name)) {
                    data[i][0] = String.valueOf(temp.getDate()).substring(0, 10) + " 2021";
                    data[i][1] = temp2[1];

                    break;
                }

            }
            i++;
        }
    }
}


