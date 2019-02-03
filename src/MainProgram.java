import javax.swing.*;
//import java.awt.*; //not used
import java.awt.event.*;
//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;

public class MainProgram {
    public static ArrayList<Zombie> zombies = new ArrayList<>();
    public static ArrayList<ZombieSpawner> zombieSpawners = new ArrayList<>();
    public static ArrayList<Tree> trees = new ArrayList<>();
    public static ArrayList<Rock> rocks = new ArrayList<>();
    public static ArrayList<Turret> turrets = new ArrayList<>();
    public static ArrayList<Building> buildings = new ArrayList<>();
    public static MyFrame myFrame;
    public static Player player;
    public static int tick = 0;
    public static final int tickSpeed = 20;
    public static  ArrayList<String> weaponsList = new ArrayList<>();
    public static ArrayList<String> rands = new ArrayList<>();
    public static ArrayList<String> dRands = new ArrayList<>();

    public static void main(String[] args)
    {
        init();

        Timer timer = new Timer(tickSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(myFrame.dMode == "singleplayer") {
                    Fixer.fixAll();
                    tick++;
                } else {
                    myFrame.panelRefresh();
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public static void init() {
        FileManager.init();
        player = new Player();
        for(int i = 0; i < 3; i++) {
            ZombieSpawner zombieSpawner = new ZombieSpawner();
            zombieSpawner.setPositionX(Math.random()*2000);
            zombieSpawner.setPositionY(Math.random()*1000);
            zombieSpawners.add(zombieSpawner);
        }
        for(int i = 0; i < 50; i++) {
            Tree t = new Tree();
            t.setPositionX(Math.random()*2000);
            t.setPositionY(Math.random()*1000);
            trees.add(t);
        }
        for(int i = 0; i < 50; i++) {
            Rock r = new Rock();
            r.setPositionX(Math.random()*2000);
            r.setPositionY(Math.random()*1000);
            rocks.add(r);
        }
        myFrame = new MyFrame("HMMMMMMMMMM");

        weaponsList = FileManager.listWeapons();
        for(String s : weaponsList) {
            rands.add(myFrame.p.genRand(FileManager.sDo(s, "displayName").length()));
            dRands.add(myFrame.p.genRand(FileManager.sDo(s, "description").length()));
        }

    }
}