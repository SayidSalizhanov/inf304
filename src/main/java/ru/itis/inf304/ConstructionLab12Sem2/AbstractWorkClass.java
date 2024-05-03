package ru.itis.inf304.ConstructionLab12Sem2;

public abstract class AbstractWorkClass implements Runnable {
    // массив статусов этапов строительства (без этапа с 17 id)
    protected static boolean[] arrayForSynchronization = new boolean[16];
}
