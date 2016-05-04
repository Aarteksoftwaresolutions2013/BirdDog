package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class ConstructionType {

    public static final String CBS = "CBS";
    public static final String WOODFRAME_STUCCO = "Woodframe/Stucco";
    public static final String WOODFRAME = "Woodframe";
    public static final String VINYL_SLIDING = "Vinyl Siding";

    public static List<String> constructionType() {

        List<String> constructionType = new ArrayList<String>();
        constructionType.add(CBS);
        constructionType.add(WOODFRAME_STUCCO);
        constructionType.add(WOODFRAME);
        constructionType.add(VINYL_SLIDING);

        return constructionType;
    }
}
