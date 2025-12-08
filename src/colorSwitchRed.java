import java.awt.Color;

public class colorSwitchRed implements Obj {
	public void onCollision(PlayerStats p) {
		System.out.println("SWITCH");
		Color[] set = {
			(new Color(000, 000, 000, 000)),
			(new Color(000, 000, 000)),
			(new Color(207, 33, 73)),
			(new Color(122, 9, 35))
		};
		p.resetSprite(set);
	}
	public int getSize() {return 3;}
	public Color[][] getSprite() {
		Color[] s = {
    			(new Color(000, 000, 000, 000)),
    			(new Color(99, 5, 0)),
    			(new Color(209, 11, 0)),
    			(new Color(196, 85, 79)),
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