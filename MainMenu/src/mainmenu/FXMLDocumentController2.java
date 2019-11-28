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
/**
 *
 * @author saad
 */
public class FXMLDocumentController2 implements Initializable {
    @FXML
    private Label sunCount;
    @FXML
    private ImageView z1;
    @FXML
    private ImageView sunPlantSide;
    @FXML
    private ImageView peaPlantSide;
    @FXML
    private ImageView cornBreadSide;
    @FXML
    private ImageView pea1;
    @FXML
    private ImageView lawn;
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
    private GridPane mainGrid;
    @FXML
    private AnchorPane sunpane;

    @FXML
    private Button igmExitButton;
    private TranslateTransition tt;
    private TranslateTransition tt2;
    private TranslateTransition tt3;
    private TranslateTransition tt4;
    @FXML
    private ProgressBar progBar;
    @FXML
    private ImageView z11;
    @FXML
    private Color x2;
    @FXML
    private Font x1;

    private Timer timer;
    @FXML
    private Button igmCloseBut;

    @FXML
    private void igmclose(ActionEvent event) {
        igm.toBack();
    }
    
    private void ssFade() {
        FadeTransition fade = new FadeTransition();  
        fade.setDuration(Duration.millis(10000)); 
        fade.setFromValue(0.1);  
        fade.setToValue(10);
        fade.setNode(sunPlantSide);
        fade.play();
    }

    private void spFade() {
        FadeTransition fade = new FadeTransition();  
        fade.setDuration(Duration.millis(10000)); 
        fade.setFromValue(0.1);  
        fade.setToValue(10);
        fade.setNode(peaPlantSide);
        fade.play();
    }

    private void cbFade() {
        FadeTransition fade = new FadeTransition();  
        fade.setDuration(Duration.millis(10000)); 
        fade.setFromValue(0.1);  
        fade.setToValue(10);
        fade.setNode(cornBreadSide);
        fade.play();
    }
    
    class Helper extends TimerTask 
    { 
        Random r = new Random();
	public int i = 0; 
	public void run() 
	{ 
            ++i;
            if(i<=5){
                peaPlantSide.setOpacity(i/5.0);
                cornBreadSide.setOpacity(i/5.0);
            }
            progBar.setProgress(i/500.0);
            int prob = r.nextInt(10);

	} 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        Sun s = new Sun(sunpane,sunCount);
        igm.toBack();
        progBar.setProgress(0);
        timer = new Timer(); 
        //TimerTask task = new Helper(); 	
	  //  timer.schedule(task, 0, 1000);
        
        //pic.toFront();
        //hb.toFront();
   
        pea1.translateXProperty().addListener((Observable observable) -> {
            if(checkIntersect(pea1, z1)){
                pea1.setOpacity(0);
                GridPane.setConstraints(pea1, 3, 0);
            }
            if(pea1.getTranslateX()==0){
                pea1.setOpacity(1);
            }
            if(pea1.getTranslateX()==0){
                pea1.setOpacity(1);
            }
        });


        tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(7));
        tt.setToX(1000);
        tt.setNode(pea1);
        tt.setCycleCount( Timeline.INDEFINITE );
        tt.play();

        Runnable task2 = () -> {
            System.out.println("Sun Spawned");
            s.spawnSun();
        };
        
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(task2, 10, 5,
                TimeUnit.SECONDS);


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
        pauseButton.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                tt.pause();
                tt2.pause();
                tt3.pause();
            }
        });
        igmCloseBut.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                tt.play();
                tt2.play();
                tt3.play();
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
        tt4 = new TranslateTransition();
        tt4.setDuration(Duration.seconds(30));
        tt4.setToX(-750);
        tt4.setNode(z1);
        tt4.play();
        /*sun.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                count+=25;
                sunCount.setText(""+count);
                sun.setY(-500);
                
            }
        });*/
        
        sunPlantSide.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            Dragboard db = sunPlantSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(sunPlantSide.getImage());
            db.setContent(cbContent);
            ssFade();
            event.consume();
        }
    });
    sunPlantSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            event.consume();
        }
    });
    peaPlantSide.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            Dragboard db = peaPlantSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(peaPlantSide.getImage());
            cbContent.putUrl("Pea");
            db.setContent(cbContent);
            spFade();
            event.consume();
        }
    });
    peaPlantSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            event.consume();
        }
    });
    cornBreadSide.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            Dragboard db = cornBreadSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(cornBreadSide.getImage());
            db.setContent(cbContent);
            cbFade();
            event.consume();
        }
    });
    cornBreadSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            event.consume();
        }
    });
    mainGrid.setOnDragOver(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            if(event.getGestureSource() != mainGrid && event.getDragboard().hasImage()){
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        }
    });

    mainGrid.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            if(event.getGestureSource() != mainGrid && event.getDragboard().hasImage()){
                mainGrid.setOpacity(0.7);
                System.out.println("Drag entered");
            }
            event.consume();
        }
    });

    mainGrid.setOnDragExited(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            mainGrid.setOpacity(1);

            event.consume();
        }
    });

    mainGrid.setOnDragDropped(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            Dragboard db = event.getDragboard();
    boolean success = false;
    ImageView img = new ImageView(db.getImage());
    
    Node node = event.getPickResult().getIntersectedNode();
    if(node==null){
            System.out.println("nodes null");

    }
    System.out.println(node);
    
    if(node != mainGrid && db.hasImage()){
        System.out.println("nodes null");
        Integer cIndex = GridPane.getColumnIndex(node);
        Integer rIndex = GridPane.getRowIndex(node);
        int x = cIndex == null ? 0 : cIndex;
        int y = rIndex == null ? 0 : rIndex;
        ImageView image;
        System.out.println(db.getUrl());
        if(db.getUrl().equals("Pea")){
            image = new ImageView(new Image(getClass().getResourceAsStream("Images/plant_1.gif")));
        }
            else{
            image = new ImageView(db.getImage());
        }
        image.setPreserveRatio(true);
        image.setFitWidth(100);
        Pane to_add = (Pane)node;
        to_add.getChildren().add(image);

        success = true;
    }
    event.setDropCompleted(success);

    event.consume();
        }
    });

       /* sunpane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
            }
        });*/
    }


    @FXML
    private void handlePauseButton(ActionEvent event) {
        igm.toFront();
    }

    @FXML
    private void handleIgmExit(ActionEvent event) {
        try {

            Parent startPageParent1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene startPageScene1 = new Scene(startPageParent1);
            Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage1.setScene(startPageScene1);
            appStage1.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);

        }
        timer.cancel();
        /*igm.toBack();
        Stage appStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage1.close();*/

    }
    private boolean checkIntersect(ImageView v1, ImageView v2){
        if(v1.getBoundsInParent().intersects(v2.getBoundsInParent())){
            System.out.println("intersection");
            return true;
        }
        return false;
    }
    
    public void bigOuf(ImageView image, int x, int y){
        //ImageView image = new ImageView(new Image(getClass().getResourceAsStream("Images/ProjectilePea_1.png")));
        mainGrid.getChildren().add(image);
        GridPane.setConstraints(image, x, y );
    }
}
