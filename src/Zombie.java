public class Zombie extends Enemy
{
    /*private double health;
    private double armor;
    private double damage;
    public int positionX;
    public int positionY;
    public int displayPosX;
    public int displayPosY;*/
    
    public Zombie()
    {
        super();
        zombieInit();
    }
    public Zombie(double posX, double posY) {
        super(posX, posY);
        setPositionX(posX);
        zombieInit();
    }
    
    public void zombieInit() {
        setHealth(200);
        setMoveScale(getMoveScale() / 8);
    }
}