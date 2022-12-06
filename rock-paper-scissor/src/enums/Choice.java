package enums;

import java.util.Optional;

public enum Choice {
    ROCK(0),
    PAPER(1),
    SCISSOR(2);

    private final int value;

    Choice(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Optional<Choice> getChoiceForValue(String userChoice){
        Optional<Choice> result = Optional.empty();
        if (userChoice.matches("\\d")){
            int userValue = Integer.parseInt(userChoice) - 1;

            for (Choice choice : Choice.values()){
                if (choice.getValue() == userValue){
                    return Optional.of(choice);
                }
            }
        }
      return result;
    }

}
