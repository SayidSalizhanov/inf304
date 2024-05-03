package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class PlumbingInstallation extends AbstractWorkClass {
    long duration = 2;

    @Override
    public void run() {
        while (!arrayForSynchronization[5] || !arrayForSynchronization[11] || !arrayForSynchronization[12]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start установка сантехники");
        try {
            Thread.sleep(1000 * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End установка сантехники");
        arrayForSynchronization[15] = true;
    }
}
