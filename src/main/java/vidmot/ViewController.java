package vidmot;


import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import vinnsla.*;

public class ViewController {

    @FXML
    private VBox fxBrowseDiv1;
    @FXML
    private Label fxBrowseDiv1Date;
    @FXML
    private Label fxBrowseDiv1Airline;
    @FXML
    private Label fxBrowseDiv1DepartureL;
    @FXML
    private Label fxBrowseDiv1DepartureT;
    @FXML
    private Label fxBrowseDiv1ArrivalL;
    @FXML
    private Label fxBrowseDiv1ArrivalT;
    @FXML
    private Label fxBrowseDiv1Price;
    @FXML
    private Label fxBrowseDiv1Seats;
    @FXML
    private VBox fxBrowseDiv2;
    @FXML
    private Label fxBrowseDiv2Date;
    @FXML
    private Label fxBrowseDiv2Airline;
    @FXML
    private Label fxBrowseDiv2DepartureL;
    @FXML
    private Label fxBrowseDiv2DepartureT;
    @FXML
    private Label fxBrowseDiv2ArrivalL;
    @FXML
    private Label fxBrowseDiv2ArrivalT;
    @FXML
    private Label fxBrowseDiv2Price;
    @FXML
    private Label fxBrowseDiv2Seats;
    @FXML
    private VBox fxBrowseDiv3;
    @FXML
    private Label fxBrowseDiv3Date;
    @FXML
    private Label fxBrowseDiv3Airline;
    @FXML
    private Label fxBrowseDiv3DepartureL;
    @FXML
    private Label fxBrowseDiv3DepartureT;
    @FXML
    private Label fxBrowseDiv3ArrivalL;
    @FXML
    private Label fxBrowseDiv3ArrivalT;
    @FXML
    private Label fxBrowseDiv3Price;
    @FXML
    private Label fxBrowseDiv3Seats;
    @FXML
    private VBox fxBrowseDiv4;
    @FXML
    private Label fxBrowseDiv4Date;
    @FXML
    private Label fxBrowseDiv4Airline;
    @FXML
    private Label fxBrowseDiv4DepartureL;
    @FXML
    private Label fxBrowseDiv4DepartureT;
    @FXML
    private Label fxBrowseDiv4ArrivalL;
    @FXML
    private Label fxBrowseDiv4ArrivalT;
    @FXML
    private Label fxBrowseDiv4Price;
    @FXML
    private Label fxBrowseDiv4Seats;


    @FXML
    private Label fxBookDate;
    @FXML
    private Label fxBookAirline;
    @FXML
    private Label fxBookDepartureL;
    @FXML
    private Label fxBookDepartureT;
    @FXML
    private Label fxBookArrivalL;
    @FXML
    private Label fxBookArrivalT;
    @FXML
    private Label fxBookPrice;
    @FXML
    private Label fxBookSeats;

    @FXML
    private Label fxFjoldiSida;// fjöldi síða í browse

    @FXML
    private Pane fxArrowLeft;// back arrow í browse á milli síða
    @FXML
    private Pane fxArrowRight;// next arrow í browse á milli síða

    @FXML
    private Pane fxBdiv1;// card 1 af 4 í browse div
    @FXML
    private Pane fxBdiv2;// card 2 af 4 í browse div
    @FXML
    private Pane fxBdiv3;// card 3 af 4 í browse div
    @FXML
    private Pane fxBdiv4;// card 4 af 4 í browse div

    @FXML
    private Label fxBdiv1Book;
    @FXML
    private Label fxBdiv2Book;
    @FXML
    private Label fxBdiv3Book;
    @FXML
    private Label fxBdiv4Book;

    @FXML
    private TextField fxLoginName;
    @FXML
    private TextField fxLoginPassword;

    @FXML
    private Label fxLoginError;


    @FXML
    private ListView<String> fxTicketList;
    @FXML
    private Label fxAccountName;
    @FXML
    private Label fxAccountEmail;
    @FXML
    private Label fxAccountKennitala;
    @FXML
    private Label fxAccountPassword;

