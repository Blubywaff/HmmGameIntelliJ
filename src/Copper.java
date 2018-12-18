public class Copper extends Resource {
    public Copper() {
        super();
        copperInit();
    }
    public Copper(double a) {
        super(a);
        copperInit();
    }
    
    public void copperInit() {
        setName("Copper");
    }
}