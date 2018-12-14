public class BasicSlingshot extends Slingshots
{   
    public BasicSlingshot()
    {
        super();
        defaultDamage = FileManager.basicSlingshot("defaultDamage");
        damage = defaultDamage;
        defaultRange = FileManager.basicSlingshot("defaultRange");
        range = defaultRange;
        defaultFireRate = FileManager.basicSlingshot("defaultFireRate");//miliseconds delay
        fireRate = defaultFireRate;
        family = "Primal Tech";
        name = "Basic Slingshot";
        endInit();
    }
}
