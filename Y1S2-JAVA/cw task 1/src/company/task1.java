package company;//import java.util.ArrayList;
//import java.util.Scanner;
import java.util.*;

public class task1 {
    private static String[] booths = new String[6];
    //private static String[] namesInBooths = new String[6];
    private static int vaccines = 21;
    private static int AddedVaccines;
    private static int numberOfPatients;
    static int boothNum;
    static int removedPatients = 0;

    //static boolean flagValidation=true;

    public static void main(String[] args) {

        boolean finished = true;                                         //creating a flag

        Scanner input = new Scanner(System.in);
        String option;

        int i = 0;
        for (i = 0; i < 6; i++) //Initializing booths array.
        {
            booths[i] = "";
        }

        do {
            System.out.println("\r\n100 or VVB: View all Vaccination Booths\r\n" + "101 or VEB: View all Empty Booths\r\n"
                    + "102 or APB: Add Patient to a Booth\r\n" + "103 or RPB: Remove Patient from a Booth\r\n"
                    + "104 or VPS: View Patients Sorted in alphabetical order\r\n"
                    + "105 or SPD: Store Program Data into file\r\n" + "106 or LPD: Load Program Data from file\r\n"
                    + "107 or VRV: View Remaining Vaccinations\r\n" + "108 or AVS: Add Vaccinations to the Stock\r\n"
                    + "999 or EXT: Exit the Program\r\n" + "" + "enter an option");

            option = input.nextLine();

            switch (option) {
                case "100":
                case "VVB":
                    ViewAllVaccinationBooths();
                    break;
                case "101":
                case "VEB":
                    //call vEB
                    ViewAllEmptyBooths();
                    break;
                case "102":
                case "APB":

                    if (vaccines > 0) {
                        AddPatientToABooth();
                        vaccines--;
                    } else {
                        System.out.println("No vaccines !");
                        AddPatientToABooth();
                    }
                    break;
                case "103":
                case "RPB":
                    RemovePatientFromABooth();
                    break;
                case "104":
                case "VPS":
                    //call vPS
                    ViewPatientsSortedInAlphabetical0rder();
                    break;
                case "105":
                case "SPD":
                    //call sPD
                    break;
                case "106":
                case "LPD":
                    //call lPD
                    break;
                case "107":
                case "VRV":
                    ViewRemainingVaccinations();
                    break;
                case "108":
                case "AVS":
                    AddVaccinationsToTheStock();
                    break;
                case "999":
                case "EXT":
                    finished = false;
                    //exit flag set to true, exiting program
                    System.out.println("Exiting program");
                    break;
            }
        } while (finished);


        /*   if (option == "100" || option == "VVB") {
                ViewAllVaccinationBooths();
            } else if (option == "101" || option == "VEB") {
                ViewAllEmptyBooths();
            } else if (option == "102" || option == "APB") {
                AddPatientToABooth();
                if (vaccines > 0) {
                    AddPatientToABooth();
                    vaccines--;
                } else {
                    System.out.println("No vaccines !");
                    AddPatientToABooth();
                }

            } else if (option == "103" || option == "RPB") {
                RemovePatientFromABooth();
            } else if (option == "104" || option == "VPS") {
                ViewPatientsSortedInAlphabetical0rder();
            } else if (option == "105" || option == "SPD") {

            } else if (option == "106" || option == "LPD") {

            } else if (option == "107" || option == "VRV") {
                ViewRemainingVaccinations();
            } else if (option == "108" || option == "AVS") {
                AddVaccinationsToTheStock();
            } else if (option == "999" || option == "EXIT") {
                finished = false;                                                         //exit flag set to true, exiting program
                System.out.println("Exiting program");

            }
        }
            while (finished) ;*/

    }

    private static void initialise(String booths[]) {
        for (int x = 0; x < 6; x++) booths[x] = " ";
    }

    public static void validateBoothNumEntered() {
        boolean flagValidation = true;
        Scanner sc = new Scanner(System.in);
        int boothNum;
        System.out.println("Enter booth number:");
        boothNum = sc.nextInt();
        while (flagValidation) {
            if (boothNum < 7 && boothNum > -1) {

                System.out.println("Entered booth number is valid");
                flagValidation = false;

            } else {
                System.out.println("Enter a valid booth number between 0 and 5");
                flagValidation = true;

            }
        }
    }


    public static void ViewAllVaccinationBooths() {
        //String[] booths = new String[6];
        //102
        numberOfPatients = 0;
        int i;
        for (i = 0; i < 6; i++) {
            if (booths[i].equals("")) {
                System.out.println("Booth number " + i + " is empty.");
            } else {
                System.out.println("Booth number " + i + " is occupied by: " + booths[i] + ".");
                numberOfPatients = numberOfPatients + 1;
            }

        }
        System.out.println("Current number of patients:" + numberOfPatients);
    }

    public static void ViewAllEmptyBooths() {
        int i;
        for (i = 0; i < 6; i++) {
            if (booths[i].equals("")) {
                System.out.println("Booth number " + i + " is empty.");
            }
        }
    }


