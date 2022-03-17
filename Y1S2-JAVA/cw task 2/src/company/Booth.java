package company;


public class Booth {


    private String name;
    private  int boothNum;




    public Booth(String  name,int boothNum) {                                     //constructor
        this.name = name;
        this.boothNum= boothNum;


    }


    public String getName() {                                                     //getters and setters
        return name;
    }
    public  void setName(String name) {
        this.name = name;
    }

    public  int getBoothNum() {
        return boothNum;
    }
    public  void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }









}

