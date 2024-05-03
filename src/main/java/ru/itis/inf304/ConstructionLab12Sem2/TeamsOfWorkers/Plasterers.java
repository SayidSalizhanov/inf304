package ru.itis.inf304.ConstructionLab12Sem2.TeamsOfWorkers;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractTeamOfWorkersClass;

public class Plasterers extends AbstractTeamOfWorkersClass {
    public Plasterers() {
        this.addiction = new int[]{12,13};
    }

    @Override
    public String name() {
        return "Штукатуры";
    }
}
