import java.awt.*;
import javax.swing.*;
//import java.awt.event.*; //not used
import java.util.*;

public class MyPanel extends JPanel //implements KeyListener
{
    public static Graphics graphic;
    public static String printerSet = "";
    public static ArrayList<String[]> commands = new ArrayList<String[]>();
    public final static Color GREEN1 = new Color(0, 150, 0);
    public final static int SHOWSHOOT = 200; //millisecond
    public static ArrayList<Enemy> hitsP = new ArrayList<Enemy>();
    public static ArrayList<Enemy> hitsS = new ArrayList<Enemy>();
    
    public MyPanel()
    {
        super();
        setSize(1920, 1080);
    }
    
    public void paint(Graphics g)
    {
        //super.paint(g);
        graphic = g;
        if(MainProgram.myFrame.dMode == "main menu") {
            mainMenuDraw();
        }
        else if(MainProgram.myFrame.dMode == "singleplayer") {
            startDraw();
            drawPlayer();
            drawZombies();
            drawSpawners();
            drawTrees();
            drawRocks();
            drawShoot();
        } else if(MainProgram.myFrame.dMode == "player dead") {
            startDraw();
            drawPlayer();
            drawZombies();
            drawSpawners();
            drawPD();
        } else if(MainProgram.myFrame.dMode == "inventory") {
            inventoryDraw();
        }
        if(MainProgram.myFrame.dMode == "singleplayer" || MainProgram.myFrame.dMode == "inventory") {
            drawPlayerInfo();
        }
        debugDraw();
        //doCommands();
    }
    
    public void addCommand(String[] args) {
        commands.add(args);
    }
    
    public void doCommands() {
        for(int i = 0; i < commands.size(); i++) {
            String command = commands.get(i)[0];
            if(command == "setColor") {
                if(commands.get(i)[1] == "blue") {
                    graphic.setColor(Color.BLUE);
                }
                int r = Integer.parseInt(commands.get(i)[1]);
                int g = Integer.parseInt(commands.get(i)[2]);
                int b = Integer.parseInt(commands.get(i)[3]);
                graphic.setColor(new Color(r, g, b));
            } else if(command == "ellipse") {
                int x1 = Integer.parseInt(commands.get(i)[1]);
                int y1 = Integer.parseInt(commands.get(i)[2]);
                int width = Integer.parseInt(commands.get(i)[3]);
                int height = Integer.parseInt(commands.get(i)[4]);
                ellipse(x1, y1, width, height);
            }
        }
    }
    
    public void blacker() {
        graphic.setColor(Color.BLACK);
        filledRectangle(0, 0, 1920, 1080);
    }
    
