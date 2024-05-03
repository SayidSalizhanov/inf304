package ru.itis.inf304.ConstructionLab12Sem2.WorkClasses;

import ru.itis.inf304.ConstructionLab12Sem2.AbstractWorkClass;

public class CompletionOfConstruction extends AbstractWorkClass {
    @Override
    public void run() {
        while (true) {
            boolean flag = true;
            for (boolean b : arrayForSynchronization) {
                flag = b && flag;
            }
            if (flag) break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Start завершение строительства");
        System.out.println("End завершение строительства");

        // заканчиваем подсчет дней и выводим
        stopCounting();
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
