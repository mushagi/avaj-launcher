import simulator.Simulator;
import exception.InvalidFileExtension;

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
            System.out.println("Usage : \n  ./avaj_launcher [FILENAME] ");
            e.printStackTrace();
            System.exit(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
