package app.console;

import simulator.Simulator;
import simulator.exception.InvalidFileExtension;

class Main
{
    public static void main(String[] args) {

        validateArgs(args);
        String file = args[0];

        Simulator simulator = new Simulator();
        simulator.runFromFile(file);
    }

    private static void validateArgs(String[] args) {
        try {
            if (args.length != 1)
                throw new IllegalArgumentException();
            String extension = args[0].trim();
            extension = extension.substring(extension.lastIndexOf('.'));
            if (!extension.equals(".txt"))
                throw new InvalidFileExtension();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Usage:\n    ./avaj_launcher [FILENAME]");
            System.exit(1);
        }
        catch (InvalidFileExtension e)
        {
            System.out.println("Invalid extension. It should be at .txt");
            System.exit(1);
        }
    }
}