    public static void AddPatientToABooth() {

        String name;
        String[] namesInBooths = new String[6];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number:");
        boothNum = input.nextInt();
        if (boothNum < 6 && boothNum > -1) {
            System.out.println("Please enter the name of the patient");
            input.nextLine();
            name = input.nextLine();
            booths[boothNum] = name;
            System.out.println(" ");
            System.out.println("Booth" + " " + boothNum + "is occupied by" + " " + name);

        //validateBoothNumEntered();
        //boothNum= input.nextLine();
        //String booths[]=new String[6];
        //System.out.println("Please enter the name of the patient");
        //name = input.nextLine();
        //booths[boothNum] = name;
        //System.out.println("Booth " + " " + boothNum + "is occupied by" + " " + name);

        }
        else{
        System.out.println("Enter a booth number between 0 and 5 please");

    }

}
    //patients.add(input.nextLine());
/*=========================================================================================================================
String name;
        String[] namesInBooths=new String[6];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number:");
        boothNum = input.nextInt();
        //try {
        if (boothNum < 6 && boothNum > -1) {
            System.out.println("Please enter the name of the patient");
            input.nextLine();
            name = input.nextLine();
            ////booths[boothNum] = String.valueOf(patients.add(name));
            booths[boothNum] = name;
            //namesInBooths[Integer.parseInt(name)]=input.nextLine();
            // store names in array
            System.out.println(" ");
            System.out.println("company.Booth" + " " + boothNum + "is occupied by" + " " + name);
        }

        //catch (Exception e) {
        else{
            System.out.println("Enter a booth number between 0 and 5 please");

        }



 */






    /*=====================================================================================
        //int boothNum;
    String name;
    String[] namesInBooths = new String[6];
    Scanner input = new Scanner(System.in);
    /////System.out.println("Enter the booth number:");
    /////boothNum = input.nextInt();
    //try {
    ////if (boothNum < 6 && boothNum > -1) {
        System.out.println("Please enter the name of the patient");
        input.nextLine();
        name = input.nextLine();
        ////booths[boothNum] = String.valueOf(patients.add(name));
                                                                           // store names in array
        //namesInBooths[Integer.parseInt(name)]=input.nextLine();


        System.out.println("Enter first name:");                           //additional information
        String firstName = input.nextLine();
        System.out.println("Enter last name:");
        String lastName = input.nextLine();


        System.out.println("Select vaccine type !" + "\nEnter A for AstraZeneca" + "\nEnter S for Sinopharm" + "\nEnter P for Pfizer");
        String typeOfVaccine = input.nextLine();
        String TYPE = typeOfVaccine.toUpperCase();
        if (TYPE == "A") {
            System.out.println("Add to booths 0 or 1");
            if (booths[0].equals(" ")) {
                boothNum=0;
                System.out.println("Booth" + " " + 0 + "is occupied by" + " " + booths[boothNum] );

            }else{
                boothNum=1;
                System.out.println("Booth" + " " + 1 + "is occupied by" + " " + booths[boothNum] );

            }

        } else if (TYPE == "B") {
            System.out.println("Add to booths 2 or 3");
            if (booths[2].equals(" ")) {
                boothNum=2;
                System.out.println("Booth" + " " + 2 + "is occupied by" + " " + booths[boothNum] );

            } else {
                boothNum=3;
                System.out.println("Booth" + " " + 3 +" "+ "is occupied by" + " " + booths[boothNum] );

            }
        } else {
            System.out.println("Add to booths 4 or 5");
            if (booths[4].equals(" ")) {
                boothNum=4;
                System.out.println("Booth" + " " + 4 +" "+ "is occupied by" + " " + booths[boothNum] );

            } else {
                boothNum=5;
                System.out.println("Booth" + " " + 5 + " "+ "is occupied by" + " " +booths[boothNum] );

            }
        }

}


     //catch (Exception e) {
    //else{
        //System.out.println("Enter a booth number between 0 and 5 please");






     */



    public static void RemovePatientFromABooth()
    {
        //int boothNum ;

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the booth want to remove");
        boothNum= input.nextInt();
        booths[boothNum] = "";

        removedPatients++;
        System.out.println("Removed patients="+ removedPatients);
    }

    public static void ViewPatientsSortedInAlphabetical0rder()
    {
        //booths[]
        //for(int i=0;i<6;i++){
            //namesInBooths[i].compareToIgnoreCase(namesInBooths[i+1]);
        }

        //Collections.sort(patients);                                          //order alphabatically
        //System.out.println("Patients in order of alphabet:" + patients);


    public static void ViewRemainingVaccinations()
    {
        //int numberOfPatients=0;

        /*for(int x=0;x<6;x++){
           if ((booths[boothNum]) != " ") {
               numberOfPatients++;

           }
       }
       System.out.println("Total patients currently:"+ numberOfPatients);*/
//int count=0;
               //int NumberOfPatients=patients.size();
        /*for(int x=0; x<6; x++){
            if(booths[x]!=" "){
                numberOfPatients=numberOfPatients+1;
            }
        }*/
        //numberOfPatients=count;
        ViewAllVaccinationBooths();
        System.out.println("Total patients:" + numberOfPatients+ "\nremaining vaccines:" + (vaccines-numberOfPatients+ AddedVaccines));
        if (21-numberOfPatients+ AddedVaccines==20){
            System.out.println("WARNING!Only 20 vaccines left");
        }
    }

    public static void AddVaccinationsToTheStock(){

            System.out.println("Add vaccines ");
            Scanner input=new Scanner(System.in);

            System.out.print("added vaccines: ");
            AddedVaccines=input.nextInt();
            vaccines=vaccines + AddedVaccines;
            System.out.println("New Total vaccines:"+ vaccines);
        }
    }


