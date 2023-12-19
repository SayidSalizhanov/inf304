package ru.itis.inf304.lab25;

public class InvalidNumNonPositiveException extends Exception {
    public InvalidNumNonPositiveException() {
        super("Num should be greater than 0");
    }
}
