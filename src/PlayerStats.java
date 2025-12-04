import java.awt.Color;
import java.util.HashMap;

public class PlayerStats {
	///////////////////////////
    ///      VARIABLES      ///
    ///////////////////////////
	public String username;
	public int coins;
	
	//defaults
	public int displaySize;
	public int x;
	public int y;
	public int speed;
	public Color[][] world;
	public Obj[][] objects;
    public HashMap<String, Color> colors = new HashMap<>();
    
    ///////////////////////////
    ///    CONSTRUCTORS     ///
    ///////////////////////////
    public PlayerStats() {this(150);}
	public PlayerStats(int d) {
		x = 20;
		y = 20;
		speed = 2;
		setColors();
		
		//World Rendering
		displaySize = d; 
		world = new Color[displaySize][displaySize];
		objects = new Obj[displaySize][displaySize];
		objects[100][100] = new Coin();
		
		//Set to default color
		for(int y = 0; y < displaySize; y++) {
        	for(int x = 0; x < displaySize; x++) {
            	world[y][x] = colors.get("green");
            }
        }
    }
	
	///////////////////////////
    ///       METHODS       ///
    ///////////////////////////
    private void setColors() {
    	colors.put("background", new Color(255, 255, 255));
    	colors.put("player", new Color(000, 000, 000));
    	colors.put("button", new Color(232, 193, 121));
    	//colors
    	colors.put("red", new Color(255, 66, 85));
    	colors.put("orange", new Color(252, 195, 35));
    	colors.put("yellow", new Color(255, 236, 130));
    	colors.put("green", new Color(130, 255, 132));

   }
    public Color[][] getWorld() {return world;}
    public void render() {new gameViewer(this);}
    public boolean checkCollision() {
    	if(objects[y][x] != null) return true;
    	return false;
    }
}