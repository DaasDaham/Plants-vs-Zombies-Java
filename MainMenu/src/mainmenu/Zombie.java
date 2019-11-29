/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author saad
 */
public class Zombie {
    protected double maxHealth;
    protected double currHealth;
    protected int lane;
    protected double xPos;
    protected boolean reachHouse;
    protected ImageView zImg; 
    protected int checker;
    protected Plant currPlant;
    
    public Zombie(){
        maxHealth = 100;
        currHealth=100;
        lane = 1;

    }
    
    public void startTranslation(GridPane mainGrid){
         
        
        TranslateTransition t = new TranslateTransition();
        t.setDuration(Duration.seconds(60));
        t.setToX(-750);
        t.setNode(zImg);
        t.play();
        
        zImg.translateXProperty().addListener((Observable observable) -> {
            //System.out.println(currZombie.getImage().getTranslateX());
            if(currPlant==null){
                //System.out.println("plant null");
            }
            else if(checkIntersect(zImg, currPlant.getImage(),false)){
                //System.out.println("intersected");
                t.pause();
                
                //currPlant.takeDamage();
                //if(currPlant.getHealth()<=0){
                    mainGrid.getChildren().remove(currPlant.getImage());
                    mainGrid.getChildren().remove(currPlant.getBullet());
                //}
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
        if(checker==0 && v1.getParent().getBoundsInParent().intersects(v2.getBoundsInParent())){
            checker++;
            //System.out.println("intersection");
            return true;
        }
        return false;
    }
    
    public int randLane(){
        Random r = new Random();
        return r.nextInt(5);
    }
    
    public ImageView getImage(){
        return zImg;
    }
    
    public int getLane(){
        return lane;
    }
    public void takeDamage(){
        currHealth-=100;
    }
    public double getHealth(){
        return currHealth;
    }
    public void attack(){
        
    }
}

class NormalZombie extends Zombie{
    public NormalZombie(){
        super();
        this.maxHealth=100;
        zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/fin.gif")));
        System.out.println("new normalzonmbie spawnde");
    }   
}
class FlyingZombie extends Zombie{
    public FlyingZombie(){
        super();
        this.maxHealth=200;
        zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/fly_zombie.gif")));
        System.out.println("new flyingzonmbie spawnde");
    }
}
class BucketZombie extends Zombie{
    public BucketZombie(){
        super();
        this.maxHealth=150;
        zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/bucket_zombie.gif")));
        System.out.println("new flyingzonmbie spawnde");
    }
}
class FlagZombie extends Zombie{
    public FlagZombie(){
        super();
        this.maxHealth=125;
        zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/flag_zombie.gif")));
        System.out.println("new flagzonmbie spawnde");
    }
}
