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
        removeDeads();
        constSpawn();
        fixZombies();
        fixZombieDisplay();
        fixSpawnerDisplay();
        fixEnvironmentDisplay();
        fixPlayerTakingDamage();
        fixRegen();
        fixTurretDisplay();
        checkAMs();
        checkPD();
        MainProgram.myFrame.panelRefresh();
        MainProgram.myFrame.fixPlayerDirection();
        MainProgram.player.checkBuffs();
    }
    
    public static void fixRegen() {
        MainProgram.player.regen();
    }
    
    public static void fixTurretDisplay() {
        for(Turret t : MainProgram.turrets) {
            t.fixDisplayCoords();
        }
    }

    public static void checkAMs() {
        for(ArmorModule am : MainProgram.player.getInventory().getArmorModules()) {
            am.doStuff();
        }
    }

    public static void fixZombies() {
        for(Zombie z : MainProgram.zombies) {
            z.aiMove();
        }
    }
    public static void fixZombieDisplay() {
        for(Zombie z : MainProgram.zombies) {
            z.fixDisplayCoords();
        }
    }
    public static void fixSpawnerDisplay() {
        for(ZombieSpawner zs : MainProgram.zombieSpawners) {
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
        for(Zombie z : MainProgram.zombies) {
            z.playerCheck();
        }
    }
    public static void removeDeads() {
        ArrayList<Zombie> zRemoves = new ArrayList<>();
        for(Zombie z : MainProgram.zombies) {
            z.checkDead();
            if(MainProgram.tick >= z.getDeathTick() + 500/MainProgram.tickSpeed && z.isDead() && z.getDeathTick() != -1) {
                zRemoves.add(z);
            }
        }
        for(Zombie z : zRemoves) {
            MainProgram.zombies.remove(z);
        }

        ArrayList<ZombieSpawner> zsRemoves = new ArrayList<>();
        for(ZombieSpawner zs : MainProgram.zombieSpawners) {
            zs.checkDead();
            if(MainProgram.tick >= zs.getDeathTick() + 500/MainProgram.tickSpeed && zs.isDead() && zs.getDeathTick() != -1) {
                zsRemoves.add(zs);
            }
        }
        for(ZombieSpawner zs : zsRemoves) {
            MainProgram.zombieSpawners.remove(zs);
        }

        ArrayList<Tree> tRemoves = new ArrayList<>();
        for(Tree t : MainProgram.trees) {
            t.checkDead();
            if(t.isDead()) {
                tRemoves.add(t);
            }
        }
        for(Tree t : tRemoves) {
            MainProgram.trees.remove(t);
        }
        
        ArrayList<Rock> rRemoves = new ArrayList<>();
        for(Rock r : MainProgram.rocks) {
            r.checkDead();
            if(r.isDead()) {
                rRemoves.add(r);
            }
        }
        for(Rock r : rRemoves) {
            MainProgram.rocks.remove(r);
        }
    }
    public static Zombie spawnNewZombie() {
        Zombie zombie = new Zombie();
        zombie.setPositionX(Math.random()*(MainProgram.player.getPositionX() +1000) + (MainProgram.player.getPositionX() -1000));
        zombie.setPositionY(Math.random()*(MainProgram.player.getPositionY() +1000) + (MainProgram.player.getPositionY() -1000));
        return zombie;
    }
    public static void constSpawn() {
        for(ZombieSpawner zs : MainProgram.zombieSpawners) {
            zs.spawn();
        }
    }
    public static void checkPD() {
        MainProgram.player.checkDead();
        if(MainProgram.player.isDead()) {
            MainProgram.myFrame.dMode = "player dead";
        }
    }
    public static void entityCap() {
        ArrayList<Zombie> olds = new ArrayList<>();
        int numRemoved = 0;
        if(MainProgram.zombies.size() > 100) {
            for(Zombie z : MainProgram.zombies) {
                if(numRemoved < MainProgram.zombies.size() - 100) {
                    if(MainProgram.tick > z.getSpawnTick() + 1000) {
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