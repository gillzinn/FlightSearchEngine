package vinnsla;

public class Ticket {
    private Flight flight;
    private User user;
    private String ticketNum;
    private String passportNum;
    private int baggage;

    public Ticket() {

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
        return ticketNum;
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
