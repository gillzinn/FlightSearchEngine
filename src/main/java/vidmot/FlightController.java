package vidmot;


import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import vinnsla.Airplane;
import vinnsla.Flight;
import vinnsla.FlightList;
import vinnsla.User;

public class FlightController {


    private VBox node;//node sem er hoveruð yfir í browse

    private AirplaneController airplaneController;
    private UserController userController;
    private ObservableList<Flight> flightList;

    private ObservableList<Airplane> planes;
    private ObservableList<Flight> searchFlightss;
    private FlightList mainFlightList;
    private ObservableList<User> users;


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


    }


}
