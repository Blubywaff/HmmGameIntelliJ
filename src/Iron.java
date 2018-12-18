public class Iron extends Resource{
    public Iron() {
        super();
        ironInit();
    }
    public Iron(double a) {
        super(a);
        ironInit();
    }
    
    public void ironInit() {
        setName("Iron");
    }
}