package vidmot;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import vinnsla.Flight;
import vinnsla.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewSwitcher {

    private static Scene scene;//núverandi scene
    private static Map<View, Parent> cache = new HashMap<>();//hashmap sem geymir uppl um scenes sem gerðust á undan

    /**
     * fall sem setur scene
     *
     * @param scene er scene sem á að setja
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }


    /**
     * Fall sem skiptir um scenu
     *
     * @param view er síðan sem á að breyta í
     */
    public static void switchTo(View view) {
        if (scene == null) {
            return;
        }
        try {
            Parent root;

            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFilename()));
            root = loader.load();
            cache.put(view, root);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Fall sem skiptir um scenu
     *
     * @param view       er síðan sem á að breyta í
     * @param flightList er listi af quizum sem er notaður til að uppfæra listann á nýju síðunni
     */
    public static void switchTo(View view, ObservableList<Flight> flightList) {

        if (scene == null) {
            return;
        }
        try {
            Parent root;


            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFilename()));
            root = loader.load();
            ViewController browseController = loader.getController();
            switch (view.getFilename()) {
                case "browse-view.fxml":
                    browseController.initializeBrowse(flightList);
                    break;

            }

            cache.put(view, root);


            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void switchTo(View view, ObservableList<User> users, User u, Flight f, ObservableList<Flight> flightList) {
        if (scene == null) {
            return;
        }
        try {
            Parent root;

            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFilename()));
            root = loader.load();
            if (view.getFilename().equals("booking-view.fxml")) {
                ViewController Controller = loader.getController();
                Controller.initializeBookingWithFlight(users, u, f, flightList);
            }

            cache.put(view, root);


            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void switchTo(View view, ObservableList<User> users, User u, ObservableList<Flight> flightList) {
        if (scene == null) {
            return;
        }
        try {
            Parent root;

            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFilename()));
            root = loader.load();
            ViewController Controller = loader.getController();

            switch (view.getFilename()) {
                case "browse-view.fxml":
                    Controller.initializeBrowseWithUser(users, u, flightList);
                    break;
                case "myaccount-view.fxml":
                    Controller.initializeAccount(users, u, flightList);
                    break;
            }

            cache.put(view, root);


            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
