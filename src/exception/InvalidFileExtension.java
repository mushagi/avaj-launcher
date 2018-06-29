package exception;

public class InvalidFileExtension extends Exception {
    public InvalidFileExtension() {
        super("The file extension should be *.txt");
    }
}
