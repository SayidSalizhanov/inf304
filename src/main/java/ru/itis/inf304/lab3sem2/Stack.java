package ru.itis.inf304.lab32;
public class Stack<T> implements IStack<T> {
    private int size;
    private Element<T> stack;

    @Override
    public void pop() throws StackSizeIsNull {
        if (size == 0) throw new StackSizeIsNull();
        if (size == 1) stack = null;
        else {
            stack = stack.next;
        }
        size--;
    }

    @Override
    public void push(T e) {
        if (size == 0) stack = new Element<>(e);
        else {
            Element<T> newEl = new Element<>(e);
            newEl.next = stack;
            stack = newEl;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    public void stackPrint() {stack.listPrint();}
}

