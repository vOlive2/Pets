import java.awt.Color;
import java.util.HashMap;

public class PlayerStats {
	///////////////////////////
    ///      VARIABLES      ///
    ///////////////////////////
	public String username;
	public int pixelSize = 2;
	public int coins;
	Color[] s = {
			(new Color(000, 000, 000, 000)),
			(new Color(000, 000, 000)),
			(new Color(255, 184, 211)),
			(new Color(255, 115, 168)),
	};
	Color sprite[][] = {
		{s[0], s[0], s[1], s[1], s[1], s[0], s[0]},
		{s[0], s[1], s[2], s[2], s[2], s[1], s[0]},
		{s[1], s[2], s[3], s[2], s[3], s[2], s[1]},
		{s[1], s[2], s[2], s[2], s[2], s[2], s[1]},
		{s[1], s[3], s[2], s[2], s[2], s[3], s[1]},
		{s[1], s[2], s[3], s[3], s[3], s[2], s[1]},
		{s[0], s[1], s[1], s[1], s[1], s[1], s[0]},
	};
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
    public PlayerStats() {this(200);}
	public PlayerStats(int d) {
		x = 4;
		y = 4;
		speed = 2;
		setColors();
		
		//World Rendering
		displaySize = d; 
		world = new Color[displaySize][displaySize];
		objects = new Obj[displaySize][displaySize];
		objects[50][100] = new Coin();
		objects[80][40] = new colorSwitchRed();
		objects[100][130] = new colorSwitchGreen();
		objects[150][76] = new colorSwitchBlue();
		
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
    	colors.put("button", new Color(232, 193, 121));
    	colors.put("red", new Color(255, 66, 85));
    	colors.put("orange", new Color(252, 195, 35));
    	colors.put("yellow", new Color(255, 236, 130));
    	colors.put("green", new Color(130, 255, 132));
    }
    public void resetSprite(Color[] spriteSet) {
    	s = spriteSet;
    	Color newSprite[][] = {
    			{s[0], s[0], s[1], s[1], s[1], s[0], s[0]},
    			{s[0], s[1], s[2], s[2], s[2], s[1], s[0]},
    			{s[1], s[2], s[3], s[2], s[3], s[2], s[1]},
    			{s[1], s[2], s[2], s[2], s[2], s[2], s[1]},
    			{s[1], s[3], s[2], s[2], s[2], s[3], s[1]},
    			{s[1], s[2], s[3], s[3], s[3], s[2], s[1]},
    			{s[0], s[1], s[1], s[1], s[1], s[1], s[0]},
    	};
    	sprite = newSprite;

    }
    public Color[][] getWorld() {return world;}
    public void render() {new gameViewer(this);}
    public void checkCollision() {
    	for(int i = -pixelSize; i < pixelSize; i++) {
    		for(int j = -pixelSize; j < pixelSize; j++) {
        		if(objects[y+i][x+j] != null) objects[y+i][x+j].onCollision(this);
        	}   
    	}
    }
}