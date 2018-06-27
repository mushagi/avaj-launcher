package tools;

import logging.FileLogging;

public class Global {

    public static int idCount = 0;
    private static final String LOG_FILE_NAME = "simulation.txt";
    public static final FileLogging fileLogging = new FileLogging(LOG_FILE_NAME);

    public Global()
    {
        idCount = 0;
    }
}
