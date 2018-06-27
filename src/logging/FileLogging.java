package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogging {

    private final String filePath;
    private final PrintWriter printWriter;

    public FileLogging(String filePath) {

        this.filePath = filePath;
        this.printWriter = createFileReader();
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
