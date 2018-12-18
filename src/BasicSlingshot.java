public class BasicSlingshot extends Slingshots
{   
    public BasicSlingshot()
    {
        super();
        setDefaultDamage(FileManager.basicSlingshot("defaultDamage"));
        setDamage(getDefaultDamage());
        setDefaultRange(FileManager.basicSlingshot("defaultRange"));
        setRange(getDefaultRange());
        setDefaultFireRate(FileManager.basicSlingshot("defaultFireRate"));//miliseconds delay
        setFireRate(getDefaultFireRate());
        //defaultAccuracy = 1;
        //accuracy = defaultAccuracy;
        endInit();
        basicSlingshotInit();
    }
    
    public void basicSlingshotInit() {
        setName("Basic Slingshot");
    }
}
