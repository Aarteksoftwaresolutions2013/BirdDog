package com.birddog.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    /**
     * Generate todate date
     * 
     * @return Date
     */
    public static Date todayDate() {

        return new Date();
    }

    /**
     * 30 days before
     * 
     * @return
     */
    public static Date dateBeforeThirtyDays() {

        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -30);
        Date today30 = cal.getTime();

        return today30;
    }

    /**
     * 60 Days Before
     * 
     * @return
     */
    public static Date dateBeforeSixtyDays() {

        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -60);
        Date today60 = cal.getTime();

        return today60;
    }

}
