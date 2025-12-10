package objects;
import java.awt.Color;

public class colorSwitchYellow implements Obj {
	public void onCollision(PlayerStats p) {
		System.out.println("SWITCH");
		Color[] set = {
			    new Color(0,0,0,0),
			    new Color(90,80,20),
			    new Color(255,255,190),
			    new Color(255,240,130),
			    new Color(230,200,50)
			};


		p.resetSprite(set);
	}
	public int getSize() {return 3;}
	public Color[][] getSprite() {
		Color[] s = {
    			(new Color(000, 000, 000, 000)),
    			(new Color(90,80,20)),
    			(new Color(255,240,130)),
    			(new Color(230,200,50)),
    	};
    	Color set[][] = {
			{s[0], s[1], s[1], s[1], s[1], s[1], s[0]},
			{s[1], s[2], s[3], s[2], s[3], s[2], s[1]},
			{s[1], s[3], s[2], s[3], s[2], s[3], s[1]},
			{s[1], s[2], s[3], s[2], s[3], s[2], s[1]},
			{s[1], s[3], s[2], s[3], s[2], s[3], s[1]},
			{s[1], s[2], s[3], s[2], s[3], s[2], s[1]},
			{s[0], s[1], s[1], s[1], s[1], s[1], s[0]},
    	};
    	return set;
    
	}
}