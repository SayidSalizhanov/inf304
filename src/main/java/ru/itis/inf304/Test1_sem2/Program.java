package ru.itis.inf304.Test1_sem2;

public class Program implements Comparable {
    private String channel;
    private BroadcastsTime time;
    private String name;

    public Program(String channel, BroadcastsTime time, String name) {
        this.channel = channel;
        this.time = time;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public void setTime(BroadcastsTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return getTime().getAllMinutes() - ((Program) o).getTime().getAllMinutes();
    }
}
