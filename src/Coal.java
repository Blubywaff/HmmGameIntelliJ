public class Coal extends Resource {
    public Coal() {
        super();
        coalInit();
    }
    public Coal(double a) {
        super(a);
        coalInit();
    }

    public void coalInit() {
        setName("Coal");
    }
}
