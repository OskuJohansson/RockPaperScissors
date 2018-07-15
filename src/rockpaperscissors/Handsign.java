package rockpaperscissors;

public enum Handsign {
    ROCK, PAPER, SCISSORS;

    public static Handsign wins(Handsign hs) {
        if (hs == Handsign.ROCK) {
            return Handsign.PAPER;
        } else if (hs == Handsign.PAPER) {
            return Handsign.SCISSORS;
        } else {
            return Handsign.ROCK;
        }
    }

    public static Handsign losesTo(Handsign hs) {
        if (hs == Handsign.ROCK) {
            return Handsign.SCISSORS;
        } else if (hs == Handsign.PAPER) {
            return Handsign.ROCK;
        } else {
            return Handsign.PAPER;
        }
    }
    
}
