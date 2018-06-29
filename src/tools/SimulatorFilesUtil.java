package tools;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimulatorFilesUtil {

    public static String fileToString(String filePath) {
        StringBuilder fileString = new StringBuilder();
        try {
            Path path = Paths.get(filePath);
            InputStream inputStream = Files.newInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
                fileString.append(line).append('\n');
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return fileString.toString();
    }
}