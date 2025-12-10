package objects;
import java.awt.Color;
import game.PlayerStats;

public class Coin implements Obj {
	public void onCollision(PlayerStats p) {System.out.println("COIN");}
	public int getSize() {return 3;}
	public Color[][] getSprite() {
		Color[] s = {
    			(new Color(000, 000, 000, 000)),
    			(new Color(000, 000, 000)),
    			(new Color(252, 186, 3)),
    			(new Color(204, 150, 0)),
    	};
    	Color set[][] = {
			{s[0], s[1], s[1], s[1], s[1], s[1], s[0]},
			{s[1], s[2], s[3], s[3], s[3], s[2], s[1]},
			{s[1], s[2], s[3], s[3], s[2], s[2], s[1]},
			{s[1], s[2], s[3], s[3], s[3], s[2], s[1]},
			{s[1], s[2], s[2], s[3], s[3], s[2], s[1]},
			{s[1], s[2], s[3], s[3], s[3], s[2], s[1]},
			{s[0], s[1], s[1], s[1], s[1], s[1], s[0]},
    	};
    	return set;
    
	}
}