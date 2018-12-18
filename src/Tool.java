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
                if(Math.sqrt((mY - t.getDisplayPosY()) * (mY - t.getDisplayPosY()) + (mX - t.getDisplayPosX()) * (mX - t.getDisplayPosX())) < 10) {
                    t.mine(mineFactor);
                    isDone = true;
                }
            }
        } else if(useType == "Stone") {
            for(Rock r : MainProgram.rocks) {
                if(isDone) {
                    break;
                }
                if(Math.sqrt((mY - r.getDisplayPosY()) * (mY - r.getDisplayPosY()) + (mX - r.getDisplayPosX()) * (mX - r.getDisplayPosX())) < 10) {
                    r.mine(mineFactor);
                    isDone = true;
                }
            }
        } else if(useType == "All") {
            for(Tree t : MainProgram.trees) {
                if(isDone) {
                    break;
                }
                if(Math.sqrt((mY - t.getDisplayPosY()) * (mY - t.getDisplayPosY()) + (mX - t.getDisplayPosX()) * (mX - t.getDisplayPosX())) < 10) {
                    t.mine(mineFactor);
                    isDone = true;
                }
            }
            for(Rock r : MainProgram.rocks) {
                if(isDone) {
                    break;
                }
                if(Math.sqrt((mY - r.getDisplayPosY()) * (mY - r.getDisplayPosY()) + (mX - r.getDisplayPosX()) * (mX - r.getDisplayPosX())) < 10) {
                    r.mine(mineFactor);
                    isDone = true;
                }
            }
        }
    }
}