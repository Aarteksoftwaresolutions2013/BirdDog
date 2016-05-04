package com.birddog.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BuiltYear {
    public static List<Integer> year() {
    	List<Integer> yearList = new ArrayList<Integer>();
    	int thisYear = Calendar.getInstance().get(Calendar.YEAR);

    	  for (int i = 1900; i <= thisYear; i++) 
    	  {
    		  yearList.add(i);
    	  }

        
        return yearList;
    }
}
