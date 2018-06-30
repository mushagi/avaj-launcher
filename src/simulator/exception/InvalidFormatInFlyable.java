package simulator.exception;

public class InvalidFormatInFlyable extends Exception {
    public InvalidFormatInFlyable(String line, int number) {
        super("There should be 5 arguments, but " + number + " was found"+"\n"+line);
    }
}
