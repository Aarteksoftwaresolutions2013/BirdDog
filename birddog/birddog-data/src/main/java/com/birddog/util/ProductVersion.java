package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class ProductVersion {
    
public static final String BASIC="BASIC";
public static final String PRO="PRO";
public static final String MAX="MAX";
public static final String DEMO="DEMO";

public static List<String> getProductVersions(){
    List<String> list=new ArrayList<String>();

    list.add(BASIC);
    list.add(PRO);
    list.add(MAX);
    list.add(DEMO);
    
    return list;
}

}
