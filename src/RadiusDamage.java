public class RadiusDamage extends Projectile{
    public RadiusDamage(double d, double x, double y, double r)
    {
        setDamage(d);
        setPositionX(x);
        setPositionY(y);
        setRange(r);
        checkEnemy();
    }
    
    @Override
    public void checkEnemy() {
        String direct = "";
        for(Zombie z : MainProgram.zombies) {
            if(Math.sqrt((getPositionY() - z.getPositionY()) * (getPositionY() - z.getPositionY()) + (getPositionX() - z.getPositionX()) * (getPositionX() - z.getPositionX())) < getRange()) {
                z.damage(getDamage());//damage
                //calculate direction
                double numer = z.getPositionY() - getPositionY();
                double denum = z.getPositionX() - getPositionX();
                double slope = numer / denum;
                slope = -1*slope;
                if(z.getPositionX() > getPositionX()) {
                    direct = "right";
                } else if(z.getPositionX() < getPositionX()){
                    direct = "left";
                } else if(slope == Double.NEGATIVE_INFINITY) {
                    direct = "down";
                } else if(slope == Double.POSITIVE_INFINITY) {
                    direct = "up";
                }
                //repulse
                while(Math.sqrt((z.getPositionY() - getPositionY()) * (z.getPositionY() - getPositionY()) + (z.getPositionX() - getPositionX()) * (z.getPositionX() - getPositionX())) < getRange() * 2) {
                    if(direct == "right") {
                        z.setPositionX(z.getPositionX() + 1);
                        z.setPositionY(z.getPositionY() - slope);
                    } else if(direct == "left") {
                        z.setPositionX(z.getPositionX() - 1);
                        z.setPositionY(z.getPositionY() + slope);
                    } else if(direct == "up") {
                        z.setPositionY(z.getPositionY() - 1);
                    } else if(direct == "down") {
                        z.setPositionY(z.getPositionY() + 1);
                    }
                }
            }
        }
    }
}