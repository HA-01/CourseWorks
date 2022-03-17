import java.io.*;
import java.util.Scanner;

public class VaccinationCenter extends Writer {
    static Booth[] boothObjects = new Booth[6];                                 //instantiating an array of Booth class
    private static int AddedVaccines;
    private static int vaccines=150;
    static String option;
    private static int boothNum;
    private static int numberOfPatients;
    private static int removedPatients;
    private static String firstName;
    private static String surName;
    private static String vaccineType;

    private static String fName;
    private static String sName;
    private static int age;
    private static String id;
    private static String city;

    static Scanner input=new Scanner(System.in);                               //scanner to input data

    public VaccinationCenter(String s) {
    }

    public static void main(String args[]) {
        boolean finished = true;                        //boolean flag

        initialise();                                   //initializing booths

        do {


            System.out.println("\r\n100 or VVB: View all Vaccination Booths\r\n" + "101 or VEB: View all Empty Booths\r\n"
                    + "102 or APB: Add Patient to a company.Booth\r\n" + "103 or RPB: Remove Patient from a company.Booth\r\n"
                    + "104 or VPS: View Patients Sorted in alphabetical order\r\n"
                    + "105 or SPD: Store Program Data into file\r\n" + "106 or LPD: Load Program Data from file\r\n"
                    + "107 or VRV: View Remaining Vaccinations\r\n" + "108 or AVS: Add Vaccinations to the Stock\r\n"
                    + "999 or EXIT: Exit the Program\r\n" + "");
            option = input.nextLine();


            switch (option) {
                case "100":
                case "VVB":
                    ViewAllVaccinationBooths();
                    break;
                case "101":
                case "VEB":
                    ViewAllEmptyBooths();
                    break;
                case "102":
                case "APB":
                    if (vaccines > 0) {
                        AddPatientToABooth();
                        vaccines--;

                    } else {
                        System.out.println("Vaccines out of stock");
                        AddPatientToABooth();
                    }
                    break;
                case "103":
                case "RPB":
                    RemovePatientFromABooth();
                    break;
                case "104":
                case "VPS":
                    ViewPatientsSortedInAlphabetical0rder();
                    break;
                case "105":
                case "SPD":
                    StoreProgramData();
                    break;
                case "106":
                case "LPD":
                    break;
                   //LoadProgramDataFromAFile();
                case "107":
                case "VRV":
                    ViewRemainingVaccinations();
                case "108":
                case "AVS":
                    AddVaccinationsToTheStock();
                    break;
                case "999":
                case "EXT":
                    finished = false;
                    System.out.println("Exit program");
                    break;

            }


        } while (finished);
    }


    //=========SET OF METHODS====================================================================================================================



    public static void initialise() {
        for (int x = 0; x < 6; x++)
        {
            boothObjects[x] = new Booth("e", 0);
            boothObjects[x].setFirstName("e");
            boothObjects[x].setSurName("e");
            boothObjects[x].setPatientAge(0);
            boothObjects[x].setNIC_or_passport_num("e");
            boothObjects[x].setCityOfThePatient("e");
        }

    }



    public static void validateBoothNumEntered(){
        boolean flagValidation=true;
        Scanner sc=new Scanner(System.in);
        int boothNum;
        System.out.println("Enter booth number:");
        boothNum=sc.nextInt();
        while(flagValidation){
            if(boothNum<7 && boothNum>-1) {

                System.out.println("Entered booth number is valid");
                flagValidation=false;

            }
            else
            {
                System.out.println("Enter a valid booth number between 0 and 5");
                flagValidation=true;

            }
        }
    }
    public static void ViewAllVaccinationBooths() {

        numberOfPatients=0;
        int i;
        for (i = 0; i <6; i++)
        {
            if (boothObjects[i].getFirstName().equals("e"))
            {
                System.out.println("Booth number " + i + " is empty.");
            }
            else
            {
                System.out.println("Booth number " + i + " is occupied by: "+ boothObjects[i].getFirstName() + ".");
                numberOfPatients=numberOfPatients+1;
            }

        }
        System.out.println("Current number of patients:"+numberOfPatients);
    }




    public static void ViewAllEmptyBooths()
    {
        int i;
        for (i = 0; i <6; i++)
        {
            if (boothObjects[i].getFirstName().equals("e"))
            {
                System.out.println("Booth number " + i + " is empty.");
            }
        }
    }




