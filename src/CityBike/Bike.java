package CityBike;

public class Bike {
    protected int bikeID;
    private String color;
    enum State {
        Available,
        Not_Available,
        inService,
    }
    State aState;
    private static Integer counter = 1;

    public Bike(String color, State aState){
        this.bikeID = counter++;
        this.color = color;
        this.aState = aState;
    }

    public State getaState() {
        return aState;
    }

    public void setaState(State aState) {
        this.aState = aState;
    }

    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Integer getCounter() {
        return counter;
    }

    public static void setCounter(Integer counter) {
        Bike.counter = counter;
    }

    public void showAll(){
        System.out.println("" +bikeID + " " + aState + " " + color);
    }

}
