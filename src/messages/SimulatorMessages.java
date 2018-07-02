package messages;

import java.util.*;

public class SimulatorMessages {
    private static SimulatorMessages simulatorMessages;
    private final Map<String, ArrayList<String>> messages;

    private static SimulatorMessages getInstance()
    {
        if (simulatorMessages == null)
            return new SimulatorMessages();
        return simulatorMessages;
    }

    private SimulatorMessages() {
        messages = new HashMap<>();
        addMessages();
    }

    public static String getFunnyWeatherMessage(String weather) {
        ArrayList<String> weatherMessages = getInstance().messages.get(weather);
        Random rand= new Random();
        int randomNumber = rand.nextInt(weatherMessages.size());
        return "weather: "+weather + ": " +(weatherMessages.get(randomNumber));
    }

    private void addMessages() {
        ArrayList<String> sunMessages = new ArrayList<String>(){{
            add("It's sunny");
            add("OMG, like, whatever, it's so hot, whatever");
            add("And he said, Let there SUN");
            add("My eyes, aaa they burn, so bright");
        }};
        messages.put("SUN", sunMessages);

        ArrayList<String> rainMessages = new ArrayList<String>(){{
            add("It's rainy");
            add("It's raining ");
            add("rain is awesome");
            add("I'm so wet.");
        }};
        messages.put("RAIN", rainMessages);

        ArrayList<String> snowMessages = new ArrayList<String>(){{
            add("It's snowy");
            add("Like, today it's snow and stuff");
	        add("Today's weather forecast: Holy crap i can't feel my face");
	        add("Winter is here. So are the White walkers. But Snow will prevail");
        }};
        messages.put("SNOW", snowMessages);

        ArrayList<String> fogMessages = new ArrayList<String>(){{
            add("It's foggy");
            add("I have been fogged. Hard.");
            add("it's a mystery");
        }};
        messages.put("FOG", fogMessages);
    }
}