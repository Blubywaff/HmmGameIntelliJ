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
        getInventory().setGunPrimary(new BasicSlingshot());
        getInventory().setGunBody(new MagnetoRepulser());
        getInventory().setGunSecondary(new AdvancedSlingshot());
        getInventory().setArmorHead(new Hat());
        getInventory().setArmorChest(new Shirt());
        getInventory().setArmorLegs(new Pants());
        getInventory().setArmorFeet(new Shoes());
        getInventory().setArmorHands(new Gloves());
        getInventory().setToolPrimary(new Axe());
        getInventory().setToolSecondary(new Multitool());
        calculateArmor();
        setDefaultHealth(500);
        setHealth(getDefaultHealth());
        setPositionX(960);
        setDisplayPosX(960);
        setPositionY(540);
        setDisplayPosY(540);
    }
    
    public int getChangeX()
    {
        return getDisplayPosX() - (int) getPositionX();
    }
    public int getChangeY()
    {
        return getDisplayPosY() - (int) getPositionY();
    }
    
    public void playerMove(ArrayList<String> arrows)
    {
        move(arrows);
        //Fixer.fixZombieDisplay();
        //Fixer.fixPlayerTakingDamage();
    }
    
    public void firePrimary(){
        getInventory().getGunPrimary().fire(genVector());
    }
    public void fireSecondary() {
        getInventory().getGunSecondary().fire(genVector());
    }
    
    public void fireBody() {
        getInventory().getGunBody().fire();
    }
    
    public void usePrimary() {
        getInventory().getToolPrimary().use();
    }
    public void useSecondary() {
        getInventory().getToolSecondary().use();
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
            getInventory().getToolPrimary().use(mX, mY);
        } else if(mB == 3) {
            getInventory().getToolSecondary().use(mX, mY);
        }
    }
    
    public void calculateDirection(double mX, double mY) {
        double numer = mY - getDisplayPosY();
        double denum = mX - getDisplayPosX();
        double slope = numer / denum;
        //slope = (int)(slope*1000);
        //slope /= 1000;
        slope = -1*slope;
        if(mX > MainProgram.player.getDisplayPosX()) {
            setsDirect("right");
        } else if(mX < MainProgram.player.getDisplayPosX()){
            setsDirect("left");
        } else if(slope == Double.NEGATIVE_INFINITY) {
            setsDirect("up");
        } else if(slope == Double.POSITIVE_INFINITY) {
            setsDirect("down");
        }
        setDirection(slope);
    }
    
    public Vector genVector() {
        Vector vector = new Vector(getPositionX(), getPositionY(), getsDirect(), getDirection());
        return vector;
    }
    
    public void calculateArmor() {
        setArmor(getArmor() + getInventory().getArmorHead().armor + getInventory().getArmorChest().armor + getInventory().getArmorLegs().armor + getInventory().getArmorHands().armor + getInventory().getArmorFeet().armor);
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