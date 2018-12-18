public class Turret extends Building {
    public Gun gun;
    public Turret() {
        gun = new NullGun();
    }
    
    public void fire() {
        fire(calcVector());
    }
    
    public void fire(Vector v) {
        gun.fire(v);
    }
    
    public Vector calcVector() {
        Vector vector;
        String sDirect = "";
        double direction = 0;
        double dist = 10000;
        for(Zombie z : MainProgram.zombies) {
            if(Math.sqrt((positionY - z.positionY) * (positionY - z.positionY) + (positionX - z.positionX) * (positionX - z.positionX)) < gun.getRange() && Math.sqrt((positionY - z.positionY) * (positionY - z.positionY) + (positionX - z.positionX) * (positionX - z.positionX)) < dist) {
                double numer = MainProgram.player.positionY - z.positionY;
                double denum = MainProgram.player.positionY - z.positionX;
                double slope = numer / denum;
                slope = -1*slope;
                if(z.positionX > positionX) {
                    sDirect = "right";
                }
                else if(z.positionX < positionY){
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