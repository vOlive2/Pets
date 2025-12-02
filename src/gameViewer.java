import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gameViewer extends JPanel {
    private Color[][] world;
    private final int pixelSize = 4;

    public gameViewer(Color[][] world, PlayerStats player) {
        this.world = world;

        JFrame frame = new JFrame("Game Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int width = world[0].length * pixelSize;
        int height = world.length * pixelSize;

        frame.setSize(width + 16, height + 39);
        frame.add(this);
        frame.setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // convert screen pixels → world grid coordinates
                int gridX = e.getX() / pixelSize;
                int gridY = e.getY() / pixelSize;

                // check bounds (so clicking outside the grid doesn't error)
                if (gridX >= 0 && gridX < world[0].length &&
                    gridY >= 0 && gridY < world.length) {
                	if ((gridY > 10 && gridY < 30)&&(gridX > 10 && gridX < 30)) {
                	  System.out.println("Clicked Orange Button");
                	  
                	}

                    //System.out.println("Clicked tile: (" + gridX + ", " + gridY + ")");
                    // Example action: turn pixel RED
                    //world[gridY][gridX] = Color.RED;
                    repaint(); // update the display
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[0].length; x++) {

                Color c = world[y][x];
                if (c == null) c = Color.BLACK;

                g.setColor(c);
                g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }
}
