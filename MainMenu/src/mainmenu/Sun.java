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
class Counter {
    public static int count=50;
    public static Label sunCount;
}
public class Sun {
    @FXML
    private TranslateTransition tt3;
    private ImageView sunimage;
    private GridPane mg;
    public Sun(int x,int y, GridPane mainGrid)
    {
        Image image = new Image(getClass().getResourceAsStream("Images/Sun_PvZ2.png"));
        this.sunimage = new ImageView(image);
        sunimage.toFront();
        mainGrid.getChildren().add(sunimage);
        System.out.println("new flower "+x+" "+y);
        GridPane.setConstraints(sunimage,x+1,y);
        sunimage.setFitWidth(60);
        sunimage.setFitHeight(60);
        sunimage.setOnMouseClicked(event1 -> checkClick());
    }
    public Sun(GridPane mainGrid, Label suncounter)
    {
        Image image = new Image(getClass().getResourceAsStream("Images/Sun_PvZ2.png"));
        this.sunimage = new ImageView(image);
        Counter.sunCount=suncounter;
        mg = mainGrid;
        sunimage.setTranslateX(200);
        sunimage.setTranslateY(0);
        sunimage.toFront();
        sunimage.setFitWidth(50);
        sunimage.setFitHeight(50);
        sunimage.setId("sooraj");
        sunimage.setOnMouseClicked(event1 -> checkClick());
        mainGrid.getChildren().add(sunimage);
        sunimage.setOpacity(0);
    }
    public void spawnSun()
    {
        sunimage.setOpacity(1);
        Random random = new Random();
        int ranX = random.nextInt(7); // random value from 0 to width
        int ranY = random.nextInt(5); // random value from 0 to width
        GridPane.setConstraints(sunimage, ranX, ranY);
        System.out.println(ranX+" "+ranY);
        /*if(sunimage.getLayoutY()!=-200)
        {
            sunimage.setLayoutY(-200);
        }
        /*tt3.setNode(sunimage);
        sunimage.setLayoutX(ranX+200);
        System.out.println(sunimage.getX() + " " + sunimage.getY());
        tt3.setDuration(Duration.seconds(2));
        tt3.setToY(ranY+300);
        tt3.play();
        System.out.println((ranX+300)+" "+(ranY+50));
        sunimage.setLayoutX(ranX+300);
        sunimage.setLayoutY(ranY+50);*/
    }
    public void dropSun(){
        System.out.println(sunimage.getLayoutX()+" "+sunimage.getLayoutY());
        //sunimage.setTranslateX(500);
        //sunimage.setTranslateY(0);
        sunimage.translateYProperty().addListener((Observable observable) -> {
            System.out.println(sunimage.getTranslateX()+" inside "+sunimage.getTranslateY());
        });
        tt3 = new TranslateTransition();
        tt3.setDuration(Duration.seconds(20));
        tt3.setToY(500);
        tt3.setNode(sunimage);
        tt3.play();
        
        System.out.println(sunimage.getLayoutX()+" "+sunimage.getLayoutY());
        
    }
    public void spawnsunforflower(GridPane mainGrid,int x,int y)
    {
        sunimage.setOpacity(1);
        GridPane.setConstraints(sunimage,x+1,y);
        sunimage.setFitWidth(60);
        sunimage.setFitHeight(60);
    }
    public void checkClick()
    {
        this.sunimage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("Sun Collected");
                sunimage.setOpacity(0);
                Counter.count+=25;
                Counter.sunCount.setText(""+Counter.count);
                
            }
        });
    }
    public void changecounter(int x)
    {
        Counter.count-=x;
        Counter.sunCount.setText(""+Counter.count);
    }
    public void setNormal()
    {
        Counter.count=50;
        Counter.sunCount.setText(""+Counter.count);
    }
    public void setSunCount(int s){
        Counter.count = s;
        Counter.sunCount.setText(""+Counter.count);
    }
    public int getcount()
    {
        return Counter.count;
    }
}
