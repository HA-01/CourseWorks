public class Booth extends Patient{

    private  int boothNum;
    private String firstname;



    public Booth(String  firstname,int boothNum) {                                     //constructor
        this.firstname = firstname;
        this.boothNum= boothNum;
    }


    public  int getBoothNum() {                                                        //getters and setters
        return boothNum;
    }
    public  void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }


}
