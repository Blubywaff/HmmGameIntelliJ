public class BasicSlingshot extends Slingshots
{   
    public BasicSlingshot()
    {
        super();
        defaultDamage = 200;//FileManager.basicSlingshot("defaultDamage");
        damage = defaultDamage;
        defaultRange = 100;//FileManager.basicSlingshot("defaultRange");
        range = defaultRange;
        defaultFireRate = 5000;//FileManager.basicSlingshot("defaultFireRate");//miliseconds delay
        fireRate = defaultFireRate;
        endInit();
        basicSlingshotInit();
    }
    
    public void basicSlingshotInit() {
        name = "Basic Slingshot";
    }
}
