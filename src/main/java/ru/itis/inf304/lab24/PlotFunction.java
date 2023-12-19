package ru.itis.inf304.lab24;

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

        g2d.drawString("Хромосома", 50, 500);

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

        for (int i = 1; i < WIDTH; ++i) {
            g2d.fillRect(i + 390, HEIGHT - (int)function.calculate(i) - 400, 3, (int)function.calculate(i) - (int)function.calculate(i - 1) + 2);
        }

        g2d.setColor(new Color(0, 255, 0));

        for (int i = 1; i < WIDTH; ++i) {
            g2d.fillRect(WIDTH - i - 391, HEIGHT - (int)function.calculate(i) - 400, 3, (int)function.calculate(i) - (int)function.calculate(i - 1) + 2);
        }

        g2d.setColor(new Color(0, 255, 0));

        for (int i = 1; i < WIDTH; ++i) {
            g2d.fillRect(i + 390, (int)function.calculate(i) + 400, 3, (int)function.calculate(i) - (int)function.calculate(i - 1) + 2);
        }

        g2d.setColor(new Color(255, 0, 0));

        for (int i = 1; i < WIDTH; ++i) {
            g2d.fillRect(WIDTH - i - 391, (int)function.calculate(i) + 400, 3, (int)function.calculate(i) - (int)function.calculate(i - 1) + 2);
        }
    }
}
