package com.birddog.util;

import java.util.Random;

import com.birddog.commonutility.CommonUtility;

/**
 * 
 * @author Aartek
 *
 */
public class RandomNoGenerate {

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 8;

    /**
     * This method generates random string
     * 
     * @return
     */
    public static String generateRandomString() {
        StringBuffer randStr = new StringBuffer();

        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {

            int number = getRandomNumber();
            char ch = CommonUtility.charAt(CHAR_LIST, number);
            randStr.append(ch);
        }

        return CommonUtility.toString(randStr);
    }

    /**
     * This method generates random numbers
     * 
     * @return int
     */
    private static int getRandomNumber() {

        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CommonUtility.length(CHAR_LIST));

        if (randomInt - 1 == -1) {

            return randomInt;
        } else {

            return randomInt - 1;
        }
    }
}
