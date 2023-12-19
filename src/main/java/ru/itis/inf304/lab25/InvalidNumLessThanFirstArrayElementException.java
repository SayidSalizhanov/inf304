package ru.itis.inf304.lab25;

public class InvalidNumLessThanFirstArrayElementException extends Exception {
    public InvalidNumLessThanFirstArrayElementException() {
        super("The number must be greater than the first element of the array");
    }
}
