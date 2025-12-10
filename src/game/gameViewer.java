package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameViewer extends JPanel {
	///////////////////////////
	///      VARIABLES      ///
	///////////////////////////
    private int pixelSize = 3;
    public PlayerStats player;
    
    ///////////////////////////
    ///    CONSTRUCTORS     ///
    ///////////////////////////
    public gameViewer(PlayerStats p) {
    	player = p;
        pixelSize = player.pixelSize;

        JFrame frame = new JFrame("Game Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int width = p.world[0].length * pixelSize;
        int height = p.world.length * pixelSize;
        
        frame.setSize(width + 16, height + 39);
        frame.add(this);
        frame.setVisible(true);
        
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                int key = e.getKeyCode();
                if (key == java.awt.event.KeyEvent.VK_W) movePlayer(0, 1); // up
                if (key == java.awt.event.KeyEvent.VK_S) movePlayer(0, -1);// down
                if (key == java.awt.event.KeyEvent.VK_A) movePlayer(1, 0); // left
                if (key == java.awt.event.KeyEvent.VK_D) movePlayer(-1, 0); // right
                keepPlayerInBounds();
                repaint();
            }
        });
    }
    
    ///////////////////////////
    ///       METHODS       ///
    ///////////////////////////
    public void keepPlayerInBounds() {
    	if(player.x < 12) player.x = 12;
    	if(player.y < 12) player.y = 12;
    	if(player.x > player.displaySize-12) player.x = player.displaySize-12;
    	if(player.y > player.displaySize-12) player.y = player.displaySize-12;
    }
    public void movePlayer(int x, int y) {
    	player.x-=x*player.speed;
    	player.y-=y*player.speed;
    	keepPlayerInBounds();
    	player.checkCollision();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //world[y][x] = grassColors[((int)(Math.random() * 10))];
        paintGrass(g);
        
        for (int y = 0; y < player.world.length; y++) {
            for (int x = 0; x < player.world[0].length; x++) {
            	if (player.objects[y][x] != null) {
            		for (int y1 = 0; y1 < player.objects[y][x].getSize()*2+1; y1++) {
                        for (int x1 = 0; x1 < player.objects[y][x].getSize()*2+1; x1++) {
                        	Color c = player.objects[y][x].getSprite()[y1][x1];
                        	g.setColor(c);
                        	int size = player.objects[y][x].getSize();
                        	g.fillRect((x-size+x1)*pixelSize, (y-size+y1)*pixelSize, pixelSize, pixelSize);
                        	//if(player.y == y && player.x == x) {paintPlayer(g);}
                        }
            		}
                }           
            }
        }
        paintPlayer(g);
    }
    protected void paintGrass(Graphics g) {
    	for (int y = 0; y < player.world.length; y++) {
            for (int x = 0; x < player.world.length; x++) {
               	Color c = player.world[y][x];
               	g.setColor(c);
            	g.fillRect(x*pixelSize, y*pixelSize, pixelSize, pixelSize);
            }
        }
    }
    protected void paintPlayer(Graphics g) {
    	for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
               	Color c = player.sprite[y][x];
               	g.setColor(c);
               	g.fillRect((player.x-6+x)*pixelSize, (player.y-6+y)*pixelSize, pixelSize, pixelSize);           
            }
        }
    }
}
