package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class InstallationOfHeatingDevices extends AbstractWorkClass {
    int duration = 3;
    int dayOfBegin;
    int dayOfEnd;

    @Override
    public void run() {
        while (!arrayForSynchronization[5] || !arrayForSynchronization[8] || !arrayForSynchronization[9]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start установка отопительных приборов");
        dayOfBegin = getCountDay();
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End установка отопительных приборов");
        dayOfEnd = getCountDay();
        arrayForSynchronization[10] = true;
    }

    @Override
    protected int getDuration() {
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
