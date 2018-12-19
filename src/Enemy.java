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
        setDrops(new ZombieParts((int)(Math.random()*5+3)));
    }
    
    public Enemy(double posX, double posY) {
        super(posX, posY);
        randX = getPositionX() + Math.random()*400-200;
        randY = getPositionY() + Math.random()*400-200;
        isRandMove = true;
    }
    
    public void enemyInit() {
        
    }
    
    public void playerCheck()
    {
        if(!isDead()) {
            if(MainProgram.tick >= tickDamage + 10) {
                if(Math.sqrt((this.getPositionX() - MainProgram.player.getPositionX())*(this.getPositionX() - MainProgram.player.getPositionX())+(this.getPositionY() - MainProgram.player.getPositionY())*(this.getPositionY() - MainProgram.player.getPositionY())) <= 10) {
                    MainProgram.player.damage(getDamage());
                    tickDamage = MainProgram.tick;
                }
            }
        }
    }
    
    public void aiMove() {
        ArrayList<String> moveTPArrs = new ArrayList<String>();
        if(isDead());
        else if(isRandMove) {
            if(randX < getPositionX() && randY < getPositionY()) {
                moveTPArrs.add("up");
                moveTPArrs.add("left");
                move(moveTPArrs);
            } else if(randX < getPositionX() && randY > getPositionY()) {
                moveTPArrs.add("down");
                moveTPArrs.add("left");
                move(moveTPArrs);
            } else if(randX > getPositionX() && randY < getPositionY()) {
                moveTPArrs.add("up");
                moveTPArrs.add("right");
                move(moveTPArrs);
            } else if(randX > getPositionX() && randY > getPositionY()) {
                moveTPArrs.add("down");
                moveTPArrs.add("right");
                move(moveTPArrs);
            }
            if(Math.sqrt((randY - getPositionY()) * (randY - getPositionY()) + (randX - getPositionX()) * (randX - getPositionX())) < 10 || Math.sqrt((MainProgram.player.getPositionY() - getPositionY()) * (MainProgram.player.getPositionY() - getPositionY()) + (MainProgram.player.getPositionX() - getPositionX()) * (MainProgram.player.getPositionX() - getPositionX())) < 300) {
                isRandMove = false;
            }
        } else if(true) {
            if(Math.sqrt((MainProgram.player.getPositionY() - getPositionY()) * (MainProgram.player.getPositionY() - getPositionY()) + (MainProgram.player.getPositionX() - getPositionX()) * (MainProgram.player.getPositionX() - getPositionX())) < 300) {
                if(MainProgram.player.getPositionX() < getPositionX() && MainProgram.player.getPositionY() < getPositionY()) {
                    moveTPArrs.add("up");
                    moveTPArrs.add("left");
                    move(moveTPArrs);
                } else if(MainProgram.player.getPositionX() < getPositionX() && MainProgram.player.getPositionY() > getPositionY()) {
                    moveTPArrs.add("down");
                    moveTPArrs.add("left");
                    move(moveTPArrs);
                } else if(MainProgram.player.getPositionX() > getPositionX() && MainProgram.player.getPositionY() < getPositionY()) {
                    moveTPArrs.add("up");
                    moveTPArrs.add("right");
                    move(moveTPArrs);
                } else if(MainProgram.player.getPositionX() > getPositionX() && MainProgram.player.getPositionY() > getPositionY()) {
                    moveTPArrs.add("down");
                    moveTPArrs.add("right");
                    move(moveTPArrs);
                }
            }
        }//level one ai
        /* else if(true) {
            
        }*///level two ai
    }
}