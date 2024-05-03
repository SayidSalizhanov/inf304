package ru.itis.inf304.ConstructionLab12Sem2;

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

        for (AbstractWorkClass cl : workList) {
            new Thread(cl).start();
        }
    }
}
