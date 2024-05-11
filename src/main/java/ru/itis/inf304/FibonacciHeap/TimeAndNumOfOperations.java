package ru.itis.inf304.FibonacciHeap;

import java.util.List;

public class TimeAndNumOfOperations {
    private long time;
    private int countOfOperations;

    public TimeAndNumOfOperations(long time, int countOfOperations) {
        this.time = time;
        this.countOfOperations = countOfOperations;
    }

    public static TimeAndNumOfOperations averageValues(List<TimeAndNumOfOperations> list) {
        long time = 0;
        int count = 0;

        for (TimeAndNumOfOperations t : list) {
            time += t.getTime();
            count += t.getCountOfOperations();
        }

        return new TimeAndNumOfOperations(time / list.size(), count / list.size());
    }

    @Override
    public String toString() {
        return time + " " + countOfOperations;
    }

    public long getTime() {
        return time;
    }

    public int getCountOfOperations() {
        return countOfOperations;
    }
}
