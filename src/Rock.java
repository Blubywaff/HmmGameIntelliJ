public class Rock extends Environment {
    public Rock() {
        resource = new Stone(Math.random()*200+100);
        normalYeild = 20;
    }
}