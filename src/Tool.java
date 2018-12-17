public class Tool extends Item{
    public String useType = "";
    public double mineFactor = 0;
    public void use() {
    }
    
    public void use(double mX, double mY) {
        boolean isDone = false;
        if(useType == "Wood") {
            for(Tree t : MainProgram.trees) {
                if(isDone) {
                    break;
                }
                if(Math.sqrt((mY - t.displayPosY) * (mY - t.displayPosY) + (mX - t.displayPosX) * (mX - t.displayPosX)) < 10) {
                    t.mine(mineFactor);
                    isDone = true;
                }
            }
        } else if(useType == "Stone") {
            for(Rock r : MainProgram.rocks) {
                if(isDone) {
                    break;
                }
                if(Math.sqrt((mY - r.displayPosY) * (mY - r.displayPosY) + (mX - r.displayPosX) * (mX - r.displayPosX)) < 10) {
                    r.mine(mineFactor);
                    isDone = true;
                }
            }
        } else if(useType == "All") {
            for(Tree t : MainProgram.trees) {
                if(isDone) {
                    break;
                }
                if(Math.sqrt((mY - t.displayPosY) * (mY - t.displayPosY) + (mX - t.displayPosX) * (mX - t.displayPosX)) < 10) {
                    t.mine(mineFactor);
                    isDone = true;
                }
            }
            for(Rock r : MainProgram.rocks) {
                if(isDone) {
                    break;
                }
                if(Math.sqrt((mY - r.displayPosY) * (mY - r.displayPosY) + (mX - r.displayPosX) * (mX - r.displayPosX)) < 10) {
                    r.mine(mineFactor);
                    isDone = true;
                }
            }
        }
    }
}