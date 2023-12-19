package ru.itis.inf304.lab23;

public class InvalidTotalScaleException extends Exception {
    public InvalidTotalScaleException(int currentScale, int validScale) {
        super("Total has scale = " + currentScale + " instead of scale = " + validScale);
    }
}
