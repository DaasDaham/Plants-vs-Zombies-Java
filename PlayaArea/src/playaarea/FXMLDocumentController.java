/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playaarea;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author saad
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label lawnmover1;
    @FXML
    private Label lawnmover2;
    @FXML
    private Label lawnmover3;
    @FXML
    private Label lawnmover4;
    @FXML
    private Label lawnmover5;

    @FXML
    private void handleButtonAction1(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World1!");
        lawnmover1.setTranslateX(1000);
    }
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World2!");
        lawnmover2.setTranslateX(1000);
    }
    @FXML
    private void handleButtonAction3(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World3!");
        lawnmover3.setTranslateX(1000);
    }
    @FXML
    private void handleButtonAction4(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World4!");
        lawnmover4.setTranslateX(1000);
    }
    @FXML
    private void handleButtonAction5(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World5!");
        lawnmover5.setTranslateX(1000);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
