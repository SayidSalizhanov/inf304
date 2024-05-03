package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class ConstructionOfTheFoundation extends AbstractWorkClass {
    long duration = 14;

    @Override
    public void run() {
        while (!arrayForSynchronization[1]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start возведение фундамента");
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End возведение фундамента");
        arrayForSynchronization[4] = true;
    }
}
