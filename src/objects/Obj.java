package objects;
import java.awt.Color;
import game.PlayerStats;

public interface Obj {
	public void onCollision(PlayerStats p);
	public int getSize();
	public Color[][] getSprite();

}
