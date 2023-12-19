package ru.itis.inf304.lab20;

public class MyLinkedList implements MyList {
    private Element current;
    private Element first;
    private Element last;
    private int size;

    @Override
    public void add(int value) {
        Element oldLast = this.last;
        Element newLast = new Element(oldLast, null, value);
        this.last = newLast;
        if (oldLast == null)
            this.first = newLast;
        else
            oldLast.next = newLast;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int next() {
        if (current == null) {
            current = first;
            return current.value;
        }
        current = current.next;
        return current.value;
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    @Override
    public int max() {
        int max = -1000000;
        do {
            int next = next();
            if (compare(max, next) < 0) {
                max = next;
            }
        } while (hasNext());
        return max;
    }

    @Override
    public int min() {
        int min = 1000000;
        do {
            int next = next();
            if (compare(min, next) > 0) {
                min = next;
            }
        } while (hasNext());
        return min;
    }

    @Override
    public int compare(int a, int b) {
        return a - b;
    }

    public void print() {
        Element current = this.first;
        System.out.print(current.value);
        while (current != null) {
            System.out.print(" ");
            System.out.print(current.value);
            current = current.next;
        }
        System.out.println(" ");
    }

}
