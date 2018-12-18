import java.util.*;
public class Entity
{
    public double health;
    public double shield;
    public double armor;
    public double damage = 10;
    public double positionX;
    public double positionY;
    public int displayPosX;
    public int displayPosY;
    public double direction = 0;
    public String sDirect = "right";
    public static final double DIAGMOVE = 0.7071068;
    public double moveScale = 8.0; //Default 4
    public boolean isDead = true;
    public int spawnTick = 0;
    public int deathTick = -1;
    public double defaultHealth;
    public Inventory inventory = new Inventory();
    public Resource drops = new ZombieParts((int)(Math.random()*5+3))/*NullResource()*/;
    
    public Entity()
    {
        positionX = displayPosX = /*960*/ 0;
        positionY = displayPosY = /*540*/ 0;
        entityInit();
    }
    
    public Entity(double posX, double posY) {
        positionX = posX;
        positionY = posY;
        displayPosX = (int)positionX;
        displayPosY = (int)positionY;
        entityInit();
    }
    
    public void entityInit() {
        armor = 1.0;//default 1
        shield = 0.0;
        health = 100;
        isDead = false;
        spawnTick = MainProgram.tick;
    }
    
    public void damage(double d) {
        double realD = d / armor;
        if(shield <= 0) {
            health -= realD;
        } else if(shield > 0) {
            shield -= d;
        }
    }
    
    public void checkDead()
    {
        if(this.health <= 0) {
            isDead  = true;
            if(deathTick == -1) {
                deathTick = MainProgram.tick;
                MainProgram.player.inventory.getzParts().amount += drops.amount;
            }
        } else {
            isDead = false;
            deathTick = -1;
        }
    }
    
