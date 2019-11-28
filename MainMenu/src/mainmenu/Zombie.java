/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author saad
 */
public class Zombie {
    protected double max_health;
    protected double curr_health;
    protected int lane;
    protected double xPos;
    protected boolean reachHouse;
    protected ImageView zImg; 
    //private Plant currPlant;
    
    public Zombie(){
        lane = randLane();
    }
    
    public void startTranslation(){
        TranslateTransition t = new TranslateTransition();
        t.setDuration(Duration.seconds(60));
        t.setToX(-750);
        t.setNode(zImg);
        t.play();
    }
    
    public int randLane(){
        Random r = new Random();
        return r.nextInt(3);
    }
    
    public ImageView getImage(){
        return zImg;
    }
    
    public int getLane(){
        return lane;
    }
}

class NormalZombie extends Zombie{
    public NormalZombie(){
        super();
        zImg = new ImageView(new Image(getClass().getResourceAsStream("Images/fin.gif")));
        System.out.println("new normalzonmbie spawnde");
    }   
}
