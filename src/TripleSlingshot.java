public class TripleSlingshot extends Slingshots{
    public TripleSlingshot() {
        super();
        setDefaultDamage(FileManager.tripleSlingshot("defaultDamage"));
        setDamage(getDefaultDamage());
        setDefaultRange(FileManager.tripleSlingshot("defaultRange"));
        setRange(getDefaultRange());
        setDefaultFireRate(FileManager.tripleSlingshot("defaultFireRate"));//milliseconds delay
        setFireRate(getDefaultFireRate());
        setDefaultProjectileNum((int)FileManager.tripleSlingshot("defaultProjectileNum"));
        setProjectileNum(getDefaultProjectileNum());
        endInit();
        tripleSlingshotInit();
    }
    public void tripleSlingshotInit() {
        setName("Triple Slingshot");
    }
}