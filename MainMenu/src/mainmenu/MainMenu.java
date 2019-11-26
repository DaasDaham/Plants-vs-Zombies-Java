/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

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
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        Parent root = loader.load();

        FXMLDocumentController2 controller = loader.getController();
        Image image = new Image(getClass().getResourceAsStream("ProjectilePea_1.png"));
        ImageView imageView = new ImageView(image);

        //controller.bigOuf(imageView, 2, 5);
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        
        
        stage.show();
        /*primaryStage.setTitle("ImageView Experiment 1");

        Image image = new Image(getClass().getResourceAsStream("ProjectilePea_1.png"));
        ImageView imageView = new ImageView(image);

        HBox hbox = new HBox(imageView);

        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
    
}
