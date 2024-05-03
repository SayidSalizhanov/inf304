package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class RoofConstruction extends AbstractWorkClass {
    long duration = 3;
    int dayOfBegin;
    int dayOfEnd;

    @Override
    public void run() {
        while (!arrayForSynchronization[6]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start возведение крыши");
        dayOfBegin = getCountDay();
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End возведение крыши");
        dayOfEnd = getCountDay();
        arrayForSynchronization[7] = true;
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
