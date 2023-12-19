package ru.itis.inf304.lab22;

public class BinTreeElement {
    public int value;
    public BinTreeElement nextLeft;
    public BinTreeElement nextRight;

    public BinTreeElement(int value, BinTreeElement nextLeft, BinTreeElement nextRight) {
        this.value = value;
        this.nextLeft = nextLeft;
        this.nextRight = nextRight;
    }

    public BinTreeElement(int value) {
        this.value = value;
    }

}
