public class Slingshots extends Gun
{
    public Slingshots()
    {
        super();
        slingshotInit();
    }
    
    public void slingshotInit() {
        getPerks().set(0, new HeavyRocksPerk());
        getPerks().set(1, new ThickBandPerk());
        getPerks().set(2, new StiffStickPerk());
        name = "Slingshot";
        family = "Primal Tech";
    }
}