public class Slingshots extends Gun
{
    public Slingshots()
    {
        super();
        perks.set(0, new HeavyRocksPerk());
        perks.set(1, new ThickBandPerk());
        perks.set(2, new StiffStickPerk());
    }
}