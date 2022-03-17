public class Booth extends Patient{

    private  int boothNum;
    private String vaccineType;



    public Booth(String vaccineType,int boothNum) {                                     //constructor
        this.vaccineType = vaccineType;
        this.boothNum= boothNum;
    }


    public  int getBoothNum() {                                                        //getters and setters
        return boothNum;
    }

    public  void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }
}




