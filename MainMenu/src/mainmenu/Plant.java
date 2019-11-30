/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.Queue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author saad
 */
public class Plant {
    protected double maxHealth;
    protected double currHealth;
    //protected ImageView bullet; //Replace with Bullet class
    protected int xPos;
    protected int yPos;

    protected int tempvar;
    protected ImageView pImg;
    protected int lane;
    protected int pType;
    protected Zombie currZombie;
    protected ImageView peaBullet;
    protected TranslateTransition tt;
    protected ImageView grave;
    
    public Plant(){
        tempvar = 2;
        maxHealth = 100;
        currHealth = 100;
    } 
    public int getLane(){
        return lane;
    }
    
    public void takeDamage(){
        currHealth-=50;
    }
    
    public void setZombie(Zombie z){
        currZombie = z; 
    }
    
    public ImageView getImage(){
        return pImg;
    }
    
    public double getHealth(){
        return currHealth;
    }
    
    public ImageView getBullet(){
        return peaBullet;
    }
    
    public int getType(){
        return pType;
    }
    public void setX(int xPos){
        this.xPos = xPos;
    }
    public void setY(int yPos){
        this.yPos = yPos;
    }

    public void attack(GridPane mainGrid, Queue<Zombie> laneq){}

    public void attack(){
     //
    }
}

class PeaPlant extends Plant{
    private int checker = 0;
    public PeaPlant(){
        super();
        this.maxHealth=100;
        pImg = new ImageView(new Image(getClass().getResourceAsStream("Images/PeaShooter.gif")));
        peaBullet = new ImageView(new Image(getClass().getResourceAsStream("ProjectilePea_1.png")));  
        tt = new TranslateTransition();
    }
    public void attack(GridPane mainGrid, Queue<Zombie> laneq){
        tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(4));
        tt.setToX(1000);
        tt.setNode(peaBullet);
        tt.setCycleCount( Timeline.INDEFINITE );
        //System.out.println("intersection");
        tt.play();
        
        peaBullet.translateXProperty().addListener((Observable observable) -> {
            //System.out.println(laneq.size()+" lolol");
            if(laneq.size()==0){
                peaBullet.setOpacity(0);
            }
            else{
                currZombie = laneq.peek();
                if(peaBullet.getTranslateX()==0){
                    peaBullet.setOpacity(1);
                    checkIntersect(peaBullet, currZombie.getImage(), true);
                }
                if(currZombie!=null){
                    if(checkIntersect(peaBullet, currZombie.getImage(),false)){
                        peaBullet.setOpacity(0);
                        currZombie.takeDamage(50,mainGrid,laneq);
                    }
                }
            }            
        });
    }
    private boolean checkIntersect(ImageView v1, ImageView v2, boolean chek){
        if(chek){
            checker=0;
        }
        if(v1.getParent() == null){
            //System.out.println("this is null block");
            //System.out.println(v1.toString());
        }
        if(checker==0 && v1.getBoundsInParent().intersects(v2.getBoundsInParent())){
            checker++;
            //System.out.println("intersection");
            return true;
        }
        return false;
    }
}
class WalnutPlant extends Plant{

    public WalnutPlant(){
        this.maxHealth=400;
        pImg = new ImageView(new Image(getClass().getResourceAsStream("Images/walnut.png")));
        //peaBullet = new ImageView(new Image(getClass().getResourceAsStream("transparent.jfif")));
        tt = new TranslateTransition();
    }
    public void attack(GridPane mainGrid, Queue<Zombie> laneq){
        System.out.println("skadgba");
    }
    private boolean checkIntersect(ImageView v1, ImageView v2){

        if(v1.getBoundsInParent().intersects(v2.getBoundsInParent())){
            //System.out.println("intersection");
            return true;
        }
        return false;
    }
}
class SunFlowerPlant extends Plant{
    public ScheduledExecutorService scheduler;

    public SunFlowerPlant(GridPane mainGrid){
        this.maxHealth=100;
        pImg = new ImageView(new Image(getClass().getResourceAsStream("Images/Sunflower.gif")));
        //peaBullet = new ImageView(new Image(getClass().getResourceAsStream("ProjectilePea_1.png")));
        tt = new TranslateTransition();

    }

    public void attack(GridPane mainGrid, Queue<Zombie> laneq){
        Sun s= new Sun(xPos, yPos,mainGrid);
        Runnable task2 = () -> {
            //System.out.println("Sunflower sun Spawned");
            s.spawnsunforflower(mainGrid,xPos,yPos);
        };

        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(task2, 10, 10,
                TimeUnit.SECONDS); //UNCOMMENT THIS
        System.out.println("heloo");
    }
    private boolean checkIntersect(ImageView v1, ImageView v2){

        if(v1.getBoundsInParent().intersects(v2.getBoundsInParent())){
            //System.out.println("intersection");
            return true;
        }
        return false;
    }
}
class CherryBombPlant extends Plant{

    public CherryBombPlant(){
        this.maxHealth=150;
        pImg = new ImageView(new Image(getClass().getResourceAsStream("Images/cherry_bomb.png")));
        //peaBullet = new ImageView(new Image(getClass().getResourceAsStream("ProjectilePea_1.png")));
        tt = new TranslateTransition();
    }
    public void attack(GridPane mainGrid, Queue<Zombie> laneq){
        // Check of imtersect with zombie
        /*ImageView explode = new ImageView(new Image(getClass().getResourceAsStream("Images/explosion.png")));
        ImageView boom = new ImageView(new Image(getClass().getResourceAsStream("Images/boom.png")));
        mainGrid.getChildren().add(explode);
        mainGrid.getChildren().add(boom);
        explode.setFitWidth(100);
        explode.setFitHeight(80);
        boom.setFitWidth(90);
        boom.setFitHeight(80);
        explode.toFront();
        boom.toFront();
        GridPane.setConstraints(explode,xPos,yPos);
        GridPane.setConstraints(boom,xPos+1,yPos);
        System.out.println("asfa");
        pImg.setOpacity(0.5);*/
    }


        //GridPane.setConstraints(explode,getX(),getY());
    //}

    private boolean checkIntersect(ImageView v1, ImageView v2){

        if(v1.getParent().getBoundsInParent().intersects(v2.getBoundsInParent())){

            //System.out.println("intersection");
            return true;
        }
        return false;
    }
}
