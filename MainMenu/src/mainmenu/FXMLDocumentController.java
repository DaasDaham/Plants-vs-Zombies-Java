/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author saad
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;

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
    }

    @FXML
    private void handleResumeGame(ActionEvent event) throws IOException {
        try {

            Parent startPageParent1 = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
            Scene startPageScene1 = new Scene(startPageParent1);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            appStage1.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);

        }
    }
    @FXML
    private void handleselectlevel(ActionEvent event) throws IOException {
        try {

            Parent startPageParent1 = FXMLLoader.load(getClass().getResource("FXMLDocument3.fxml"));
            Scene startPageScene1 = new Scene(startPageParent1);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            appStage1.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);

        }
    }
    @FXML
    private void handleExitGame(ActionEvent event) {
        Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

