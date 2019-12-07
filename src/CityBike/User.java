package CityBike;

import java.util.ArrayList;
;

public class User {
    private int userID;
    private String name;
    private String surname;
    private Rent rent;
    private ArrayList<Rent> rents = new ArrayList<>();
    private Integer currentlyRentedBike;

    public User(int userID, String name, String surname) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public User(){}
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public ArrayList<Rent> getRents() {
        return rents;
    }

    public void setRents(ArrayList<Rent> rents) {
        this.rents = rents;
    }

    public Integer getCurrentlyRentedBike(){
        return this.currentlyRentedBike;
    }
    public void setCurrentlyRentedBike(Integer bikeID){
        this.currentlyRentedBike = bikeID;
    }

    public void showAll(){
        System.out.println(name + " " + surname + " " + userID);
    }

    public void removeBike(Integer bikeID){
        this.currentlyRentedBike = null;
        System.out.println("Bike with the ID: " + bikeID + " has been removed.");
    }

    public void rentABike( Integer bikeID){
        if(Main.placeholder.get(bikeID).getaState() == Bike.State.Available){
            Main.checkWhichStation(bikeID);
            this.currentlyRentedBike = bikeID;
            System.out.println("Bike with the ID: " + bikeID + " has been taken from " + name +" "+ surname + " with the id " + userID );
        }else{
            System.out.println("This bike can't be rented at the moment!");
        }
        }


    }

