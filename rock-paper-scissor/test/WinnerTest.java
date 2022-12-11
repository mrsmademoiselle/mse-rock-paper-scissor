
import constants.Choice;
import constants.Winner;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


public class WinnerTest {

    @Test
    public void determineWinner_player1(){
        Choice player_paper = Choice.PAPER;
        Choice computer_rock = Choice.ROCK;

        Winner winner = Winner.determineWinner(player_paper, computer_rock);

        Assertions.assertEquals(winner, Winner.PLAYER);
    }
    @Test
    public void determineWinner_computer(){
        Choice player_rock = Choice.SCISSOR;
        Choice computer_paper = Choice.ROCK;

        Winner winner = Winner.determineWinner(player_rock, computer_paper);

        Assertions.assertEquals(winner, Winner.COMPUTER);
    }
    @Test
    public void determineWinner_draw(){
        Choice player_rock = Choice.ROCK;
        Choice computer_rock = Choice.ROCK;

        Winner winner = Winner.determineWinner(player_rock, computer_rock);

        Assertions.assertEquals(winner, Winner.DRAW);
    }
}