    public static void line(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);
    }
    public static void rectangle(int x, int y, int width, int height)
    {
        graphic.drawRect(x, y, width, height);
    }
    public static void filledRectangle(int x, int y, int width, int height)
    {
        graphic.fillRect(x, y, width, height);
    }
    public static void ellipse(int x, int y, int width, int height)
    {
        graphic.drawOval(x, y, width, height);
    }
    public static void filledEllipse(int x, int y, int width, int height)
    {
        graphic.fillOval(x, y, width, height);
    }
    public static void triangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        int xPoints[] = {x1, x2, x3};
        int yPoints[] = {y1, y2, y3};
        graphic.drawPolygon(xPoints, yPoints, 3);
    }
    public static void filledTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        int xPoints[] = {x1, x2, x3};
        int yPoints[] = {y1, y2, y3};
        graphic.fillPolygon(xPoints, yPoints, 3);
    }
    public static void polygon(int[] xPoints, int[] yPoints, int nPoints)
    {
        graphic.drawPolygon(xPoints, yPoints, nPoints);
    }
    public static void filledPolygon(int[] xPoints, int[] yPoints, int nPoints)
    {
        graphic.fillPolygon(xPoints, yPoints, nPoints);
    }
    public static void makeText(String text, int x, int y)
    {
        graphic.drawString(text, x, y);
    }
    
    public void debugDraw() {
        graphic.setFont(new Font("debug1", 0, 20));
        graphic.setColor(Color.BLACK);
        makeText("" + MainProgram.tick, 1800, 980);
        makeText("" + MainProgram.zombies.size(), 1800, 1000);
        makeText("" + MainProgram.player.getHealth(), 1800, 1020);
    }
    
    public void drawPD() {
        graphic.setFont(new Font("mainMenu1", 0, 50));
        graphic.setColor(Color.BLACK);
        makeText("You died ya goof", 500, 400);
    }
    
    public void mainMenuDraw() {
        graphic.setColor(new Color(0, 0, 150));
        filledRectangle(0, 0, 1920, 1080);
        graphic.setFont(new Font("mainMenu1", 0, 50));
        double x = MainProgram.myFrame.getMX();
        double y = MainProgram.myFrame.getMY();
        if(x > 100 && x < 500 && y > 100 && y < 250) {
            graphic.setColor(Color.RED);
        } else {
            graphic.setColor(Color.BLACK);
        }
        rectangle(100, 100, 400, 150);
        makeText("SINGLEPLAYER", 110, 200);
        if(x > 100 && x < 500 && y > 300 && y < 450) {
            graphic.setColor(Color.RED);
        } else {
            graphic.setColor(Color.BLACK);
        }
        rectangle(100, 300, 400, 150);
        makeText("SETTINGS", 170, 400);
    }
    
    public void inventoryDraw() {
        graphic.setColor(new Color(175, 175, 175));
        filledRectangle(0, 0, 1920, 1080);
        graphic.setColor(Color.BLACK);
        /*for(int i = -10000; i <= 10000; i += 50)
        {
            line(i + (MainProgram.player.displayPosX - (int)MainProgram.player.positionX), 0, i + (MainProgram.player.displayPosX - (int)MainProgram.player.positionX), 10000);
            line(0, i + (MainProgram.player.displayPosY - (int)MainProgram.player.positionY), 10000, i + (MainProgram.player.displayPosY - (int)MainProgram.player.positionY));
        }*/
        graphic.setColor(Color.BLACK);
        ellipse(0, 0, 50, 50);
        line(25, 50, 25, 150);
        line(25, 150, 0, 250);
        line(25, 150, 50, 250);
        line(0, 75, 50, 75);
        graphic.setColor(Color.WHITE);
        filledEllipse(5, 15, 15, 15);
        filledEllipse(30, 15, 15, 15);
        graphic.setFont(new Font("Inventory", 0, 15));
        makeText("Head: " + MainProgram.player.getInventory().getArmorHead().getName(), 60, 20);
        makeText("Hands: " + MainProgram.player.getInventory().getArmorHands().getName(), 60, 75);
        makeText("Chest: " + MainProgram.player.getInventory().getArmorChest().getName(), 60, 125);
        makeText("Legs: " + MainProgram.player.getInventory().getArmorLegs().getName(), 60, 175);
        makeText("Feet: " + MainProgram.player.getInventory().getArmorFeet().getName(), 60, 250);
        
        makeText("Wood: " + MainProgram.player.getInventory().getWood().amount, 950, 400);
        makeText("Stone: " + MainProgram.player.getInventory().getStone().amount, 950, 450);
        makeText("Zombie parts: " + MainProgram.player.getInventory().getzParts().amount, 950, 500);
    }
    
    public void drawPlayerInfo() {
        graphic.setColor(new Color(100, 100, 100));
        filledRectangle(898, 98, 104, 24);
        graphic.setColor(Color.BLACK);
        filledRectangle(900, 100, 100, 20);
        graphic.setColor(Color.RED);
        int terval = (int)(MainProgram.player.getDefaultHealth() / 100);
        filledRectangle(900,100, (int)(MainProgram.player.getHealth() / terval), 20);
        
        graphic.setColor(Color.RED);
        graphic.setFont(new Font("WeaponInfo", 0, 15));
        if(MainProgram.player.useMode == "Gun") {
            graphic.setColor(Color.BLUE);
        } else {
            graphic.setColor(Color.RED);
        }
        makeText("Primary Weapon: " + MainProgram.player.getInventory().getGunPrimary().getName(), 1700, 900);
        makeText("Secondary Weapon: " + MainProgram.player.getInventory().getGunSecondary().getName(), 1700, 950);
        if(MainProgram.player.useMode == "Tool") {
            graphic.setColor(Color.BLUE);
        } else {
            graphic.setColor(Color.RED);
        }
        makeText("Primary Tool: " + MainProgram.player.getInventory().getToolPrimary().getName(), 10, 900);
        makeText("Secondary Tool: " + MainProgram.player.getInventory().getToolSecondary().getName(), 10, 950);
    }
    
    public void startDraw()
    {
        graphic.setColor(GREEN1);
        filledRectangle(0, 0, 1920, 1080);
        graphic.setColor(Color.BLACK);
        for(int i = -10000; i <= 10000; i += 50)
        {
            line(i + (MainProgram.player.getDisplayPosX() - (int) MainProgram.player.getPositionX()), 0, i + (MainProgram.player.getDisplayPosX() - (int) MainProgram.player.getPositionX()), 10000);
            line(0, i + (MainProgram.player.getDisplayPosY() - (int) MainProgram.player.getPositionY()), 10000, i + (MainProgram.player.getDisplayPosY() - (int) MainProgram.player.getPositionY()));
        }
        //filledEllipse(475,475, 50, 50);
    }
    
    public static void drawPlayer()
    {
        if(!MainProgram.player.isDead()) {
            graphic.setColor(Color.WHITE);
            if(MainProgram.player.isDead())
                graphic.setColor(Color.RED);
            filledEllipse(MainProgram.player.getDisplayX()-15, MainProgram.player.getDisplayY()-15, 30, 30);
            graphic.setColor(Color.BLUE);
            filledEllipse(MainProgram.player.getDisplayX()-14, MainProgram.player.getDisplayY()-14, 28, 28);
            graphic.setColor(Color.BLACK);
            /*if(MainProgram.player.getDirection() <= 90)
                line(MainProgram.player.getDisplayX(), MainProgram.player.getDisplayY(), MainProgram.player.getDisplayX() + (int)MainProgram.player.getDirection(), MainProgram.player.getDisplayY() - (90 - (int)MainProgram.player.getDirection()));
            else if(MainProgram.player.getDirection() <= 180)
                line(MainProgram.player.getDisplayX(), MainProgram.player.getDisplayY(), MainProgram.player.getDisplayX() + (180 - (int)MainProgram.player.getDirection()), MainProgram.player.getDisplayY() + ((int)MainProgram.player.getDirection() - 90));
            else if(MainProgram.player.getDirection() <= 270)
                line(MainProgram.player.getDisplayX(), MainProgram.player.getDisplayY(), MainProgram.player.getDisplayX() - ((int)MainProgram.player.getDirection() - 180), MainProgram.player.getDisplayY() + (270 - (int)MainProgram.player.getDirection()));
            else if(MainProgram.player.getDirection() <= 360)
                line(MainProgram.player.getDisplayX(), MainProgram.player.getDisplayY(), MainProgram.player.getDisplayX() - (360 - (int)MainProgram.player.getDirection()), MainProgram.player.getDisplayY() - ((int)MainProgram.player.getDirection() - 270));*/
            double finalX = MainProgram.player.getDisplayPosX();
            double finalY = MainProgram.player.getDisplayPosY();
            while(finalX > 0 && finalX < 1920 && finalY > 0 && finalY < 1080) {
                if(MainProgram.player.getsDirect() == "up") {
                    finalY--;
                } else if(MainProgram.player.getsDirect() == "down"){
                    finalY++;
                } else if(MainProgram.player.getsDirect() == "right") {
                    finalX++;
                    finalY -= MainProgram.player.getDirection();
                } else {
                    finalX--;
                    finalY += MainProgram.player.getDirection();
                }
            }
            line(MainProgram.player.getDisplayPosX(), MainProgram.player.getDisplayPosY(), (int)finalX, (int)finalY);
        }
    }
    public static void drawZombies()
    {
        for(Zombie z : MainProgram.zombies) {
            if(!z.isDead())
            {
                graphic.setColor(Color.WHITE);
                filledEllipse(z.getDisplayX()-10, z.getDisplayY()-10, 20, 20);
                graphic.setColor(Color.RED);
                filledEllipse(z.getDisplayX()-9, z.getDisplayY()-9, 18, 18);
            } else {
                graphic.setColor(Color.RED);
                filledEllipse(z.getDisplayX()-10, z.getDisplayY()-10, 20, 20);
            }
        }
    }
    
    public void drawSpawners() {
        for(ZombieSpawner zs : MainProgram.zombieSpawners) {
            graphic.setColor(Color.BLACK);
            filledEllipse(zs.getDisplayPosX() -10, zs.getDisplayPosY() -10, 20, 20);
        }
    }
    
    public void drawTrees() {
        for(Tree t : MainProgram.trees) {
            graphic.setColor(Color.BLACK);
            filledEllipse(t.getDisplayPosX() -10, t.getDisplayPosY() -10, 20, 20);
            graphic.setColor(Color.CYAN);
            filledEllipse(t.getDisplayPosX() -9, t.getDisplayPosY() -9, 18, 18);
        }
    }
    
    public void drawRocks() {
        for(Rock r : MainProgram.rocks) {
            graphic.setColor(Color.BLACK);
            filledEllipse(r.getDisplayPosX() -10, r.getDisplayPosY() -10, 20, 20);
            graphic.setColor(Color.GRAY);
            filledEllipse(r.getDisplayPosX() -9, r.getDisplayPosY() -9, 18, 18);
        }
    }
    
    public void drawShoot() {
        if(MainProgram.player.getInventory().getGunBody().getTickFired() + (SHOWSHOOT/MainProgram.tickSpeed) >= MainProgram.tick) {
            graphic.setColor(new Color(250, 0, 200));
            filledEllipse(MainProgram.player.getDisplayPosX() - 50, MainProgram.player.getDisplayPosY() - 50, 100, 100);
        }
        if(MainProgram.player.getInventory().getGunPrimary().getTickFired() + (SHOWSHOOT/MainProgram.tickSpeed) >= MainProgram.tick) {
            graphic.setColor(new Color(125, 50, 255));
            for(Enemy e : hitsP) {
                filledEllipse(e.getDisplayPosX() -15, e.getDisplayPosY() -15, 30, 30);
                line(MainProgram.player.getDisplayPosX(), MainProgram.player.getDisplayPosY(), e.getDisplayPosX(), e.getDisplayPosY());
            }
        } else {
            hitsP.clear();
        }
        if(MainProgram.player.getInventory().getGunSecondary().getTickFired() + (SHOWSHOOT/MainProgram.tickSpeed) >= MainProgram.tick) {
            graphic.setColor(new Color(0, 50, 255));
            for(Enemy e : hitsS) {
                filledEllipse(e.getDisplayPosX() -15, e.getDisplayPosY() -15, 30, 30);
                line(MainProgram.player.getDisplayPosX(), MainProgram.player.getDisplayPosY(), e.getDisplayPosX(), e.getDisplayPosY());
            }
        } else {
            hitsS.clear();
        }
    }

}