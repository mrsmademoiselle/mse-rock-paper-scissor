import constants.Choice;
import constants.Winner;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class GameService {

    private final Choice[] ALL_CHOICES = Choice.values();

    public  void startGame(){
        System.out.println("Welcome to Rock Paper Scissor!");

        boolean shouldStopGame = false;

        while (!shouldStopGame){
            mainMenu();
            shouldStopGame = askIfUserWantsToStop();
        }
    }

    private void mainMenu(){
        System.out.println("-----\n");
        Choice computerChoice = makeComputerChoice();
        Choice userChoice = askUserChoice();

        System.out.println("The computers choice: "+computerChoice.name());
        System.out.println("Your choice: "+userChoice.name());

        Winner winner = Winner.determineWinner(userChoice,computerChoice);

        printGameResult(winner);
    }

    private void printGameResult(Winner winner){
        if (winner.equals(Winner.DRAW)){
            System.out.println("It was a draw.");
        } else {
            boolean playerHasWon = winner.equals(Winner.PLAYER);
            System.out.println("You have " + (playerHasWon ? "won." : "lost."));
            System.out.println(playerHasWon ? "Congratulations!" : "Better luck next time.");
        }
    }

    private Choice askUserChoice(){
        Scanner scanner = new Scanner(System.in);
        boolean isValidNumber = false;
        Optional<Choice> userChoice = Optional.empty();

        while (!isValidNumber){
            System.out.println("Please make a choice between these options:");
            printAllPossibleChoices();

            String userChoiceInput = scanner.nextLine();
            userChoice = Choice.getChoiceForValue(userChoiceInput);
            isValidNumber = userChoice.isPresent();
        }

        return userChoice.get();
    }

    private void printAllPossibleChoices(){
        for (int i = 1; i <= this.ALL_CHOICES.length; i++){
            System.out.println(i + " " +this.ALL_CHOICES[i-1].toString());
        }
    }

    /**
     * Generates a random int and chooses the item on that index from ALL_CHOICES
     */
    private Choice makeComputerChoice() {
        Random random = new Random();
        int number = random.nextInt(this.ALL_CHOICES.length);

        return this.ALL_CHOICES[number];
    }

    private boolean askIfUserWantsToStop(){
        System.out.println("\nDo you want to play again? Y/N");

        Scanner scanner = new Scanner(System.in);
        String anotherGameString = scanner.nextLine();

        if (anotherGameString.equalsIgnoreCase("y")){
            System.out.println("Starting another game.");
            return false;
        } else if (anotherGameString.equalsIgnoreCase("n")){
            System.out.println("Thank you for playing. Goodbye.");
            return true;
        }else {
            System.out.println("Unknown answer. Terminating game.");
            return true;
        }
    }
}
