import java.util.*;
public class Gun extends Item
{
    private ArrayList<WeaponPerk> perks = new ArrayList<WeaponPerk>();
    private double defaultDamage;
    private double damage;
    private double defaultRange;
    private double range;
    private double defaultAccuracy;
    private double accuracy;
    private double defaultFireRate;
    private double fireRate;
    private int defaultProjectileNum;
    private int projectileNum;
    private boolean canFire = true;
    private int tickFired = -100000;
    private double hitX;
    private double hitY;
    
    private final HeavyRocksPerk heavyRocks = new HeavyRocksPerk();
    private final ThickBandPerk thickBand = new ThickBandPerk();
    private final StiffStickPerk stiffStick = new StiffStickPerk();
    
    public Gun()
    {
        getPerks().add(new NullWeaponPerk());
        getPerks().add(new NullWeaponPerk());
        getPerks().add(new NullWeaponPerk());
        applyPerks();
    }
    
    public void endInit() {
        applyPerks();
    }
    
    public void applyPerks()
    {
        for(int i = 0; i < 3; i++)
        {
            if(getPerks().get(i).perkActive())
            {
                setDamage(getDefaultDamage() * getPerks().get(i).damageAffect);
                setRange(getDefaultRange() * getPerks().get(i).rangeAffect);
                setAccuracy(getDefaultAccuracy() * getPerks().get(i).accuracyAffect);
                setFireRate(getDefaultFireRate() * getPerks().get(i).fireRateAffect);
            }
        }
    }
    
    public void fire() {}
    
    public void fire(Vector v) {
        if(MainProgram.tick - getTickFired() >= getFireRate() / MainProgram.tickSpeed)
            setCanFire(true);
        if(isCanFire()) {
            ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
            for (int i = 0; i < getProjectileNum(); i++) {
                Projectile projectile = new Projectile(getDamage(), getRange(), v);
                projectiles.add(projectile);
            }
                setCanFire(false);
                setTickFired(MainProgram.tick);
        }
    }

    public ArrayList<WeaponPerk> getPerks() {
        return perks;
    }

    public void setPerks(ArrayList<WeaponPerk> perks) {
        this.perks = perks;
    }

    public double getDefaultDamage() {
        return defaultDamage;
    }

    public void setDefaultDamage(double defaultDamage) {
        this.defaultDamage = defaultDamage;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDefaultRange() {
        return defaultRange;
    }

    public void setDefaultRange(double defaultRange) {
        this.defaultRange = defaultRange;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getDefaultAccuracy() {
        return defaultAccuracy;
    }

    public void setDefaultAccuracy(double defaultAccuracy) {
        this.defaultAccuracy = defaultAccuracy;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getDefaultFireRate() {
        return defaultFireRate;
    }

    public void setDefaultFireRate(double defaultFireRate) {
        this.defaultFireRate = defaultFireRate;
    }

    public double getFireRate() {
        return fireRate;
    }

    public void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }

    public boolean isCanFire() {
        return canFire;
    }

    public void setCanFire(boolean canFire) {
        this.canFire = canFire;
    }

    public int getTickFired() {
        return tickFired;
    }

    public void setTickFired(int tickFired) {
        this.tickFired = tickFired;
    }

    public double getHitX() {
        return hitX;
    }

    public void setHitX(double hitX) {
        this.hitX = hitX;
    }

    public double getHitY() {
        return hitY;
    }

    public void setHitY(double hitY) {
        this.hitY = hitY;
    }

    public HeavyRocksPerk getHeavyRocks() {
        return heavyRocks;
    }

    public ThickBandPerk getThickBand() {
        return thickBand;
    }

    public StiffStickPerk getStiffStick() {
        return stiffStick;
    }

    public int getDefaultProjectileNum() {
        return defaultProjectileNum;
    }

    public void setDefaultProjectileNum(int defaultProjectileNum) {
        this.defaultProjectileNum = defaultProjectileNum;
    }

    public int getProjectileNum() {
        return projectileNum;
    }

    public void setProjectileNum(int projectileNum) {
        this.projectileNum = projectileNum;
    }
}