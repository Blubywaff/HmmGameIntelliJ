public class Wood extends Resource {
    public Wood() {
        super();
        woodInit();
    }
    public Wood(double a) {
        super(a);
        woodInit();
    }
    
    public void woodInit() {
        name = "Wood";
    }
}