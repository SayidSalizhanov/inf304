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
        Thread resultThread = new Thread(workList[16]);
        resultThread.start();

        // ждем его выполнения
        try {
            resultThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int duration = workList[16].getCountDay();
        System.out.println("\nКоличество дней работы: " + duration);

        // время выполнение всего проекта без учета разработки проекта
        long durationForTeams = duration - workList[1].getDuration();
        System.out.println("Количество дней работы без учета разработки проекта: " + durationForTeams);


        System.out.println("\nБригады:\n");


        AbstractTeamOfWorkersClass[] teams = new AbstractTeamOfWorkersClass[]{
                new Bricklayers(),
                new Carpenters(),
                new Electricians(),
                new Plasterers(),
                new Plumbers()
        };

        for (AbstractTeamOfWorkersClass team : teams) {
            System.out.println(team.name() + " проиграли в домино: " + team.numberOfDaysOfWork(workList) + " дней");
        }
    }
}
