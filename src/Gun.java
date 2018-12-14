import java.util.*;
public class Gun extends Item
{
    public ArrayList<WeaponPerk> perks = new ArrayList<WeaponPerk>();
    public double defaultDamage;
    public double damage;
    public double defaultRange;
    public double range;
    public double defaultAccuracy;
    public double accuracy;
    //public String type;
    public double defaultFireRate;
    public double fireRate;
    //public String family;
    public boolean canFire = true;
    public int tickFired = -100000;
    //public String name;
    
    public final HeavyRocksPerk heavyRocks = new HeavyRocksPerk();
    public final ThickBandPerk thickBand = new ThickBandPerk();
    public final StiffStickPerk stiffStick = new StiffStickPerk();
    
    public Gun()
    {
        perks.add(new NullWeaponPerk());
        perks.add(new NullWeaponPerk());
        perks.add(new NullWeaponPerk());
        applyPerks();
    }
    
    public void endInit() {
        applyPerks();
    }
    
    public void applyPerks()
    {
        for(int i = 0; i < 3; i++)
        {
            if(perks.get(i).perkActive())
            {
                damage = defaultDamage * perks.get(i).damageAffect;
                range = defaultRange * perks.get(i).rangeAffect;
                accuracy = defaultAccuracy * perks.get(i).accuracyAffect;
                fireRate = defaultFireRate * perks.get(i).fireRateAffect;
            }
        }
    }
    
    public void fire() {}
    
    /*public void fire()
    {
        if(MainProgram.tick - tickFired >= fireRate/MainProgram.tickSpeed)
            canFire = true;
        if(canFire) {
            Projectile projectile = new Projectile(damage, MainProgram.player.positionX, MainProgram.player.positionY, range, new Vector(MainProgram.player.sDirect, MainProgram.player.direction));
            canFire = false;
            tickFired = MainProgram.tick;
        }
        //Projectile projectile = new Projectile(damage, MainProgram.player.positionX, MainProgram.player.positionY, range);
    }*/
    
    public void fire(Vector v) {
        if(MainProgram.tick - tickFired >= fireRate/MainProgram.tickSpeed)
            canFire = true;
        if(canFire) {
            Projectile projectile = new Projectile(damage, range, v);
            canFire = false;
            tickFired = MainProgram.tick;
        }
    }
}