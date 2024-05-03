package ru.itis.inf304.ConstructionLab12Sem2.TeamsOfWorkers;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractTeamOfWorkersClass;

public class Plumbers extends AbstractTeamOfWorkersClass {
    public Plumbers() {
        this.addiction = new int[]{11,14};
    }

    @Override
    public String name() {
        return "Сантехники";
    }
}
