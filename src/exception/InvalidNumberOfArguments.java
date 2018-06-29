package exception;

public class InvalidNumberOfArguments extends Exception {
    public InvalidNumberOfArguments(int number) {
        super("Invalid number of arguments in a flyable string. There should be 5 arguments, but " + number + " was found.");
    }
}
