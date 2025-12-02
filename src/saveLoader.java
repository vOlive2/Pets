import java.util.prefs.Preferences;

public class saveLoader {
    private static final Preferences prefs = Preferences.userNodeForPackage(saveLoader.class);

    public static PlayerStats loadALL() {
    	PlayerStats player = new PlayerStats();
    	player.username = prefs.get("username", "Guest Player");
        player.coins = prefs.getInt("coins", 0);
        return player;
    }
    
    public static PlayerStats saveScore(PlayerStats player) {
    	prefs.getInt("coins", player.coins);
    	prefs.get("username", player.username);
    	return player;
    }
   

}