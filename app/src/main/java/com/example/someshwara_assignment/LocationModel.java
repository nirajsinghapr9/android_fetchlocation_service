package com.example.someshwara_assignment;

public class LocationModel {
    public static LocationModel page1_data;
    private String longitude;
    private String latitude;

    private LocationModel(){}
    public static LocationModel getSingletonePage1Data(){
        if(page1_data==null){
            page1_data=new LocationModel();
        }
        return page1_data;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
