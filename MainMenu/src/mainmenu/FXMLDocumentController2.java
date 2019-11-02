/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;

/**
 *
 * @author saad
 */
public class FXMLDocumentController2 implements Initializable {
    int count=0;
    @FXML
    private Label sunCount;

    @FXML
    private ImageView z1;

    @FXML
    private ImageView pea1;
    
    @FXML
    private ImageView lm1;

    @FXML
    private ImageView sun;
    @FXML
    private ImageView lm2;
    @FXML
    private ImageView lm3;
    @FXML
    private ImageView lm4;
    @FXML
    private ImageView lm5;
    @FXML
    private Button pauseButton;
    @FXML
    private AnchorPane igm;
    @FXML
    private Button igmExitButton;
    @FXML
    private TranslateTransition tt;
    @FXML
    private TranslateTransition tt2;
    @FXML
    private TranslateTransition tt3;
    


    @Override
    public void initialize(URL url, ResourceBundle rb){
        tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(1.55));
        tt.setToX(1000);
        tt.setNode(pea1);
        tt.setCycleCount( Timeline.INDEFINITE );
        tt.play();

        spawnSun();


        lm1.setOnMouseClicked(new EventHandler<MouseEvent>(){
 
            @Override
            public void handle(MouseEvent event) {
                tt2 = new TranslateTransition();
                tt2.setDuration(Duration.seconds(2));
                tt2.setToX(1000);
                tt2.setNode(lm1);
                tt2.play();
            }
        });
        lm2.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                tt2 = new TranslateTransition();
                tt2.setDuration(Duration.seconds(2));
                tt2.setToX(1000);
                tt2.setNode(lm2);
                tt2.play();
            }
        });
        lm3.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                tt2 = new TranslateTransition();
                tt2.setDuration(Duration.seconds(2));
                tt2.setToX(1000);
                tt2.setNode(lm3);
                tt2.play();
            }
        });
        lm4.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                tt2 = new TranslateTransition();
                tt2.setDuration(Duration.seconds(2));
                tt2.setToX(1000);
                tt2.setNode(lm4);
                tt2.play();
            }
        });
        lm5.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                tt2 = new TranslateTransition();
                tt2.setDuration(Duration.seconds(2));
                tt2.setToX(1000);
                tt2.setNode(lm5);
                tt2.play();
            }
        });
        z1.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                tt2 = new TranslateTransition();
                tt2.setDuration(Duration.seconds(7));
                tt2.setToX(-750);
                tt2.setNode(z1);
                tt2.play();
            }
        });
        sun.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                sun.setY(-500);
                count+=100;
                sunCount.setText(""+count);

            }
        });

    }

    
    @FXML
    private void handlePauseButton(ActionEvent event) {
        System.out.println("sdglajgn");
        igm.toFront();
        tt2.pause();
       
    }

    @FXML
    private void handleIgmExit(ActionEvent event) {
        igm.toBack();
        tt2.play();
        Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage1.close();

    }
    @FXML
    private void spawnSun()
    {
        Random random = new Random();
        int ranX = random.nextInt(11); // random value from 0 to width
        int ranY = random.nextInt(7);
        System.out.println(ranX+" "+ranY);

        tt3 = new TranslateTransition();
        tt3.setDuration(Duration.seconds(1.55));
        tt3.setToY(500);
        tt3.setNode(sun);
        tt3.play();

    }
    
}
