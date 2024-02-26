package ru.itis.inf304.lab31;

//внутренняя структура - массив
public class List304ImplAsArray<T> implements List304<T> {
    private int size;
    private Object[] arr = new Object[1];

    @Override
    public void add(T e) throws EmptyElementException {
        size++;
        if (e == null) throw new EmptyElementException();

        Object[] copy = new Object[size];
        System.arraycopy(arr, 0, copy, 0, size - 1);
        arr = copy;

        arr[size - 1] = e;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size && index < 0) throw new IndexOutOfBoundsException();
        return (T)arr[index];
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
    public T pop() {
        Object ret = arr[size - 1];
        size--;
        return (T)ret;
    }

    public void ArrayToString() throws ArraySizeIsNull {
        if (size == 0) throw new ArraySizeIsNull();
        for (int i = 0; i < size; i++) System.out.print(arr[i] + " ");
    }
}
