package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class PropertyType {
    public static final String SINGLE_FAMILY_RESIDENCE = "SFR (Single Family Residence)";
    public static final String MULTI_FAMILY = "(MF) Multi-Family 1-4 units";
    public static final String APARTMENT = "(AP)Apartment";
    public static final String CONDO = "(C) Condo";
    public static final String TOWNHOUSE = "(TH) Townhouse";
    public static final String MOBILE_HOME = "(MH) Mobile Home";
    public static final String VACANT_LOT = "(VL) Vacant Lot";

    public static List<String> propertyType() {

        List<String> propertyType = new ArrayList<String>();
        propertyType.add(SINGLE_FAMILY_RESIDENCE);
        propertyType.add(MULTI_FAMILY);
        propertyType.add(APARTMENT);
        propertyType.add(CONDO);
        propertyType.add(TOWNHOUSE);
        propertyType.add(MOBILE_HOME);
        propertyType.add(VACANT_LOT);

        return propertyType;
    }

}