    @FXML
    private ChoiceBox<String> fxChoiceBoxAirline;
    @FXML
    private ChoiceBox<String> fxChoiceBoxDepartureL;
    @FXML
    private DatePicker fxDatePickerDepartureT;
    @FXML
    private ChoiceBox<String> fxChoiceBoxArrivalL;


    private VBox node;//node sem er hoveruð yfir í browse

    private AirplaneController airplaneController;
    private UserController userController;
    private ObservableList<Flight> flightList;

    private ObservableList<Airplane> planes;
    private ObservableList<Flight> searchFlightss;
    private FlightList mainFlightList;
    private ObservableList<User> users;

    private User loggedInUser;
    private Flight validFlight;


    private int browseCount;// teljari fyrir núverandi síðu í browse
    private int fjoldisida = 0;// fjöldi síða í browse


    public void initialize() {

        userController = new UserController();
        userController.initialize();
        users = userController.getUsers();
        airplaneController = new AirplaneController();
        airplaneController.initialize();
        planes = airplaneController.getPlanes();
        mainFlightList = new FlightList(planes);
        flightList = mainFlightList.getFlights();
        searchFlightss = flightList;

        browseCount = 1;


    }

    public void initializeAccount(ObservableList<User> userss, User u, ObservableList<Flight> flghtlst) {
        users = userss;
        loggedInUser = u;
        flightList = flghtlst;

        fxAccountName.setText(loggedInUser.getNafn());
        fxAccountEmail.setText(loggedInUser.getEmail());
        fxAccountKennitala.setText(loggedInUser.getKennitala());
        fxAccountPassword.setText(loggedInUser.getPassword());


        for (Ticket t : loggedInUser.getTickets()) {
            String str = t.getFlight().getAirline() + " From: " + t.getFlight().getDepartureLoc() + " To: " + t.getFlight().getArrivalLoc();
            fxTicketList.getItems().add(str);
        }


    }

    public void initializeBrowseWithUser(ObservableList<User> userss, User u, ObservableList<Flight> flghtlst) {
        loggedInUser = u;
        users = userss;
        initializeBrowse(flghtlst);


    }


    public void initializeBrowseBySearch(ObservableList<Flight> quizl) {

        searchFlightss = quizl;

        browseCount = 1;

        int size = searchFlightss.size();


        if (browseCount * 4 <= size) {
            fxBdiv1.setVisible(true);
            fxBdiv2.setVisible(true);
            fxBdiv3.setVisible(true);
            fxBdiv4.setVisible(true);
            fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
            fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
            fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
            fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
            fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
            fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
            fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
            fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));

