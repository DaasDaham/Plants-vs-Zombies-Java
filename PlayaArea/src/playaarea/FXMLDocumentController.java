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
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author saad
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ImageView z1;
    
    @FXML
    private ImageView lm1;
    
    @FXML
    private ImageView lm2;
    @FXML
    private ImageView lm3;
    @FXML
    private ImageView lm4;
    @FXML
    private ImageView lm5;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(100));
        tt.setToX(-750);
        tt.setNode(z1);
        tt.play();
        
        lm1.setOnMouseClicked(new EventHandler<MouseEvent>(){
 
            @Override
            public void handle(MouseEvent event) {
                TranslateTransition tt2 = new TranslateTransition();
                tt2.setDuration(Duration.seconds(15));
                tt2.setToX(1000);
                tt2.setNode(lm1);
                tt2.play();
            }
        });
    }    
    
}
