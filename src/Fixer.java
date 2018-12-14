//import javax.swing.*; // not used
//import java.awt.*; //not used
//import java.awt.event.*; //not used
import java.util.*;
public class Fixer
{
    static int i;
    static int tickMove = 0;
    static int tickSpawn = 0;
    static int constSpawnTick = 0;
    public static void setter()
    {
    }
    public static void fixAll()
    {
        //fixDeads();
        removeDeads();
        constSpawn();
        fixZombies();
        fixZombieDisplay();
        fixSpawnerDisplay();
        fixEnvironmentDisplay();
        fixPlayerTakingDamage();
        checkPD();
        MainProgram.myFrame.panelRefresh();
        MainProgram.myFrame.fixPlayerDirection();
    }
    public static void fixZombies() {
        /*if(MainProgram.tick > tickMove + 3) { 
            for(int i = 0; i < MainProgram.zombieNum; i++) {
                MainProgram.zombies[i].aiMove();
            }
            tickMove = MainProgram.tick;
        }*///zombo
        //if(MainProgram.tick > tickMove + 3) {
            for(Zombie z : MainProgram.zombies) {
                z.aiMove();
            }
            //tickMove = MainProgram.tick;
        //}
    }
    public static void fixZombieDisplay()
    {
            /*MainProgram.zombies[i].displayPosX += MainProgram.player.getChangeX();
            MainProgram.zombies[i].displayPosY += MainProgram.player.getChangeY();
            System.out.println(MainProgram.zombies[i].displayPosX + " - " + MainProgram.zombies[i].displayPosY);*/
        /*if(arrows.contains("up"))
            arrowsZ.add("down");
        if(arrows.contains("right"))
            arrowsZ.add("left");
        if(arrows.contains("down"))
            arrowsZ.add("up");
        if(arrows.contains("left"))
            arrowsZ.add("right");
        for(int i = 0; i < MainProgram.zombieNum; i++) {
            MainProgram.zombies[i].displayMove(arrowsZ);
        }*/
        /*for(int i = 0; i < MainProgram.zombieNum; i++) {
            MainProgram.zombies[i].displayPosX = (int)MainProgram.zombies[i].positionX + MainProgram.player.displayPosX - (int)MainProgram.player.positionX;
            MainProgram.zombies[i].displayPosY = (int)MainProgram.zombies[i].positionY + MainProgram.player.displayPosY - (int)MainProgram.player.positionY;
        }*///zombo
        for(Zombie z : MainProgram.zombies) {
            /* 
            z.displayPosX = (int)z.positionX + MainProgram.player.displayPosX - (int)MainProgram.player.positionX;
            z.displayPosY = (int)z.positionY + MainProgram.player.displayPosY - (int)MainProgram.player.positionY;
            */
            z.fixDisplayCoords();
        }
    }
    public static void fixSpawnerDisplay() {
        for(ZombieSpawner zs : MainProgram.zombieSpawners) {
            /*
            zs.displayPosX = (int)zs.positionX + MainProgram.player.displayPosX - (int)MainProgram.player.positionX;
            zs.displayPosY = (int)zs.positionY + MainProgram.player.displayPosY - (int)MainProgram.player.positionY;
            */
            zs.fixDisplayCoords();
        }
    }
    public static void fixEnvironmentDisplay() {
        for(Tree t : MainProgram.trees) {
            t.fixDisplayCoords();
        }
        for(Rock r : MainProgram.rocks) {
            r.fixDisplayCoords();
        }
    }
    public static void fixPlayerTakingDamage()
    {
        /*for(i = 0; i < MainProgram.zombieNum; i++)
        {
            MainProgram.zombies[i].playerCheck();
        }*///zombo
        for(Zombie z : MainProgram.zombies) {
            z.playerCheck();
        }
    }
    public static void removeDeads() {
        ArrayList<Zombie> zRemoves = new ArrayList<Zombie>();
        for(Zombie z : MainProgram.zombies) {
            z.checkDead();
            if(MainProgram.tick >= z.deathTick + 500 && z.isDead && z.deathTick != -1) {
                zRemoves.add(z);
            }
        }
        for(Zombie z : zRemoves) {
            MainProgram.zombies.remove(z);
        }
        
        ArrayList<Tree> tRemoves = new ArrayList<Tree>();
        for(Tree t : MainProgram.trees) {
            t.checkDead();
            if(t.isDead) {
                tRemoves.add(t);
            }
        }
        for(Tree t : tRemoves) {
            MainProgram.trees.remove(t);
        }
        
        ArrayList<Rock> rRemoves = new ArrayList<Rock>();
        for(Rock r : MainProgram.rocks) {
            r.checkDead();
            if(r.isDead) {
                rRemoves.add(r);
            }
        }
        for(Rock r : rRemoves) {
            MainProgram.rocks.remove(r);
        }
    }
    public static void fixDeads()
    {
        /*for(int i = 0; i < MainProgram.zombieNum; i++) {
            MainProgram.zombies[i].checkDead();
            if(MainProgram.zombies[i].isDead) {
                MainProgram.zombies[i] = spawnNewZombie();
            }
        }*///zombo
        ArrayList<Zombie> removes = new ArrayList<Zombie>();
        int numAdd = 0;
        for(Zombie z : MainProgram.zombies) {
            z.checkDead();
            if(z.isDead && MainProgram.tick >= tickSpawn + 50) {
                removes.add(z);
                numAdd++;
                tickSpawn = MainProgram.tick;
                System.out.println("spawn");
            }
        }
        for(Zombie z : removes) {
            MainProgram.zombies.remove(z);
        }
        for(int i = 0; i < numAdd; i++) {
            MainProgram.zombies.add(spawnNewZombie());
        }
        MainProgram.player.checkDead();
    }
    public static Zombie spawnNewZombie() {
        Zombie zombie = new Zombie();
        zombie.positionX = Math.random()*(MainProgram.player.positionX+1000) + (MainProgram.player.positionX-1000);
        zombie.positionY = Math.random()*(MainProgram.player.positionY+1000) + (MainProgram.player.positionY-1000);
        //zombie.fixDisplayCoords();
        return zombie;
    }
    public static void constSpawn() {
        /*if(MainProgram.tick >= constSpawnTick + 50) {
            Zombie zombie = new Zombie();
            zombie.positionX = Math.random()*(MainProgram.player.positionX+1000) + (MainProgram.player.positionX-1000);
            zombie.positionY = Math.random()*(MainProgram.player.positionY+1000) + (MainProgram.player.positionY-1000);
            zombie.fixDisplayCoords();
            MainProgram.zombies.add(zombie);
            constSpawnTick = MainProgram.tick;
        }*/
        for(ZombieSpawner zs : MainProgram.zombieSpawners) {
            zs.spawn();
        }
    }
    public static void checkPD() {
        MainProgram.player.checkDead();
        if(MainProgram.player.isDead) {
            MainProgram.myFrame.dMode = "player dead";
        }
    }
    public static void entityCap() {
        ArrayList<Zombie> olds = new ArrayList<Zombie>();
        int numRemoved = 0;
        if(MainProgram.zombies.size() > 100) {
            for(Zombie z : MainProgram.zombies) {
                if(numRemoved < MainProgram.zombies.size() - 100) {
                    if(MainProgram.tick > z.spawnTick + 1000) {
                        numRemoved++;
                        olds.add(z);
                    }
                }
            }
            for(Zombie z : olds) {
                MainProgram.zombies.remove(z);
            }
        }
    }
}