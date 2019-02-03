public class CampFire extends Building {
    public Buff buff = new CampFireBuff();
    public double range = 100;

    public CampFire() {
        super();
    }
    public CampFire(double posX, double posY) {
        super(posX, posY);
    }

    public void checkPlayerProx() {
        if(Math.sqrt((MainProgram.player.getPositionY() - getPositionY()) * (MainProgram.player.getPositionY() - getPositionY()) + (MainProgram.player.getPositionX() - getPositionX()) * (MainProgram.player.getPositionX() - getPositionX())) < range) {
            applyBuff();
        } else {
            //removeBuff();
        }
    }



    public void applyBuff() {
        MainProgram.player.addBuff(buff);
    }

    /*public void removeBuff() {
        MainProgram.player.getInventory().buffs.remove(buff);
    }*/

}
