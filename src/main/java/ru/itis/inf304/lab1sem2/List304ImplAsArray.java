package ru.itis.inf304.lab30sem2;

//внутренняя структура - массив
public class List304ImplAsArray implements List304 {
    private int size;
    private Integer[] arr = new Integer[1];

    @Override
    public void add(Integer e) throws EmptyElementException {
        size++;
        if (e == null) throw new EmptyElementException();

        Integer[] copy = new Integer[size];
        System.arraycopy(arr, 0, copy, 0, size - 1);
        arr = copy;

        arr[size - 1] = e;
    }

    @Override
    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index >= size && index < 0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index >= size && index < 0) throw new IndexOutOfBoundsException();

        for (int i = index; i < size - 1; i++) arr[i] = arr[i + 1];
        size--;
    }

    @Override
    public Integer pop() {
        Integer ret = arr[size - 1];
        size--;
        return ret;
    }

    public void ArrayToString() throws ArraySizeIsNull {
        if (size == 0) throw new ArraySizeIsNull();
        for (int i = 0; i < size; i++) System.out.print(arr[i] + " ");
    }
}
