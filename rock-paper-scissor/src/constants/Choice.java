package constants;

import java.util.Optional;

public enum Choice {
    ROCK(0),
    PAPER(1),
    SCISSOR(2);

    // each choice has a hierarchy that overrides another. For example: paper (1) overrides rock (0)
    private final int hierarchy;

    Choice(final int hierarchy) {
        this.hierarchy = hierarchy;
    }

    public static Optional<Choice> getChoiceForValue(String userChoice){
        Optional<Choice> result = Optional.empty();
        boolean isValidUserChoice = userChoice.matches("\\d");
        if (isValidUserChoice){
            int userChoiceAsIndex = Integer.parseInt(userChoice) - 1;

            for (Choice choice : Choice.values()){
                if (choice.getHierarchy() == userChoiceAsIndex){
                    return Optional.of(choice);
                }
            }
        }
      return result;
    }

    public int getHierarchy() {
        return this.hierarchy;
    }

}
