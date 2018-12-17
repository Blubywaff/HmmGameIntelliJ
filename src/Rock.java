public class Rock extends Environment {
    public Rock() {
        super();
        resource = new Stone((int)(Math.random()*200+100));
        normalYield = 20;
    }
}