public class AdvancedSlingshot extends Slingshots {
    public AdvancedSlingshot()
    {
        super();
        defaultDamage = 70;
        damage = defaultDamage;
        defaultRange = 120;
        range = defaultRange;
        defaultFireRate = 4000;//milliseconds delay
        fireRate = defaultFireRate;
        endInit();
    }
}