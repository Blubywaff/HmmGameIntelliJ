//import javax.swing.*; //not used
//import java.awt.*; //not used
//import java.awt.event.*; //not used
import java.util.*;
public class Player extends Entity
{
    /*private double health;
    private double armor;
    private int positionX;
    private int positionY;
    private int direction = 0;*/
    public String useMode = "Tool";
    
    
    public Player()
    {
        super();
        inventory.gunPrimary = new BasicSlingshot();
        inventory.gunBody = new MagnetoRepulser();
        inventory.gunSecondary = new NullGun();
        inventory.armorHead = new Hat();
        inventory.armorChest = new Shirt();
        inventory.armorLegs = new Pants();
        inventory.armorFeet = new Shoes();
        inventory.armorHands = new Gloves();
        inventory.toolPrimary = new Axe();
        inventory.toolSecondary = new Picaxe();
        calculateArmor();
        defaultHealth = 500;
        health = defaultHealth;
        positionX = displayPosX = 960;
        positionY = displayPosY = 540;
    }
    
    public int getChangeX()
    {
        return displayPosX - (int)positionX;
    }
    public int getChangeY()
    {
        return displayPosY - (int)positionY;
    }
    
    public void playerMove(ArrayList<String> arrows)
    {
        move(arrows);
        //Fixer.fixZombieDisplay();
        //Fixer.fixPlayerTakingDamage();
    }
    
    public void firePrimary(){
        inventory.gunPrimary.fire(genVector());
    }
    public void fireSecondary() {
        inventory.gunSecondary.fire(genVector());
    }
    
    public void fireBody() {
        inventory.gunBody.fire();
    }
    
    public void usePrimary() {
        inventory.toolPrimary.use();
    }
    public void useSecondary() {
        inventory.toolSecondary.use();
    }
    
    public void use(int mB, double mX, double mY) {
        calculateDirection(mX, mY);
        if(useMode == "Tool") {
            use(mX, mY, mB);
        } else if(useMode == "Gun") {
            fire(mX, mY, mB);
        }
    }
    
    public void fire(double mX, double mY, int mB) {
        if(mB == 1) {
            firePrimary();
        } else if(mB == 3) {
            fireSecondary();
        }
    }
    
    public void use(double mX, double mY, int mB) {
        if(mB == 1) {
            inventory.toolPrimary.use(mX, mY);
        } else if(mB == 3) {
            inventory.toolPrimary.use(mX, mY);
        }
    }
    
    public void calculateDirection(double mX, double mY) {
        double numer = mY - displayPosY;
        double denum = mX - displayPosX;
        double slope = numer / denum;
        //slope = (int)(slope*1000);
        //slope /= 1000;
        slope = -1*slope;
        if(mX > MainProgram.player.displayPosX) {
            sDirect = "right";
        } else if(mX < MainProgram.player.displayPosX){
            sDirect = "left";
        } else if(slope == Double.NEGATIVE_INFINITY) {
            sDirect = "up";
        } else if(slope == Double.POSITIVE_INFINITY) {
            sDirect = "down";
        }
        direction = slope;
    }
    
    public Vector genVector() {
        Vector vector = new Vector(positionX, positionY, sDirect, direction);
        return vector;
    }
    
    public void calculateArmor() {
        armor += inventory.armorHead.armor + inventory.armorChest.armor + inventory.armorLegs.armor + inventory.armorHands.armor + inventory.armorFeet.armor;
    }
    
    public void switchMode() {
        if(useMode == "Tool") {
            useMode = "Gun";
        } else if(useMode == "Gun") {
            useMode = "Tool";
        }
    }
    
    /*
    public void changeDirection(int d)
    {
        direction = d;
        if(direction >= 360)
            direction -= 360;
        else if(direction <= 0)
            direction += 360;
    }
    
    public int getPosX()
    {
        return positionX;
    }
    public int getPosY()
    {
        return positionY;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    public void move(String arrow)
    {
        int moveDirection = direction;
        if(arrow == "up")
        {
            //do nothing
        }
        else if(arrow == "right")
        {
            moveDirection += 90;//change direction to 90 degrees relative to actual direction
        }
        else if(arrow == "down")
        {
            moveDirection += 180;
        }
        else if(arrow == "left")
        {
            moveDirection += 270;
        }
        if(moveDirection >= 360)
        {
            moveDirection -= 360;
        }
        if(moveDirection <= 90)
        {
            positionX += (moveDirection);
            positionY -= (90 - moveDirection);
        }
        else if(moveDirection <= 180 && moveDirection > 90)
        {
            positionX += (180 - moveDirection);
            positionY += (moveDirection - 90);
        }
        else if(moveDirection <= 270 && moveDirection > 180)
        {
            positionX -= (moveDirection - 180);
            positionY += (270 - moveDirection);
        }
        else if(moveDirection <= 359 && moveDirection > 270)
        {
            positionX -= (360 - moveDirection);
            positionY -= (moveDirection - 270);
        }
        MainProgram.myFrame.panelRefresh();
    }
    */
}