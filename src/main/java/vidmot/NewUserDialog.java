package vidmot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.User;

import java.io.IOException;
import java.util.Optional;

public class NewUserDialog extends Dialog<User> {

    // viðmótshlutir
    @FXML
    private TextField fxName; // nafn notanda  element- engin controller í .fxml skrá þannig að breytur eru ekki litaðar
    @FXML
    private TextField fxEmail; // spurning sem bæta á við
    @FXML
    private TextField fxPassword;// svar við spurningunni
    @FXML
    private TextField fxKennitala;


    @FXML
    private ButtonType fxILagi;// í lagi button


    /**
     * Ný spurning dialog smiður
     */
    public NewUserDialog() {
        setDialogPane(lesaUserDialog());
        iLagiRegla();


        setResultConverter(b -> {                                 // b er af taginu ButtonType
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                User ny = new User(fxKennitala.getText(), fxName.getText(), fxEmail.getText(), fxPassword.getText());
                return ny;
            } else {
                return null;
            }
        });         // endir á d.setResultConverter

    }

    /**
     * þettta les fxml skránna sem inniheldur dialoginn
     *
     * @return Dialoginum
     */
    private DialogPane lesaUserDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newuser-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    /**
     * Regla sem bindir disableproperty á ilagi takka við það að búið sé að fylla inn í alla reiti
     */
    private void iLagiRegla() {
        // fletta upp í lagi hnappnum út frá hnappategund
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty()
                .bind(fxName.textProperty().isEmpty()
                        .or(fxEmail.textProperty().isEmpty().or(fxKennitala.textProperty().isEmpty().or(fxPassword.textProperty().isEmpty()))));
    }

    /**
     * Birtir dialog d og skilar nafni notanda úr dialog
     *
     * @return skilar nafni notanda nema ef hætt við þá skilar hann null
     */
    public User getUser() {
        // Dialog birtur og svarið fengið
        Optional<User> utkoma = showAndWait();
        return utkoma.orElse(null);
    }
}
