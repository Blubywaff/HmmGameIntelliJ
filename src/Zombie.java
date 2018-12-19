public class Zombie extends Enemy
{
    
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