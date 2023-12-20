package ru.itis.inf304.lab28;

public class Roof extends Stage {
    public int square;

    public Roof(int square) {
        this.square = square;
    }

    public Roof() {
        this.square = 0;
    }

    public Roof(Status status) {
        this.status = status;
    }
}