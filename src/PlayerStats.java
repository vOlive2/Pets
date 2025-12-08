import java.awt.Color;
import java.util.HashMap;

public class PlayerStats {
	///////////////////////////
    ///      VARIABLES      ///
    ///////////////////////////
	public String username;
	public int pixelSize = 3;
	public int coins;
	Color[] grassColors = {
		    new Color(215, 245, 178), // light pastel grass
		    new Color(194, 237, 151), // soft green
		    new Color(176, 229, 124), // mellow bright grass
		    new Color(161, 219, 105), // warm natural green
		    new Color(145, 209, 85),  // mid green
		    new Color(126, 188, 73),  // earthy midtone
		    new Color(106, 166, 62),  // slightly darker
		    new Color(90, 145, 53),   // shadow grass
		    new Color(74, 123, 44),   // deep shade
		    new Color(59, 102, 35)    // darkest grass
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
		x = 30;
		y = 30;
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
		
		//Set to default color
		for(int y = 0; y < displaySize; y++) {
        	for(int x = 0; x < displaySize; x++) {
            	world[y][x] = grassColors[((int)(Math.random() * 10))];
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