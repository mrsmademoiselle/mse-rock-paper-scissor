package constants;

public enum Winner {
    DRAW(0),
    PLAYER(1),
    COMPUTER(2);

    private final int VALUE;

    Winner( int value) {
        this.VALUE = value;
    }

    public static Winner determineWinner(Choice player, Choice computer){
        /* We can calculate the winner by subtracting the hierarchy levels of the choices. This greatly reduces the
         * amount of if-elses necessary for this evaluation & does not need adjustments in case of future Choice-extensions.
         * For more information see:
         * https://stackoverflow.com/questions/2795399/one-liner-to-determine-who-wins-in-rock-paper-scissors
         */
        int winnerValue = (3 + player.getHierarchy() - computer.getHierarchy()) % 3;
        Winner winner = Winner.DRAW;
        for (Winner w : Winner.values()){
            if (w.VALUE == winnerValue){
                winner = w;
            }
        }
        return winner;
    }
}
