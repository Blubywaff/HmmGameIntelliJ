import java.util.*;
public class Armor extends Item
{
    public ArrayList<ArmorPerk> perks = new ArrayList<ArmorPerk>();
    //public String family = "";
    //public String name = "";
    public double shield = 0;
    public double armor = 0;
    public Armor() {
        perks.add(new NullArmorPerk());
        perks.add(new NullArmorPerk());
        perks.add(new NullArmorPerk());
    }
    
    public void applyPerks()
    {
        for(int i = 0; i < 3; i++)
        {
            if(perks.get(i).perkActive())
            {
                
            }
        }
    }
}