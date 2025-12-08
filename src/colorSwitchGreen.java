import java.awt.Color;

public class colorSwitchGreen implements Obj {
	public void onCollision(PlayerStats p) {
		System.out.println("SWITCH");
		Color[] set = {
			(new Color(000, 000, 000, 000)),
			(new Color(000, 000, 000)),
			(new Color(189, 240, 108)),
			(new Color(93, 153, 0))
		};
		p.resetSprite(set);
	}
	public int getSize() {return 3;}
	public Color[][] getSprite() {
		Color[] s = {
    			(new Color(000, 000, 000, 000)),
    			(new Color(47, 77, 0)),
    			(new Color(189, 240, 108)),
    			(new Color(143, 230, 5)),
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