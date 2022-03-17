// Name   - W.A.L.H.N.Wickrama Arachchi
// IIT ID - 20200477
// UoW ID - w1830146

package com.company;

import java.util.Comparator;

public class firstPlaceComparator implements Comparator<Fomula1Driver> {
    @Override
    public int compare(Fomula1Driver o1, Fomula1Driver o2) {

        if (o1.getNoOfFirstPositions() == o2.getNoOfFirstPositions())
            return 0;
        else if (o1.getNoOfFirstPositions() < o2.getNoOfFirstPositions())
            return 1;
        else
            return -1;

    }
}
