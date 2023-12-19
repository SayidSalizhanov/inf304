package ru.itis.inf304.lab22;

import java.util.Scanner;

public class Element {
    public Element next;
    public int value;

    public Element(int value, Element next) {
        this.next = next;
        this.value = value;
    }
}
