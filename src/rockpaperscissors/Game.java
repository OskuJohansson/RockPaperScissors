package rockpaperscissors;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private int playerWins, botWins;
    private boolean running;
    private ArrayList<Handsigns> playerHandsigns, botHandsigns;

    public Game(ArrayList playerHandsigns, ArrayList botHansigns) {
        this.playerHandsigns = playerHandsigns;
        this.botHandsigns = botHansigns;
    }

    public Game() {
        this.playerHandsigns = new ArrayList<>();
        this.botHandsigns = new ArrayList<>();
        this.playerWins = 0;
        this.botWins = 0;
        this.running = false;
    }

    public ArrayList<Handsigns> getPlayerHandsigns() {
        return playerHandsigns;
    }

    public void setPlayerHandsigns(ArrayList<Handsigns> playerHandsigns) {
        this.playerHandsigns = playerHandsigns;
    }

    public ArrayList<Handsigns> getBotHandsigns() {
        return botHandsigns;
    }

    public void setBotHandsigns(ArrayList<Handsigns> botHandsigns) {
        this.botHandsigns = botHandsigns;
    }

    public void addPlayerHandsign(Handsigns handsign) {
        this.playerHandsigns.add(handsign);
    }

    public void addBotHandsign(Handsigns handsign) {
        this.botHandsigns.add(handsign);
    }

    private static Handsigns convertToHandsign(String hs) {
        if (hs.equalsIgnoreCase("r") || hs.equalsIgnoreCase("rock")) {
            return Handsigns.ROCK;
        } else if (hs.equalsIgnoreCase("p") || hs.equalsIgnoreCase("paper")) {
            return Handsigns.PAPER;
        } else if (hs.equalsIgnoreCase("s") || hs.equalsIgnoreCase("scissors")) {
            return Handsigns.SCISSORS;
        } else {
            return null;
        }
    }
    // this is where the magic happens
    public void play() {
        this.startInfo();
        
        Scanner scanner = new Scanner(System.in);
        Handsigns playerHs = null;
        this.running = true;

        while (this.running) {
            Handsigns botHs = betterAI(playerHs);

            System.out.print("Choose your handsign: ");
            String playerInput = scanner.nextLine();
            if (playerInput.equalsIgnoreCase("stop")) {
                this.endGame();
                break;
            }
            playerHs = convertToHandsign(playerInput);
            System.out.println("You chose " + playerHs + ".");
            System.out.println("Your opponent chose " + botHs + ".");

            this.result(playerHs, botHs);
            System.out.println("----------------------------");
        }
    }

    private void startInfo() {
        System.out.println("Let's play Rock, Paper, Scissors! \n"
                + "The rules are simple: you will choose either rock, paper or "
                + "scissors, and the bot will do the same. \n"
                + "Rock beats scissors, paper beats rock and scissors beat paper. \n"
                + "You can stop playing at any time by typing \"Stop\". \n"
                + "Let's begin! \n");
    }

    private void endGame() {
        System.out.println("Total player wins: " + this.playerWins);
        System.out.println("Total bot wins: " + this.botWins);
        System.out.println("Thank you for playing!");
        this.running = false;
    }

    private void result(Handsigns playerHs, Handsigns botHs) {
        if (playerHs == botHs) {
            System.out.println("It's a tie!");
        } else if (playerHs == Handsigns.wins(botHs)) {
            System.out.println("You won!");
            this.playerWins++;
        } else {
            System.out.println("You lost!");
            this.botWins++;
        }
    }

    // Randomly plays any of the handsigns
    private static Handsigns dumbAI() {
        Random r = new Random();
        int res = r.nextInt(Handsigns.values().length);
        return Handsigns.values()[res];
    }

    // Plays the handsign that would lose to the player's previous handsign
    // with a 50% chance and either of the other hands with a 50% chance
    private static Handsigns betterAI(Handsigns playerHs) {
        if (playerHs == null) {
            return dumbAI();
        }
        Random r = new Random();
        int res = r.nextInt(4);

        switch (res) {
            case 0:
                return playerHs;
            case 1:
                return Handsigns.wins(playerHs);
            default:
                return Handsigns.losesTo(playerHs);
        }
    }
}
