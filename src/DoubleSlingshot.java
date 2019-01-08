public class DoubleSlingshot extends Slingshots{
    public DoubleSlingshot() {
        super();
        endInit();
        doubleSlingshotInit();
    }
    public void doubleSlingshotInit() {
        setName("DoubleSlingshot");
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