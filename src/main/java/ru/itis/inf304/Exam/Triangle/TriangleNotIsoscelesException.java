package ru.itis.inf304.Exam.Triangle;

public class TriangleNotIsoscelesException extends Exception {
    public TriangleNotIsoscelesException() {
        super("Введенные значения не могут являться параметрами равнобедренного треугольника");
    }
}
