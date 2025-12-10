package objects;
import java.awt.Color;
import game.PlayerStats;

public class colorSwitchRed implements Obj {
	public void onCollision(PlayerStats p) {
		System.out.println("SWITCH");
		Color[] set = {
			    new Color(0,0,0,0),
			    new Color(80,35,35),
			    new Color(255,190,190),
			    new Color(240,140,140),
			    new Color(200,90,90)
			};

		p.resetSprite(set);
	}
	public int getSize() {return 3;}
	public Color[][] getSprite() {
		Color[] s = {
    			(new Color(000, 000, 000, 000)),
    			(new Color(99, 5, 0)),
    			(new Color(209, 11, 0)),
    			(new Color(200,90,90)),
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