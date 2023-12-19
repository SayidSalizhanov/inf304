package ru.itis.inf304.lab26;

public class BTree implements IBTree {

    private Node root;

    private int currentLevel = 0;

    private int bufferPosition = 0;

    private int countLevelElements = 0;

    private Node[] currentLevelBuffer;

    private Node[] tempBuffer;

    private int tempBufferPosition = 0;

    private int tempLevel = 0;

    @Override
    public void siftUp(Node node) {

    }

    @Override
    public void siftDown(Node node) {

    }

    @Override
    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            countLevelElements = 1;
            currentLevelBuffer = new Node[1];
            currentLevelBuffer[0] = root;
        } else {
            if (tempBufferPosition == (2 << (currentLevel - 1)) + 1) {
                currentLevelBuffer = tempBuffer;
                tempBuffer = null;
            }
            if (tempBuffer == null) {
                tempBuffer = new Node[2 << currentLevel];
                currentLevel++;
                tempBufferPosition = 0;
                bufferPosition = 0;
            }
            Node node = currentLevelBuffer[bufferPosition];
            Node tmp = new Node(value);
            if (node.left == null) {
                node.left = tmp;
            }
            else {
                node.right = tmp;
                bufferPosition++;
            }
            tempBufferPosition++;
        }
    }

    @Override
    public int popRoot() {
        return 0;
    }
}