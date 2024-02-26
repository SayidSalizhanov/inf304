package ru.itis.inf304.lab32;

public class Set<T> implements ISet<T> {
    private int size;
    private Object[] array = new Object[0];

    @Override
    public void add(T e) {
        if (contains(e)) System.out.println("Этот элемент уже есть");
        else {
            size++;
            Object[] copy = new Object[size];
            System.arraycopy(array, 0, copy, 0, size - 1);
            array = copy;

            array[size - 1] = e;
        }
    }

    @Override
    public List304ImplAsLinkedList<T> asList() {
        List304ImplAsLinkedList<T> list = new List304ImplAsLinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add((T)array[i]);
        }
        return list;
    }

    @Override
    public void delete(T e) {
        boolean isElementInArray = false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                isElementInArray = true;
                for (int j = i; j < size - 1; j++) array[j] = array[j + 1];
                break;
            }
        }
        if (!isElementInArray) System.out.println("Такого элемента нет");
        size--;
    }

    @Override
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(array[i])) return true;
        }
        return false;
    }
}
