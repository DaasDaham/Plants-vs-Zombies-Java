/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
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
import java.util.ArrayList;
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
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
/**
 *
 * @author saad
 */
public class FXMLDocumentController2 implements Initializable {
    int i=0;
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
    private ImageView cherryBombSide;
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
    public Zombie damnZombie;
    public FlagZombie dZombie;
    public int[][] allPlants = new int[5][9];
    public int level = 1;

    public static Queue<Zombie> lane0 = new LinkedList<Zombie>();
    public static Queue<Zombie> lane1 = new LinkedList<Zombie>();
    public static Queue<Zombie> lane2 = new LinkedList<Zombie>();
    public static Queue<Zombie> lane3 = new LinkedList<Zombie>();
    public static Queue<Zombie> lane4 = new LinkedList<Zombie>();
    
    public boolean peablock=false;
    public boolean sunblock=false;
    public boolean walnutblock=false;
    public boolean cbblock=false;
    public int peaTimer=1;
    public int sunTimer=1;
    public int walnutTimer=1;
    public int cbTimer=1;
    public int timerI = 0; 
    

    public Plant[] plane0 = new Plant[9];
    public Plant[] plane1 = new Plant[9];
    public Plant[] plane2 = new Plant[9];
    public Plant[] plane3 = new Plant[9];
    public Plant[] plane4 = new Plant[9];
    
    public int numPlants= 0;
    

    @FXML
    private void igmclose(ActionEvent event) {
        igm.toBack();
    }
    
    private void ssFade() {
        FadeTransition fade = new FadeTransition();  
        fade.setDuration(Duration.millis(5000)); 
        fade.setFromValue(0.1);  
        fade.setToValue(1);
        fade.setNode(sunPlantSide);
        fade.play();
    }

    private void spFade() {
        FadeTransition fade = new FadeTransition();  
        fade.setDuration(Duration.millis(5000)); 
        fade.setFromValue(0.1);  
        fade.setToValue(1);
        fade.setNode(peaPlantSide);
        fade.play();
        
    }

    private void cbFade() {
        FadeTransition fade = new FadeTransition();  
        fade.setDuration(Duration.millis(5000)); 
        fade.setFromValue(0.1);  
        fade.setToValue(1);
        fade.setNode(cornBreadSide);
        fade.play();
    }
    
    private void chbFade() {
        FadeTransition fade = new FadeTransition();  
        fade.setDuration(Duration.millis(5000)); 
        fade.setFromValue(0.1);  
        fade.setToValue(1);
        fade.setNode(cherryBombSide);
        fade.play();
    }
    
    class Helper extends TimerTask 
    { 
        Random r = new Random();
	
	public void run() 
	{ 
            ++timerI;
            
            //System.out.println("val i+ "+i);
            progBar.setProgress(timerI/10.0);
            if(timerI%10==0 && timerI>=2){
                Platform.runLater(() -> {
                    addZombie(new NormalZombie());
                    //Special trying = new Laser(mainGrid);
                });  
            }
            if(progBar.getProgress()>=1){
                level++;
                Platform.runLater(() -> {
                ObservableList<Node> childrens = mainGrid.getChildren();
                for(Node node : childrens) {
                 if(node instanceof ImageView) {
                    ImageView imageView=(ImageView)node; // use what you want to remove
                    mainGrid.getChildren().remove(imageView);
                    break;
                }
                }
                lane0 = new LinkedList<Zombie>();
                lane1 = new LinkedList<Zombie>();
                lane2 = new LinkedList<Zombie>();
                lane3 = new LinkedList<Zombie>();
                lane4 = new LinkedList<Zombie>();
                plane0 = new Plant[9];
                plane1 = new Plant[9];
                plane2 = new Plant[9];
                plane3 = new Plant[9];
                plane4 = new Plant[9];
                for(int kk=0;kk<9;kk++){
                plane0[kk] = null;
                plane1[kk]=null;
                plane2[kk]=null;
                plane3[kk]=null;
                plane4[kk]=null;
                }
                allPlants = new int[5][9];
                timerI=0;
                progBar.setProgress(0);
                System.out.println("Entered next level");
            }); }
	} 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        if(level==1){
            sunPlantSide.setOpacity(0);
            cornBreadSide.setOpacity(0);
            cherryBombSide.setOpacity(0);
        }else if(level==2){
            cornBreadSide.setOpacity(0);
            cherryBombSide.setOpacity(0);
        }else if(level==3){
            cherryBombSide.setOpacity(0);
        }
        for(int kk=0;kk<9;kk++){
            plane0[kk] = null;
            plane1[kk]=null;
            plane2[kk]=null;
            plane3[kk]=null;
            plane4[kk]=null;
        }
        addZombie(new NormalZombie());

        Sun s = new Sun(mainGrid,sunCount);
        igm.toBack();
        progBar.setProgress(0);
        timer = new Timer();
        TimerTask task = new Helper(); 
          
        timer.schedule(task, 2000, 1000);

        Runnable task2 = () -> {
            System.out.println("Sun Spawned");
            s.spawnSun();
        };
        
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(task2, 5, 20,
                TimeUnit.SECONDS);
        
         
        
