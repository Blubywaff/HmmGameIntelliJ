public class Slingshots extends Gun
{
    public Slingshots()
    {
        super();
        slingshotInit();
    }
    
    public void slingshotInit() {
        perks.set(0, new HeavyRocksPerk());
        perks.set(1, new ThickBandPerk());
        perks.set(2, new StiffStickPerk());
        name = "Slingshot";
        family = "Primal Tech";
    }
}