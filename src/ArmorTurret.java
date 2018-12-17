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
            if(Math.sqrt((MainProgram.player.positionY - z.positionY) * (MainProgram.player.positionY - z.positionY) + (MainProgram.player.positionX - z.positionX) * (MainProgram.player.positionX - z.positionX)) < gun.range && Math.sqrt((MainProgram.player.positionY - z.positionY) * (MainProgram.player.positionY - z.positionY) + (MainProgram.player.positionX - z.positionX) * (MainProgram.player.positionX - z.positionX)) < dist) {
                double numer = MainProgram.player.positionY - z.positionY;
                double denum = MainProgram.player.positionY - z.positionX;
                double slope = numer / denum;
                slope = -1*slope;
                if(z.positionX > MainProgram.player.positionX) {
                    sDirect = "right";
                } else if(z.positionX < MainProgram.player.positionX){
                    sDirect = "left";
                } else if(slope == Double.NEGATIVE_INFINITY) {
                    sDirect = "up";
                } else if(slope == Double.POSITIVE_INFINITY) {
                    sDirect = "down";
                }
                direction = slope;
            }
        }
        vector = new Vector(MainProgram.player.positionX, MainProgram.player.positionY, sDirect, direction);
        return vector;
    }
}