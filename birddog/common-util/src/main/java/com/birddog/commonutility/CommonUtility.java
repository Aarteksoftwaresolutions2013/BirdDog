/**
 * 
 */
package com.birddog.commonutility;

/**
 * Common class contains all utility methods
 * 
 * @author Aartek
 *
 */
public class CommonUtility {

    public static char charAt(String inputString, int index) {

        return inputString.charAt(index);
    }

    public static int length(String inputString) {

        return inputString.length();
    }

    public static String toString(StringBuffer randStr) {
       
        return randStr.toString();
    }

    public static byte[] getBytes(String id) {
       
        return id.getBytes();
    }

}
