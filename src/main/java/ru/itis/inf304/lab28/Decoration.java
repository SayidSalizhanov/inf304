package ru.itis.inf304.lab28;

public class Decoration extends Stage {
    public int cost;

    public Decoration(int cost) {
        this.cost = cost;
    }

    public Decoration() {
        this.cost = 0;
    }

    public Decoration(Status status) {
        this.status = status;
    }
}
