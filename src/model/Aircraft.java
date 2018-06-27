package model;

import tools.Global;

public class Aircraft {

    private final long _id;
    private final String _name;
    private final Coordinate _coordinate;
    private static long _idCounter;
    private String _type;
    private boolean landed;

    public Aircraft(String _name, Coordinate _coordinate) {
        this._name = _name;
        this._coordinate = _coordinate;
        _id = nextID();
        landed = false;
    }

    public boolean isLanded() {
        return landed;
    }

    public String get_type() {
        return _type;
    }

    void setLanded() {
        this.landed = true;
    }

    void set_type(String _type) {
        this._type = _type;
    }

    private long nextID() {
        _idCounter = ++Global.idCount;
        return _idCounter;
    }

    public long get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public Coordinate get_coordinate() {
        return _coordinate;
    }

    public long get_idCounter() {
        return _idCounter;
    }
}