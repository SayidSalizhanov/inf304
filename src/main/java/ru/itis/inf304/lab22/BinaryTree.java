package ru.itis.inf304.lab22;

import java.util.Scanner;

public class BinaryTree {

    private static final int ARRAY_SIZE = 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите " + ARRAY_SIZE + " целых чисел");
        Element head = new Element(in.nextInt(), null);
        Element current = head;
        for (int i = 1; i < ARRAY_SIZE; ++i) {
            Element next = new Element(in.nextInt(), null);
            current.next = next;
            current = next;
        }

        System.out.println(" ");

        output(head);

        System.out.println(" ");

    }

    public static void output(Element head) {
        Element current = head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static BinTreeElement BinTreeCreate(Element head) {
        BinTreeElement headBin = new BinTreeElement(head.value);
        BinTreeElement currentBin = headBin;
        Element current = head;

        for (int i = 0; i < ARRAY_SIZE - 1; ++i) {
            current = current.next;
            boolean flag = true;

            while (flag) {
                if (current.value > currentBin.value) {
                    if (currentBin.nextRight == null) {
                        currentBin.nextRight = new BinTreeElement(current.value);
                        flag = false;
                    }
                    else {
                        currentBin = currentBin.nextRight;
                    }
                }
                else if (current.value < currentBin.value) {
                    if (currentBin.nextLeft == null) {
                        currentBin.nextLeft = new BinTreeElement(current.value);
                        flag = false;
                    }
                    else {
                        currentBin = currentBin.nextLeft;
                    }
                }
                else flag = false;
            }
        }
        return headBin;
    }

    public static void BinTreeOutput(BinTreeElement head) {

    }
}
