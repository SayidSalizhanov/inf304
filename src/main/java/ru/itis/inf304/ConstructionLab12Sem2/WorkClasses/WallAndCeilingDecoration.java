package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class WallAndCeilingDecoration extends AbstractWorkClass {
    @Override
    public void run() {
        while (!arrayForSynchronization[8] || !arrayForSynchronization[9] || !arrayForSynchronization[11]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start отделка стен и потолка");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End отделка стен и потолка");
        arrayForSynchronization[12] = true;
    }
}
