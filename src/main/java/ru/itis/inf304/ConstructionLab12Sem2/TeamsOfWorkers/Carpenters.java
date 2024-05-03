package ru.itis.inf304.ConstructionLab12Sem2.TeamsOfWorkers;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractTeamOfWorkersClass;

public class Carpenters extends AbstractTeamOfWorkersClass {
    public Carpenters() {
        this.addiction = new int[]{2,3,7,8,9};
    }

    @Override
    public String name() {
        return "Плотники";
    }
}
