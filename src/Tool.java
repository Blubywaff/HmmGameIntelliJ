public class Tool extends Item{
    public String useType = "";
    public double mineFactor = 0;
    public void use() {
    }
    
    public void use(double mX, double mY) {
        if(useType == "Wood") {
            for(Tree t : MainProgram.trees) {
                if(Math.sqrt((mY - t.displayPosY) * (mY - t.displayPosY) + (mX - t.displayPosX) * (mX - t.displayPosX)) < 10) {
                    t.mine(mineFactor);
                }
            }
        } else if(useType == "Stone") {
            for(Rock r : MainProgram.rocks) {
                if(Math.sqrt((mY - r.displayPosY) * (mY - r.displayPosY) + (mX - r.displayPosX) * (mX - r.displayPosX)) < 10) {
                    r.mine(mineFactor);
                }
            }
        }
    }
}