        /*Runnable task3 = () -> {
            
            Zombie z = new NormalZombie();
            addZombie(z);
        };  
        
        ScheduledExecutorService scheduler2
                = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(task3, 4, 5,
                TimeUnit.SECONDS);*/


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
            if(level>=2){
            Dragboard db = sunPlantSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(sunPlantSide.getImage());
            cbContent.putUrl("Sun");
            db.setContent(cbContent);
            ssFade();
            event.consume();}
        }
    });
    sunPlantSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            event.consume();
        }
    });
    cherryBombSide.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            if(level>=4){
            Dragboard db = cherryBombSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(cherryBombSide.getImage());
            cbContent.putUrl("Cherry");
            db.setContent(cbContent);
            ssFade();
            event.consume();}
        }
    });
    cherryBombSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            event.consume();
        }
    });
    peaPlantSide.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            System.out.println(timerI+" lock "+peaTimer);
            if(timerI>=peaTimer){
            Dragboard db = peaPlantSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(peaPlantSide.getImage());
            cbContent.putUrl("Pea");
            db.setContent(cbContent);
            event.consume();
            }
        }
    });
    peaPlantSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            spFade();
            peaTimer = timerI+5;
            event.consume();
        }
    });
    cornBreadSide.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            if(level>=3){
            Dragboard db = cornBreadSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(cornBreadSide.getImage());
            cbContent.putUrl("Walnut");
            db.setContent(cbContent);
            cbFade();
            event.consume();}
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
            Node node = (Node)event.getTarget();
            //System.out.println(node.getParent());
            if(node != mainGrid && db.hasImage()){
            Integer cIndex = GridPane.getColumnIndex(node);
            Integer rIndex = GridPane.getRowIndex(node);
            int x = cIndex == null ? 0 : cIndex;
            int y = rIndex == null ? 0 : rIndex;
            if(allPlants[y][x]!=1){
            if(db.getUrl().equals("Pea")){
                Plant p = new PeaPlant();
                
                ImageView plantimg = p.getImage();
                ImageView peaimg = p.getBullet();
                plantimg.setPreserveRatio(true);
                plantimg.setFitWidth(70);
                peaimg.setPreserveRatio(true);
                peaimg.setFitWidth(30);
                
                
                p.setX(x);
                p.setY(y);
                allPlants[y][x]=1;
                if(y==0 && level >=3){
                    plane0[x] = p;
                    p.attack(mainGrid, lane0);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);
                }else if(y==1 && level >=2){
                    plane1[x] = p;
                    p.attack(mainGrid, lane1);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);
                }else if(y==2 && level==1){
                    plane2[x] = p;
                    p.attack(mainGrid, lane2);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);
                }else if(y==3 && level>=2){
                    plane3[x] = p;
                    p.attack(mainGrid, lane3);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);
                }else if(y==4 && level>=3){
                    plane4[x] = p;
                    p.attack(mainGrid, lane4);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);
                }
                
            }
            else if(db.getUrl().equals("Sun")){
                Plant p = new SunFlowerPlant(mainGrid);
                p.setZombie(damnZombie);  //CHANGE THIS

                ImageView plantimg = p.getImage();
                plantimg.setPreserveRatio(true);
                plantimg.setFitWidth(70);
                p.setX(x);
                p.setY(y);
                allPlants[y][x]=1;
                if(y==0 && level >=3){
                    plane0[x] = p;
                    p.attack(mainGrid, lane0);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==1 && level >=2){
                    plane1[x] = p;
                    p.attack(mainGrid, lane1);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==2 && level==1){
                    plane2[x] = p;
                    p.attack(mainGrid, lane2);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==3 && level>=2){
                    plane3[x] = p;
                    p.attack(mainGrid, lane3);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==4 && level>=3){
                    plane4[x] = p;
                    p.attack(mainGrid, lane4);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }
            }
            else if(db.getUrl().equals("Walnut")){
                Plant p = new WalnutPlant();
                p.setZombie(lane1.peek());  //CHANGE THIS
                ImageView plantimg = p.getImage();
                plantimg.setPreserveRatio(true);
                plantimg.setFitWidth(70);
                
                p.setX(x);
                p.setY(y);
                
                allPlants[y][x]=1;
                if(y==0 && level >=3){
                    plane0[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }else if(y==1 && level>=2){
                    plane1[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }else if(y==2 && level==1){
                    plane2[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }else if(y==3 && level>=2){
                    plane3[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }else if(y==4 && level >=3){
                    plane4[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }
            }
            else if((db.getUrl().equals("Cherry"))){
                Plant p = new CherryBombPlant();
                p.setZombie(lane1.peek());  //CHANGE THIS
                ImageView plantimg = p.getImage();
                plantimg.setPreserveRatio(true);
                plantimg.setFitWidth(100);
                p.setX(x);
                p.setY(y);
                allPlants[y][x]=1;
                if(y==0 && level >=3){
                    plane0[x] = p;
                    p.attack(mainGrid, lane0);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==1 && level >=2){
                    plane1[x] = p;
                    p.attack(mainGrid, lane1);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==2 && level==1){
                    plane2[x] = p;
                    p.attack(mainGrid, lane2);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==3 && level>=2){
                    plane3[x] = p;
                    p.attack(mainGrid, lane3);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==4 && level>=3){
                    plane4[x] = p;
                    p.attack(mainGrid, lane4);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }
            }
            success = true;
        }}
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
       //Special trying = new Thunder(mainGrid); // special 1
       //Special trying = new Laser(mainGrid); // special 1

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
            i++;
            //System.out.println("intersection");
            return true;
        }
        else
        {
            i=0;
            return false;
        }
    }
    
    public void bigOuf(ImageView image, int x, int y){
        mainGrid.getChildren().add(image);
        GridPane.setConstraints(image, x, y );
    }
    
    public void addZombie(Zombie z){
        z.setLane(level);
        int zombLane = z.getLane();
        //System.out.println(zombLane+" zomb addded to lan");
        if(zombLane==0){
            lane0.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane0, numPlants);
        }else if(zombLane==1){
            lane1.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane1, numPlants);
        }else if(zombLane==2){
            lane2.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane2, numPlants);
        }else if(zombLane==3){
            lane3.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane3, numPlants);
        }else if(zombLane==4){
            lane4.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane4, numPlants);
        }
    }
}
