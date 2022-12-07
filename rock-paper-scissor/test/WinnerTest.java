
import constants.Choice;
import constants.Winner;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


// TODO: Test First
public class WinnerTest {

    @Test
    public void determineWinner_player1(){
        Choice player = Choice.PAPER;
        Choice computer = Choice.ROCK;

        Winner result = Winner.determineWinner(player, computer);

        Assertions.assertTrue(result.equals(Winner.PLAYER));
    }
    @Test
    public void determineWinner_computer(){
        Choice player = Choice.ROCK;
        Choice computer = Choice.PAPER;

        Winner result = Winner.determineWinner(player, computer);

        Assertions.assertTrue(result.equals(Winner.COMPUTER));
    }
    @Test
    public void determineWinner_draw(){
        Choice player = Choice.ROCK;
        Choice computer = Choice.ROCK;

        Winner result = Winner.determineWinner(player, computer);

        Assertions.assertTrue(result.equals(Winner.DRAW));
    }
    @Test
    public void determineWinner_scissor_vs_rock(){
        Choice player = Choice.ROCK;
        Choice computer = Choice.SCISSOR;

        Winner result = Winner.determineWinner(player, computer);

        Assertions.assertTrue(result.equals(Winner.PLAYER));
    }
}