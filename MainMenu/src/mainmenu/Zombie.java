/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import com.sun.media.jfxmedia.events.PlayerTimeListener;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.event.ActionEvent;
/**
 *
 * @author saad
 */
public class Zombie {
    protected double maxHealth;
    protected double currHealth;
    protected int lane;
    protected double xPos;protected double yPos;
    protected boolean reachHouse;
    protected ImageView zImg;
    protected int checker;
    protected Plant currPlant;
    public int checkTimer=0;
    public int closeit;
    public Timer timer;
    public TimerTask task;
    public Plant[] lape;

    public double getCurrHealth() {
        return currHealth;
    }
    class Helper2 extends TimerTask 
    { 
	public int i = 0; 
	public void run() 
	{
            ++i;
            if(i==3){
                timer.cancel();
                System.out.println("timer cancelled");
            }
	} 
    }

    public void setCurrHealth(double currHealth) {
        this.currHealth = currHealth;
    }

    public Zombie(){
        maxHealth = 100;
        currHealth=100;
    }
    

    public void setCurrPlant(Plant p) {
        currPlant = p;
    }
    public void setLane(int level){
        
        if(level ==1){
            this.lane=2;
        }else if(level==2){
            lane = rand2();
        }else if(level >=3){
            lane = randLane();
        }
        
    }
    
