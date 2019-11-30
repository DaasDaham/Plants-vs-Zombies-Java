/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.Random;
import java.util.Stack;
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
        lane = randLane();
    }
    
    public void setCurrPlant(Plant p){
        currPlant = p;
    }
    
    public void startTranslation(GridPane mainGrid, Plant[] plane, int numPlants){
        TranslateTransition t = new TranslateTransition();
        t.setDuration(Duration.seconds(50));
        t.setToX(-800);
        t.setNode(zImg);
        t.play();
        
        zImg.translateXProperty().addListener((Observable observable) -> {
            //System.out.println("i am alive");
            if(currHealth<=0){t.stop();}
            else{
            if(this!=null){
            int x = checkPlant(zImg,plane);
            if(x!=-1){
                mainGrid.getChildren().remove(plane[x].getImage());
                mainGrid.getChildren().remove(plane[x].getBullet());
                plane[x] = null;
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
        currHealth-=20;
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
        //System.out.println("new normalzonmbie spawnde");
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
