public class Stone extends Resource {
    public Stone() {
        super();
        stoneInit();
    }
    public Stone(double a) {
        super(a);
        stoneInit();
    }
    
    public void stoneInit() {
        name = "Stone";
    }
}