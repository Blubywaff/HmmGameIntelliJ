import java.util.ArrayList;

public class Sword extends Gun {

    public Sword() {
        setName("Sword");
        setDefaultDamage(200);
        setDamage(getDefaultDamage());
        setDefaultFireRate(20);
        setDefaultFireRate(getDefaultFireRate());
        setDefaultRange(1000);
        setRange(getDefaultRange());
    }

    @Override
    public void fire(Vector v) {
        if(MainProgram.tick - getTickFired() >= getFireRate() / MainProgram.tickSpeed)
            setCanFire(true);
        if(isCanFire()) {
            ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

            for(Zombie z : MainProgram.zombies) {
                if(Math.sqrt((MainProgram.player.getPositionY() - z.getPositionY()) * (MainProgram.player.getPositionY() - z.getPositionY()) + (MainProgram.player.getPositionX() - z.getPositionX()) * (MainProgram.player.getPositionX() - z.getPositionX())) < getRange()) {
                    Vector vector;
                    String sDirect = "";
                    double direction = 0;

                    double numer = MainProgram.player.getPositionY() - z.getPositionY();
                    double denum = MainProgram.player.getPositionY() - z.getPositionX();
                    double slope = numer / denum;
                    slope = -1*slope;
                    if(z.getPositionX() > MainProgram.player.getPositionX()) {
                        sDirect = "right";
                    } else if(z.getPositionX() < MainProgram.player.getPositionX()){
                        sDirect = "left";
                    } else if(slope == Double.NEGATIVE_INFINITY) {
                        sDirect = "up";
                    } else if(slope == Double.POSITIVE_INFINITY) {
                        sDirect = "down";
                    }
                    direction = slope;

                    if(sDirect == v.sDirect) {
                        vector = new Vector(v.positionX, v.positionY, sDirect, direction);
                        Projectile projectile = new Projectile(getDamage(), getRange(), vector, this);
                        projectiles.add(projectile);
                    }

                }
            }

            setCanFire(false);
            setTickFired(MainProgram.tick);
        }
    }

}
