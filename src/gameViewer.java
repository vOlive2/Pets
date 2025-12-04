import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameViewer extends JPanel {
	///////////////////////////
	///      VARIABLES      ///
	///////////////////////////
    private final int pixelSize = 3;
    public PlayerStats player;
    
    ///////////////////////////
    ///    CONSTRUCTORS     ///
    ///////////////////////////
    public gameViewer(PlayerStats p) {
    	player = p;

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
    	if(player.x < 1) player.x = 1;
    	if(player.y < 1) player.y = 1;
    	if(player.x > player.displaySize-1) player.x = player.displaySize-1;
    	if(player.y > player.displaySize-1) player.y = player.displaySize-1;
    }
    public void movePlayer(int x, int y) {
    	player.x-=x*player.speed;
    	player.y-=y*player.speed;
    	keepPlayerInBounds();
    	if(player.checkCollision()) {
    		player.objects[player.x][player.y].onCollision();;
    	}
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(player.colors.get("green"));
        g.fillRect(0, 0, player.displaySize*pixelSize, player.displaySize*pixelSize);

        for (int y = 0; y < player.world.length; y++) {
            for (int x = 0; x < player.world[0].length; x++) {
            	if (player.objects[y][x] != null) {
                	Color c = player.objects[y][x].getColor();
                	g.setColor(c);
                	int size = player.objects[y][x].getSize()*pixelSize*2;
                	g.fillRect(x*pixelSize, y*pixelSize, size, size);
                }           
            }
        }
        g.setColor(player.colors.get("player")); // player color
        g.fillRect(player.x*pixelSize, player.y*pixelSize, pixelSize*2, pixelSize*2);
    }
}
