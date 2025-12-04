import java.awt.Color;

public class Coin implements Obj {
	Color c = new Color(255, 196, 0);
	public Color getColor() {return c;}
	public void onCollision() {System.out.print("COIN");}
	public int getSize() {return 1;}
}