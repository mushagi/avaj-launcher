package simulator;

class Aircraft {
    private static int idCounter;
    private final long id;
    private final String name;
    private final Coordinates coordinates;
    private String type;
    private boolean landed;

    Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextID();
        landed = false;
    }

    public boolean isLanded() {
        return landed;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    void hasLanded() {
        this.landed = true;
    }

    private long nextID() {
        return ++idCounter;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}