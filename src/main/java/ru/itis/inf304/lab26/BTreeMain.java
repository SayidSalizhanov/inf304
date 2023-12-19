package ru.itis.inf304.lab26;

public class BTreeMain {
    public static void main(String[] args) {
        int[] inputArray = {2,12,3,0,15,6,21,-4};

        BTree bTree = new BTree();

        for (int n : inputArray) {
            bTree.add(n);
        }
    }
}
