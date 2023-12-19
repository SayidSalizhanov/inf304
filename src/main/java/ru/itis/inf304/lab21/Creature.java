package ru.itis.inf304.lab21;

public abstract class Creature implements Printable, Moveable {
    protected String name;

    protected Point currentPosition;

    public void init() {
        currentPosition = new Point(((int)(Math.random() * 1000)), ((int)(Math.random() * 1000)));
    }

    @Override
    public abstract Point move();

    @Override
    public void print() {
        System.out.println(name + " - " + currentPosition.toString());
    }
}