package objects;
import java.awt.Color;

public interface Obj {
	public void onCollision(PlayerStats p);
	public int getSize();
	public Color[][] getSprite();

}
