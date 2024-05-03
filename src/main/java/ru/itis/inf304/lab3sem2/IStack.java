package ru.itis.inf304.lab32;

public interface IStack<T> {
    void pop() throws StackSizeIsNull; // снять вершину
    void push(T e); // положить на верх
    int size(); // вернуть размер
}
