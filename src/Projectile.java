import java.util.ArrayList;
public class Projectile extends Entity
{
    public double velocity;
    public double range;
    public int penetration = 1;
    public Vector vector;
    public double hitX;
    public double hitY;
    
    public Projectile()
    {
    }
    
    /*public Projectile(double d, double x, double y, double r)
    {
        damage = d;
        positionX = x;
        positionY = y;
        range = r;
        checkEnemy();
    }*/
    
    public Projectile(double d, double r, Vector v) {
        damage = d;
        range = r;
        vector = v;
        checkEnemy();
    }
    
    public void checkEnemy()
    {
        int numHit = 0;
        double x = vector.positionX;
        double y = vector.positionY;
        ArrayList<double[]> coords = new ArrayList<double[]>();
        double[] trashCoord = {x, y};
        coords.add(trashCoord);
        while(Math.sqrt((y - vector.positionY) * (y - vector.positionY) + (x - vector.positionX) * (x - vector.positionX)) < range) {
            if(vector.sDirect == "right") {
                x += 0.1;
                y -= vector.direction/10;
            } else {
                x -= 0.1;
                y += vector.direction/10;
            }
            double[] coord = {x, y};
            coords.add(coord);
        }
        for(double[] coord : coords) {
            for(Zombie z : MainProgram.zombies) {
                if(numHit >= penetration) {
                    break;
                }
                if(Math.sqrt((coord[1] - z.positionY) * (coord[1] - z.positionY) + (coord[0] - z.positionX) * (coord[0] - z.positionX)) < 5) {
                    z.damage(damage);
                    numHit++;
                    MyPanel.z = z;
                    break;
                }
            }
            for(ZombieSpawner zs : MainProgram.zombieSpawners) {
                if(numHit >= penetration) {
                    break;
                }
                if(Math.sqrt((coord[1] - zs.positionY) * (coord[1] - zs.positionY) + (coord[0] - zs.positionX) * (coord[0] - zs.positionX)) < 5) {
                    zs.damage(damage);
                    numHit++;
                    hitX = zs.displayPosX;
                    hitY = zs.displayPosY;
                    break;
                }
            }
            if(numHit >= penetration) {
                break;
            }
        }
    }
}