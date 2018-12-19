import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyFrame extends JFrame implements KeyListener, MouseListener
{
    MyPanel p;
    private ArrayList<Integer> keysDown = new ArrayList<Integer>();
    private ArrayList<Integer> mouseKeysDown = new ArrayList<Integer>();
    private ArrayList<String> arrows = new ArrayList<String>();
    public String dMode = "main menu";
    public double mX = 0;
    public double mY = 0;
    public int tickUpdate = 0;
    public MyFrame(String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        pack();
        p = new MyPanel();
        Insets insets = getInsets();
        int width = p.getWidth()+insets.left+insets.right;
        int height = p.getHeight()+insets.top+insets.bottom;
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        //
        
        add(p);
        pack();
        //
        setVisible(true);
        
        this.addKeyListener(this);
        this.addMouseListener(this);
    }
    
    public void newPanel()
    {
        MyPanel.printerSet = "redraw";
        p = new MyPanel();
        Insets insets = getInsets();
        int width = p.getWidth()+insets.left+insets.right;
        int height = p.getHeight()+insets.top+insets.bottom;
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }
    
    public void panelRefresh()
    {
        p.revalidate();
        p.repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(!keysDown.contains(new Integer(keyEvent.getKeyCode())))
            keysDown.add(new Integer(keyEvent.getKeyCode()));
        if(dMode == "singleplayer" /*&& MainProgram.tick != tickUpdate*/) {
            tickUpdate = MainProgram.tick;
            if(keysDown.contains(new Integer(KeyEvent.VK_UP)) || keysDown.contains(new Integer(KeyEvent.VK_RIGHT)) || keysDown.contains(new Integer(KeyEvent.VK_DOWN)) || keysDown.contains(new Integer(KeyEvent.VK_LEFT)) || keysDown.contains(new Integer(KeyEvent.VK_A)) || keysDown.contains(new Integer(KeyEvent.VK_S)) || keysDown.contains(new Integer(KeyEvent.VK_W)) || keysDown.contains(new Integer(KeyEvent.VK_D))) {
                if(keysDown.contains(new Integer(KeyEvent.VK_UP)) || keysDown.contains(new Integer(KeyEvent.VK_W)))
                {
                    arrows.add("up");
                }
                if(keysDown.contains(new Integer(KeyEvent.VK_DOWN)) || keysDown.contains(new Integer(KeyEvent.VK_S)))
                {
                    arrows.add("down");
                }
                if(keysDown.contains(new Integer(KeyEvent.VK_RIGHT)) || keysDown.contains(new Integer(KeyEvent.VK_D)))
                {
                    arrows.add("right");
                }
                if(keysDown.contains(new Integer(KeyEvent.VK_LEFT)) || keysDown.contains(new Integer(KeyEvent.VK_A)))
                {
                    arrows.add("left");
                }
                MainProgram.player.playerMove(arrows);
                arrows.clear();
            }
            if(keysDown.contains(new Integer(KeyEvent.VK_ADD)))
            {
                //MainProgram.player.changeDirection(MainProgram.player.getDirection() + 5);
            }
            if(keysDown.contains(new Integer(KeyEvent.VK_SUBTRACT)))
            {
                //MainProgram.player.changeDirection(MainProgram.player.getDirection() - 5);
            }
            if(keysDown.contains(new Integer(KeyEvent.VK_V)))
            {
                keysDown.clear();
            }
            if(keysDown.contains(new Integer(KeyEvent.VK_SPACE)))
            {
                MainProgram.player.fireBody();
                //MainProgram.player.calculateDirection();
            }
            if(keysDown.contains(new Integer(KeyEvent.VK_E))) {
                MainProgram.myFrame.dMode = "inventory";
            }
            if(keysDown.contains(new Integer(KeyEvent.VK_SHIFT))) {
                MainProgram.player.switchMode();
            }
        }
        if(keysDown.contains(new Integer(KeyEvent.VK_ESCAPE)))
        {
            if(dMode == "singleplayer" || dMode == "settings" || dMode == "player dead") {
                dMode = "main menu";
            } else if(dMode == "inventory") {
                dMode = "singleplayer";
            }    
            else if(dMode == "main menu") {
                System.exit(0);
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent keyEvent)
    {     
        keysDown.remove(new Integer(keyEvent.getKeyCode()));
    }
    
    @Override
    public void keyTyped(KeyEvent keyEvent)
    {
    }
    
    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {
    }
    
    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {
    }
    
    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        mouseKeysDown.remove(new Integer(mouseEvent.getButton()));
        mouseKeysDown.clear();
    }
    
    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        Point point = MouseInfo.getPointerInfo().getLocation();
        double x = point.getX();
        double y = point.getY();
        if(!mouseKeysDown.contains(new Integer(mouseEvent.getButton()))) {
            mouseKeysDown.add(new Integer(mouseEvent.getButton()));
        }
        if(mouseKeysDown.contains(new Integer(MouseEvent.BUTTON1)))
        {
            //System.exit(0);
        }
        if(dMode == "main menu") {
            if(mouseKeysDown.contains(new Integer(MouseEvent.BUTTON1)))  {
                if(x > 100 && x < 500 && y > 100 && y < 250) {
                    dMode = "singleplayer";
                }
                if(x > 100 && x < 500 && y > 300 && y < 450) {
                    dMode = "settings";
                }
            }
        } else if(dMode == "singleplayer") {
            if(mouseKeysDown.contains(new Integer(MouseEvent.BUTTON1))) {
                MainProgram.player.use(1, getMX(), getMY());
            }
            if(mouseKeysDown.contains(new Integer(MouseEvent.BUTTON3)) /*isRightClick(mouseEvent)*/) {
                MainProgram.player.use(3, getMX(), getMY());
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
    }
    
    public double getMX() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        return point.getX();
    }
    public double getMY() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        return point.getY();
    }
    
    public void fixPlayerDirection() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        double x = point.getX();
        double y = point.getY();
        MainProgram.player.calculateDirection(x, y);
    }
    
}