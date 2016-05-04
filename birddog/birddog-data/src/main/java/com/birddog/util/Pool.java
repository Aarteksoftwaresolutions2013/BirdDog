package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class Pool {
    public static final String YES = "Yes";
    public static final String NO = "No";

    public static List<String> pool() {

        List<String> pool = new ArrayList<String>();
        pool.add(NO);
        pool.add(YES);

        return pool;
    }
}
