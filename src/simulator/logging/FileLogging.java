package simulator.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

class FileLogging {
    private final String filePath;

    private final PrintWriter printWriter;
    private static FileLogging fileLogging;


    private FileLogging() {
        this.filePath = "simulation.txt";
        this.printWriter = createFileReader();
    }

    static FileLogging getInstance()
    {
        if (fileLogging == null)
            fileLogging = new FileLogging();
        return fileLogging;
    }

    void writeToFile(String data) {
        printWriter.println(data);
    }


    void closeFile() {
        printWriter.close();
    }

    private PrintWriter createFileReader() {
        try {
            File file = new File(filePath);
            Files.deleteIfExists(file.toPath());
            FileWriter fileWriter = new FileWriter(filePath, true);
            return new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
