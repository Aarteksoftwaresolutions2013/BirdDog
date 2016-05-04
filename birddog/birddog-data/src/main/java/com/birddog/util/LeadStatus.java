/**
 * 
 */
package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dell
 *
 */
public class LeadStatus {

    public static final String REVIEWING = "Reviewing";
    public static final String CONTACTING_OWNER = "Contacting Owner";
    public static final String OFFER_SUBMITTED = "Offer Submitted";
    public static final String UNDER_CONTRACT = "Under Contract";
    public static final String SUCCESS = "Success";

    public static List<String> leadStatus() {

        List<String> leadStatus = new ArrayList<String>();
        leadStatus.add(REVIEWING);
        leadStatus.add(CONTACTING_OWNER);
        leadStatus.add(OFFER_SUBMITTED);
        leadStatus.add(UNDER_CONTRACT);
        leadStatus.add(SUCCESS);

        return leadStatus;
    }

}
