public class AdvancedSlingshot extends Slingshots {
    public AdvancedSlingshot()
    {
        super();
        endInit();
        advancedSlingshotInit();
    }
    
    public void advancedSlingshotInit() {
        setName("AdvancedSlingshot");
        setDefaultDamage(FileManager.dDo(getName(), "defaultDamage"));
        setDamage(getDefaultDamage());
        setDefaultRange(FileManager.dDo(getName(), "defaultRange"));
        setRange(getDefaultRange());
        setDefaultFireRate(FileManager.dDo(getName(), "defaultFireRate"));//milliseconds delay
        setFireRate(getDefaultFireRate());
        setDefaultProjectileNum((int)FileManager.dDo(getName(), "defaultProjectileNum"));
        setProjectileNum(getDefaultProjectileNum());
    }
}