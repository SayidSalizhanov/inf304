package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class DoorManufacturing extends AbstractWorkClass {
    @Override
    public void run() {
        while (!arrayForSynchronization[1]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start Изготовление дверей");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End Изготовление дверей");
        arrayForSynchronization[3] = true;
    }
}
