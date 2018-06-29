package simulator;

class Coordinates {
    private int latitude;
    private int height;
    private int longitude;

    Coordinates(int longitude, int latitude, int height) {
        this.latitude = latitude;
        setHeight(height);
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    protected void setHeight(int height) {
        if (height > 100)
            this.height = 100;
        else if (height < 0)
            this.height = 0;
        else
            this.height = height;
    }
}