package ru.itis.inf304.lab24;

import javax.swing.*;

public class MainPlotFunction {
    public static void main(String[] args) {

//        new PlotFunction();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlotFunction(new LineFunction());
            }
        });
    }
}
