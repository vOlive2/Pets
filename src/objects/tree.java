package objects;
import java.awt.Color;
import game.PlayerStats;

public class tree implements Obj {
	public void onCollision(PlayerStats p) {System.out.println("TREE");}
	public int getSize() {return 4;}
	public Color[][] getSprite() {
		Color[] s = {
    			(new Color(000, 000, 000, 000)),
    			(new Color(71, 52, 0)),
    			(new Color(110, 89, 31)),
    			(new Color(48, 143, 39)),
    			(new Color(38, 122, 29)),
    			(new Color(199, 64, 52))

    	};
		Color set[][] = {
				{s[0], s[0], s[3], s[3], s[3], s[5], s[3], s[0], s[0]},
				{s[0], s[3], s[3], s[4], s[4], s[3], s[4], s[3], s[0]},
				{s[0], s[3], s[3], s[4], s[5], s[4], s[3], s[3], s[0]},
				{s[0], s[5], s[3], s[3], s[4], s[4], s[3], s[3], s[0]},
				{s[0], s[0], s[3], s[4], s[3], s[3], s[5], s[0], s[0]},
				{s[0], s[0], s[0], s[2], s[1], s[2], s[0], s[0], s[0]},
				{s[0], s[0], s[0], s[2], s[1], s[2], s[0], s[0], s[0]},
				{s[0], s[0], s[0], s[2], s[1], s[2], s[0], s[0], s[0]},
			    {s[0], s[0], s[0], s[2], s[2], s[2], s[0], s[0], s[0]}
			};
    	return set;
    
	}
}