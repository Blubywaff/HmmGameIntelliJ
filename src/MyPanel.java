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
    public static Zombie z = new Zombie();
    
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
        makeText("" + MainProgram.player.health, 1800, 1020);
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
        makeText("Head: " + MainProgram.player.inventory.armorHead.name, 60, 20);
        makeText("Hands: " + MainProgram.player.inventory.armorHands.name, 60, 75);
        makeText("Chest: " + MainProgram.player.inventory.armorChest.name, 60, 125);
        makeText("Legs: " + MainProgram.player.inventory.armorLegs.name, 60, 175);
        makeText("Feet: " + MainProgram.player.inventory.armorFeet.name, 60, 250);
        
        makeText("Wood: " + MainProgram.player.inventory.wood.amount, 950, 400);
        makeText("Stone: " + MainProgram.player.inventory.stone.amount, 950, 450);
        makeText("Zombie parts: " + MainProgram.player.inventory.zParts.amount, 950, 500);
    }
    
    public void drawPlayerInfo() {
        graphic.setColor(new Color(100, 100, 100));
        filledRectangle(898, 98, 104, 24);
        graphic.setColor(Color.BLACK);
        filledRectangle(900, 100, 100, 20);
        graphic.setColor(Color.RED);
        int terval = (int)(MainProgram.player.defaultHealth / 100);
        filledRectangle(900,100, (int)(MainProgram.player.health / terval), 20);
        
        graphic.setColor(Color.RED);
        graphic.setFont(new Font("WeaponInfo", 0, 15));
        if(MainProgram.player.useMode == "Gun") {
            graphic.setColor(Color.BLUE);
        } else {
            graphic.setColor(Color.RED);
        }
        makeText("Primary Weapon: " + MainProgram.player.inventory.gunPrimary.name, 1700, 900);
        makeText("Secondary Weapon: " + MainProgram.player.inventory.gunSecondary.name, 1700, 950);
        if(MainProgram.player.useMode == "Tool") {
            graphic.setColor(Color.BLUE);
        } else {
            graphic.setColor(Color.RED);
        }
        makeText("Primary Tool: " + MainProgram.player.inventory.toolPrimary.name, 10, 900);
        makeText("Secondary Tool: " + MainProgram.player.inventory.toolSecondary.name, 10, 950);
    }
    
    public void startDraw()
    {
        graphic.setColor(GREEN1);
        filledRectangle(0, 0, 1920, 1080);
        graphic.setColor(Color.BLACK);
        for(int i = -10000; i <= 10000; i += 50)
        {
            line(i + (MainProgram.player.displayPosX - (int)MainProgram.player.positionX), 0, i + (MainProgram.player.displayPosX - (int)MainProgram.player.positionX), 10000);
            line(0, i + (MainProgram.player.displayPosY - (int)MainProgram.player.positionY), 10000, i + (MainProgram.player.displayPosY - (int)MainProgram.player.positionY));
        }
        //filledEllipse(475,475, 50, 50);
    }
    
    public static void drawPlayer()
    {
        if(!MainProgram.player.isDead) {
            graphic.setColor(Color.WHITE);
            if(MainProgram.player.isDead)
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
            double finalX = MainProgram.player.displayPosX;
            double finalY = MainProgram.player.displayPosY;
            while(finalX > 0 && finalX < 1920 && finalY > 0 && finalY < 1080) {
                if(MainProgram.player.sDirect == "up") {
                    finalY--;
                } else if(MainProgram.player.sDirect == "down"){
                    finalY++;
                } else if(MainProgram.player.sDirect == "right") {
                    finalX++;
                    finalY -= MainProgram.player.direction;
                } else {
                    finalX--;
                    finalY += MainProgram.player.direction;
                }
            }
            line(MainProgram.player.displayPosX, MainProgram.player.displayPosY, (int)finalX, (int)finalY);
        }
    }
    public static void drawZombies()
    {
        /*for(int i = 0; i < MainProgram.zombieNum; i++)
        {
            MainProgram.zombies[i] = new Zombie();
            MainProgram.zombies[i].positionX = (int) (Math.random()*1000);
            MainProgram.zombies[i].positionY = (int) (Math.random()*1000);
            System.out.println(MainProgram.zombies[i].positionX + "\n" + MainProgram.zombies[i].positionY);
        }*/
        /*for(int i = 0; i < MainProgram.zombieNum; i++)
        {
            if(!MainProgram.zombies[i].isDead)
            {
                graphic.setColor(Color.WHITE);
                filledEllipse(MainProgram.zombies[i].getDisplayX()-10, MainProgram.zombies[i].getDisplayY()-10, 20, 20);
                graphic.setColor(Color.RED);
                filledEllipse(MainProgram.zombies[i].getDisplayX()-9, MainProgram.zombies[i].getDisplayY()-9, 18, 18);
            }
        }*///zombo
        for(Zombie z : MainProgram.zombies) {
            if(!z.isDead)
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
            filledEllipse(zs.displayPosX-10, zs.displayPosY-10, 20, 20);
        }
    }
    
    public void drawTrees() {
        for(Tree t : MainProgram.trees) {
            graphic.setColor(Color.BLACK);
            filledEllipse(t.displayPosX-10, t.displayPosY-10, 20, 20);
            graphic.setColor(Color.CYAN);
            filledEllipse(t.displayPosX-9, t.displayPosY-9, 18, 18);
        }
    }
    
    public void drawRocks() {
        for(Rock r : MainProgram.rocks) {
            graphic.setColor(Color.BLACK);
            filledEllipse(r.displayPosX-10, r.displayPosY-10, 20, 20);
            graphic.setColor(Color.GRAY);
            filledEllipse(r.displayPosX-9, r.displayPosY-9, 18, 18);
        }
    }
    
    public void drawShoot() {
        if(MainProgram.player.inventory.gunBody.tickFired + (SHOWSHOOT/MainProgram.tickSpeed) >= MainProgram.tick) {
            graphic.setColor(new Color(250, 0, 200));
            filledEllipse(MainProgram.player.displayPosX-50, MainProgram.player.displayPosY-50, 100, 100);
        }
        if(MainProgram.player.inventory.gunPrimary.tickFired + (SHOWSHOOT/MainProgram.tickSpeed) >= MainProgram.tick) {
            graphic.setColor(new Color(125, 50, 255));
            //line(MainProgram.player.displayPosX, MainProgram.player.displayPosY, (int)MainProgram.player.inventory.gunPrimary.hitX, (int)MainProgram.player.inventory.gunPrimary.hitY);
            //filledEllipse((int)MainProgram.player.inventory.gunPrimary.hitX, (int)MainProgram.player.inventory.gunPrimary.hitY, 50, 50);
            filledEllipse(z.displayPosX-15, z.displayPosY-15, 30, 30);
        }
        if(MainProgram.player.inventory.gunSecondary.tickFired + (SHOWSHOOT/MainProgram.tickSpeed) >= MainProgram.tick) {
            graphic.setColor(new Color(0, 50, 200));
            //line(MainProgram.player.displayPosX, MainProgram.player.displayPosY, (int)MainProgram.player.inventory.gunSecondary.hitX, (int)MainProgram.player.inventory.gunSecondary.hitY);
            filledEllipse(z.displayPosX-15, z.displayPosY-15, 30, 30);
        }
    }
    
    /*
    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        int keyCode = keyEvent.getKeyCode();
        if(keyCode == KeyEvent.VK_UP)
        {
            playerMove("up");
        }
        else if(keyCode == KeyEvent.VK_DOWN)
        {
            playerMove("down");
        }
        else if(keyCode == KeyEvent.VK_RIGHT)
        {
            playerMove("right");
        }
        else if(keyCode == KeyEvent.VK_LEFT)
        {
            playerMove("left");
        }
    }
    
    @Override
    public void keyReleased(KeyEvent keyEvent)
    {     
    }
    
    @Override
    public void keyTyped(KeyEvent keyEvent)
    {
        int keyCode = keyEvent.getKeyCode();
        switch(keyCode)
        {
            case KeyEvent.VK_UP:
                playerMove("up");
                break;
            case KeyEvent.VK_DOWN:
                break;
        }
        if(keyCode == KeyEvent.VK_UP)
            System.out.print("hi");
    }
    */
}