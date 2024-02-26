package ru.itis.inf304.lab32;

public interface List304<T> {
    void add(T e);
    T get(int index) throws IndexOutOfBoundsException;
    int size();
    void delete(int index) throws IndexOutOfBoundsException;
    T pop(); //Возвращаем последний элемент и удаляем его из списка
}
