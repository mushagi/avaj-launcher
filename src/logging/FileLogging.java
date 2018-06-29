package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogging {
    private String filePath;

    private final PrintWriter printWriter;
    private static FileLogging fileLogging;

    public FileLogging(String filePath) {
        this.filePath = filePath;
        this.printWriter = createFileReader();
    }

    public static FileLogging getInstance()
    {
        if (fileLogging == null)
            fileLogging = new FileLogging("simulation.txt");
        return fileLogging;
    }

    public void writeToFile(String data) {
        printWriter.println(data);

    }
    public void closeFile() {
        printWriter.close();
    }

    private PrintWriter createFileReader() {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            return new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
