public class Environment extends Structure {
    public Resource resource = new NullResource();
    public double normalYeild = 0;
    public Environment() {
    }
    
    @Override
    public void mine(double factor) {
        double mineAmount = normalYeild*factor;
        if(mineAmount <= resource.amount) {
            resource.amount -= mineAmount;
            MainProgram.player.inventory.addResource(resource.name, mineAmount);
        } else {
            mineAmount = resource.amount;
            resource.amount = 0;
            MainProgram.player.inventory.addResource(resource.name, mineAmount);
        }
    }
    
    @Override
    public void checkDead() {
        if(health <= 0 || resource.amount <= 0) {
            isDead = true;
        } else {
            isDead = false;
        }
    }
}