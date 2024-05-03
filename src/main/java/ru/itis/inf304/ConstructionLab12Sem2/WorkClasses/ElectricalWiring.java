package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class ElectricalWiring extends AbstractWorkClass {
    @Override
    public void run() {
        while (!arrayForSynchronization[5] || !arrayForSynchronization[7]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start прокладка электропроводки");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End прокладка электропроводки");
        arrayForSynchronization[11] = true;
    }
}
