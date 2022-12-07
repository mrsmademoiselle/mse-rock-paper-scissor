package constants;

import java.util.Optional;

// TODO Separation of Concerns
// TODO Single Responsibility Principle -> Ich kenne nur meine eigenen Werte und kann dir sagen, ob dein Wert einer davon ist
public enum Choice {
    // TODO Open Closed Principle: für Erweiterungen öffnen, für Veränderungen schließen
    ROCK(Hierarchy.HIERARCHY_0),
    PAPER(Hierarchy.HIERARCHY_1),
    SCISSOR(Hierarchy.HIERARCHY_2);

    // TODO Information Hiding Principle
    private final int hierarchy; // each choice has a hierarchy that overrides another. For example: paper (1) overrides rock (0)

    Choice(final int hierarchy) {
        this.hierarchy = hierarchy;
    }

    public int getHierarchy() {
        return hierarchy;
    }

    // TODO Keep it simple, stupid -> User-Input ist eine Zahl von 1-3, die dem hierarchy Wert entspricht
    public static Optional<Choice> getChoiceForValue(String userChoice){
        Optional<Choice> result = Optional.empty();
        if (userChoice.matches("\\d")){
            int userChoiceAsIndex = Integer.parseInt(userChoice) - 1;

            for (Choice choice : Choice.values()){
                if (choice.getHierarchy() == userChoiceAsIndex){
                    return Optional.of(choice);
                }
            }
        }
      return result;
    }

}
