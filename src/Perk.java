//import java.util.*; //not used

public class Perk
{
    public String affect = "";
    public double damageAffect = 1.0;
    public double rangeAffect = 1.0;
    public double accuracyAffect = 1.0;
    public double fireRateAffect = 1.0;
    public double shieldAffect = 1.0;
    public double armorAffect = 1.0;
    public boolean isActive = false;
    public String name = "generic perk";
    public Perk()
    {
    }
    
    public boolean perkActive()
    {
        return isActive;
    }
    
    public String toString()
    {
        return(name + " - " + isActive);
    }
}