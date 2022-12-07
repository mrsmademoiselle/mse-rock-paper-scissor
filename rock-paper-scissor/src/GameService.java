import constants.Choice;
import constants.Winner;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class GameService {

    public  void startGame(){
        // TODO Keep it simple, stupid
        Choice[] allChoices = Choice.values();
        Random random = new Random();
        System.out.println("Welcome to Rock Paper Scissor!");

        boolean stopGames = false;

        // TODO: Don't Repeat Yourself
        while (!stopGames){
            // TODO Simple refactorings: Exctract repeating code into a method
            mainMenu(allChoices, random);
            stopGames = checkIfGameShouldContinue();
        }
    }

    // TODO Single Level of Abstraction (SLA)
    // TODO IOSP: Diese Methode ist eine Integration, da sie selbst keine Logik beinhaltet, sondern nur Aufrufe
    private  void mainMenu(Choice[] allChoices, Random random){
        System.out.println("-----\n");
        // TODO Simple refactorings: Exctract repeating code into a method
        Choice computerChoice = makeComputerChoice(allChoices,random);
        Choice userChoice = askUserChoice(allChoices);

        System.out.println("The computers choice: "+computerChoice.name());
        System.out.println("Your choice: "+userChoice.name());

        // TODO Simple refactorings: Exctract repeating code into a method
        Winner winner = Winner.determineWinner(userChoice,computerChoice);

        printGameResult(winner);
    }

    // TODO IOSP: Diese Methode ist eine Operation, da sie nur Logik und keine weiteren Aufrufe beinhaltet
    // TODO Principle of Least Astonishment -> enthält keine weitere Logik/Veränderungen außer das printen
    private  void printGameResult(Winner winner){
        if (winner.equals(Winner.DRAW)){
            System.out.println("It was a draw.");
        } else {
            boolean playerWon = winner.equals(Winner.PLAYER);
            System.out.println((playerWon ? "You" : "The computer")+" won.");
            System.out.println(playerWon ? "Congratulations!" : "Better luck next time.");
        }
    }

    private  Choice askUserChoice(Choice[] allChoices){
        Scanner scanner = new Scanner(System.in);
        boolean isValidNumber = false;
        Optional<Choice> userChoice = Optional.empty();

        while (!isValidNumber){
            System.out.println("Please make a choice between these options:");

            listAllPossibleChoices(allChoices);

            String userChoiceString = scanner.nextLine();
            // TODO Tell, don't ask: Statt zu fragen, ob die Auswahl valide ist, such mir das passende Enum dazu raus
            userChoice = Choice.getChoiceForValue(userChoiceString);
            isValidNumber = userChoice.isPresent();
        }

        return userChoice.get();
    }

    // TODO IOSP: Diese Methode ist eine Operation, da sie nur Logik und keine weiteren Aufrufe beinhaltet
    // TODO Principle of Least Astonishment -> enthält keine weitere Logik/Veränderungen außer das printen
    private  void listAllPossibleChoices(Choice[] allChoices){
        for (int i = 1; i <= allChoices.length; i++){
            System.out.println(i + " " +allChoices[i-1].toString());
        }

    }

    // TODO IOSP: Diese Methode ist eine Operation, da sie nur Logik und keine weiteren Aufrufe beinhaltet
    // TODO Keep it simple, stupid als Alternative für random.nextInt
    // TODO Principle of Least Astonishment -> enthält keine weitere Logik/Veränderungen außer das printen
    private  Choice makeComputerChoice(Choice[] allChoices, Random random) {
        int number = random.nextInt(3);

        return allChoices[number];
    }

    // TODO IOSP: Diese Methode ist eine Operation, da sie nur Logik und keine weiteren Aufrufe beinhaltet
    // TODO Principle of Least Astonishment -> enthält keine weitere Logik/Veränderungen außer das printen
    private  boolean checkIfGameShouldContinue(){
        System.out.println("\nDo you want to play again? Y/N");

        Scanner scanner = new Scanner(System.in);
        String anotherGameString = scanner.nextLine();

        // TODO Keep it simple, stupid -> if-else hätte man vereinfachen können gegen Leserlichkeit
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
