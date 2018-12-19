public class BasicSlingshot extends Slingshots {
    public BasicSlingshot() {
        super();
        setDefaultDamage(FileManager.basicSlingshot("defaultDamage"));
        setDamage(getDefaultDamage());
        setDefaultRange(FileManager.basicSlingshot("defaultRange"));
        setRange(getDefaultRange());
        setDefaultFireRate(FileManager.basicSlingshot("defaultFireRate"));//miliseconds delay
        setFireRate(getDefaultFireRate());
        setDefaultProjectileNum((int)FileManager.basicSlingshot("defaultProjectileNum"));
        setProjectileNum(getDefaultProjectileNum());
        endInit();
        basicSlingshotInit();
    }
    
    public void basicSlingshotInit() {
        setName("Basic Slingshot");
    }
}