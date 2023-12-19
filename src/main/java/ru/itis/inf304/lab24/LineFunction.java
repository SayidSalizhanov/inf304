package ru.itis.inf304.lab24;

public class LineFunction implements IFunction {
    @Override
    public double calculate(double x) {
        return (0.005 * x * x);
    }
}