    public void fixDisplayCoords()
    {
        displayPosX = (int) (positionX - (MainProgram.player.positionX - MainProgram.player.displayPosX));
        displayPosY = (int) (positionY - (MainProgram.player.positionY - MainProgram.player.displayPosY));
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
    */
    public double getPosX()
    {
        return positionX;
    }
    public double getPosY()
    { 
        return positionY;
    }
    
    public int getDisplayX()
    {
        return displayPosX;
    }
    public int getDisplayY()
    {
        return displayPosY;
    }
    
    public double getDirection()
    {
        return direction;
    }
    
    /*public void move(String arrow)
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
            positionX += (moveDirection)/moveScale;
            positionY -= (90 - moveDirection)/moveScale;
        }
        else if(moveDirection <= 180 && moveDirection > 90)
        {
            positionX += (180 - moveDirection)/moveScale;
            positionY += (moveDirection - 90)/moveScale;
        }
        else if(moveDirection <= 270 && moveDirection > 180)
        {
            positionX -= (moveDirection - 180)/moveScale;
            positionY += (270 - moveDirection)/moveScale;
        }
        else if(moveDirection <= 359 && moveDirection > 270)
        {
            positionX -= (360 - moveDirection)/moveScale;
            positionY -= (moveDirection - 270)/moveScale;
        }
        //System.out.println(positionX + " - " + positionY);
        MainProgram.myFrame.panelRefresh();
    }*/
    public void move(ArrayList<String> arrows) {
        /*if(arrows.contains("up") && arrows.contains("right") && arrows.contains("down") && arrows.contains("left"));
        else if(arrows.contains("left") && arrows.contains("right")) {
            if(arrows.contains("down")) {
                positionY += moveScale;
            }
            else if(arrows.contains("up")) {
                positionY -= moveScale;
            }
        }
        else if(arrows.contains("up") && arrows.contains("down")) {
            if(arrows.contains("right")) {
                positionX += moveScale;
            }
            else if(arrows.contains("left")) {
                positionX -= moveScale;
            }
        }
        else if(arrows.contains("up") && arrows.contains("right")) {
            positionX += DIAGMOVE * moveScale;
            positionY -= DIAGMOVE * moveScale;
        }
        else if(arrows.contains("right") && arrows.contains("down")) {
            positionX += DIAGMOVE * moveScale;
            positionY += DIAGMOVE * moveScale;
        }
        else if(arrows.contains("down") && arrows.contains("left")) {
            positionX -= DIAGMOVE * moveScale;
            positionY += DIAGMOVE * moveScale;
        }
        else if(arrows.contains("left") && arrows.contains("up")) {
            positionX -= DIAGMOVE * moveScale;
            positionY -= DIAGMOVE * moveScale;
        }
        else if(arrows.contains("up")) {
            positionY -= moveScale;
        }
        else if(arrows.contains("right")) {
            positionX += moveScale;
        }
        else if(arrows.contains("down")) {
            positionY += moveScale;
        }
        else if(arrows.contains("left")) {
            positionX -= moveScale;
        }*///original based on string arraylist\
        if(arrows.contains("up") && arrows.contains("right") && arrows.contains("down") && arrows.contains("left"));
        else if(arrows.contains("left") && arrows.contains("right")) {
            if(arrows.contains("down")) {
                move(0, "down");
            }
            else if(arrows.contains("up")) {
                move(0, "up");
            }
        }
        else if(arrows.contains("up") && arrows.contains("down")) {
            if(arrows.contains("right")) {
                move(0, "right");
            }
            else if(arrows.contains("left")) {
                move(0, "left");
            }
        }
        else if(arrows.contains("up") && arrows.contains("right")) {
            //positionX += DIAGMOVE * moveScale;
            //positionY -= DIAGMOVE * moveScale;
            move(DIAGMOVE, "right");
        }
        else if(arrows.contains("right") && arrows.contains("down")) {
            //positionX += DIAGMOVE * moveScale;
            //positionY += DIAGMOVE * moveScale;
            move(-1*DIAGMOVE, "right");
        }
        else if(arrows.contains("down") && arrows.contains("left")) {
            //positionX -= DIAGMOVE * moveScale;
            //positionY += DIAGMOVE * moveScale;
            move(DIAGMOVE, "left");
        }
        else if(arrows.contains("left") && arrows.contains("up")) {
            //positionX -= DIAGMOVE * moveScale;
            //positionY -= DIAGMOVE * moveScale;
            move(-1*DIAGMOVE, "left");
        }
        else if(arrows.contains("up")) {
            move(0, "up");
        }
        else if(arrows.contains("right")) {
            move(0, "right");
        }
        else if(arrows.contains("down")) {
            move(0, "down");
        }
        else if(arrows.contains("left")) {
            move(0, "left");
        }
    }
    
    public void move(double vector, String direction) {
        if(direction == "down"){
            positionY += 1 * moveScale;
        } else if(direction == "up") {
            positionY -= 1 * moveScale;
        } else if(direction == "right") {
            positionY -= vector * moveScale;
            positionX += 1 * moveScale;
        } else if(direction == "left") {
            positionY += vector * moveScale;
            positionX -= 1 * moveScale;
        }
    }
    
    public void displayMove(ArrayList<String> arrows)//useless function
    {
        /*int moveDirection = MainProgram.player.direction;
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
            displayPosX += (moveDirection)/moveScale;
            displayPosY -= (90 - moveDirection)/moveScale;
        }
        else if(moveDirection <= 180 && moveDirection > 90)
        {
            displayPosX += (180 - moveDirection)/moveScale;
            displayPosY += (moveDirection - 90)/moveScale;
        }
        else if(moveDirection <= 270 && moveDirection > 180)
        {
            displayPosX -= (moveDirection - 180)/moveScale;
            displayPosY += (270 - moveDirection)/moveScale;
        }
        else if(moveDirection <= 359 && moveDirection > 270)
        {
            displayPosX -= (360 - moveDirection)/moveScale;
            displayPosY -= (moveDirection - 270)/moveScale;
        }
        MainProgram.myFrame.panelRefresh();*/
        /*if(arrows.contains("up") && arrows.contains("right") && arrows.contains("down") && arrows.contains("left"));
        else if(arrows.contains("left") && arrows.contains("right")) {
            if(arrows.contains("down")) {
                displayPosY += moveScale;
            }
            else if(arrows.contains("up")) {
                displayPosY -= moveScale;
            }
        }
        else if(arrows.contains("up") && arrows.contains("down")) {
            if(arrows.contains("right")) {
                displayPosX += moveScale;
            }
            else if(arrows.contains("left")) {
                displayPosX -= moveScale;
            }
        }
        else if(arrows.contains("up") && arrows.contains("right")) {
            displayPosX += DIAGMOVE * moveScale;
            displayPosY -= DIAGMOVE * moveScale;
        }
        else if(arrows.contains("right") && arrows.contains("down")) {
            displayPosX += DIAGMOVE * moveScale;
            displayPosY += DIAGMOVE * moveScale;
        }
        else if(arrows.contains("down") && arrows.contains("left")) {
            displayPosX -= (DIAGMOVE * moveScale);
            displayPosY += (DIAGMOVE * moveScale);
        }
        else if(arrows.contains("left") && arrows.contains("up")) {
            displayPosX -= DIAGMOVE * moveScale;
            displayPosY -= DIAGMOVE * moveScale;
        }
        else if(arrows.contains("up")) {
            displayPosY -= moveScale;
        }
        else if(arrows.contains("right")) {
            displayPosX += moveScale;
        }
        else if(arrows.contains("down")) {
            displayPosY += moveScale;
        }
        else if(arrows.contains("left")) {
            displayPosX -= moveScale;
        }*/
    }
}