public class ZombieSpawner extends Spawner {
    public ZombieSpawner() {
        type = "ZombieSpawner";
        speed = 1000;
    }
    
    public ZombieSpawner(double posX, double posY) {
        super(posX, posY);
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
        Zombie zombie = new Zombie(positionX, positionY);
        //zombie.positionX = positionX;
        //zombie.positionY = positionY;
        return zombie;
    }
}