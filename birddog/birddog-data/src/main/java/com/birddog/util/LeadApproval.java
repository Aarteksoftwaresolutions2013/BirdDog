package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class LeadApproval {
    public static final String PENDING = "Pending";
    public static final String APPROVAL = "Approved";
    public static final String REJECTED = "Rejected";

    public static List<String> leadApproval() {
        List<String> leadApproval = new ArrayList<String>();
        leadApproval.add(PENDING);
        leadApproval.add(APPROVAL);
        leadApproval.add(REJECTED);

        return leadApproval;
    }

}
