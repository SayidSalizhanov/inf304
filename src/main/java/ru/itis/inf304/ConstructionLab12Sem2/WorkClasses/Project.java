package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class Project extends AbstractWorkClass {
    long duration = 7;
    int dayOfBegin;
    int dayOfEnd;

    @Override
    public void run() {

        // начинаем подсчет дней
        startCounting();

        while (!arrayForSynchronization[0]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start Проект");
        dayOfBegin = getCountDay();
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End Проект");
        dayOfEnd = getCountDay();
        arrayForSynchronization[1] = true;
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
