import java.util.*;
public class Spawner extends Enemy{
    public String type;
    public int speed;//miliseconds
    public double tickSpawn = 0;
    public Spawner() {
        positionX = positionY = 0;
        speed = 0;
        type = "generic";
    }
    
    public Spawner(double posX, double posY) {
        super(posX, posY);
        speed = 0;
        type = "generic";
    }
    
    public void spawn() {
        if(MainProgram.tick - tickSpawn >= speed/MainProgram.tickSpeed) {
            Enemy enemy = doSpawn();
        }
    }
    
    public Enemy doSpawn() {
        Enemy enemy = new Enemy();
        return enemy;
    }
    
    @Override
    public void move(ArrayList<String> arrows) {
        
    }
    @Override
    public void move(double vector, String direction) {
    }
}