package CityBike;

import java.util.*;

public class Main {
   static HashMap<Integer, Bike> placeholder = new HashMap<>();
   static HashMap<Integer, Stations> hashStations = new HashMap<>();
   static HashMap<Integer, User> users = new HashMap<>();


    public static void main(String[] args){
        System.out.println("");
        Bike eins = new Bike("red", Bike.State.Available);
        Bike zwei = new Bike("blue",Bike.State.Available);
        Bike drei = new Bike("yellow",Bike.State.Available);
        Bike vier = new Bike("red",Bike.State.Available);
        Bike fünf = new Bike("orange",Bike.State.Available);
        Bike sechs = new Bike("blue",Bike.State.Available);
        Bike sieben = new Bike("red",Bike.State.Available);
        Bike acht = new Bike("orange",Bike.State.Available);

        placeholder.put(eins.getBikeID(), eins);
        placeholder.put(zwei.getBikeID(), zwei);
        placeholder.put(drei.getBikeID(), drei);
        placeholder.put(vier.getBikeID(), vier);
        placeholder.put(fünf.getBikeID(), fünf);
        placeholder.put(sechs.getBikeID(), sechs);
        placeholder.put(sieben.getBikeID(), sieben);
        placeholder.put(acht.getBikeID(), acht);

        // important for the loop.
        Iterator placeholderIterator = placeholder.entrySet().iterator();

        System.out.println("This is a list of all bikes available, with states, color and ID");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        while(placeholderIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)placeholderIterator.next();
            System.out.println("The bike with the ID " + mapElement.getKey() + " and the color " + placeholder.get(mapElement.getKey()).getColor() + " has the state " + placeholder.get(mapElement.getKey()).getaState());
        }


        System.out.println("");
        Stations praterstern = new Stations(1,"Praterstern");
        Stations schwedenplatz = new Stations(2,"Schwedenplatz");
        Stations aspernstraße = new Stations (3,"Aspernstraße");

        hashStations.put(praterstern.getStationID(),praterstern);
        hashStations.put(schwedenplatz.getStationID(),schwedenplatz);
        hashStations.put(aspernstraße.getStationID(),aspernstraße);

        System.out.println("This is a list of all Stations available for our service with ID and Location");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Iterator hashStationsIterator = hashStations.entrySet().iterator();
        while(hashStationsIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)hashStationsIterator.next();
            System.out.println("the Station with ID " + mapElement.getKey() + " has the location " +  hashStations.get(mapElement.getKey()).getLocation());
        }

        System.out.println("");

        praterstern.addBike(eins.bikeID);
        praterstern.addBike(zwei.bikeID);
        praterstern.addBike(drei.bikeID);
        schwedenplatz.addBike(vier.bikeID);
        schwedenplatz.addBike(fünf.bikeID);
        schwedenplatz.addBike(sechs.bikeID);
        schwedenplatz.addBike(sieben.bikeID);

        System.out.println("following stations with following bikes are available:");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        praterstern.showAll();
        schwedenplatz.showAll();
        aspernstraße.showAll();


        User Franz = new User(54,"Franz","Klaus");
        User Peter = new User(73,"Peter","Eberhardt");
        User Herbert = new User(52,"Herbert","Fallmüller");
        User Igor = new User(92,"Igor","von Habsburg");

        users.put(Franz.getUserID(),Franz);
        users.put(Peter.getUserID(),Peter);
        users.put(Herbert.getUserID(),Herbert);
        users.put(Igor.getUserID(),Igor);
        System.out.println("");
        Iterator usersIterator = users.entrySet().iterator();
        System.out.println("Following users we have for our service. Pssst data privacy");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        while(usersIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)usersIterator.next();
            System.out.println("The user with the name " + users.get(mapElement.getKey()).getName() + " "+  users.get(mapElement.getKey()).getSurname() + " has the ID "+ mapElement.getKey());
        }


        System.out.println("");
        Franz.rentABike(3);
        praterstern.showAll();
        praterstern.returnBike(3);
        praterstern.showAll();
        Peter.rentABike(2);
        Igor.rentABike(6);
        Herbert.rentABike(4);
        aspernstraße.returnBike(2);
        aspernstraße.returnBike(6);
        aspernstraße.returnBike(4);
        praterstern.showAll();
        schwedenplatz.showAll();
        aspernstraße.showAll();

    }

    public static void checkWhichStation(Integer bikeID){
        Stations station = new Stations();
        for(Map.Entry<Integer, Stations> entry : hashStations.entrySet()){
            if(entry.getValue().getBikes().contains(bikeID)){
                station = entry.getValue();
                break;
            }
        }
        station.removeBike(bikeID);
    }
    public static void checkWhichUser(Integer bikeID){
        User user = new User();
        for(Map.Entry<Integer, User> entry : users.entrySet()){
            if(entry.getValue().getCurrentlyRentedBike() == bikeID){
                user = entry.getValue();
                break;
            }
        }
        user.removeBike(bikeID);
    }
}
