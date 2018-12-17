public class AdvancedSlingshot extends Slingshots {
    public AdvancedSlingshot()
    {
        super();
        defaultDamage = FileManager.advancedSlingshot("defaultDamage");
        damage = defaultDamage;
        defaultRange = FileManager.advancedSlingshot("defaultRange");
        range = defaultRange;
        defaultFireRate = FileManager.advancedSlingshot("defaultFireRate");//milliseconds delay
        fireRate = defaultFireRate;
        endInit();
        advancedSlingshotInit();
    }
    
    public void advancedSlingshotInit() {
        name = "Advanced Slingshot";
    }
}