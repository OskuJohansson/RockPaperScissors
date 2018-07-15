package rockpaperscissors;

import java.util.ArrayList;
import java.util.Random;

public class AI {

    private ArrayList<Handsign> playerHandsigns, botHandsigns;

    public AI() {
        this.playerHandsigns = new ArrayList<>();
        this.botHandsigns = new ArrayList<>();
    }

    // Randomly plays any of the handsigns
    public Handsign random() {
        Random r = new Random();
        int res = r.nextInt(Handsign.values().length);
        return Handsign.values()[res];
    }

    // Plays the handsign that would lose to the player's previous handsign
    // with a 50% chance and either of the other hands with a 50% chance
    public Handsign levelOne(Handsign playerHs) {
        if (playerHs == null) {
            return random();
        }
        Random r = new Random();
        int res = r.nextInt(4);

        switch (res) {
            case 0:
                return playerHs;
            case 1:
                return Handsign.wins(playerHs);
            default:
                return Handsign.losesTo(playerHs);
        }
    }
    
    public Handsign levelTwo() {
        /*  TODO: Create a database that stores game history, use that data to predict the next optimal move.
            Implement that algorithm in this method.
        */
        return null;
    }
    
}
