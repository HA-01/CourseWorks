// Name   - W.A.L.H.N.Wickrama Arachchi
// IIT ID - 20200477
// UoW ID - w1830146

package com.company;

public class Fomula1Driver extends Driver{

    public Fomula1Driver(String Name, String location, String Team) {
        super(Name, location, Team);
    }

    @Override
    public void calcPoints(int place) {
        switch (place){
            case 1:
                super.setNoOfPoints(25);
                break;
            case 2:
                super.setNoOfPoints(18);
                break;
            case 3:
                super.setNoOfPoints(15);
                break;
            case 4:
                super.setNoOfPoints(12);
                break;
            case 5:
                super.setNoOfPoints(10);
                break;
            case 6:
                super.setNoOfPoints(8);
                break;
            case 7:
                super.setNoOfPoints(6);
                break;
            case 8:
                super.setNoOfPoints(4);
                break;
            case 9:
                super.setNoOfPoints(2);
                break;
            case 10:
                super.setNoOfPoints(1);
            default:
        }




    }

}
