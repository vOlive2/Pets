import java.awt.Color;

public class colorSwitchBlue implements Obj {
	public void onCollision(PlayerStats p) {
		System.out.println("SWITCH");
		Color[] set = {
			(new Color(000, 000, 000, 000)),
			(new Color(000, 000, 000)),
			(new Color(122, 129, 255)),
			(new Color(0, 10, 199))
		};
		p.resetSprite(set);
	}
	public int getSize() {return 3;}
	public Color[][] getSprite() {
		Color[] s = {
    			(new Color(000, 000, 000, 000)),
    			(new Color(0, 2, 48)),
    			(new Color(122, 129, 255)),
    			(new Color(0, 10, 199)),
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