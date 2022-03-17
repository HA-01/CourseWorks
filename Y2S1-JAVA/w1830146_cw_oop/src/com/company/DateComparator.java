// Name   - W.A.L.H.N.Wickrama Arachchi
// IIT ID - 20200477
// UoW ID - w1830146

package com.company;

import java.util.Comparator;

public class DateComparator implements Comparator<Race> {
    @Override
    public int compare(Race r1, Race r2) {
        if(r1.getDate().compareTo(r2.getDate())==0) {
            return 0;
        }else if(r1.getDate().compareTo(r2.getDate()) > 0) {
            return 1;
        }else{
            return -1;
        }
    }
}

//(obtained via: https://www.javatpoint.com/how-to-compare-dates-in-java )