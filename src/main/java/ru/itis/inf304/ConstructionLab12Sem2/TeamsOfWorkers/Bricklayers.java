package ru.itis.inf304.ConstructionLab12Sem2.TeamsOfWorkers;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractTeamOfWorkersClass;

public class Bricklayers extends AbstractTeamOfWorkersClass {
    public Bricklayers() {
        this.addiction = new int[]{4,6};
    }

    @Override
    public String name() {
        return "Каменщики";
    }
}
