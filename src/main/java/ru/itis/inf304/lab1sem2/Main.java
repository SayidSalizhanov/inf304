package ru.itis.inf304.lab30sem2;

public class Main {
    public static void main(String[] args) {
        List304ImplAsArray array = new List304ImplAsArray();
        try {
            array.add(5);
            array.add(7);
            array.add(8);
            array.add(9);
            array.ArrayToString();
            System.out.print("\n");
            Integer n = array.get(1);
            int size = array.size();
            System.out.println(n + " " + size);
            array.delete(0);
            System.out.println(array.get(0));
            System.out.println(array.size());
            Integer p = array.pop();
            System.out.println(p);
            array.ArrayToString();
        }
        catch (EmptyElementException e) {
            System.err.println("Нельзя добавить ничто");
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("В массиве нет элемента с таким индексом");
        }
        catch (ArraySizeIsNull e) {
            System.err.println("Длина массива равна нулю");
        }

        System.out.println();
        System.out.println("-");
        System.out.println("List");
        System.out.println("-");

        List304ImplAsLinkedList list = new List304ImplAsLinkedList();
        try {
            list.add(5);
            list.add(7);
            list.add(8);
            list.add(9);
            list.ListToString();
            System.out.print("\n");
            Integer n = list.get(1);
            int size = list.size();
            System.out.println(n + " " + size);
            list.delete(0);
            System.out.println(list.get(0));
            System.out.println(list.size());
            Integer p = list.pop();
            System.out.println(p);
            list.ListToString();
        }
        catch (EmptyElementException e) {
            System.err.println("Нельзя добавить ничто");
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("В массиве нет элемента с таким индексом");
        }
        catch (ListSizeIsNull e) {
            System.err.println("Длина списка равна нулю");
        }
    }
}
