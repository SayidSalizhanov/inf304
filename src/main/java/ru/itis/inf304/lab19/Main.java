package ru.itis.inf304.lab19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Element[] elementsArray = input(in);

        bubbleSort(elementsArray);

        output(elementsArray[0]);
    }

    public static Element[] input(Scanner in) {
        System.out.println("Сколько элементов вы хотите отсортировать:");
        int n = in.nextInt();
        in.nextLine();

        //массив элементов, с которым будет проводиться основная работа
        Element[] arr = new Element[n];

        // заполнение массива
        System.out.println("Введите элементы строго через пробел:");
        String ElementsArray = in.nextLine();
        String[] str = ElementsArray.split(" ");
        for (int i = 0; i < n; ++i) {
            arr[i] = new Element(Integer.parseInt(str[i]));
        }

        arr[0].prev = null;

        // присваивание ссылок на предыдущие и следующие элементы
        for (int i = 0; i < arr.length - 1; ++i) {
            arr[i].next = arr[i + 1];
            arr[i + 1].prev = arr[i];
        }

        arr[arr.length - 1].next = null;

        return arr;
    }

    public static int compare(Element e1, Element e2) {
        return (e1.value - e2.value);
    }

    // смена ссылок элементов, вещественно в массиве они не меняются
    public static void swapLinks(Element e2, Element e3) {
        // норм элементы
        if (e2.prev != null & e3.next != null) {
            e2.next = e3.next;
            Element temp = e2.prev;
            e2.prev = e3;
            e3.prev = temp;
            temp.next = e3;
            e3.next.prev = e2;
            e3.next = e2;

        // последний элемент, содержащий ссылку на ничего
        } else if (e3.next == null) {
            e2.next = null;
            Element temp = e2.prev;
            e2.prev = e3;
            e3.prev = temp;
            temp.next = e3;
            e3.next = e2;

        // первый элемент, выходящий из ничего
        } else if (e2.prev == null) {
            e2.next = e3.next;
            e2.prev = e3;
            e3.prev = null;
            e3.next.prev = e2;
            e3.next = e2;
        }
    }

    // смена элементов в массиве поиндексно (вещественно)
    public static void swapElementsInArray(Element[] sortArr, int k1, int k2) {
        Element temp = sortArr[k1];
        sortArr[k1] = sortArr[k2];
        sortArr[k2] = temp;
    }

    public static void output(Element e1) {
        System.out.println("Отсортированные элементы в порядке возрастания:");;
        Element current = e1;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static void bubbleSort(Element[] sortArr) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (compare(sortArr[j], sortArr[j + 1]) > 0) {
                    swapLinks(sortArr[j], sortArr[j + 1]);
                    swapElementsInArray(sortArr, j, j + 1);
                }
            }
        }
    }
}