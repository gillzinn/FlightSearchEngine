package vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinnsla.Airplane;

public class AirplaneController {
    protected ObservableList<Airplane> planes = FXCollections.observableArrayList();

    public void initialize() {

        setPlane(new Airplane("1", "IcelandAir", 100));
        setPlane(new Airplane("2", "Play", 150));
        setPlane(new Airplane("3", "Wow air", 75));
        setPlane(new Airplane("4", "IcelandAir", 200));
        setPlane(new Airplane("5", "Play", 50));


    }


    public void setPlane(Airplane e) {
        planes.add(e);
    }

    public ObservableList<Airplane> getPlanes() {
        return planes;
    }
}
