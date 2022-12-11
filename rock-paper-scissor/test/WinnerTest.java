
import constants.Choice;
import constants.Winner;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


public class WinnerTest {

    @Test
    public void determineWinner_playerWins(){
        Choice playerPaper = Choice.PAPER;
        Choice computerRock = Choice.ROCK;

        Winner winner = Winner.determineWinner(playerPaper, computerRock);

        Assertions.assertEquals(winner, Winner.PLAYER);
    }
    @Test
    public void determineWinner_computerWins(){
        Choice playerScissor = Choice.SCISSOR;
        Choice computerPaper = Choice.ROCK;

        Winner winner = Winner.determineWinner(playerScissor, computerPaper);

        Assertions.assertEquals(winner, Winner.COMPUTER);
    }
    @Test
    public void determineWinner_draw(){
        Choice playerRock = Choice.ROCK;
        Choice computerRock = Choice.ROCK;

        Winner winner = Winner.determineWinner(playerRock, computerRock);

        Assertions.assertEquals(winner, Winner.DRAW);
    }
}