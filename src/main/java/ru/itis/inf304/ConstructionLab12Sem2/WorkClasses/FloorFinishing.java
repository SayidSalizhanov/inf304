package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class FloorFinishing extends AbstractWorkClass {
    @Override
    public void run() {
        while (!arrayForSynchronization[12]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start отделка пола");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End отделка пола");
        arrayForSynchronization[13] = true;
    }
}
