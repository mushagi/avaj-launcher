package exception;

public class InvalidAirCraftType extends  Exception{
    public InvalidAirCraftType() {
        super("The aircraft is invalid. It should be JetPlane, Helicopter or Baloon");
    }
}
