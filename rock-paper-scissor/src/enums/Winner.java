package enums;

public enum Winner {
    DRAW(0),
    PLAYER(1),
    COMPUTER(2);

    private final int value;

    Winner(final int value) {
        this.value = value;
    }

    public static Winner determineWinner(Choice player, Choice computer){
        int winnerValue = (3 + player.getValue() - computer.getValue()) % 3;
        Winner winner = Winner.DRAW;
        for (Winner w : Winner.values()){
            if (w.value == winnerValue){
                winner = w;
            }
        }
        return winner;
    }
}
