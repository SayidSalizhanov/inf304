package ru.itis.inf304.lab32;

public class Main {
    public static void main(String[] args) throws StackSizeIsNull {
        Set<Integer> set = new Set<>();
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.asList().listToString();
        System.out.println();
        set.delete(6);
        set.asList().listToString();

        System.out.print("\n\n");
        System.out.print("Stack");
        System.out.print("\n\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.stackPrint();
        System.out.println();
        stack.pop();
        stack.stackPrint();
    }
}
