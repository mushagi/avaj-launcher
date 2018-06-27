package model;

import tools.Global;

public class Aircraft {

    private long _id;
    private String _name;
    private Coordinate _coordinate;
    private long _idCounter;
    private String _type;

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public long nextID() {
        _idCounter = ++Global.idCount;
        return _idCounter;
    }

    public Aircraft(String _name, Coordinate _coordinate) {
        this._name = _name;
        this._coordinate = _coordinate;
        _id = nextID();
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

    public void set_name(String _name) {
        this._name = _name;
    }

    public long get_idCounter() {
        return _idCounter;
    }
}