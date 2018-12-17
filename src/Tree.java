public class Tree extends Environment{
    public Tree() {
        super();
        resource = new Wood((int)(Math.random()*200+100));
        normalYield = 20;
        treeInit();
    }

    public void treeInit() {
        resource = new Wood((int)(Math.random()*200+100));
        normalYield = 20;
    }
}