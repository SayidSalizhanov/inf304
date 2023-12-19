package ru.itis.inf304.lab20;

public class Element {

    public Element prev;
    public Element next;
    public int value;

    public Element(Element prev, Element next, int value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}