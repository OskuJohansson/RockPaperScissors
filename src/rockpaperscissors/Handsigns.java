package rockpaperscissors;

public enum Handsigns {
    ROCK, PAPER, SCISSORS;

    public static Handsigns wins(Handsigns hs) {
        if (hs == Handsigns.ROCK) {
            return Handsigns.PAPER;
        } else if (hs == Handsigns.PAPER) {
            return Handsigns.SCISSORS;
        } else {
            return Handsigns.ROCK;
        }
    }

    public static Handsigns losesTo(Handsigns hs) {
        if (hs == Handsigns.ROCK) {
            return Handsigns.SCISSORS;
        } else if (hs == Handsigns.PAPER) {
            return Handsigns.ROCK;
        } else {
            return Handsigns.PAPER;
        }
    }
    
}
