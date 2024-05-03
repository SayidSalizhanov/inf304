package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class InstallationOfHeatingDevices extends AbstractWorkClass {
    @Override
    public void run() {
        while (!arrayForSynchronization[5] || !arrayForSynchronization[8] || !arrayForSynchronization[9]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start установка отопительных приборов");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End установка отопительных приборов");
        arrayForSynchronization[10] = true;
    }
}
