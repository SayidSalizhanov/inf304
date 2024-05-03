package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class WindowInstallation extends AbstractWorkClass {
    @Override
    public void run() {
        while (!arrayForSynchronization[2] || !arrayForSynchronization[7]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start установка окон");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End установка окон");
        arrayForSynchronization[8] = true;
    }
}
