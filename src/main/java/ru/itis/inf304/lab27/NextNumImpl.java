package ru.itis.inf304.lab27;

public class NextNumImpl implements NumberOfOrder {
    private Node current;

    @Override
    public int next() {
        current = current.next;
        int result = current.value;
        return result;
    }

    public NextNumImpl() {
        Node root = new Node(1);
        current = root;
        for (int i = 2; i < 11; ++i) {
            current.next = new Node(i);
            current = current.next;
        }
        current.next = root;
    }
}
