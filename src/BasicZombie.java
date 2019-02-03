public class BasicZombie  extends Zombie {
    public BasicZombie() {
        super();
        basicZombieInit();
    }

    public void basicZombieInit() {

        setMoveScale(getMoveScale() / 8);
    }
}
