package ru.itis.inf304.lab18;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Element e1 = input(in);

        System.out.println("На какую позицию вы хотите добавить элемент (начиная с 0)?");
        int position = in.nextInt();

        System.out.println("Введите числовое значение элемента, которое вы хотите добавить?");
        Element newElement = new Element(in.nextInt());

        ElementAddition(e1, position, newElement);

        output(e1);
    }

    public static Element input(Scanner in) {
        System.out.println("Введите 5 целых чисел");
        Element head = new Element(in.nextInt());
        Element current = head;
        for (int i = 1; i < 5; ++i) {
            Element next = new Element(in.nextInt());
            current.next = next;
            current = next;
        }
        return head;
    }

    public static void output(Element e1) {
        System.out.println("Итоговый порядок элементов:");
        Element current = e1;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static void ElementAddition(Element head, int position, Element newElement) {
        int c = 0;
        Element current = head;
        while (current != null) {
            if (c == position - 1) {
                newElement.next = current.next;
                current.next = newElement;


            }
            current = current.next;
            c++;
        }
    }
}