public class Axe extends Tool {
    public Axe() {
        super();
        axeInit();
    }
    
    public void axeInit() {
        useType = "Wood";
        mineFactor = 1;
        name = "Axe";
    }
}