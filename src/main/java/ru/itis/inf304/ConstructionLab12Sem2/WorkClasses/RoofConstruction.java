package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class RoofConstruction extends AbstractWorkClass {
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
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End возведение крыши");
        arrayForSynchronization[7] = true;
    }
}
