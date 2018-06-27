package model;

public class Coordinate {

    private int _latitude;
    private int _height;
    private int _longitude;

    public Coordinate( int _longitude , int _latitude, int _height ) {
        this._latitude = _latitude;
        set_height(_height);
        this._longitude = _longitude;
    }

    public int get_latitude() {
        return _latitude;
    }

    public int get_height() {
        return _height;
    }

    public void set_latitude(int _latitude) {
        this._latitude = _latitude;
    }

    public void set_height(int height) {
        if (height > 100)
            this._height = 100;
        else if (height < 0)
            this._height = 0;
        else
            this._height = height;
    }

    public void set_longitude(int _longitude) {
        this._longitude = _longitude;
    }

    public int get_longitude() {
        return _longitude;
    }
}
