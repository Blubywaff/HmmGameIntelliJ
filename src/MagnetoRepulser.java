public class MagnetoRepulser extends Gun{
    public MagnetoRepulser()
    {
        super();
        setDefaultDamage(100);
        setDamage(getDefaultDamage());
        setDefaultRange(50);
        setRange(getDefaultRange());
        setDefaultFireRate(10000);//miliseconds delay
        setFireRate(getDefaultFireRate());
    }
    
    @Override
    public void fire() {
        if(MainProgram.tick - getTickFired() >= getFireRate() /MainProgram.tickSpeed)
            setCanFire(true);
        if(isCanFire()) {
            RadiusDamage projectile = new RadiusDamage(getDamage(), MainProgram.player.getPositionX(), MainProgram.player.getPositionY(), getRange());
            setCanFire(false);
            setTickFired(MainProgram.tick);
        }
    }
}