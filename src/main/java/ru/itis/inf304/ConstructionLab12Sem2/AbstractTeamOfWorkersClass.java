package ru.itis.inf304.ConstructionLab12Sem2;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTeamOfWorkersClass {

    // здесь id процессов, на которые данная бригада приходит
    protected int[] addiction;

    // номера дней, в которые бригады работали
    Set<Integer> workDays = new HashSet<>();

    // Принцип работы метода: берем все классы проектов, на которые бригада должна пойти.
    // В каждом классе берем день начала работ и день конца. Заносим множество чисел с данными границами в Set.
    // Если бригада в какие-то дни работала параллельно на нескольких объектах, на Set это никак не отобразится.
    // Длина Set - количество рабочих дней бригады.
    protected void numberDaysOfWork(AbstractWorkClass[] arrayOfConstructionStages) {
        for (Integer i : addiction) {
            for (int j = arrayOfConstructionStages[i].getDayOfBegin(); j <= arrayOfConstructionStages[i].getDayOfEnd(); j++) {
                workDays.add(j);
            }
        }
    }

    // Берем максимальный рабочий день,
    // вычитаем количество рабочих дней,
    // вычитаем количество дней, потраченных на разработку проекта,
    protected int numberDominoDays(AbstractWorkClass[] arrayOfConstructionStages) {
        numberDaysOfWork(arrayOfConstructionStages);
        return workDays.stream().max(Integer::compareTo).get() - workDays.size() - arrayOfConstructionStages[1].getDuration() + 1;
    }

    abstract public String name();
}
