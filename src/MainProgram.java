import javax.swing.*;
//import java.awt.*; //not used
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class MainProgram {
    public static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    public static ArrayList<ZombieSpawner> zombieSpawners = new ArrayList<ZombieSpawner>();
    public static ArrayList<Tree> trees = new ArrayList<Tree>();
    public static ArrayList<Rock> rocks = new ArrayList<Rock>();
    public static MyFrame myFrame;
    public static Player player;
    public static int tick = 0;
    public static final int tickSpeed = 20;
    public static void main(String[] args)
    {
        player = new Player();
        for(int i = 0; i < 3; i++) {
            ZombieSpawner zombieSpawner = new ZombieSpawner();
            zombieSpawner.positionX = Math.random()*2000;
            zombieSpawner.positionY = Math.random()*1000;
            zombieSpawners.add(zombieSpawner);
        }
        for(int i = 0; i < 25; i++) {
            Tree t = new Tree();
            t.positionX = Math.random()*2000;
            t.positionY = Math.random()*1000;
            trees.add(t);
            //System.out.println(t.positionX + " - " + t.positionY);
        }
        for(int i = 0; i < 25; i++) {
            Rock r = new Rock();
            r.positionX = Math.random()*2000;
            r.positionY = Math.random()*1000;
            rocks.add(r);
        }
        
        myFrame = new MyFrame("HMMMMMMMMMM");
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
}