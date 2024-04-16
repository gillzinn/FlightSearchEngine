package vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinnsla.User;

public class UserController {

    protected ObservableList<User> users = FXCollections.observableArrayList();

    public void initialize() {

        setUser(new User("121000-3280", "Egill", "egill@gmail.com", "123"));


    }


    public void setUser(User u) {
        users.add(u);

    }


    public ObservableList<User> getUsers() {
        return users;
    }
}
