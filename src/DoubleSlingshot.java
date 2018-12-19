public class DoubleSlingshot extends Slingshots{
    public DoubleSlingshot() {
        super();
        setDefaultDamage(FileManager.doubleSlingshot("defaultDamage"));
        setDamage(getDefaultDamage());
        setDefaultRange(FileManager.doubleSlingshot("defaultRange"));
        setRange(getDefaultRange());
        setDefaultFireRate(FileManager.doubleSlingshot("defaultFireRate"));//milliseconds delay
        setFireRate(getDefaultFireRate());
        setDefaultProjectileNum((int)FileManager.doubleSlingshot("defaultProjectileNum"));
        setProjectileNum(getDefaultProjectileNum());
        endInit();
        doubleSlingshotInit();
    }
    public void doubleSlingshotInit() {
        setName("Double Slingshot");
    }
}
