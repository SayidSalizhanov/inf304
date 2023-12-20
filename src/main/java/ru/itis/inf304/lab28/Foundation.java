package ru.itis.inf304.lab28;

public class Foundation extends Stage {
    public int volumeOfSoil;

    public Foundation(int volumeOfSoil) {
        this.volumeOfSoil = volumeOfSoil;
    }

    public Foundation() {
        this.volumeOfSoil = 0;
    }

    public Foundation(Status status) {
        this.status = status;
    }
}
