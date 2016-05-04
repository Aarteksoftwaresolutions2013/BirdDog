package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class PersonalIndicators {
    public static final String FORECLOSURE = "Foreclosure";
    public static final String DIVORCE = "Divorce";
    public static final String RELOCATION = "Relocation";
    public static final String TIRED_LANDLORD = "Tired Landlord";

    public static List<String> personalIndicatorsList() {

        List<String> personalIndicatorsList = new ArrayList<String>();
        personalIndicatorsList.add(FORECLOSURE);
        personalIndicatorsList.add(DIVORCE);
        personalIndicatorsList.add(RELOCATION);
        personalIndicatorsList.add(TIRED_LANDLORD);

        return personalIndicatorsList;
    }
}
