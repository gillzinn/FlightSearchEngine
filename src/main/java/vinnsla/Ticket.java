package vinnsla;

public class Ticket {
    private Flight flight;
    private User user;
    private String ticketId;

    private int baggage;

    public Ticket(Flight f, User u) {
        flight = f;
        user = u;
    }

    public void addBag() {
        baggage++;
    }

    public void bookSeat() {
        //something imporent
    }

    //use : getTicketNumber();
    //pre : nothing
    //post: retures the String value of
    //	    ticketNum.
    public String getTickerNumber() {
        return ticketId;
    }

    //use : getFlight();
    //pre : nothing
    //post: retures the Flight object
    //	    fligth.
    public Flight getFlight() {
        return flight;
    }

    //use : getUser();
    //pre : nothing
    //post: retures the User object
    //	    user.
    public User getUser() {
        return user;
    }
}
