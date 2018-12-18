public class ZombieSpawner extends Spawner {
    public ZombieSpawner() {
        super();
        zombieSpawnerInit();
    }
    
    public ZombieSpawner(double posX, double posY) {
        super(posX, posY);
        zombieSpawnerInit();
    }
    
    public void zombieSpawnerInit() {
        type = "ZombieSpawner";
        speed = 1000;
    }
    
    @Override
    public void spawn() {
        if(MainProgram.tick - tickSpawn >= speed / MainProgram.tickSpeed) {
            Zombie zombie = doSpawn();
            MainProgram.zombies.add(zombie);
            tickSpawn = MainProgram.tick;
        }
    }
    
    @Override
    public Zombie doSpawn() {
        Zombie zombie = new Zombie(getPositionX(), getPositionY());
        //zombie.positionX = positionX;
        //zombie.positionY = positionY;
        return zombie;
    }
}