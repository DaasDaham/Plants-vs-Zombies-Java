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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.animation.Timeline;
import javafx.stage.Window;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.Timer; 
import java.util.TimerTask; 
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
class lawncount{
    public static int lawndone0 =0;
    public static int lawndone1 =0;
    public static int lawndone2 =0;
    public static int lawndone3 =0;
    public static int lawndone4 =0;
}
public class FXMLDocumentController2 implements Initializable {
    int i=0;
    public boolean end =false;
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
    public GridPane mainGrid;
    @FXML
    public AnchorPane sunpane;
    @FXML
    private Button igmExitButton;
    private TranslateTransition tt;
    private TranslateTransition tt2;
    private TranslateTransition tt3;
    private TranslateTransition tt4;
    @FXML
    private ProgressBar progBar;
    @FXML
    private ImageView special_Thunder;
    @FXML
    private ImageView special_Laser;
    @FXML
    private TextField special_Thunder_text;
    @FXML
    private TextField special_Laser_text;
    @FXML
    private TextField sunCost;
    @FXML
    private TextField peaCost;
    @FXML
    private TextField bombCost;
    @FXML
    private TextField nutCost;
    @FXML
    private Color x2;
    @FXML
    private Font x1;
    @FXML
    private Button saveGame;
    
    private Timer timer;
    @FXML
    private Button igmCloseBut;
    public Zombie damnZombie;
    public FlagZombie dZombie;
    public static int[][] allPlants = new int[5][9];
    public static int level = 1;

    public static Queue<Zombie> lane0 = new LinkedList<Zombie>();
    public static Queue<Zombie> lane1 = new LinkedList<Zombie>();
    public static Queue<Zombie> lane2 = new LinkedList<Zombie>();
    public static Queue<Zombie> lane3 = new LinkedList<Zombie>();
    public static Queue<Zombie> lane4 = new LinkedList<Zombie>();


    public int currlvl;
    public static Sun s;

    public boolean peablock=false;
    public boolean sunblock=false;
    public boolean walnutblock=false;
    public boolean cbblock=false;
    public int peaTimer=1;
    public int sunTimer=1;
    public int walnutTimer=1;
    public int cbTimer=1;
    public int timerI = 0; 
    public static int numSerialize=1;

    public Plant[] plane0 = new Plant[9];
    public Plant[] plane1 = new Plant[9];
    public Plant[] plane2 = new Plant[9];
    public Plant[] plane3 = new Plant[9];
    public Plant[] plane4 = new Plant[9];
    public static int[][] plantTypes = new int[5][9];
    
    public int numPlants= 0;
    public Special power;

    @FXML
    private void igmclose(ActionEvent event) {
        igm.toBack();
    }
    public void setLevel(int l){
        level = l;
    }
    public void setCounter(int ss){
        s.setSunCount(ss);
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
	public void run(){ 
            ++timerI;
            //System.out.println("currleve "+level);
            progBar.setProgress(timerI/100.0);
            if(timerI%6==0 && timerI>=2){
                Platform.runLater(() -> {
                    if(r.nextInt(4)==0)
                        addZombie(new NormalZombie());
                    else if (r.nextInt(4)==1 && level>=1)
                        addZombie(new FlagZombie());
                    else if (r.nextInt(4)==2 && level>=2)
                        addZombie(new BucketZombie());
                    else if (r.nextInt(4)==1 && level>=3)
                        addZombie(new FlyingZombie());
                    //Special trying = new Laser(mainGrid);
                });  
            }
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
            if(progBar.getProgress()>=1){
               timerI=0;
               level++;
               progBar.setProgress(1);
               peaTimer=0;
               sunTimer=0;
               walnutTimer=0;
               cbTimer=0;
               if(level==2){
                   sunPlantSide.setOpacity(1);
               }else if(level==3){
                   cornBreadSide.setOpacity(1);
               }else if(level>=4){
                   cherryBombSide.setOpacity(1);
               }
            }
        }
    } 
  
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        for(int kk=0;kk<9;kk++){
            plane0[kk] = null;
            plane1[kk]=null;
            plane2[kk]=null;
            plane3[kk]=null;
            plane4[kk]=null;
        }
        addZombie(new NormalZombie());

