package mainmenu;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.logging.Level;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import javafx.animation.KeyFrame;
import javafx.beans.Observable;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Sun {
    @FXML
    private TranslateTransition tt3;
    private ImageView sunimage;
    public Sun(AnchorPane mainGrid)
    {
        Image image = new Image(getClass().getResourceAsStream("Images/Sun_PvZ2.png"));
        this.sunimage = new  ImageView(image);
        sunimage.setLayoutX(0);
        sunimage.setLayoutY(-200);
        sunimage.toFront();
        sunimage.setFitWidth(50);
        sunimage.setFitHeight(50);
        sunimage.setId("sooraj");
        mainGrid.getChildren().add(sunimage);
        sunimage.setOnMouseClicked(event1 -> checkClick());
    }
    public void spawnSun()
    {
        Random random = new Random();
        int ranX = random.nextInt(700); // random value from 0 to width
        int ranY = random.nextInt(500); // random value from 0 to width
        /*tt3.setNode(sunimage);
        sunimage.setLayoutX(ranX+200);
        System.out.println(sunimage.getX() + " " + sunimage.getY());
        tt3.setDuration(Duration.seconds(2));
        tt3.setToY(ranY+300);
        tt3.play();*/
        sunimage.setLayoutX(ranX+200);
        sunimage.setTranslateY(ranY+200);
    }
    public void checkClick()
    {
        this.sunimage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Clicked");
                sunimage.setTranslateY(-200);
            }
        });
    }
}
