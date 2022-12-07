
/**
 * Still missing:
 *
 * Boy Scout
 * Daily Reflection
 * -- Root Cause Analysis -> Beispiel Tests rot weil falsche Reihenfolge
 * Favor Composition over Inheritance
 * Beware of Premature Optimization
 * Issue Tracking
 * Automated Integrationtests
 * Read, Read, Read
 * Reviews
 * Automated Unittests
 * Mockups
 * -- Code Coverage Analysis
 * Participation in professional Events
 * Complex Refactorings
 * Tell, don't ask
 * Continuous Integration
 * Continuous Delivery
 * Statical Code Analysis
 * ? Inversion of Control Container
 * Share Experience
 * Error Measurement
 * Design before Implementation
 * You ain't gonna need it
 * Iterative Development
 * Incremental Development
 * Component Orientation
 */

// ÜBERALL:
// TODO Law of demeter: Don't talk so strangers, only use associated classes/functions/fieldsS
// TODO Version Control System durch Git
// TODO Source Code Conventions: Namensregelungen, Kommentare, Variablennamen
// TODO Principle of Least Astonishment: Es gibt keine/kaum Überraschungen, Methoden machen das, was man von ihnen erwartet
// TODO Information Hiding Principle (alles private außer startGame())
// TODO You ain't gonna need it: Fancy UI, more classes/services/abstractions would just make it less comprehensible

public class RockPaperScissor {

    // TODO IOSP: Diese Methode ist eine Integration, da sie selbst keine Logik beinhaltet, sondern nur Aufrufe
    public static void main(String[] args){

        // TODO: Separation of Concerns - Ich kümmere mich um Startup, GameService kümmert sich um den Spielablauf
        // TODO: Single Responsibility Principle
        GameService gameService = new GameService();
       gameService.startGame();
    }

}
