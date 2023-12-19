package ru.itis.inf304.lab21;

public class Something extends Creature {
    public Something(String name) {
        this.name = name;
    }
    @Override
    public Point move() {
        currentPosition = new Point(((int)(Math.random() * 1001)), ((int)(Math.random() * 1001)));
        return currentPosition;
    }

}