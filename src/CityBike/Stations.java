package CityBike;

import java.util.ArrayList;

public class Stations{
    private int StationID;
    private String location;
    private ArrayList<Integer> bikes;

    public Stations(int stationID, String location) {
        this.StationID = stationID;
        this.location = location;
        this.bikes = new ArrayList<>();
    }

    public int getStationID() {
        return StationID;
    }

    public Stations(){}

    public void setStationID(int stationID) {
        StationID = stationID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Integer> getBikes() {
        return bikes;
    }

    public void setBikes(ArrayList<Integer> bikes) {
        this.bikes = bikes;
    }
    public void addBike(Integer bikeID){
        this.bikes.add(bikeID);
    }

    public void removeBike(Integer bikeID){
        this.bikes.remove(bikeID);
    }

    public void showAll(){
        System.out.println(StationID + " " + location + " " + bikes);
    }
    public void returnBike(Integer bikeID){
        addBike(bikeID);
        Main.checkWhichUser(bikeID);
    }


}
