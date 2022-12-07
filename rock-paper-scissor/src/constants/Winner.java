package constants;

public enum Winner {
    // TODO Open Closed Principle: für Erweiterungen öffnen, für Veränderungen schließen
    DRAW(Hierarchy.HIERARCHY_0),
    PLAYER(Hierarchy.HIERARCHY_1),
    COMPUTER(Hierarchy.HIERARCHY_2);

    // TODO Information Hiding Principle
    private final int value;

    Winner(final int value) {
        this.value = value;
    }

    public static Winner determineWinner(Choice player, Choice computer){
        // due to the defined hierarchy levels in Choice, we can calculate the winner by subtracting the choice hierarchies.
        // for more information see: https://stackoverflow.com/questions/2795399/one-liner-to-determine-who-wins-in-rock-paper-scissors
        int winnerValue = (3 + player.getHierarchy() - computer.getHierarchy()) % 3;
        Winner winner = Winner.DRAW;
        for (Winner w : Winner.values()){
            if (w.value == winnerValue){
                winner = w;
            }
        }
        return winner;
    }
}
