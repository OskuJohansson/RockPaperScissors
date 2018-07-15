package rockpaperscissors;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private int playerWins, botWins;
    private boolean running;
    private ArrayList<Handsign> playerHandsigns, botHandsigns;

    public Game(ArrayList playerHandsigns, ArrayList botHansigns) {
        this.playerHandsigns = playerHandsigns;
        this.botHandsigns = botHansigns;
        this.running = false;
    }

    public Game() {
        this.playerHandsigns = new ArrayList<>();
        this.botHandsigns = new ArrayList<>();
        this.playerWins = 0;
        this.botWins = 0;
        this.running = false;
    }

    public ArrayList<Handsign> getPlayerHandsigns() {
        return playerHandsigns;
    }

    public void setPlayerHandsigns(ArrayList<Handsign> playerHandsigns) {
        this.playerHandsigns = playerHandsigns;
    }

    public ArrayList<Handsign> getBotHandsigns() {
        return botHandsigns;
    }

    public void setBotHandsigns(ArrayList<Handsign> botHandsigns) {
        this.botHandsigns = botHandsigns;
    }

    public void addPlayerHandsign(Handsign handsign) {
        this.playerHandsigns.add(handsign);
    }

    public void addBotHandsign(Handsign handsign) {
        this.botHandsigns.add(handsign);
    }

    private static Handsign convertToHandsign(String hs) {
        if (hs.equalsIgnoreCase("r") || hs.equalsIgnoreCase("rock")) {
            return Handsign.ROCK;
        } else if (hs.equalsIgnoreCase("p") || hs.equalsIgnoreCase("paper")) {
            return Handsign.PAPER;
        } else if (hs.equalsIgnoreCase("s") || hs.equalsIgnoreCase("scissors")) {
            return Handsign.SCISSORS;
        } else {
            return null;
        }
    }

    // this is where the magic happens
    public void play() {
        this.startInfo();

        Scanner scanner = new Scanner(System.in);
        AI ai = new AI();
        Handsign playerHs = null;
        this.running = true;

        while (this.running) {
            Handsign botHs = ai.levelOne(playerHs);

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

    private void result(Handsign playerHs, Handsign botHs) {
        if (playerHs == botHs) {
            System.out.println("It's a tie!");
        } else if (playerHs == Handsign.wins(botHs)) {
            System.out.println("You won!");
            this.playerWins++;
        } else {
            System.out.println("You lost!");
            this.botWins++;
        }
    }
}