    public static void AddPatientToABooth() {

                    //Adding extra details
        System.out.println("Please enter the first name of the patient");
        fName = input.next();

        System.out.println("Please enter the Surname of the patient");
        sName = input.next();

        System.out.println("Please enter the city of the patient");
        city = input.next();

        System.out.println("Please enter the age of the patient");
        age = input.nextInt();

        System.out.println("Please enter the National Identity Card or Passport Number of the patient");
        id = input.next();


        System.out.println("==================Enter the vaccine type=========================" + "\n A for AstraZeneca\n S for Sinopharm\n P for Pfizer ");
        String vaccineType = input.next().toUpperCase();
        System.out.println("Selected type:"+ vaccineType);


        try {
            if (vaccineType.equals("A")) {
                if (boothObjects[0].getFirstName().equals("e")) {
                    addtobooth(0);
                    numberOfPatients++;
                } else if (boothObjects[1].getFirstName().equals("e")) {
                    addtobooth(1);
                    numberOfPatients++;
                } else {
                    System.out.println("Try another vaccine");
                }
            } else if (vaccineType.equals("S")) {
                if (boothObjects[2].getFirstName().equals("e")) {
                    addtobooth(2);
                    numberOfPatients++;
                } else if (boothObjects[3].getFirstName().equals("e")) {
                    addtobooth(3);
                    numberOfPatients++;
                } else {
                    System.out.println("Try another vaccine");
                }
            } else if (vaccineType.equals("P")) {
                if (boothObjects[4].getFirstName().equals("e")) {
                    addtobooth(4);
                    numberOfPatients++;
                } else if (boothObjects[5].getFirstName().equals("e")) {
                    addtobooth(5);
                    numberOfPatients++;
                } else {
                    System.out.println("Try another vaccine");
                }

            } else {
                System.out.println("All booths are filled");
            }

        } catch (Exception e) {
            System.out.println("Enter a valid Vaccine type");
        }


    }

    public static void addtobooth(int i)
                           //method to add patient details
    {
        boothObjects[i].setFirstName(fName) ;
        boothObjects[i].setSurName(sName);
        boothObjects[i].setCityOfThePatient(city);
        boothObjects[i].setPatientAge(age);
        boothObjects[i].setNIC_or_passport_num(id);
    }




    public static void RemovePatientFromABooth()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the booth want to remove");
        boothNum= input.nextInt();
        boothObjects[boothNum].setFirstName(" ");

        removedPatients++;
        System.out.println("Removed patients="+ removedPatients);
    }


    public static void ViewPatientsSortedInAlphabetical0rder()
    {

    }

    public static void StoreProgramData(){
        try{

            VaccinationCenter fstream = new VaccinationCenter(System.currentTimeMillis() + "out.txt");                 // Create file
            BufferedWriter out = new BufferedWriter(fstream);
            out.write( boothObjects[boothNum].getFirstName()+ "\nPatient Booth Number:"+ boothObjects[boothNum].getBoothNum());
            //Close the output stream
            out.close();
        }catch (Exception e){                                                    //Catch exception if any
            System.out.println("Error: " + e.getMessage());
        }
    }



    public static void LoadProgramDataFromAFile(){
    try {
            // Create f1 object of the file to read data
            File f1 = new File("D:FileOperationExample.txt");
            Scanner dataReader = new Scanner(f1);
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();
        } catch (FileNotFoundException exception) {                           //Catch exception if any
            System.out.println("Unexpected error occurred!");

        }
    }



    public static void ViewRemainingVaccinations(){
        System.out.println("Total patients:"+ numberOfPatients+ "\nremaining vaccines"+ (vaccines-numberOfPatients+AddedVaccines));
        if ((vaccines-numberOfPatients+AddedVaccines)==20){
            System.out.println("Only 20 vaccines left");
            AddVaccinationsToTheStock();
        }
    }


    public static void AddVaccinationsToTheStock()
    {

        System.out.println("Add vaccines ");
        Scanner input=new Scanner(System.in);

        System.out.print("added vaccines: ");
        AddedVaccines=input.nextInt();
        vaccines=vaccines + AddedVaccines;
        System.out.println("New Total vaccines:"+ vaccines);
    }


    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}
