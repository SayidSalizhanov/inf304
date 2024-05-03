package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class InstallationOfLightingFixtures extends AbstractWorkClass {
    @Override
    public void run() {
        while (!arrayForSynchronization[12]) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start установка осветительных приборов");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End установка осветительных приборов");
        arrayForSynchronization[14] = true;
    }
}
