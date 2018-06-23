package tools;

import java.util.Random;

public class Generator {
    public static int getRandomId()
    {
        int randomID;
        Random rand = new Random();
        randomID = (rand.nextInt(1000)) + 1;
        return randomID;
    }
}
