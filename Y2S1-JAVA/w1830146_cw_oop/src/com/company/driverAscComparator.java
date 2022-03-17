// Name   - W.A.L.H.N.Wickrama Arachchi
// IIT ID - 20200477
// UoW ID - w1830146

package com.company;

import java.util.Comparator;

public class driverAscComparator implements Comparator<Fomula1Driver>
{

    public int compare(Fomula1Driver f1,Fomula1Driver f2)
    {
        if(f1.getNoOfPoints()==f2.getNoOfPoints())
        {
            if (f1.getNoOfFirstPositions() > f2.getNoOfFirstPositions()) {
                return 1;
            } else
                return -1;

        }
        else if(f1.getNoOfPoints()>f2.getNoOfPoints())
        {
            return  1;
        }
        else
            return  -1;
    }
}

// https://www.javatpoint.com/Comparator-interface-in-collection-framework#:~:text=Java%20Comparator%20interface%20is%20used%20to%20order%20the,compare%20%28Object%20obj1%2CObject%20obj2%29%20and%20equals%20%28Object%20element%29.