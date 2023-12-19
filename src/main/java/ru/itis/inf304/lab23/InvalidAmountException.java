package ru.itis.inf304.lab23;

public class InvalidAmountException extends Exception {
    public InvalidAmountException() {
        super("Amount should be greater than 0");
    }
}