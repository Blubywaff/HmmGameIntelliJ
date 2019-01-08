public class BasicSlingshot extends Slingshots {
    public BasicSlingshot() {
        super();
        endInit();
        basicSlingshotInit();
    }
    
    public void basicSlingshotInit() {
        setName("BasicSlingshot");
        setDefaultDamage(FileManager.dDo(getName(), "defaultDamage"));
        setDamage(getDefaultDamage());
        setDefaultRange(FileManager.dDo(getName(), "defaultRange"));
        setRange(getDefaultRange());
        setDefaultFireRate(FileManager.dDo(getName(), "defaultFireRate"));//miliseconds delay
        setFireRate(getDefaultFireRate());
        setDefaultProjectileNum((int)FileManager.dDo(getName(), "defaultProjectileNum"));
        setProjectileNum(getDefaultProjectileNum());
    }
}