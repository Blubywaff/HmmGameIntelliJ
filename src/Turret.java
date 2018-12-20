public class Turret extends Building {
    public Gun gun;
    public Turret() {
        gun = new TripleSlingshot();
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
            if(Math.sqrt((getPositionY() - z.getPositionY()) * (getPositionY() - z.getPositionY()) + (getPositionX() - z.getPositionX()) * (getPositionX() - z.getPositionX())) < gun.getRange() && Math.sqrt((getPositionY() - z.getPositionY()) * (getPositionY() - z.getPositionY()) + (getPositionX() - z.getPositionX()) * (getPositionX() - z.getPositionX())) < dist) {
                double numer = MainProgram.player.getPositionY() - z.getPositionY();
                double denum = MainProgram.player.getPositionY() - z.getPositionX();
                double slope = numer / denum;
                slope = -1*slope;
                if(z.getPositionX() > getPositionX()) {
                    sDirect = "right";
                }
                else if(z.getPositionX() < getPositionY()){
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