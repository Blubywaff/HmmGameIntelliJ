public class RadiusDamage extends Projectile{
    public RadiusDamage(double d, double x, double y, double r)
    {
        damage = d;
        positionX = x;
        positionY = y;
        range = r;
        checkEnemy();
    }
    
    @Override
    public void checkEnemy() {
        /*for(int i = 0; i < MainProgram.zombieNum; i++) {
            if(Math.sqrt((positionY - MainProgram.zombies[i].positionY) * (positionY - MainProgram.zombies[i].positionY) + (positionX - MainProgram.zombies[i].positionX) * (positionX - MainProgram.zombies[i].positionX)) < range) {
                MainProgram.zombies[i].health -= damage;
            }
        }*///zombo
        String direct = "";
        for(Zombie z : MainProgram.zombies) {
            if(Math.sqrt((positionY - z.positionY) * (positionY - z.positionY) + (positionX - z.positionX) * (positionX - z.positionX)) < range) {
                z.damage(damage);//damage
                //calculate direction
                double numer = z.positionY - positionY;
                double denum = z.positionX - positionX;
                double slope = numer / denum;
                //slope = (int)(slope*1000);
                //slope /= 1000;
                slope = -1*slope;
                if(z.positionX > positionX) {
                    direct = "right";
                } else if(z.positionX < positionX){
                    direct = "left";
                } else if(slope == Double.NEGATIVE_INFINITY) {
                    direct = "down";
                } else if(slope == Double.POSITIVE_INFINITY) {
                    direct = "up";
                }
                //repulse
                while(Math.sqrt((z.positionY - positionY) * (z.positionY - positionY) + (z.positionX - positionX) * (z.positionX - positionX)) < range * 2) {
                    if(direct == "right") {
                        z.positionX++;
                        z.positionY -= slope;
                    } else if(direct == "left") {
                        z.positionX--;
                        z.positionY += slope;
                    } else if(direct == "up") {
                        z.positionY--;
                    } else if(direct == "down") {
                        z.positionY++;
                    }
                }
            }
        }
    }
}