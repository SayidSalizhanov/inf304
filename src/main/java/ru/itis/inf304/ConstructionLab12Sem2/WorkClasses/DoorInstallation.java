package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class DoorInstallation extends AbstractWorkClass {
    long duration = 1;
    int dayOfBegin;
    int dayOfEnd;

    @Override
    public void run() {
        while (!arrayForSynchronization[3] || !arrayForSynchronization[7]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start установка дверей");
        dayOfBegin = getCountDay();
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End установка дверей");
        dayOfEnd = getCountDay();
        arrayForSynchronization[9] = true;
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
