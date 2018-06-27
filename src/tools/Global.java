package tools;

import java.util.Random;

public class Global {

    public static int idCount = 0;

    public static int getRandomId()
    {
        int randomID;
        Random rand = new Random();
        randomID = (rand.nextInt(1000)) + 1;
        return randomID;
    }
}
