package ru.itis.inf304.lab28;

public class InvalidProjectIsRejected extends Exception {
    public InvalidProjectIsRejected() {
        super("Проект забракован, стройка закрыта");
    }
}
