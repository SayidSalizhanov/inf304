package ru.itis.inf304.ConstructionLab12Sem2.TeamsOfWorkers;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractTeamOfWorkersClass;

public class Electricians extends AbstractTeamOfWorkersClass {
    public Electricians() {
        this.addiction = new int[]{5,10,15};
    }

    @Override
    public String name() {
        return "Электрики";
    }
}
