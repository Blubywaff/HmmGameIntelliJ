public class ArmorTurret extends ArmorModule {
    public Gun gun;
    public ArmorTurret() {
        gun = new BasicSlingshot();
    }
    
    //@Override
    public void fire() {
        fire(calcVector());
    }
    
    //@Override
    public void fire(Vector v) {
        gun.fire(v);
    }
    
    public Vector calcVector() {
        Vector vector;
        String sDirect = "";
        double direction = 0;
        double dist = 10000;
        for(Zombie z : MainProgram.zombies) {
            if(Math.sqrt((MainProgram.player.getPositionY() - z.getPositionY()) * (MainProgram.player.getPositionY() - z.getPositionY()) + (MainProgram.player.getPositionX() - z.getPositionX()) * (MainProgram.player.getPositionX() - z.getPositionX())) < gun.getRange() && Math.sqrt((MainProgram.player.getPositionY() - z.getPositionY()) * (MainProgram.player.getPositionY() - z.getPositionY()) + (MainProgram.player.getPositionX() - z.getPositionX()) * (MainProgram.player.getPositionX() - z.getPositionX())) < dist) {
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
            }
        }
        vector = new Vector(MainProgram.player.getPositionX(), MainProgram.player.getPositionY(), sDirect, direction);
        return vector;
    }
}