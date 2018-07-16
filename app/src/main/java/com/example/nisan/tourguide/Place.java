package com.example.nisan.tourguide;

public class Place {

    private String mName;
    private String mAddress;
    private String mDescription;
    private int mImageResourceId;

    public Place(String name, String address,String description, int imageResourceId) {
        this.mName = name;
        this.mAddress = address;
        this.mDescription = description;
        this.mImageResourceId = imageResourceId;
    }


    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getDescription() {
        return mDescription;
    }
}
