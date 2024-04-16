package vinnsla;

public class Flight {
    private Airplane airplane;
    private String id;
    private String date;
    private String departureLocation;
    private String departure;
    private String arrivalLocation;
    private String arrival;
    private int seatPrice;
    private String status;
    private int availableSeats;


    public Flight(Airplane a, String ID, String datee, String deptL, String deptT, String arrivalL, String arrivalT, int price, String stat) {
        airplane = a;
        id = ID;
        date = datee;
        departureLocation = deptL;
        departure = deptT;
        arrivalLocation = arrivalL;
        arrival = arrivalT;
        seatPrice = price;
        status = stat;
        availableSeats = airplane.getSeats();
    }

    //Use : getSeats();
    //pre : nothing.
    //post: returns a matrix of Seat.
    public int getSeatCapacity() {
        return airplane.getSeats();
    }

    public int getNumOfAvailableSeats() {
        return availableSeats;
    }

    public String getAirline() {
        return airplane.getAirline();
    }

    //Use : getAirplaneID();
    //pre : nothing.
    //post: returns the Sting value for
    //      airplaneId.
    public String getAirplaneId() {
        return airplane.getId();
    }

    //Use : getDepartureLoc();
    //pre : nothing.
    //post: returns the Sting value for
    //      derpartureLocation.
    public String getDepartureLoc() {
        return departureLocation;
    }

    //Use : getDepartureDate();
    //pre : nothing.
    //post: returns the Sting value for
    //      derparture.
    public String getDepartureTime() {
        return departure;
    }

    //Use : getArrivalLoc();
    //pre : nothing.
    //post: returns the Sting value for
    //      arrivalLocation.
    public String getArrivalLoc() {
        return arrivalLocation;
    }

    //Use : getArrivalTime();
    //pre : nothing.
    //post: returns the Sting value for
    //      arrival.
    public String getArrivalTime() {
        return arrival;
    }

    //Use : getStatus();
    //pre : nothing.
    //post: returns the Sting value for
    //      status.
    public String getStatus() {
        return status;
    }


    public String getId() {
        return id;
    }


    public int getSeatPrice() {
        return seatPrice;
    }

    public String getDate() {
        return date;
    }


    public void setAvailableSeats() {
        availableSeats--;
    }


}
