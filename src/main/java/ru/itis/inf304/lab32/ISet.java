package ru.itis.inf304.lab32;

public interface ISet<T> {
    void add(T e); // добавить в конец
    List304ImplAsLinkedList<T> asList(); // вернуть список элементов
    void delete(T e); // удалить по значению
    boolean contains(T e); // содержит ли значение
}
