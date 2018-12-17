public class Tree extends Environment{
    public Tree() {
        super();
        resource = new Wood((int)(Math.random()*200+100));
        normalYeild = 20;
    }
}