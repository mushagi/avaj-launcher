package simulator.logging;

import java.util.logging.Logger;

public class SimulatorLogger {
    private static final FileLogging fileLogging = FileLogging.getInstance();
    private static final Logger logger = Logger.getGlobal();

    public static void log(String message)
    {
        fileLogging.writeToFile(message);
        logger.info(message);
    }

    public static void logToScreen(String message)
    {
        logger.info(message);
    }

    public static void closeFile()
    {
        fileLogging.closeFile();
    }
}