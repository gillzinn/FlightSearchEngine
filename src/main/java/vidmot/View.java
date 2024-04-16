package vidmot;

public enum View {


    MAIN("home-view.fxml"),
    BROWSE("browse-view.fxml"),
    BOOK("booking-view.fxml"),
    ACCOUNT("myaccount-view.fxml");

    private String filename;

    //smiður fyrir skráarnafn á fxml skránni
    View(String filename) {
        this.filename = filename;
    }

    //skilar skráarnafninu
    public String getFilename() {
        return filename;
    }
}
