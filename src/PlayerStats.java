import java.awt.Color;
import java.util.HashMap;

public class PlayerStats {
	///////////////////////////
    ///      VARIABLES      ///
    ///////////////////////////
	public String username;
	public int coins;
	public int displaySize;
    private Color[][] world;
    public HashMap<String, Color> colors = new HashMap<>();
    
    ///////////////////////////
    ///    CONSTRUCTORS     ///
    ///////////////////////////
    public PlayerStats() {this(150);}
	public PlayerStats(int d) {
		setColors();
		displaySize = d;
		world = new Color[displaySize][displaySize];
		//set to default color
		for(int y = 0; y < displaySize; y++) {
        	for(int x = 0; x < displaySize; x++) {
            	world[y][x] = colors.get("red");
            }
        }
		for(int y = 10; y < 30; y++) {
        	for(int x = 10; x < 30; x++) {
            	world[y][x] = colors.get("orange");
            }
        }
    }
	
	///////////////////////////
    ///       METHODS       ///
    ///////////////////////////
    private void setColors() {
    	colors.put("background", new Color(255, 255, 255));
    	colors.put("button", new Color(232, 193, 121));
    	colors.put("red", new Color(255, 66, 85));
    	colors.put("orange", new Color(252, 195, 35));
    }
    public Color[][] getWorld() {return world;}
    public void render() {new gameViewer(world, this);}
}