import java.util.Scanner;

public class task1extended {
    private static String[] booths = new String[6];
    private static int boothNum;
    private String name=" ";
    private static int numberOfPatients;
    private static int vaccines = 150;
    private static int AddedVaccines;
    static int removedPatients=0;
    static String option;

    public static void main(String args[]) {
        boolean finished = false;
        String name;
        String option = null;


        //==================================================================================================================================//
        do {

            Scanner input = new Scanner(System.in);

            System.out.println("\r\n100 or VVB: View all Vaccination Booths\r\n" + "101 or VEB: View all Empty Booths\r\n"
                    + "102 or APB: Add Patient to a company.Booth\r\n" + "103 or RPB: Remove Patient from a company.Booth\r\n"
                    + "104 or VPS: View Patients Sorted in alphabetical order\r\n"
                    + "105 or SPD: Store Program Data into file\r\n" + "106 or LPD: Load Program Data from file\r\n"
                    + "107 or VRV: View Remaining Vaccinations\r\n" + "108 or AVS: Add Vaccinations to the Stock\r\n"
                    + "999 or EXIT: Exit the Program\r\n" + "");
            option = input.nextLine();
            switch(option) {
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
                    break;
                case "106":
                case "LPD":
                    break;
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

        } while (finished = true);
    }




    //private static ArrayList<String> patients=new ArrayList<String>();
    //private static int vaccines = 150;

    private  void initialise(String booths[]) {
        for (int x = 0; x < 6; x++) booths[x] = " ";
    }

    public  void validateBoothNumEntered(){
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
        //String[] booths = new String[6];
        //102
        numberOfPatients=0;
        int i;
        for (i = 0; i <6; i++)
        {
            if (booths[i].equals(""))
            {
                System.out.println("Booth number " + i + " is empty.");
            }
            else
            {
                System.out.println("Booth number " + i + " is occupied by: "+ booths[i] + ".");
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
            if (booths[i].equals(""))
            {
                System.out.println("Booth number " + i + " is empty.");
            }
        }
    }




    public static void AddPatientToABooth()
    {
        Scanner input=new Scanner(System.in);                                           //Adding extra details
        System.out.println("Please enter the first name of the patient");
        String firstName=input.nextLine();
        System.out.println("Please enter the Surname of the patient");
        String Surname=input.nextLine();
        System.out.println("==================Enter the vaccine type========================="+"\n A for AstraZeneca\n S for Sinopharm\n P for Pfizer ");

        String typeOfVaccine=input.nextLine();
        String vaccineType=typeOfVaccine.toUpperCase();
        input.nextLine();

        try {
            if (vaccineType.equals("A"))
            {
                if (booths[0].equals(" ")) {
                    booths[0] = firstName;
                } else if (booths[1].equals(" ")) {
                    booths[1] = firstName;
                } else {
                    System.out.println("Try another vaccine");
                }
            }
            else if (vaccineType.equals("S"))
            {
                if (booths[2].equals(" ")) {
                    booths[2] = firstName;
                } else if (booths[3].equals(" "))
                {
                    booths[3] = firstName;
                } else
                {
                    System.out.println("Try another vaccine");
                }

            }
            else if (vaccineType.equals("P"))
            {
                if (booths[4].equals(" ")) {
                    booths[4] = firstName;
                } else if (booths[5].equals(" ")) {
                    booths[5] = firstName;
                } else {
                    System.out.println("Try another vaccine");
                }
            } else
            {
                System.out.println("All booths are filled");
            }

        }
        catch (Exception e)
        {
            System.out.println("Enter a valid Vaccine type");
        }


    }


    public static void RemovePatientFromABooth()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the booth want to remove");
        boothNum= input.nextInt();
        booths[boothNum] = "";

        removedPatients++;
        System.out.println("Removed p102" +
                "atients="+ removedPatients);
    }

    public static void ViewPatientsSortedInAlphabetical0rder()
    {

        //Collections.sort(patients);                                          //order alphabatically
        //System.out.println("Patients in order of alphabet:" + patients);
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


}


