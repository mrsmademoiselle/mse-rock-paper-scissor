import enums.Choice;
import enums.Winner;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {


    public static void main(String[] args){
        Choice[] allChoices = Choice.values();
        Random random = new Random();
        System.out.println("Welcome to Rock Paper Scissor!");

        boolean stopGames = false;

        while (!stopGames){
            mainMenu(allChoices, random);
            stopGames = stopGame();
        }
    }

    public static boolean stopGame(){
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

    public static void mainMenu(Choice[] allChoices, Random random){
        System.out.println("-----\n");
        Choice computerChoice = makeChoice(allChoices,random);
        Choice userChoice = askUserChoice(allChoices);

        System.out.println("The computers choice: "+computerChoice.name());
        System.out.println("Your choice: "+userChoice.name());

        Winner winner = Winner.determineWinner(userChoice,computerChoice);

        printGameResult(winner);
    }

    public static void printGameResult(Winner winner){
        if (winner.equals(Winner.DRAW)){
            System.out.println("It was a draw.");
        } else {
            boolean playerWon = winner.equals(Winner.PLAYER);
            System.out.println((playerWon ? "You" : "The computer")+" won.");
            System.out.println(playerWon ? "Congratulations!" : "Better luck next time.");
        }
    }

    public static Choice askUserChoice(Choice[] allChoices){
        Scanner scanner = new Scanner(System.in);
        boolean isValidNumber = false;
        Optional<Choice> userChoice = Optional.empty();

        while (!isValidNumber){
            System.out.println("Please make a choice between these options:");

            listChoices(allChoices);

            String userChoiceString = scanner.nextLine();
            userChoice = Choice.getChoiceForValue(userChoiceString);
            isValidNumber = userChoice.isPresent();
        }

        return userChoice.get();
    }

    public static void listChoices(Choice[] allChoices){
        for (int i = 1; i <= allChoices.length; i++){
            System.out.println(i + " " +allChoices[i-1].toString());
        }

    }
    public static Choice makeChoice(Choice[] allChoices, Random random) {
        int number = random.nextInt(3);

        return allChoices[number];
    }
}
