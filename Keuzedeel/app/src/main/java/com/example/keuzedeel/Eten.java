package com.example.keuzedeel;

public class Eten {


    private String etenRestaurant;
    private int mImageResourceID= NO_IMAGE_PROVIDED;
private static final int NO_IMAGE_PROVIDED = -1;




    public Eten(String etenRest, int imageResourceID) {
      etenRestaurant = etenRest;
      mImageResourceID = imageResourceID;

    }

    public String getEtenRestaurant() {return etenRestaurant;}
    public int getImageResourceID() {
        return  mImageResourceID;
    }
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

}
