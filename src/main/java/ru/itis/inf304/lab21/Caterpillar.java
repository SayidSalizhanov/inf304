package ru.itis.inf304.lab21;

public class Caterpillar extends Creature {
    public Caterpillar(String name) {
        this.name = name;
    }
    @Override
    public Point move() {
        int direction = (int)(Math.random() * 3);
        if (currentPosition == null) init();
        switch (direction) {
            case 0:
                if (currentPosition.getRow() == 1000) break;
                currentPosition.setRow(currentPosition.getRow() + 1);
                break;
            case 1:
                if (currentPosition.getColumn() == 1000) break;
                currentPosition.setColumn(currentPosition.getColumn() + 1);
                break;
            case 2:
                if (currentPosition.getRow() == 0) break;
                currentPosition.setRow(currentPosition.getRow() - 1);
                break;
        }
        return currentPosition;
    }
}
