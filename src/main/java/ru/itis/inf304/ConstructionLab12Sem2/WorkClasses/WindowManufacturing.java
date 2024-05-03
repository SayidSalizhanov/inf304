package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class WindowManufacturing extends AbstractWorkClass {
    long duration = 1;

    @Override
    public void run() {
        while (!arrayForSynchronization[1]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start Изготовление окон");
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End Изготовление окон");
        arrayForSynchronization[2] = true;
    }
}
