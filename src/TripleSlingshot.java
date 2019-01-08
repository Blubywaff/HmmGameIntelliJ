public class TripleSlingshot extends Slingshots{
    public TripleSlingshot() {
        super();
        endInit();
        tripleSlingshotInit();
    }
    public void tripleSlingshotInit() {
        setName("TripleSlingshot");
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