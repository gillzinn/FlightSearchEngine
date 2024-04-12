package vinnsla;

public class Seat {
    private String airplanID;
    private boolean available;

    //eittvað sett in seina.

    public Seat(String airPlaneId, boolean boo) {
        airplanID = airPlaneId;
        available = true;


    }


    public boolean getAvailability() {
        return available;
    }
}
