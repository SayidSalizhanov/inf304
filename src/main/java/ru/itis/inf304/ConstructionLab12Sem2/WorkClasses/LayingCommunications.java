package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class LayingCommunications extends AbstractWorkClass {
    long duration = 4;

    @Override
    public void run() {
        while (!arrayForSynchronization[4]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start прокладка коммуникаций");
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End прокладка коммуникаций");
        arrayForSynchronization[5] = true;
    }
}
