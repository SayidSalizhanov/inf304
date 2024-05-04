package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class BeginningOfWork extends AbstractWorkClass {
    @Override
    public void run() {
        System.out.println("Start Начало работ");
        System.out.println("End Начало работ");
        arrayForSynchronization[0] = true;
    }

    @Override
    protected long getDuration() {
        return 0;
    }

    @Override
    protected int getDayOfBegin() {
        return countDay;
    }

    @Override
    protected int getDayOfEnd() {
        return countDay;
    }
}
