package ru.itis.inf304.lab32;

public class Element<T> {
    public T value;
    public Element<T> next;
    public Element(T value) {
        this.value = value;
    }
    public void listPrint() {
        System.out.println(value);
        Element<T> current = next;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
