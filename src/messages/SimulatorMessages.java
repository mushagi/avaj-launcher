package messages;

import java.util.*;

public class SimulatorMessages {
    public static SimulatorMessages simulatorMessages;
    private Map<String, ArrayList<String>> messages;

    public static SimulatorMessages getInstance()
    {
        if (simulatorMessages == null)
            return new SimulatorMessages();
        return simulatorMessages;
    }

    public SimulatorMessages() {
        messages = new HashMap<>();
        addMessages();
    }

    public static String getFunnyWeatherMessage(String weather) {
        ArrayList<String> weatherMessages = getInstance().messages.get(weather);
        Random rand= new Random();
        int randomNumber = rand.nextInt(weatherMessages.size());
        return weatherMessages.get(randomNumber);
    }

    private void addMessages() {
        ArrayList<String> sunMessages = new ArrayList<String>(){{
            add("It's sunny");
            add("");
            add("");
        }};

        messages.put("SUN", sunMessages);

        ArrayList<String> rainMessages = new ArrayList<String>(){{
            add("It's rainy");
            add("");
            add("");
        }};
        messages.put("RAIN", rainMessages);

        ArrayList<String> snowMessages = new ArrayList<String>(){{
            add("It's snowy");
            add("");
            add("");
        }};
        messages.put("SNOW", snowMessages);

        ArrayList<String> fogMessages = new ArrayList<String>(){{
            add("It's foggy");
            add("");
            add("");
        }};
        messages.put("FOG", fogMessages);
    }
}
