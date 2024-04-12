package vidmot;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import vinnsla.Flight;

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
            FlightController browseController = loader.getController();
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


}
