package com.birddog.commonutility;

import org.json.JSONException;

public class RoughfWork {

	public static void main(String[] args) throws JSONException {
		
		
		String address ="2446 Forest Ln #130, Garland, TX 75042";
		  String latLongs[] = null;
	        try {
	            latLongs = FindLatitudeAndLongitude.getLatLongPositions(address);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        System.out.println("Lat->"+latLongs[0]+" Long->"+latLongs[1]);
	       
	}

}
