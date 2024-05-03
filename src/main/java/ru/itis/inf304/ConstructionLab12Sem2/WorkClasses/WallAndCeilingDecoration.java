package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class WallAndCeilingDecoration extends AbstractWorkClass {
    long duration = 7;
    int dayOfBegin;
    int dayOfEnd;

    @Override
    public void run() {
        while (!arrayForSynchronization[8] || !arrayForSynchronization[9] || !arrayForSynchronization[11]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start отделка стен и потолка");
        dayOfBegin = getCountDay();
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End отделка стен и потолка");
        dayOfEnd = getCountDay();
        arrayForSynchronization[12] = true;
    }

    @Override
    protected long getDuration() {
        return duration;
    }

    @Override
    protected int getDayOfBegin() {
        return dayOfBegin;
    }

    @Override
    protected int getDayOfEnd() {
        return dayOfEnd;
    }
}
