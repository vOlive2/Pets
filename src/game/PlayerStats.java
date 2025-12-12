package game;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import objects.*;


public class PlayerStats {
	///////////////////////////
    ///      VARIABLES      ///
    ///////////////////////////
	public String username;
	public int pixelSize = 5;
	public int coins;
	Color[] grassColors = {
			new Color(178, 236, 150), // soft warm grass-light (still bright but not neon)
			new Color(148, 220, 118)  // healthy bright grass-green (natural & vivid)
	};
	Color[] s = {
		    new Color(0,0,0,0),       // 0 transparent  
		    new Color(60,40,50),      // 1 outlines  
		    new Color(255,190,215),   // 2 base  
		    new Color(255,150,185),   // 3 mid shade  
	};
	Color[][] sprite = {
		    {s[0], s[0], s[1], s[1], s[1], s[1], s[0], s[0]},
		    {s[0], s[1], s[2], s[2], s[2], s[2], s[1], s[0]},
		    {s[1], s[2], s[2], s[2], s[2], s[2], s[2], s[1]},
		    {s[1], s[2], s[2], s[2], s[2], s[2], s[2], s[1]},
		    {s[1], s[2], s[3], s[2], s[2], s[3], s[2], s[1]},
		    {s[1], s[2], s[2], s[3], s[3], s[2], s[2], s[1]},
		    {s[1], s[2], s[2], s[2], s[2], s[2], s[2], s[1]},
		    {s[0], s[1], s[1], s[1], s[1], s[1], s[1], s[0]}
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
		x = 100;
		y = 100;
		speed = 2;
		setColors();
		
		//World Rendering
		displaySize = d; 
		world = new Color[displaySize][displaySize];
		objects = new Obj[displaySize][displaySize];
		objects[50][30] = new Coin();
		objects[50][50] = new colorSwitchRed();
		objects[50][70] = new colorSwitchOrange();
		objects[50][90] = new colorSwitchYellow();
		objects[50][110] = new colorSwitchGreen();
		objects[50][130] = new colorSwitchBlue();
		objects[50][150] = new colorSwitchPurple();
		objects[100][100] = new tree();
		
		//Set to default color
		for(int y = 0; y < displaySize; y++) {
        	for(int x = 0; x < displaySize; x++) {
            	world[y][x] = grassColors[((int)(Math.random() * grassColors.length))];
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
    	Color[][] newSprite = {
    		    {s[0], s[0], s[1], s[1], s[1], s[1], s[0], s[0]},
    		    {s[0], s[1], s[2], s[2], s[2], s[2], s[1], s[0]},
    		    {s[1], s[2], s[2], s[2], s[2], s[2], s[2], s[1]},
    		    {s[1], s[2], s[2], s[2], s[2], s[2], s[2], s[1]},
    		    {s[1], s[2], s[3], s[2], s[2], s[3], s[2], s[1]},
    		    {s[1], s[2], s[2], s[3], s[3], s[2], s[2], s[1]},
    		    {s[1], s[2], s[2], s[2], s[2], s[2], s[2], s[1]},
    		    {s[0], s[1], s[1], s[1], s[1], s[1], s[1], s[0]}
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