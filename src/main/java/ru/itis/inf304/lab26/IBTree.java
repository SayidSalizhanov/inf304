package ru.itis.inf304.lab26;

public interface IBTree {
    void siftUp(Node node);
    void siftDown(Node node);
    void add(int value);
    int popRoot();
}