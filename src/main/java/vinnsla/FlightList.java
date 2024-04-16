package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightList {
    protected ObservableList<Flight> flights = FXCollections.observableArrayList();// listi öll quizin í quizlistanum


    /**
     * smiður á quizlistanum sem býr til 5 quiz og nokkrar spurningar í þau
     */
    public FlightList(ObservableList<Airplane> planes) {


        setFlight(planes.get(0), "1", "2024-05-04", "Reykjavík", "18:50", "Akureyri", "20:00", 40000, "Soon");
        setFlight(planes.get(0), "2", "2024-05-04", "Akureyri", "20:30", "Reykjavík", "21:40", 40000, "Soon");
        setFlight(planes.get(1), "3", "2024-05-06", "Reykjavík", "18:50", "Akureyri", "20:00", 40000, "Soon");
        setFlight(planes.get(3), "4", "2024-05-08", "Reykjavík", "19:50", "Akureyri", "21:00", 40000, "Soon");
        setFlight(planes.get(4), "5", "2024-05-10", "Reykjavík", "17:50", "Akureyri", "19:00", 40000, "Soon");

        setFlight(planes.get(2), "6", "2024-05-04", "Reykjavík", "18:50", "Akureyri", "20:00", 40000, "Soon");
        setFlight(planes.get(2), "7", "2024-05-04", "Akureyri", "20:30", "Reykjavík", "21:40", 40000, "Soon");
        setFlight(planes.get(1), "8", "2024-05-06", "Reykjavík", "18:50", "Akureyri", "20:00", 40000, "Soon");
        setFlight(planes.get(4), "9", "2024-05-08", "Reykjavík", "19:50", "Akureyri", "21:00", 40000, "Soon");
        setFlight(planes.get(2), "10", "2024-05-10", "Reykjavík", "17:50", "Akureyri", "19:00", 40000, "Soon");

        setFlight(planes.get(1), "11", "2024-05-04", "Reykjavík", "18:50", "Akureyri", "20:00", 40000, "Soon");
        setFlight(planes.get(3), "12", "2024-05-04", "Akureyri", "20:30", "Reykjavík", "21:40", 40000, "Soon");
        setFlight(planes.get(3), "13", "2024-05-06", "Reykjavík", "18:50", "Akureyri", "20:00", 40000, "Soon");
        setFlight(planes.get(3), "14", "2024-05-08", "Reykjavík", "19:50", "Akureyri", "21:00", 40000, "Soon");
        setFlight(planes.get(4), "15", "2024-05-10", "Reykjavík", "17:50", "Akureyri", "19:00", 40000, "Soon");


    }


    public void setFlight(Airplane plane, String ID, String date, String deptL, String deptT, String arrivalL, String arrivalT, int price, String stat) {
        Flight f = new Flight(plane, ID, date, deptL, deptT, arrivalL, arrivalT, price, stat);
        flights.add(f);
    }

    public ObservableList<Flight> getFlights() {
        return flights;
    }


    public ObservableList<Flight> getFlightDepartureLoc(String loc) {
        ObservableList<Flight> flightsByDepartLoc = FXCollections.observableArrayList();
        for (Flight f : flights) {
            if (f.getDepartureLoc().equals(loc)) {
                flightsByDepartLoc.add(f);

            }
        }
        return flightsByDepartLoc;
    }


    public ObservableList<Flight> getFlightsSearch(String airl, String departLoc, String departDate, String arrivalLoc) {
        ObservableList<Flight> flightsSearch = FXCollections.observableArrayList();
        for (Flight f : flights) {
            if ((airl.equals("null") || airl.equals(f.getAirline())) && (departLoc.equals("null") || departLoc.equals(f.getDepartureLoc())) && (departDate.equals("null") || departDate.equals(f.getDate())) && (arrivalLoc.equals("null") || arrivalLoc.equals(f.getArrivalLoc()))) {
                flightsSearch.add(f);
            }
        }

        return flightsSearch;
    }


}
