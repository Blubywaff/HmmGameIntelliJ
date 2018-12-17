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
        positionX = posX;
        zombieInit();
    }
    
    public void zombieInit() {
        health = 200;
        moveScale = moveScale / 8;
    }
}