            fxBrowseDiv2Airline.setText(searchFlightss.get(browseCount * 4 - 3).getAirline());
            fxBrowseDiv2Date.setText(searchFlightss.get(browseCount * 4 - 3).getDate());
            fxBrowseDiv2DepartureL.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureLoc());
            fxBrowseDiv2DepartureT.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureTime());
            fxBrowseDiv2ArrivalL.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalLoc());
            fxBrowseDiv2ArrivalT.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalTime());
            fxBrowseDiv2Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getSeatPrice()));
            fxBrowseDiv2Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getNumOfAvailableSeats()));

            fxBrowseDiv3Airline.setText(searchFlightss.get(browseCount * 4 - 2).getAirline());
            fxBrowseDiv3Date.setText(searchFlightss.get(browseCount * 4 - 2).getDate());
            fxBrowseDiv3DepartureL.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureLoc());
            fxBrowseDiv3DepartureT.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureTime());
            fxBrowseDiv3ArrivalL.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalLoc());
            fxBrowseDiv3ArrivalT.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalTime());
            fxBrowseDiv3Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getSeatPrice()));
            fxBrowseDiv3Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getNumOfAvailableSeats()));

            fxBrowseDiv4Airline.setText(searchFlightss.get(browseCount * 4 - 1).getAirline());
            fxBrowseDiv4Date.setText(searchFlightss.get(browseCount * 4 - 1).getDate());
            fxBrowseDiv4DepartureL.setText(searchFlightss.get(browseCount * 4 - 1).getDepartureLoc());
            fxBrowseDiv4DepartureT.setText(searchFlightss.get(browseCount * 4 - 1).getDepartureTime());
            fxBrowseDiv4ArrivalL.setText(searchFlightss.get(browseCount * 4 - 1).getArrivalLoc());
            fxBrowseDiv4ArrivalT.setText(searchFlightss.get(browseCount * 4 - 1).getArrivalTime());
            fxBrowseDiv4Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 1).getSeatPrice()));
            fxBrowseDiv4Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 1).getNumOfAvailableSeats()));

        } else if (browseCount * 4 - size == 1) {
            fxBdiv1.setVisible(true);
            fxBdiv2.setVisible(true);
            fxBdiv3.setVisible(true);
            fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
            fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
            fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
            fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
            fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
            fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
            fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
            fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));

            fxBrowseDiv2Airline.setText(searchFlightss.get(browseCount * 4 - 3).getAirline());
            fxBrowseDiv2Date.setText(searchFlightss.get(browseCount * 4 - 3).getDate());
            fxBrowseDiv2DepartureL.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureLoc());
            fxBrowseDiv2DepartureT.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureTime());
            fxBrowseDiv2ArrivalL.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalLoc());
            fxBrowseDiv2ArrivalT.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalTime());
            fxBrowseDiv2Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getSeatPrice()));
            fxBrowseDiv2Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getNumOfAvailableSeats()));

            fxBrowseDiv3Airline.setText(searchFlightss.get(browseCount * 4 - 2).getAirline());
            fxBrowseDiv3Date.setText(searchFlightss.get(browseCount * 4 - 2).getDate());
            fxBrowseDiv3DepartureL.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureLoc());
            fxBrowseDiv3DepartureT.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureTime());
            fxBrowseDiv3ArrivalL.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalLoc());
            fxBrowseDiv3ArrivalT.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalTime());
            fxBrowseDiv3Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getSeatPrice()));
            fxBrowseDiv3Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getNumOfAvailableSeats()));

            fxBdiv4.setVisible(false);
        } else if (browseCount * 4 - size == 2) {
            fxBdiv1.setVisible(true);
            fxBdiv2.setVisible(true);
            fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
            fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
            fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
            fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
            fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
            fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
            fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
            fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));


            fxBrowseDiv2Airline.setText(searchFlightss.get(browseCount * 4 - 3).getAirline());
            fxBrowseDiv2Date.setText(searchFlightss.get(browseCount * 4 - 3).getDate());
            fxBrowseDiv2DepartureL.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureLoc());
            fxBrowseDiv2DepartureT.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureTime());
            fxBrowseDiv2ArrivalL.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalLoc());
            fxBrowseDiv2ArrivalT.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalTime());
            fxBrowseDiv2Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getSeatPrice()));
            fxBrowseDiv2Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getNumOfAvailableSeats()));


            fxBdiv3.setVisible(false);

            fxBdiv4.setVisible(false);
        } else if (browseCount * 4 - size == 3) {
            fxBdiv1.setVisible(true);
            fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
            fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
            fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
            fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
            fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
            fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
            fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
            fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));

            fxBdiv2.setVisible(false);

            fxBdiv3.setVisible(false);

            fxBdiv4.setVisible(false);

        } else {
            fxBdiv1.setVisible(false);

            fxBdiv2.setVisible(false);

            fxBdiv3.setVisible(false);

            fxBdiv4.setVisible(false);
        }


        int fjoldiq = searchFlightss.size();

        if (fjoldiq % 4 == 0) {
            fjoldisida = searchFlightss.size() / 4;

        } else {
            int rem = fjoldiq % 4;
            int r = fjoldiq - rem;
            fjoldisida = r / 4 + 1;
        }

        fxFjoldiSida.setText(browseCount + "/" + fjoldisida);

        if (browseCount == 1) {
            fxArrowLeft.setOnMouseClicked(null);
        } else {
            fxArrowLeft.setOnMouseClicked(event -> {
                FyrriBrowseSida();
            });
        }

        if (browseCount < fjoldisida) {
            fxArrowRight.setOnMouseClicked(event -> {
                NaestaBrowseSida();
            });
        } else {
            fxArrowRight.setOnMouseClicked(null);
        }


    }

    public void initializeBrowse(ObservableList<Flight> flightLis) {

        flightList = flightLis;

        browseCount = 1;
        int size = flightList.size();

        fxFjoldiSida.setText(browseCount + "/" + fjoldisida);


        int fjoldiq = flightList.size();

        if (fjoldiq % 4 == 0) {
            fjoldisida = flightList.size() / 4;

        } else {
            int rem = fjoldiq % 4;
            int r = fjoldiq - rem;
            fjoldisida = r / 4 + 1;
        }
        if (fjoldisida > 1 && browseCount != fjoldisida) {
            fxArrowRight.setOnMouseClicked(event -> {
                NaestaBrowseSida();
            });
        }

        fxFjoldiSida.setText(browseCount + "/" + fjoldisida);


        String[] airlines = {"IcelandAir", "Wow air", "Play"};
        fxChoiceBoxAirline.getItems().addAll(airlines);

        String[] locations = {"Reykjavík", "Akureyri"};
        fxChoiceBoxDepartureL.getItems().addAll(locations);
        fxChoiceBoxArrivalL.getItems().addAll(locations);

        initializeBrowseBySearch(flightList);


    }


    public void SubmitSearch() {
        String airline = String.valueOf(fxChoiceBoxAirline.getValue());
        String departureLoc = String.valueOf(fxChoiceBoxDepartureL.getValue());
        String date = String.valueOf(fxDatePickerDepartureT.getValue());
        String arrivalLoc = String.valueOf(fxChoiceBoxArrivalL.getValue());

        ObservableList<Flight> searchFlightlist = mainFlightList.getFlightsSearch(airline, departureLoc, date, arrivalLoc);

        initializeBrowseBySearch(searchFlightlist);

    }

    public void Browse() {

        ViewSwitcher.switchTo(View.BROWSE, users, loggedInUser, flightList);

    }

    public void Browse(ObservableList<User> users, User u) {
        ViewSwitcher.switchTo(View.BROWSE, users, u, flightList);

    }


    /**
     * fall sem sýnir fyrri browse siðu
     */
    public void FyrriBrowseSida() {
        browseCount -= 1;


        fxFjoldiSida.setText(browseCount + "/" + fjoldisida);

        fxBdiv1.setVisible(true);
        fxBdiv2.setVisible(true);
        fxBdiv3.setVisible(true);
        fxBdiv4.setVisible(true);
        fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
        fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
        fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
        fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
        fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
        fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
        fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
        fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));

        fxBrowseDiv2Airline.setText(searchFlightss.get(browseCount * 4 - 3).getAirline());
        fxBrowseDiv2Date.setText(searchFlightss.get(browseCount * 4 - 3).getDate());
        fxBrowseDiv2DepartureL.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureLoc());
        fxBrowseDiv2DepartureT.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureTime());
        fxBrowseDiv2ArrivalL.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalLoc());
        fxBrowseDiv2ArrivalT.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalTime());
        fxBrowseDiv2Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getSeatPrice()));
        fxBrowseDiv2Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getNumOfAvailableSeats()));

        fxBrowseDiv3Airline.setText(searchFlightss.get(browseCount * 4 - 2).getAirline());
        fxBrowseDiv3Date.setText(searchFlightss.get(browseCount * 4 - 2).getDate());
        fxBrowseDiv3DepartureL.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureLoc());
        fxBrowseDiv3DepartureT.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureTime());
        fxBrowseDiv3ArrivalL.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalLoc());
        fxBrowseDiv3ArrivalT.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalTime());
        fxBrowseDiv3Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getSeatPrice()));
        fxBrowseDiv3Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getNumOfAvailableSeats()));

        fxBrowseDiv4Airline.setText(searchFlightss.get(browseCount * 4 - 1).getAirline());
        fxBrowseDiv4Date.setText(searchFlightss.get(browseCount * 4 - 1).getDate());
        fxBrowseDiv4DepartureL.setText(searchFlightss.get(browseCount * 4 - 1).getDepartureLoc());
        fxBrowseDiv4DepartureT.setText(searchFlightss.get(browseCount * 4 - 1).getDepartureTime());
        fxBrowseDiv4ArrivalL.setText(searchFlightss.get(browseCount * 4 - 1).getArrivalLoc());
        fxBrowseDiv4ArrivalT.setText(searchFlightss.get(browseCount * 4 - 1).getArrivalTime());
        fxBrowseDiv4Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 1).getSeatPrice()));
        fxBrowseDiv4Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 1).getNumOfAvailableSeats()));


        if (browseCount == 1) {
            fxArrowLeft.setOnMouseClicked(null);
        }
        if (browseCount < fjoldisida) {
            fxArrowRight.setOnMouseClicked(event -> {
                NaestaBrowseSida();
            });
        }

    }


    /**
     * fall sem sýnir næstu browse siðu
     */
    public void NaestaBrowseSida() {
        browseCount += 1;
        int size = searchFlightss.size();

        fxFjoldiSida.setText(browseCount + "/" + fjoldisida);

        if (browseCount * 4 <= size) {
            fxBdiv1.setVisible(true);
            fxBdiv2.setVisible(true);
            fxBdiv3.setVisible(true);
            fxBdiv4.setVisible(true);
            fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
            fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
            fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
            fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
            fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
            fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
            fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
            fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));

            fxBrowseDiv2Airline.setText(searchFlightss.get(browseCount * 4 - 3).getAirline());
            fxBrowseDiv2Date.setText(searchFlightss.get(browseCount * 4 - 3).getDate());
            fxBrowseDiv2DepartureL.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureLoc());
            fxBrowseDiv2DepartureT.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureTime());
            fxBrowseDiv2ArrivalL.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalLoc());
            fxBrowseDiv2ArrivalT.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalTime());
            fxBrowseDiv2Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getSeatPrice()));
            fxBrowseDiv2Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getNumOfAvailableSeats()));

            fxBrowseDiv3Airline.setText(searchFlightss.get(browseCount * 4 - 2).getAirline());
            fxBrowseDiv3Date.setText(searchFlightss.get(browseCount * 4 - 2).getDate());
            fxBrowseDiv3DepartureL.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureLoc());
            fxBrowseDiv3DepartureT.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureTime());
            fxBrowseDiv3ArrivalL.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalLoc());
            fxBrowseDiv3ArrivalT.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalTime());
            fxBrowseDiv3Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getSeatPrice()));
            fxBrowseDiv3Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getNumOfAvailableSeats()));

            fxBrowseDiv4Airline.setText(searchFlightss.get(browseCount * 4 - 1).getAirline());
            fxBrowseDiv4Date.setText(searchFlightss.get(browseCount * 4 - 1).getDate());
            fxBrowseDiv4DepartureL.setText(searchFlightss.get(browseCount * 4 - 1).getDepartureLoc());
            fxBrowseDiv4DepartureT.setText(searchFlightss.get(browseCount * 4 - 1).getDepartureTime());
            fxBrowseDiv4ArrivalL.setText(searchFlightss.get(browseCount * 4 - 1).getArrivalLoc());
            fxBrowseDiv4ArrivalT.setText(searchFlightss.get(browseCount * 4 - 1).getArrivalTime());
            fxBrowseDiv4Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 1).getSeatPrice()));
            fxBrowseDiv4Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 1).getNumOfAvailableSeats()));

        } else if (browseCount * 4 - size == 1) {
            fxBdiv1.setVisible(true);
            fxBdiv2.setVisible(true);
            fxBdiv3.setVisible(true);
            fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
            fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
            fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
            fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
            fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
            fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
            fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
            fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));

            fxBrowseDiv2Airline.setText(searchFlightss.get(browseCount * 4 - 3).getAirline());
            fxBrowseDiv2Date.setText(searchFlightss.get(browseCount * 4 - 3).getDate());
            fxBrowseDiv2DepartureL.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureLoc());
            fxBrowseDiv2DepartureT.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureTime());
            fxBrowseDiv2ArrivalL.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalLoc());
            fxBrowseDiv2ArrivalT.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalTime());
            fxBrowseDiv2Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getSeatPrice()));
            fxBrowseDiv2Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getNumOfAvailableSeats()));

            fxBrowseDiv3Airline.setText(searchFlightss.get(browseCount * 4 - 2).getAirline());
            fxBrowseDiv3Date.setText(searchFlightss.get(browseCount * 4 - 2).getDate());
            fxBrowseDiv3DepartureL.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureLoc());
            fxBrowseDiv3DepartureT.setText(searchFlightss.get(browseCount * 4 - 2).getDepartureTime());
            fxBrowseDiv3ArrivalL.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalLoc());
            fxBrowseDiv3ArrivalT.setText(searchFlightss.get(browseCount * 4 - 2).getArrivalTime());
            fxBrowseDiv3Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getSeatPrice()));
            fxBrowseDiv3Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 2).getNumOfAvailableSeats()));

            fxBdiv4.setVisible(false);
        } else if (browseCount * 4 - size == 2) {
            fxBdiv1.setVisible(true);
            fxBdiv2.setVisible(true);
            fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
            fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
            fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
            fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
            fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
            fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
            fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
            fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));


            fxBrowseDiv2Airline.setText(searchFlightss.get(browseCount * 4 - 3).getAirline());
            fxBrowseDiv2Date.setText(searchFlightss.get(browseCount * 4 - 3).getDate());
            fxBrowseDiv2DepartureL.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureLoc());
            fxBrowseDiv2DepartureT.setText(searchFlightss.get(browseCount * 4 - 3).getDepartureTime());
            fxBrowseDiv2ArrivalL.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalLoc());
            fxBrowseDiv2ArrivalT.setText(searchFlightss.get(browseCount * 4 - 3).getArrivalTime());
            fxBrowseDiv2Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getSeatPrice()));
            fxBrowseDiv2Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 3).getNumOfAvailableSeats()));


            fxBdiv3.setVisible(false);

            fxBdiv4.setVisible(false);
        } else if (browseCount * 4 - size == 3) {
            fxBdiv1.setVisible(true);
            fxBrowseDiv1Airline.setText(searchFlightss.get(browseCount * 4 - 4).getAirline());
            fxBrowseDiv1Date.setText(searchFlightss.get(browseCount * 4 - 4).getDate());
            fxBrowseDiv1DepartureL.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureLoc());
            fxBrowseDiv1DepartureT.setText(searchFlightss.get(browseCount * 4 - 4).getDepartureTime());
            fxBrowseDiv1ArrivalL.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalLoc());
            fxBrowseDiv1ArrivalT.setText(searchFlightss.get(browseCount * 4 - 4).getArrivalTime());
            fxBrowseDiv1Price.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getSeatPrice()));
            fxBrowseDiv1Seats.setText(String.valueOf(searchFlightss.get(browseCount * 4 - 4).getNumOfAvailableSeats()));

            fxBdiv2.setVisible(false);

            fxBdiv3.setVisible(false);

            fxBdiv4.setVisible(false);
        } else {

            fxBdiv1.setVisible(false);
            fxBdiv2.setVisible(false);

            fxBdiv3.setVisible(false);

            fxBdiv4.setVisible(false);
        }

        fxArrowLeft.setOnMouseClicked(event -> {
            FyrriBrowseSida();
        });

        if (fjoldisida == browseCount) {
            fxArrowRight.setOnMouseClicked(null);
        }


    }

    /**
     * fall sem býr til flott hover effect á cardunum í browse
     *
     * @param event er event þegar músin hoverar yfir card
     */
    public void viewCard(MouseEvent event) {
        Pane source = (Pane) event.getTarget();
        String id = source.getId();
        VBox n;
        if (id.equals("fxBdiv1")) {
            n = fxBrowseDiv1;
            fxBdiv1Book.setVisible(true);
            fxBrowseDiv1.setVisible(false);
        } else if (id.equals("fxBdiv2")) {
            n = fxBrowseDiv2;
            fxBdiv2Book.setVisible(true);
            fxBrowseDiv2.setVisible(false);
        } else if (id.equals("fxBdiv3")) {
            n = fxBrowseDiv3;
            fxBdiv3Book.setVisible(true);
            fxBrowseDiv3.setVisible(false);
        } else {
            n = fxBrowseDiv4;
            fxBdiv4Book.setVisible(true);
            fxBrowseDiv4.setVisible(false);
        }


        node = n;


        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(source);
        scaleTransition.setDuration(Duration.millis(250));
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }

    /**
     * fall sem lagar cardið þegar músin fer af því
     *
     * @param event er event þegar músin hoverar af cardinu
     */
    public void leaveCard(MouseEvent event) {
        Pane source = (Pane) event.getTarget();
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(source);
        scaleTransition.setDuration(Duration.millis(250));
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();


        if (node == fxBrowseDiv1) {
            fxBdiv1Book.setVisible(false);
            fxBrowseDiv1.setVisible(true);
        } else if (node == fxBrowseDiv2) {
            fxBdiv2Book.setVisible(false);
            fxBrowseDiv2.setVisible(true);
        } else if (node == fxBrowseDiv3) {
            fxBdiv3Book.setVisible(false);
            fxBrowseDiv3.setVisible(true);
        } else {
            fxBdiv4Book.setVisible(false);
            fxBrowseDiv4.setVisible(true);
        }


    }


    public void ClearAirlineChoice() {
        fxChoiceBoxAirline.setValue(null);
    }

    public void ClearDateChoice() {
        fxDatePickerDepartureT.setValue(null);
    }

    public void ClearDepartureLocChoice() {
        fxChoiceBoxDepartureL.setValue(null);
    }

    public void ClearArrivalLocChoice() {
        fxChoiceBoxArrivalL.setValue(null);
    }


    public void BookFlight() {
        Flight f;
        if (node == fxBrowseDiv1) {
            f = searchFlightss.get(4 * browseCount - 4);
        } else if (node == fxBrowseDiv2) {
            f = searchFlightss.get(4 * browseCount - 3);
        } else if (node == fxBrowseDiv3) {
            f = searchFlightss.get(4 * browseCount - 2);
        } else {
            f = searchFlightss.get(4 * browseCount - 1);
        }

        ViewSwitcher.switchTo(View.BOOK, users, loggedInUser, f, searchFlightss);


    }


    public void initializeBookingWithFlight(ObservableList<User> userss, User u, Flight f, ObservableList<Flight> flightlst) {
        users = userss;
        loggedInUser = u;
        flightList = flightlst;
        validFlight = f;


        fxBookAirline.setText(f.getAirline());
        fxBookDate.setText(f.getDate());
        fxBookArrivalL.setText(f.getArrivalLoc());
        fxBookArrivalT.setText(f.getArrivalTime());
        fxBookDepartureL.setText(f.getDepartureLoc());
        fxBookDepartureT.setText(f.getDepartureTime());
        fxBookPrice.setText(String.valueOf(f.getSeatPrice()));
        fxBookSeats.setText(String.valueOf(f.getSeatCapacity()));


    }

    /**
     * fall sem býr til nyspurningdialog svo hægt er að búa til nýja spurningu
     */
    public void NewUser() {
        NewUserDialog d = new NewUserDialog();
        User user = d.getUser();

        if (user != null) {
            users.add(user);


        } else {
            d.close();
        }

    }


    public void Login() {
        String name = fxLoginName.getText();
        String passw = fxLoginPassword.getText();

        for (User u : userController.getUsers()) {
            if (u.getNafn().equals(name) && u.getPassword().equals(passw)) {
                loggedInUser = u;
                Browse(users, loggedInUser);
                return;
            }
        }
        fxLoginError.setText("Incorrect username or password");

    }


    public void MyAccount() {
        ViewSwitcher.switchTo(View.ACCOUNT, users, loggedInUser, flightList);
    }


    public void BuyTicket() {

        loggedInUser.addTicket(new Ticket(validFlight, loggedInUser));

        validFlight.setAvailableSeats();


    }

}
