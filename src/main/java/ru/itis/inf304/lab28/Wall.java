package ru.itis.inf304.lab28;

public class Wall extends Stage {
    public int numOfBricks;

    public Wall(int numOfBricks) {
        this.numOfBricks = numOfBricks;
    }

    public Wall() {
        this.numOfBricks = 0;
    }

    public Wall(Status status) {
        this.status = status;
    }
}