        s = new Sun(mainGrid,sunCount);
        igm.toBack();
        progBar.setProgress(0);
        timer = new Timer();
        TimerTask task = new Helper(); 
            timer.schedule(task, 2000, 1000);
        Runnable task2 = () -> {
            //System.out.println("Sun Spawned");
            s.spawnSun();
        };
        
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(task2, 5, 5,
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
            if(level>=2 && timerI>=sunTimer){
            Dragboard db = sunPlantSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(sunPlantSide.getImage());
            cbContent.putUrl("Sun");
            db.setContent(cbContent);
            event.consume();}
        }
    });
    sunPlantSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            ssFade();
            sunTimer = timerI+5;
            event.consume();
        }
    });
    cherryBombSide.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            if(level>=4 && timerI>=cbTimer){
            Dragboard db = cherryBombSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(cherryBombSide.getImage());
            cbContent.putUrl("Cherry");
            db.setContent(cbContent);
            
            event.consume();}
        }
    });
    cherryBombSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            chbFade();
            cbTimer = timerI+5;
            event.consume();
        }
    });
    peaPlantSide.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //System.out.println(timerI+" lock "+peaTimer);
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
            if(level>=3 && timerI>=walnutTimer){
            Dragboard db = cornBreadSide.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(cornBreadSide.getImage());
            cbContent.putUrl("Walnut");
            db.setContent(cbContent);
            
            event.consume();}
        }
    });
    cornBreadSide.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            cbFade();
            walnutTimer = timerI+5;
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
                p.setY(y);//buying
                if(y==0 && level >=3 && s.getcount()>=50){
                    allPlants[y][x]=1;
                plantTypes[y][x]=1;
                    s.changecounter(50);
                    plane0[x] = p;
                    p.attack(mainGrid, lane0);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);

                }else if(y==1 && level >=2&& s.getcount()>=50){
                    s.changecounter(50);
            allPlants[y][x]=1;
                plantTypes[y][x]=1;
                    plane1[x] = p;
                    p.attack(mainGrid, lane1);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);

                }else if(y==2 && level>=1&& s.getcount()>=50){
             allPlants[y][x]=1;
                plantTypes[y][x]=1;        
            s.changecounter(50);

                    plane2[x] = p;
                    p.attack(mainGrid, lane2);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);

                }else if(y==3 && level>=2&& s.getcount()>=50){
                    allPlants[y][x]=1;
                plantTypes[y][x]=1;
            s.changecounter(50);

                    plane3[x] = p;
                    p.attack(mainGrid, lane3);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, x, y);

                }else if(y==4 && level>=3&& s.getcount()>=50){
                    s.changecounter(50);
            allPlants[y][x]=1;
                plantTypes[y][x]=1;

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
    
                if(y==0&& s.getcount()>=50&& s.getcount()>=50){
                    allPlants[y][x]=1;
            allPlants[y][x]=1;
                plantTypes[y][x]=2;
            s.changecounter(50);
                    p.attack(mainGrid, lane0);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==1 && level >=2&& s.getcount()>=50){
                    s.changecounter(50);                   
        allPlants[y][x]=1;
                plantTypes[y][x]=2;
                plane1[x] = p;
                    p.attack(mainGrid, lane1);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==2 && level>=1&& s.getcount()>=50){
                    s.changecounter(50);

                    allPlants[y][x]=1;
                plantTypes[y][x]=2;
                    plane2[x] = p;
                    p.attack(mainGrid, lane2);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
               }else if(y==3 && level>=2&& s.getcount()>=50){
                    s.changecounter(50);
                    allPlants[y][x]=1;
                plantTypes[y][x]=2;
                    plane3[x] = p;
                    p.attack(mainGrid, lane3);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==4 && level>=3&& s.getcount()>=50){

                    allPlants[y][x]=1;
                plantTypes[y][x]=2;
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
                if(y==0 && level >=3&& s.getcount()>=100){
                    allPlants[y][x]=1;
                plantTypes[y][x]=3;
                    s.changecounter(100);
                    plane0[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }else if(y==1 && level>=2&& s.getcount()>=100){
                    s.changecounter(100);
                    allPlants[y][x]=1;
                plantTypes[y][x]=3;
                    plane1[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }else if(y==2 && level>=1&& s.getcount()>=100){
                    s.changecounter(100);
                    allPlants[y][x]=1;
                plantTypes[y][x]=3;
                    plane2[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }else if(y==3 && level>=2&& s.getcount()>=100){
                    s.changecounter(100);
                    allPlants[y][x]=1;
                plantTypes[y][x]=3;
                    plane3[x] = p;
                    mainGrid.getChildren().add(plantimg);
                    GridPane.setConstraints(plantimg, x, y);
                }else if(y==4 && level >=3&& s.getcount()>=100){
                    s.changecounter(100);
                    allPlants[y][x]=1;
                plantTypes[y][x]=3;

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
                if(y==0 && level >=3&& s.getcount()>=25){
                    allPlants[y][x]=1;
                plantTypes[y][x]=4;
                    s.changecounter(25);
                    plane0[x] = p;
                    p.attack(mainGrid, lane0);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);

                }else if(y==1 && level >=2&& s.getcount()>=25){
                    s.changecounter(25);
        allPlants[y][x]=1;
                plantTypes[y][x]=4;
                    plane1[x] = p;
                    p.attack(mainGrid, lane1);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==2 && level>=1&& s.getcount()>=25){
                    s.changecounter(25);

        allPlants[y][x]=1;
                plantTypes[y][x]=4;
                    plane2[x] = p;
                    p.attack(mainGrid, lane2);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==3 && level>=2&& s.getcount()>=25){
                    s.changecounter(25);

        allPlants[y][x]=1;
                plantTypes[y][x]=4;
                    plane3[x] = p;
                    p.attack(mainGrid, lane3);
                    mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, x, y);
                }else if(y==4 && level>=3&& s.getcount()>=25){
                    s.changecounter(25);

                            allPlants[y][x]=1;
                plantTypes[y][x]=4;
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
    private void LaserButtonEnter(MouseEvent event) {

            special_Laser_text.setOpacity(1);
    }
    @FXML
    private void ThunderButtonEnter(MouseEvent event) {

        special_Thunder_text.setOpacity(1);
    }
    @FXML
    private void LaserButtonExit(MouseEvent event) {

        special_Laser_text.setOpacity(0);
    }
    @FXML
    private void ThunderButtonEExit(MouseEvent event) {

        special_Thunder_text.setOpacity(0);
    }
    @FXML
    private void ThunderButtonPress(MouseEvent event) {

        if(Counter.count>=200)
        {
            power = new Thunder(mainGrid);
            Counter.count-=200;
        }
    }
    @FXML
    private void LaserButtonPress(MouseEvent event) {

        if(Counter.count>=100)
        {
            power = new Laser(mainGrid);
            Counter.count-=100;
        }
    }
    @FXML
    private void SunPlantCostEnter(MouseEvent event) {

        sunCost.setOpacity(1);
    }
    @FXML
    private void SunPlantCostExit(MouseEvent event) {

        sunCost.setOpacity(0);
    }
    @FXML
    private void PeaPlantCostEnter(MouseEvent event) {

        peaCost.setOpacity(1);
    }
    @FXML
    private void peaPlantCostExit(MouseEvent event) {

        peaCost.setOpacity(0);
    }
    @FXML
    private void NutPlantCostEnter(MouseEvent event) {

        nutCost.setOpacity(1);
    }
    @FXML
    private void NutPlantCostExit(MouseEvent event) {

        nutCost.setOpacity(0);
    }
    @FXML
    private void BombPlantCostEnter(MouseEvent event) {

        bombCost.setOpacity(1);
    }
    @FXML
    private void BombPlantCostExit(MouseEvent event) {

        bombCost.setOpacity(0);
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
    
    public void setpTypes(int[][] jj){
        plantTypes = jj;
    }
    public void setallPlants(int[][] xj){
        allPlants = xj;
    }
    public void startPLant(int i, int j, int type){
        Plant p;
        if(type==1){p = new PeaPlant();}else if(type==2){p = new SunFlowerPlant(mainGrid);}else if(type==3){p = new WalnutPlant();}else{p = new CherryBombPlant();}
                ImageView plantimg = p.getImage();
                plantimg.setPreserveRatio(true);
                plantimg.setFitWidth(70);
                p.setX(j);
                p.setY(i);//buying
                mainGrid.getChildren().add(plantimg);
                GridPane.setConstraints(plantimg, j, i);
                if(type==1){ImageView peaimg = p.getBullet();
                peaimg.setPreserveRatio(true);
                peaimg.setFitWidth(30);mainGrid.getChildren().add(peaimg);
                GridPane.setConstraints(peaimg, j, i);
                }
                if(i==0){
                    plane0[j] = p;
                p.attack(mainGrid, lane0);
                }else if(i==1){
                    plane1[j] = p;
                p.attack(mainGrid, lane1);
                }else if(i==2){
                    plane2[j] = p;
                p.attack(mainGrid, lane2);
                }else if(i==3){
                    plane3[j] = p;
                p.attack(mainGrid, lane3);
                }else if(i==4){
                    plane4[j] = p;
                p.attack(mainGrid, lane4);
                }
        }
                
     @FXML
    private void handleSave(ActionEvent event) throws IOException{
        serialize();
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
    public void setNumSerialize(int kkk){
        numSerialize = kkk; 
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
        zombImg.setFitWidth(80);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane0, allPlants, plantTypes);
        }else if(zombLane==1){
            lane1.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane1, allPlants, plantTypes);
        }else if(zombLane==2){
            lane2.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane2, allPlants, plantTypes);
        }else if(zombLane==3){
            lane3.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane3, allPlants, plantTypes);
        }else if(zombLane==4){
            lane4.add(z);
            ImageView zombImg = z.getImage();
        zombImg.setPreserveRatio(true);
        zombImg.setFitWidth(100);
        zombImg.setFitHeight(100);
        zombImg.setFitWidth(50);
        mainGrid.getChildren().add(zombImg);
        GridPane.setConstraints(zombImg,9,zombLane);
        z.startTranslation(mainGrid, plane4, allPlants, plantTypes);
        }
    }
    public static void serialize() throws IOException{
        ObjectOutputStream out = null;
        try{
            System.out.println("numserial "+numSerialize);
            if(numSerialize==1){
            out = new ObjectOutputStream(
                        new FileOutputStream("firstSave.txt"));
            numSerialize++;
            Srz toser = new Srz(level, allPlants, plantTypes, s.getcount(), numSerialize);
            out.writeObject(toser);}
            else if(numSerialize==2){
            out = new ObjectOutputStream(
                        new FileOutputStream("secondSave.txt"));
            numSerialize++;
            Srz toser2 = new Srz(level, allPlants, plantTypes, s.getcount(), numSerialize);
            out.writeObject(toser2);}
            else if(numSerialize==3){
            out = new ObjectOutputStream(
                        new FileOutputStream("thirdSave.txt"));
            numSerialize++;
            Srz toser3 = new Srz(level, allPlants, plantTypes, s.getcount(), numSerialize);
            out.writeObject(toser3);}else if(numSerialize==4){
            out = new ObjectOutputStream(
                        new FileOutputStream("fourthSave.txt"));
            numSerialize++;
            Srz toser4 = new Srz(level, allPlants, plantTypes, s.getcount(), numSerialize);
            out.writeObject(toser4);}
            else if(numSerialize==5){
            out = new ObjectOutputStream(
                        new FileOutputStream("fifthSave.txt"));
            numSerialize++;
            Srz toser5 = new Srz(level, allPlants, plantTypes, s.getcount(), numSerialize);
            out.writeObject(toser5);}
            
        }finally{
            out.close();
        }
    }
    public void lawnmove(int x)
    {

        tt2 = new TranslateTransition();
        tt2.setDuration(Duration.seconds(2));
        tt2.setToX(1000);
        if(x==0)
        {
            tt2.setNode(lm1);
            for(Zombie z:lane0)
            {
                z.zImg.setOpacity(0);
                lane0.poll();
            }
            if(lawncount.lawndone0>=1)
                {
                Platform.exit();
            }
            lawncount.lawndone0++;
        }
        else if(x==1)
        {
            tt2.setNode(lm2);
            for(Zombie z:lane1)
            {
                z.zImg.setOpacity(0);
                lane1.poll();
            }
            if(lawncount.lawndone1>=1)
            {
                Platform.exit();
            }
            lawncount.lawndone1++;
        }
        else if(x==2)
        {
            tt2.setNode(lm3);
            tt2.setToX(1000);
            for(Zombie z:lane2)
            {
                z.zImg.setOpacity(0);
                lane2.poll();
            }
            if(lawncount.lawndone2>=1)
            {
                Platform.exit();
            }
            tt2.play();
            lawncount.lawndone2++;
        }
        else if(x==3)
        {
            tt2.setNode(lm4);
            for(Zombie z:lane3)
            {
                z.zImg.setOpacity(0);
                lane3.poll();
            }
            if(lawncount.lawndone3>=1)
            {
                Platform.exit();
            }
            lawncount.lawndone3++;
        }
        else
        {
            tt2.setNode(lm5);
            for(Zombie z:lane4)
            {
                z.zImg.setOpacity(0);
                lane4.poll();
            }
            if(lawncount.lawndone4>=1)
            {
                Platform.exit();
            }
            lawncount.lawndone4++;
        }
        tt2.play();
    }
}

class Srz implements Serializable{
    public Srz(int level, int[][] allPlants, int[][] plantTypes, int suncount,int numSerialize){
        this.level= level;
        this.allPlants = allPlants;
        this.plantTypes = plantTypes;
        this.suncount =suncount;
        this.numSerialize = numSerialize;
    }
    public int numSerialize;
    public int level;
    public int[][] allPlants;
    public int[][] plantTypes;
    public int suncount;
}