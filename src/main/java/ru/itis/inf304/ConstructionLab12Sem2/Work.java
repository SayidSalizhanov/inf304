package ru.itis.inf304.ConstructionLab12Sem2;

import ru.itis.inf304.ConstructionLab12Sem2.TeamsOfWorkers.*;
import ru.itis.inf304.ConstructionLab12Sem2.WorkClasses.*;

public class Work {
    public static void main(String[] args) {

        AbstractWorkClass[] workList = new AbstractWorkClass[]{
                new BeginningOfWork(),
                new Project(),
                new WindowManufacturing(),
                new DoorManufacturing(),
                new ConstructionOfTheFoundation(),
                new LayingCommunications(),
                new Walling(),
                new RoofConstruction(),
                new WindowInstallation(),
                new DoorInstallation(),
                new InstallationOfHeatingDevices(),
                new ElectricalWiring(),
                new WallAndCeilingDecoration(),
                new FloorFinishing(),
                new InstallationOfLightingFixtures(),
                new PlumbingInstallation(),
                new CompletionOfConstruction()
        };

        for (int i = 0; i < 16; i++) {
            new Thread(workList[i]).start();
        }

        //последний поток запускаем отдельно
        Thread resultThreads = new Thread(workList[16]);
        resultThreads.start();

        // ждем его выполнения
        try {
            resultThreads.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int duration = workList[16].getCountDay();
        System.out.println("\nКоличество дней работы: " + duration);

        System.out.println("\nБригады:\n");


        AbstractTeamOfWorkersClass[] teams = new AbstractTeamOfWorkersClass[]{
                new Bricklayers(),
                new Carpenters(),
                new Electricians(),
                new Plasterers(),
                new Plumbers()
        };

        for (AbstractTeamOfWorkersClass team : teams) {
            System.out.println(team.name() + " проиграли в домино: " + team.numberDominoDays(workList) + " дней");
        }
    }
}
