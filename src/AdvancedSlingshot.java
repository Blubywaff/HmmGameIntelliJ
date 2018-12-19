public class AdvancedSlingshot extends Slingshots {
    public AdvancedSlingshot()
    {
        super();
        setDefaultDamage(FileManager.advancedSlingshot("defaultDamage"));
        setDamage(getDefaultDamage());
        setDefaultRange(FileManager.advancedSlingshot("defaultRange"));
        setRange(getDefaultRange());
        setDefaultFireRate(FileManager.advancedSlingshot("defaultFireRate"));//milliseconds delay
        setFireRate(getDefaultFireRate());
        setDefaultProjectileNum((int)FileManager.advancedSlingshot("defaultProjectileNum"));
        setProjectileNum(getDefaultProjectileNum());
        endInit();
        advancedSlingshotInit();
    }
    
    public void advancedSlingshotInit() {
        setName("Advanced Slingshot");
    }
}