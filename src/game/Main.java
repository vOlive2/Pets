//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package game;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!\n" +
        				   "Loading any player data!\n");
        PlayerStats player = saveLoader.loadALL();
        System.out.println("Welcome back " + player.username);     
        player.render();
        
    }
}