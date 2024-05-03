package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class Project extends AbstractWorkClass {
    @Override
    public void run() {
        while (!arrayForSynchronization[0]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start Проект");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End Проект");
        arrayForSynchronization[1] = true;
    }
}
