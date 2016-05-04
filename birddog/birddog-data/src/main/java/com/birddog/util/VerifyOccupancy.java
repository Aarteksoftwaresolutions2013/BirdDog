package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class VerifyOccupancy {
    public static final String OWNER_OCCUPIED = "Owner Occupied";
    public static final String VACANT = "Vacant";
    public static final String RENTAL = "Rental";

    public static List<String> verifyOccupancy() {

        List<String> verifyOccupancyList = new ArrayList<String>();
        verifyOccupancyList.add(OWNER_OCCUPIED);
        verifyOccupancyList.add(VACANT);
        verifyOccupancyList.add(RENTAL);

        return verifyOccupancyList;
    }
}
