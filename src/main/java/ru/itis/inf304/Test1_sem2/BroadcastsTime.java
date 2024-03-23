package ru.itis.inf304.Test1_sem2;

public class BroadcastsTime implements Comparable {
    private byte hour;
    private byte minutes;
    private Integer allMinutes;

    public BroadcastsTime(String time){
        String[] timeStringFormat = time.split(":");
        hour = Byte.parseByte(timeStringFormat[0]);
        minutes = Byte.parseByte(timeStringFormat[1]);
        this.allMinutes = hour * 60 + minutes;
    }

    @Override
    public int compareTo(Object o) {
        return getAllMinutes().compareTo(((BroadcastsTime) o).getAllMinutes());
    }

    public boolean after(BroadcastsTime o) {
        return (o.getAllMinutes()  - getAllMinutes()) < 0;
    }
    public boolean before(BroadcastsTime o) {
        return (o.getAllMinutes()  - getAllMinutes()) > 0;
    }
    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        if (t1.getAllMinutes() <= t2.getAllMinutes()) return getAllMinutes() >= t1.getAllMinutes()
                && getAllMinutes() <= t2.getAllMinutes();
        return getAllMinutes() <= t1.getAllMinutes()
                && getAllMinutes() >= t2.getAllMinutes();
    }

    public byte getHour() {
        return hour;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }

    public byte getMinutes() {
        return minutes;
    }

    public void setMinutes(byte minutes) {
        this.minutes = minutes;
    }

    public Integer getAllMinutes() {
        return allMinutes;
    }

    public void setAllMinutes(Integer allMinutes) {
        this.allMinutes = allMinutes;
    }

    @Override
    public String toString() {
        return "BroadcastsTime{" +
                "hour=" + hour +
                ", minutes=" + minutes +
                ", allMinutes=" + allMinutes +
                '}';
    }
}
