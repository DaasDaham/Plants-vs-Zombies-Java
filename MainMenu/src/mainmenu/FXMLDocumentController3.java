package mainmenu;

import java.io.FileInputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import static mainmenu.FXMLDocumentController2.lane0;

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
    
    private Srz nn;
    
    @FXML
    private void handlesave1(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            deserialize("first");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        Parent root = loader.load();

        FXMLDocumentController2 controller = loader.getController();

            Scene startPageScene1 = new Scene(root);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            controller.setLevel(nn.level);
            controller.setCounter(nn.suncount);
            controller.setallPlants(nn.allPlants);
            controller.setallPlants(nn.plantTypes);
            controller.setNumSerialize(nn.numSerialize);
            appStage1.show();
            for(int i=0;i<5;i++){
                for(int j=0;j<9;j++){
                    if(nn.allPlants[i][j]==1){
                        controller.startPLant(i, j, nn.plantTypes[i][j]);

                    }
                    
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    @FXML
    private void handlesave2(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            deserialize("second");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        Parent root = loader.load();

        FXMLDocumentController2 controller = loader.getController();

            Scene startPageScene1 = new Scene(root);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            controller.setLevel(nn.level);
            controller.setCounter(nn.suncount);
            controller.setallPlants(nn.allPlants);
            controller.setallPlants(nn.plantTypes);
            controller.setNumSerialize(nn.numSerialize);
            appStage1.show();
            for(int i=0;i<5;i++){
                for(int j=0;j<9;j++){
                    if(nn.allPlants[i][j]==1){
                        controller.startPLant(i, j, nn.plantTypes[i][j]);

                    }
                    
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    @FXML
    private void handlesave3(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            deserialize("third");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        Parent root = loader.load();

        FXMLDocumentController2 controller = loader.getController();

            Scene startPageScene1 = new Scene(root);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            controller.setLevel(nn.level);
            controller.setCounter(nn.suncount);
            controller.setallPlants(nn.allPlants);
            controller.setallPlants(nn.plantTypes);
            controller.setNumSerialize(nn.numSerialize);
            appStage1.show();
            for(int i=0;i<5;i++){
                for(int j=0;j<9;j++){
                    if(nn.allPlants[i][j]==1){
                        controller.startPLant(i, j, nn.plantTypes[i][j]);

                    }
                    
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    @FXML
    private void handlesave4(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            deserialize("fourth");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        Parent root = loader.load();

        FXMLDocumentController2 controller = loader.getController();

            Scene startPageScene1 = new Scene(root);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            controller.setLevel(nn.level);
            controller.setCounter(nn.suncount);
            controller.setallPlants(nn.allPlants);
            controller.setallPlants(nn.plantTypes);
            controller.setNumSerialize(nn.numSerialize);
            appStage1.show();
            for(int i=0;i<5;i++){
                for(int j=0;j<9;j++){
                    if(nn.allPlants[i][j]==1){
                        controller.startPLant(i, j, nn.plantTypes[i][j]);

                    }
                    
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    @FXML
    private void handlesave5(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            deserialize("fifth");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        Parent root = loader.load();

        FXMLDocumentController2 controller = loader.getController();

            Scene startPageScene1 = new Scene(root);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            controller.setLevel(nn.level);
            controller.setCounter(nn.suncount);
            controller.setallPlants(nn.allPlants);
            controller.setallPlants(nn.plantTypes);
            controller.setNumSerialize(nn.numSerialize);
            appStage1.show();
            for(int i=0;i<5;i++){
                for(int j=0;j<9;j++){
                    if(nn.allPlants[i][j]==1){
                        controller.startPLant(i, j, nn.plantTypes[i][j]);

                    }
                    
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    public void deserialize(String s) throws IOException, ClassNotFoundException{
        ObjectInputStream in =null;
        try{
            in = new ObjectInputStream(
                    new FileInputStream(s+"Save.txt"));
            nn = (Srz)in.readObject();
        }finally{
            in.close();
        }
    }
}

