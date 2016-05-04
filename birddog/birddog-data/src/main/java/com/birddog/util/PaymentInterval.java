package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class PaymentInterval {
    
    public static final String MONTHLY="Monthly"; 
    public static final String WEEKLY="Weekly"; 

    public static List<String> getPaymentIntervals() {
       
        List<String> list=new ArrayList<String>();
        list.add(MONTHLY);
        list.add(WEEKLY);
        
        return list;
    }
}
