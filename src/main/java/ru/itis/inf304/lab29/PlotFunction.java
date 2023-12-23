package ru.itis.inf304.lab29;

import javax.swing.*;
import java.awt.*;

public class PlotFunction extends JFrame {

    private IFunction function;

    private static final int HEIGHT = 800;
    private static final int WIDTH = 800;

    public PlotFunction(IFunction function) {
        super("График функции");
        this.function = function;

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.repaint();
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0, 0, 0));

        Font currentFont = g2d.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 3F);
        g2d.setFont(newFont);

//        g2d.drawString("Хромосома", 50, 500);

        for (int i = 0; i < WIDTH; ++i) {
            g2d.fillRect(i, HEIGHT - 400, 1, 2);
            if (i % 10 == 0) {
                for (int j = 0; j < 6; ++j) {
                    g2d.fillRect(i, HEIGHT - 400 + 3 - j, 2, 1);
                }
            }
        }

        for (int i = 0; i < WIDTH; ++i) {
            g2d.fillRect(400, i, 2, 1);
            if (i % 10 == 0) {
                for (int j = 0; j < 6; ++j) {
                    g2d.fillRect(400 - 2 + j, i, 1, 2);
                }
            }
        }

        g2d.setColor(new Color(255, 0, 0));
        double k = 0;
        for (double i = 0; i < 56.52; i+=0.01) {
            k+=0.1;
            g2d.fillRect((int)(function.calculateForX(k, i)) + 400, HEIGHT - (int)(function.calculateForY(k, i)) - 400, 3, 3);
        }
    }
}