/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author saad
 */
public class MainMenu extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        //Parent root = loader.load();

        //FXMLDocumentController2 controller = loader.getController();
        
        /*Zombie lol1 = new NormalZombie();
        Zombie flyi = new FlyingZombie();
        Zombie flagi = new FlagZombie();
        Zombie bucketi = new BucketZombie();*/
        //controller.bigOuf(imageView, 2, 5);
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        
        //controller.addZombie(flyi);
        //controller.addZombie(flagi);
        //controller.addZombie(bucketi);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
    
}
