package com.birddog.util;

import java.util.ArrayList;
import java.util.List;

public class RoofConstructionType {

    public static final String METAL = "Metal";
    public static final String SHINGLE = "Shingle";
    public static final String GRAVEL = "Gravel";
    public static final String TILE_BARREL = "Tile Barrel";
    public static final String WOOD_SHINGLE = "Wood Shingle";

    public static List<String> roofConstruction() {

        List<String> roofConstruction = new ArrayList<String>();
        roofConstruction.add(METAL);
        roofConstruction.add(SHINGLE);
        roofConstruction.add(GRAVEL);
        roofConstruction.add(TILE_BARREL);
        roofConstruction.add(WOOD_SHINGLE);
        
        return roofConstruction;
    }
}
