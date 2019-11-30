package mainmenu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.net.URL;

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
public class Special {
}
class Thunder extends Special
{

    public Thunder(GridPane mainGrid)
    {
        for(int i=0;i<10;i++)
            for(int j=0;j<6;j++)
        {   ImageView specialimg;
            specialimg = new ImageView(new Image(getClass().getResourceAsStream("Images/thunder.gif")));
            specialimg.toFront();
            specialimg.setScaleZ(5);
            mainGrid.getChildren().add(specialimg);
            GridPane.setConstraints(specialimg,i,j);
            for(Zombie zom: FXMLDocumentController2.lane0)
            {
                zom.takeDamage(50,mainGrid,FXMLDocumentController2.lane0);
            }
            for(Zombie zom: FXMLDocumentController2.lane1)
            {
                zom.takeDamage(50,mainGrid,FXMLDocumentController2.lane0);
            }
            for(Zombie zom: FXMLDocumentController2.lane2)
            {
                zom.takeDamage(50,mainGrid,FXMLDocumentController2.lane0);
            }
            for(Zombie zom: FXMLDocumentController2.lane3)
            {
                zom.takeDamage(50,mainGrid,FXMLDocumentController2.lane0);
            }
            for(Zombie zom: FXMLDocumentController2.lane4)
            {
                zom.takeDamage(50,mainGrid,FXMLDocumentController2.lane0);
            }
            specialimg.setFitWidth(100);
            specialimg.setFitHeight(200);
        }

    }
}
class Laser extends Special
{
    public Laser(GridPane mainGrid)
    {
        for(int i=0;i<5;i++)
        {
            ImageView specialimg;
            specialimg = new ImageView(new Image(getClass().getResourceAsStream("Images/laser_beam.gif")));
            specialimg.toFront();
            mainGrid.getChildren().add(specialimg);
            specialimg.setScaleX(5);
            specialimg.setScaleY(3);
            GridPane.setConstraints(specialimg,4,i);
            for(Zombie zom: FXMLDocumentController2.lane0)
            {
                zom.takeDamage(100,mainGrid,FXMLDocumentController2.lane0);
            }
            for(Zombie zom: FXMLDocumentController2.lane1)
            {
                zom.takeDamage(100,mainGrid,FXMLDocumentController2.lane1);
            }
            for(Zombie zom: FXMLDocumentController2.lane2)
            {
                zom.takeDamage(100,mainGrid,FXMLDocumentController2.lane2);
            }
            for(Zombie zom: FXMLDocumentController2.lane3)
            {
                zom.takeDamage(100,mainGrid,FXMLDocumentController2.lane3);
            }
            for(Zombie zom: FXMLDocumentController2.lane4)
            {
                zom.takeDamage(100,mainGrid,FXMLDocumentController2.lane4);
            }
            //specialimg.setFitWidth(100);
            //specialimg.setFitHeight(200);
        }
    }
}