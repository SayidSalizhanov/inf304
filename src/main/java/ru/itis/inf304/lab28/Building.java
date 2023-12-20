package ru.itis.inf304.lab28;

public interface Building {
    void start() throws InvalidProjectIsRejected;
    void end(String result);
}
