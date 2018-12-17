import java.util.ArrayList;
public class Enemy extends Entity
{
    int tickDamage = 0;
    boolean isRandMove = true;
    double randX = Math.random()*400-200;
    double randY = Math.random()*400-200;
    
    public Enemy() {
        super();
        isRandMove = false;
        drops = new ZombieParts((int)(Math.random()*5+3));
    }
    
    public Enemy(double posX, double posY) {
        super(posX, posY);
        randX = positionX + Math.random()*400-200;
        randY = positionY + Math.random()*400-200;
        isRandMove = true;
    }
    
    public void enemyInit() {
        
    }
    
    public void playerCheck()
    {
        if(!isDead) {
            if(MainProgram.tick >= tickDamage + 10) {
                if(Math.sqrt((this.positionX-MainProgram.player.positionX)*(this.positionX-MainProgram.player.positionX)+(this.positionY-MainProgram.player.positionY)*(this.positionY-MainProgram.player.positionY)) <= 10) {
                    MainProgram.player.damage(damage);
                    tickDamage = MainProgram.tick;
                }
            }
        }
    }
    
    /*public void randMove() {
        double moveX = Math.random()*400-200;
        double moveY = Math.random()*400-200;
        positionX += moveX;
        positionY += moveY;
    }*/
    
    public void aiMove() {
        ArrayList<String> moveTPArrs = new ArrayList<String>();
        if(isDead);
        else if(isRandMove) {
            if(randX < positionX && randY < positionY) {
                moveTPArrs.add("up");
                moveTPArrs.add("left");
                move(moveTPArrs);
            } else if(randX < positionX && randY > positionY) {
                moveTPArrs.add("down");
                moveTPArrs.add("left");
                move(moveTPArrs);
            } else if(randX > positionX && randY < positionY) {
                moveTPArrs.add("up");
                moveTPArrs.add("right");
                move(moveTPArrs);
            } else if(randX > positionX && randY > positionY) {
                moveTPArrs.add("down");
                moveTPArrs.add("right");
                move(moveTPArrs);
            }
            if(Math.sqrt((randY - positionY) * (randY - positionY) + (randX - positionX) * (randX - positionX)) < 10 || Math.sqrt((MainProgram.player.positionY - positionY) * (MainProgram.player.positionY - positionY) + (MainProgram.player.positionX - positionX) * (MainProgram.player.positionX - positionX)) < 300) {
                isRandMove = false;
            }
        } else if(true) {
            if(Math.sqrt((MainProgram.player.positionY - positionY) * (MainProgram.player.positionY - positionY) + (MainProgram.player.positionX - positionX) * (MainProgram.player.positionX - positionX)) < 300) {
                if(MainProgram.player.positionX < positionX && MainProgram.player.positionY < positionY) {
                    moveTPArrs.add("up");
                    moveTPArrs.add("left");
                    move(moveTPArrs);
                } else if(MainProgram.player.positionX < positionX && MainProgram.player.positionY > positionY) {
                    moveTPArrs.add("down");
                    moveTPArrs.add("left");
                    move(moveTPArrs);
                } else if(MainProgram.player.positionX > positionX && MainProgram.player.positionY < positionY) {
                    moveTPArrs.add("up");
                    moveTPArrs.add("right");
                    move(moveTPArrs);
                } else if(MainProgram.player.positionX > positionX && MainProgram.player.positionY > positionY) {
                    moveTPArrs.add("down");
                    moveTPArrs.add("right");
                    move(moveTPArrs);
                }
            }
        }//level one ai
        /*if(!isDead) {
            
        }*///level two ai
    }
}