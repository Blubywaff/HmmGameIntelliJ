public class Environment extends Structure {
    public Resource resource = new NullResource();
    public double normalYield = 0;
    public Environment() {
        super();
    }
    
    @Override
    public void mine(double factor) {
        double mineAmount = normalYield*factor;
        if(mineAmount <= resource.amount) {
            resource.amount -= mineAmount;
            MainProgram.player.getInventory().addResource(resource.getName(), mineAmount);
        } else {
            mineAmount = resource.amount;
            resource.amount = 0;
            MainProgram.player.getInventory().addResource(resource.getName(), mineAmount);
        }
    }
    
    @Override
    public void checkDead() {
        if(getHealth() <= 0 || resource.amount <= 0) {
            setDead(true);
        } else {
            setDead(false);
        }
    }
}