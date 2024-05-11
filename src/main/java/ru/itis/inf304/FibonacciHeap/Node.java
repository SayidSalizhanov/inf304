package ru.itis.inf304.FibonacciHeap;

public class Node {
    private Integer key;

    private Node parent;

    private Node left = this;

    private Node right = this;

    private Node child;

    private int degree;

    private boolean marked;

    public Node(Integer element) {
        degree = 0;
        setParent(null);
        setChild(null);
        setLeft(this);
        setRight(this);
        setMarked(false);

        this.key = element;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right ) {
        this.right = right;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public int getDegree() {
        return degree;
    }

    public void increaseDegree() {
        degree++;
    }

    public void decreaseDegree() {
        degree--;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked( boolean marked ) {
        this.marked = marked;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer element) {
        this.key = element;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
