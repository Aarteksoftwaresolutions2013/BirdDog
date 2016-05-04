package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class SellerMotivation {

    public static final String DOWNSIZING = "Downsizing";

    public static final String FORECLOSURE = "Foreclosure";

    public static final String DEATH_PROBATE_INHERITANCE = "Death/Probate/Inheritance";

    public static final String DIVORCE = "Divorce";

    public static final String RELOCATION = "Relocation";

    public static final String EXCESSIVE_REPAIRS = "Excessive Repairs";

    public static final String TIRED_LANDLORD = "Tired Landlord";

    public static final String EVICTION = "Eviction";

    public static final String NEED_CASH = "Need Cash Quick/Financial";

    public static final String EXPIREED_LISTING = "Expired Listing";

    public static List<String> sellerMotivation() {

        List<String> sellerMotivationList = new ArrayList<String>();
        sellerMotivationList.add(DOWNSIZING);
        sellerMotivationList.add(FORECLOSURE);
        sellerMotivationList.add(RELOCATION);
        sellerMotivationList.add(DIVORCE);
        sellerMotivationList.add(DEATH_PROBATE_INHERITANCE);
        sellerMotivationList.add(EXCESSIVE_REPAIRS);
        sellerMotivationList.add(TIRED_LANDLORD);
        sellerMotivationList.add(EVICTION);
        sellerMotivationList.add(NEED_CASH);
        sellerMotivationList.add(EXPIREED_LISTING);
        return sellerMotivationList;
    }
}
