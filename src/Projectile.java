import java.util.ArrayList;
public class Projectile extends Entity
{
    private double velocity;
    private double range;
    private int penetration = 1;
    private Vector vector;
    private double hitX;
    private double hitY;
    private boolean isPrimary = true;
    
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
        setRange(r);
        setVector(v);
        checkEnemy();
    }
    
    public void checkEnemy()
    {
        int numHit = 0;
        double x = getVector().positionX;
        double y = getVector().positionY;
        ArrayList<double[]> coords = new ArrayList<double[]>();
        double[] trashCoord = {x, y};
        coords.add(trashCoord);
        while(Math.sqrt((y - getVector().positionY) * (y - getVector().positionY) + (x - getVector().positionX) * (x - getVector().positionX)) < getRange()) {
            if(getVector().sDirect == "right") {
                x += 0.1;
                y -= getVector().direction/10;
            } else {
                x -= 0.1;
                y += getVector().direction/10;
            }
            double[] coord = {x, y};
            coords.add(coord);
        }
        for(double[] coord : coords) {
            for(Zombie z : MainProgram.zombies) {
                if(numHit >= getPenetration()) {
                    break;
                }
                if(Math.sqrt((coord[1] - z.positionY) * (coord[1] - z.positionY) + (coord[0] - z.positionX) * (coord[0] - z.positionX)) < 5) {
                    z.damage(damage);
                    numHit++;
                    if(isPrimary()) {
                        MyPanel.hitsP.add(z);
                    } else {
                        MyPanel.hitsS.add(z);
                    }
                    break;
                }
            }
            for(ZombieSpawner zs : MainProgram.zombieSpawners) {
                if(numHit >= getPenetration()) {
                    break;
                }
                if(Math.sqrt((coord[1] - zs.positionY) * (coord[1] - zs.positionY) + (coord[0] - zs.positionX) * (coord[0] - zs.positionX)) < 5) {
                    zs.damage(damage);
                    numHit++;
                    if(isPrimary()) {
                        MyPanel.hitsP.add(zs);
                    } else {
                        MyPanel.hitsS.add(zs);
                    }
                    break;
                }
            }
            if(numHit >= getPenetration()) {
                break;
            }
        }
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getPenetration() {
        return penetration;
    }

    public void setPenetration(int penetration) {
        this.penetration = penetration;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public double getHitX() {
        return hitX;
    }

    public void setHitX(double hitX) {
        this.hitX = hitX;
    }

    public double getHitY() {
        return hitY;
    }

    public void setHitY(double hitY) {
        this.hitY = hitY;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}