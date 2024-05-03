package ru.itis.inf304.lab30sem2;
//внутренняя структура - связанный список
public class List304ImplAsLinkedList implements List304 {
    private int size;
    private Element list;
    @Override
    public void add(Integer e) throws EmptyElementException {
        size++;
        if (e == null) throw new EmptyElementException();


        if (size > 1) {
            int c = 0;
            Element newElement = new Element(e);
            Element current = list;
            while (c < size) {
                if (c == size - 2) {
                    current.next = newElement;
                }
                current = current.next;
                c++;
            }
        }
        else list = new Element(e);
    }

    @Override
    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index >= size && index < 0) throw new IndexOutOfBoundsException();

        int c = 0;
        Element current = list;
        while (c < size) {
            if (c == index) {
                return current.value;
            }
            current = current.next;
            c++;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index >= size && index < 0) throw new IndexOutOfBoundsException();

        int c = 0;

        Element current = list;
        if (index > 0 && index < size - 1) {
            while (c < size) {
                if (c == index - 1) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
                c++;
            }
        }
        else if (index == 0) list = list.next;
        else {
            while (c < size) {
                if (c == index - 1) {
                    current.next = null;
                    break;
                }
                current = current.next;
                c++;
            }
        }
        size--;
    }

    @Override
    public Integer pop() {
        Integer ret = 0;
        int c = 0;
        Element current = list;
        while (c < size) {
            if (c == size - 1) {
                ret = current.value;
                current.next = null;
                break;
            }
            current = current.next;
            c++;
        }
        size--;
        return ret;
    }

    public void ListToString() throws ListSizeIsNull {
        if (size == 0) throw new ListSizeIsNull();
        int c = 0;
        Element current = list;
        while (c < size) {
            System.out.print(current.value + " ");
            current = current.next;
            c++;
        }
    }
}
