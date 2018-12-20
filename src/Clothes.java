public class Clothes extends Armor {
    public Clothes() {
        perks.set(0, new ThickWeavePerk());
        perks.set(1, new TightWeavePerk());
        perks.set(2, new QualityWeavePerk());
        armor = 0.001;
        setFamily("Shit Equipment");
        clothesInit();
    }

    public void clothesInit() {
        perks.set(0, new ThickWeavePerk());
        perks.set(1, new TightWeavePerk());
        perks.set(2, new QualityWeavePerk());
        armor = 0.001;
        setFamily("Shit Equipment");
        numAM = 1;
    }
}