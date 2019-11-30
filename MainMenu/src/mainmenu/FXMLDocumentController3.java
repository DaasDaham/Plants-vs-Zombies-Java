package mainmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FXMLDocumentController3 {
    @FXML
    private Label Level1;
    @FXML
    private Label Level2;
    @FXML
    private Label Level3;
    @FXML
    private Label Level4;
    @FXML
    private Label Level5;

    @FXML
    private void handleNewGame(ActionEvent event) throws IOException {
        try {

            Parent startPageParent1 = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
            Scene startPageScene1 = new Scene(startPageParent1);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            appStage1.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);

        }
}}

