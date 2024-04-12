package vinnsla;

public class Airplane {
    private String airplaneID;
    private String airline;
    private int seats;


    public Airplane(String id, String airLine, int numOfSeats) {
        airplaneID = id;
        airline = airLine;
        seats = numOfSeats;

    }

    //Use : getAirline();
    //pre : nothing.
    //post: returns the Sting value for
    //      airplaneId.
    public String getAirline() {
        return airline;
    }

    //Use : getSeats();
    //pre : nothing.
    //post: returns a matrix of Seat.
    public int getSeats() {
        return seats;
    }

    //Use : getID();
    //pre : nothing.
    //post: returns the Sting value for
    //      airplaneID.
    public String getId() {
        return airplaneID;
    }
}