    public void delayedEat(GridPane mg, Plant p, TranslateTransition t){
        //System.out.println("call times");
        if(checkTimer==0){
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    checkTimer++;
                    t.pause();
                    Thread.sleep(5000);
                    
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                    System.out.println("nailed it");
                
            }
        });
        new Thread(sleeper).start();}
    }
    
    public void nuller(int p){
        lape[p] = null;
    }

    public void startTranslation(GridPane mainGrid, Plant[] plane, int[][] numPlants, int[][] plantTypes) {
        TranslateTransition t = new TranslateTransition();
        t.setDuration(Duration.seconds(50));
        t.setToX(-800);
        t.setNode(zImg);
        t.play();
        /*t.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(lane==0)
                {
                    Platform.runLater(()->
                    {FXMLDocumentController2 x = new FXMLDocumentController2();
                    x.lawnmove(0);});
                    //Iterator<Zombie> iterator = FXMLDocumentController2.lane0.iterator();
                    //while(iterator.hasNext()){
                    //    Zombie c = iterator.next();
                    //    c.takeDamage(1000,mainGrid,FXMLDocumentController2.lane0);
                    //}
                }
                else if(lane==1)
                {
                    Platform.runLater(()->
                    {FXMLDocumentController2 x = new FXMLDocumentController2();
                        x.lawnmove(1);});
                  //  Iterator<Zombie> iterator = FXMLDocumentController2.lane1.iterator();
                   // while(iterator.hasNext()){
                   //     Zombie c = iterator.next();
                  //      c.takeDamage(1000,mainGrid,FXMLDocumentController2.lane1);
                    //}
                }
                else if(lane==2)
                {
                    Platform.runLater(()->
                    {FXMLDocumentController2 x = new FXMLDocumentController2();
                        x.lawnmove(2);});
                  //  Iterator<Zombie> iterator = FXMLDocumentController2.lane2.iterator();
                   // while(iterator.hasNext()){
                     //   Zombie c = iterator.next();
                     //   c.takeDamage(1000,mainGrid,FXMLDocumentController2.lane2);
                      //  }
                    }
                else if(lane==3)
                {
                    Platform.runLater(()->
                    {FXMLDocumentController2 x = new FXMLDocumentController2();
                        x.lawnmove(3);});
                  //  Iterator<Zombie> iterator = FXMLDocumentController2.lane3.iterator();
                   // while(iterator.hasNext()){
                    //    Zombie c = iterator.next();
                    //    c.takeDamage(1000,mainGrid,FXMLDocumentController2.lane3);
                    //}
                }else if(lane==4)
                {
                    Platform.runLater(()->
                    {FXMLDocumentController2 x = new FXMLDocumentController2();
                        x.lawnmove(4);});
                   // Iterator<Zombie> iterator = FXMLDocumentController2.lane4.iterator();
                    //while(iterator.hasNext()){
                    //    Zombie c = iterator.next();
                   //     c.takeDamage(1000,mainGrid,FXMLDocumentController2.lane4);
                   // }
                }

            }
        });*/
        zImg.translateXProperty().addListener((Observable observable) -> {
            //System.out.println("i am alive");
            //System.out.println(Arrays.toString(plane));
            if(currHealth<=0){t.stop();}
            else{
                //System.out.println(Arrays.toString(plane));
            if(this!=null){
            int x = checkPlant(zImg,plane);
            if(x!=-1){
                mainGrid.getChildren().remove(plane[x].getImage());
                    mainGrid.getChildren().remove(plane[x].getBullet());
                    plane[x] = null;
                    numPlants[lane][x]=0;
                    plantTypes[lane][x]=0;
            }}}
            
            /*for(int x=0;x<9;x++){
                if(plane[x]!=null){
                if(checkIntersect(zImg, plane[x].getImage(),true)){
                System.out.println("plant NOT null");
                //System.out.println("intersected");
                //currPlant.takeDamage();
                //if(currPlant.getHealth()<=0){
                
                //checkIntersect(zImg, plane[x].getImage(),true);
                //plane.pop();
                plane[x] = null;}
                //}
            }
            }*/
            
        });
    }
    
    private int checkPlant(ImageView zImg, Plant[] parr){
        double pos = zImg.getTranslateX();
        if(pos<0 && pos>-89){
            if(parr[8]!=null){
                return 8;
            }
        }else if(pos<-89 && pos>-178){
            if(parr[7]!=null){
                return 7;
            }
        }else if(pos<-178 && pos>-267){
            if(parr[6]!=null){
                return 6;
            }
        }else if(pos<-267 && pos>-356){
            if(parr[5]!=null){
                return 5;
            }
        }else if(pos<-356 && pos>-445){
            if(parr[4]!=null){
                return 4;
            }
        }else if(pos<-445 && pos>-534){
            if(parr[3]!=null){
                return 3;
            }
        }else if(pos<-534 && pos>-623){
            if(parr[2]!=null){
                return 2;
            }
        }else if(pos<-623 && pos>-712){
            if(parr[1]!=null){
                return 1;
            }
        }else if(pos<-712 && pos>-800){
            if(parr[0]!=null){
                return 0;
            }
        }
        return -1;
    }
    
    /*private boolean checkIntersect(ImageView v1, ImageView v2, boolean chek){
        if(chek){
            checker=0;
            if (numPlants > 0) {
                for (int x = 0; x < 9; x++) {
                    if (plane[x] != null) {
                        if (checkIntersect(zImg, plane[x].getImage(), true)) {
                            System.out.println("plant NOT null");
                            //System.out.println("intersected");
                            //currPlant.takeDamage();
                            //if(currPlant.getHealth()<=0){
                            mainGrid.getChildren().remove(plane[x].getImage());
                            mainGrid.getChildren().remove(plane[x].getBullet());
                            //checkIntersect(zImg, plane[x].getImage(),true);
                            //plane.pop();
                            plane[x] = null;
                        }
                        //}
                    }
                }

            }
        });
    }

    /*private boolean checkIntersect(ImageView v1, ImageView v2, boolean chek) {
        if (chek) {
            checker = 0;

        }
        if (v1.getParent() == null) {
            //System.out.println("this is null block");
            //System.out.println(v1.toString());
        }
        if (checker == 0 && v1.getBoundsInParent().intersects(v2.getBoundsInParent())) {
            checker++;
            //System.out.println("intersection");
            return true;
        }
        return false;
    }*/

    public int randLane() {
        Random r = new Random();
        return r.nextInt(5);
    }
    public int rand2(){
        Random r = new Random();
        return 1+r.nextInt(3);
    }

    public ImageView getImage() {
        return zImg;
    }

    public int getLane() {
        return lane;
    }

    public void takeDamage(int dmg,GridPane mainGrid, Queue<Zombie> laneq) {

        currHealth -= dmg;
        if (currHealth <= 0) {
            checkDeath(mainGrid, laneq);
            System.out.println("zombie dead");
        }
    }

    public double getHealth() {
        return currHealth;
    }

    public void attack() {

    }

    public void checkDeath(GridPane mainGrid, Queue<Zombie> laneq) {
        if (getHealth() <= 0) {
            mainGrid.getChildren().remove(zImg);
            laneq.poll();
            Zombie curr = laneq.peek();
        }
    }
}
    class NormalZombie extends Zombie {
        public NormalZombie() {
            super();
            this.maxHealth = 100;
            zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/fin.gif")));
            //System.out.println("new normalzonmbie spawnde");
        }
    }

    class FlyingZombie extends Zombie {
        public FlyingZombie() {
            super();
            this.maxHealth = 200;
            zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/fly_zombie.gif")));
            System.out.println("new flyingzonmbie spawnde");
        }
    }

    class BucketZombie extends Zombie {
        public BucketZombie() {
            super();
            this.maxHealth = 150;
            zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/bucket_zombie.gif")));
            System.out.println("new flyingzonmbie spawnde");
        }
    }

    class FlagZombie extends Zombie {
        public FlagZombie() {
            super();
            this.maxHealth = 125;
            zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/flag_zombie.gif")));
            System.out.println("new flagzonmbie spawnde");
        }
    }

