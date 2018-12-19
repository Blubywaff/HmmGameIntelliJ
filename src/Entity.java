import java.util.*;
public class Entity
{
    private double health;
    private double shield;
    private double armor;
    private double damage = 10;
    private double positionX;
    private double positionY;
    private int displayPosX;
    private int displayPosY;
    private double direction = 0;
    private String sDirect = "right";
    private static final double DIAGMOVE = 0.7071068;
    private double moveScale = 8.0; //Default 4
    private boolean isDead = true;
    private int spawnTick = 0;
    private int deathTick = -1;
    private double defaultHealth;
    private Inventory inventory = new Inventory();
    private Resource drops = new ZombieParts((int)(Math.random()*5+3))/*NullResource()*/;
    
    public Entity()
    {
        setPositionX(0);
        setDisplayPosX(0);
        setPositionY(0);
        setDisplayPosY(0);
        entityInit();
    }
    
    public Entity(double posX, double posY) {
        setPositionX(posX);
        setPositionY(posY);
        setDisplayPosX((int) getPositionX());
        setDisplayPosY((int) getPositionY());
        entityInit();
    }

    public static double getDIAGMOVE() {
        return DIAGMOVE;
    }

    public void entityInit() {
        setArmor(1.0);//default 1
        setShield(0.0);
        setHealth(100);
        setDead(false);
        setSpawnTick(MainProgram.tick);
    }
    
    public void damage(double d) {
        double realD = d / getArmor();
        if(getShield() <= 0) {
            setHealth(getHealth() - realD);
        } else if(getShield() > 0) {
            setShield(getShield() - d);
        }
    }
    
    public void checkDead()
    {
        if(this.getHealth() <= 0) {
            setDead(true);
            if(getDeathTick() == -1) {
                setDeathTick(MainProgram.tick);
                MainProgram.player.getInventory().getzParts().amount += getDrops().amount;
            }
        } else {
            setDead(false);
            setDeathTick(-1);
        }
    }
    
    public void fixDisplayCoords()
    {
        setDisplayPosX((int) (getPositionX() - (MainProgram.player.getPositionX() - MainProgram.player.getDisplayPosX())));
        setDisplayPosY((int) (getPositionY() - (MainProgram.player.getPositionY() - MainProgram.player.getDisplayPosY())));
    }

    public double getPosX()
    {
        return getPositionX();
    }
    public double getPosY()
    { 
        return getPositionY();
    }
    
    public int getDisplayX()
    {
        return getDisplayPosX();
    }
    public int getDisplayY()
    {
        return getDisplayPosY();
    }
    
    public double getDirection()
    {
        return direction;
    }

    public void move(ArrayList<String> arrows) {
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
            move(getDIAGMOVE(), "right");
        }
        else if(arrows.contains("right") && arrows.contains("down")) {
            move(-1* getDIAGMOVE(), "right");
        }
        else if(arrows.contains("down") && arrows.contains("left")) {
            move(getDIAGMOVE(), "left");
        }
        else if(arrows.contains("left") && arrows.contains("up")) {
            move(-1* getDIAGMOVE(), "left");
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
            setPositionY(getPositionY() + 1 * getMoveScale());
        } else if(direction == "up") {
            setPositionY(getPositionY() - 1 * getMoveScale());
        } else if(direction == "right") {
            setPositionY(getPositionY() - vector * getMoveScale());
            setPositionX(getPositionX() + 1 * getMoveScale());
        } else if(direction == "left") {
            setPositionY(getPositionY() + vector * getMoveScale());
            setPositionX(getPositionX() - 1 * getMoveScale());
        }
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getShield() {
        return shield;
    }

    public void setShield(double shield) {
        this.shield = shield;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public int getDisplayPosX() {
        return displayPosX;
    }

    public void setDisplayPosX(int displayPosX) {
        this.displayPosX = displayPosX;
    }

    public int getDisplayPosY() {
        return displayPosY;
    }

    public void setDisplayPosY(int displayPosY) {
        this.displayPosY = displayPosY;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public String getsDirect() {
        return sDirect;
    }

    public void setsDirect(String sDirect) {
        this.sDirect = sDirect;
    }

    public double getMoveScale() {
        return moveScale;
    }

    public void setMoveScale(double moveScale) {
        this.moveScale = moveScale;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getSpawnTick() {
        return spawnTick;
    }

    public void setSpawnTick(int spawnTick) {
        this.spawnTick = spawnTick;
    }

    public int getDeathTick() {
        return deathTick;
    }

    public void setDeathTick(int deathTick) {
        this.deathTick = deathTick;
    }

    public double getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(double defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Resource getDrops() {
        return drops;
    }

    public void setDrops(Resource drops) {
        this.drops = drops;
    }
}