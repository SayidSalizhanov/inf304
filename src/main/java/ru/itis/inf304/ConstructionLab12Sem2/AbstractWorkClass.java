package ru.itis.inf304.ConstructionLab12Sem2;

public abstract class AbstractWorkClass implements Runnable {

    // массив статусов этапов строительства (без этапа с 17 id)
    protected static boolean[] arrayForSynchronization = new boolean[16];

    // количество дней
    protected static int countDay;

    // флаг для начала и остановки подсчета числа дней работы
    protected static boolean isCounting;
    protected void startCounting() {
        isCounting = true;
        Thread countingThread = new Thread(() -> {
            while (isCounting) {
                countDay++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        countingThread.start();
    }

    protected void stopCounting() {
        isCounting = false;
    }

    protected int getCountDay() {
        return countDay;
    }

    abstract protected long getDuration();
    abstract protected int getDayOfBegin();
    abstract protected int getDayOfEnd();
}
