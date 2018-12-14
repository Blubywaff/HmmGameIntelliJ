public class MagnetoRepulser extends Gun{
    public MagnetoRepulser()
    {
        super();
        defaultDamage = 100;
        damage = defaultDamage;
        defaultRange = 50;
        range = defaultRange;
        defaultFireRate = 10000;//miliseconds delay
        fireRate = defaultFireRate;
    }
    
    //@Override
    public void fire() {
        if(MainProgram.tick - tickFired >= fireRate/MainProgram.tickSpeed)
            canFire = true;
        if(canFire) {
            RadiusDamage projectile = new RadiusDamage(damage, MainProgram.player.positionX, MainProgram.player.positionY, range);
            canFire = false;
            tickFired = MainProgram.tick;
        }
    }
}