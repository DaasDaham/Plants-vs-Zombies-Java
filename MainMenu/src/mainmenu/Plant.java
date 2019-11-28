/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author saad
 */
public class Plant {
    protected double max_health;
    protected double currHealth;
    //protected ImageView bullet; //Replace with Bullet class
    protected int xPos;
    protected int yPos;
    protected int tempvar;
    protected ImageView pImg;
    protected int pType;
    protected Zombie currZombie;
    protected ImageView peaBullet;
    protected TranslateTransition tt;
    
    public Plant(){
        tempvar = 2;
    }
    
    public void setZombie(Zombie z){
        currZombie = z; 
    }
    
    public ImageView getImage(){
        return pImg;
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
    public void attack(){
        //
    }
}

class PeaPlant extends Plant{
    
    public PeaPlant(){
        pImg = new ImageView(new Image(getClass().getResourceAsStream("Images/plant_1.gif")));
        peaBullet = new ImageView(new Image(getClass().getResourceAsStream("ProjectilePea_1.png")));  
        tt = new TranslateTransition();
    }
    public void attack(){
        peaBullet.translateXProperty().addListener((Observable observable) -> {
            //System.out.println(currZombie.getImage().getTranslateX());
            if(checkIntersect(peaBullet, currZombie.getImage())){
                peaBullet.setOpacity(0);
                //GridPane.setConstraints(pea1, 3, 0);
            }
            if(peaBullet.getTranslateX()==0){
                peaBullet.setOpacity(1);
            }
        });
        tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(7));
        tt.setToX(1000);
        tt.setNode(peaBullet);
        tt.setCycleCount( Timeline.INDEFINITE );
        //System.out.println("intersection");
        tt.play();
    }
    private boolean checkIntersect(ImageView v1, ImageView v2){
        
        if(v1.getParent().getBoundsInParent().intersects(v2.getBoundsInParent())){
            //System.out.println("intersection");
            return true;
        }
        return false;
    }
}
