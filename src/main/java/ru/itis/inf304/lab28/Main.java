package ru.itis.inf304.lab28;

public class Main {
    public static void main(String[] args) {
        BuildingProcess process = new BuildingProcess();
        try {
            process.start();
            process.end("Стройка завершена успешно");
        }
        catch (InvalidProjectIsRejected e) {
            process.end(e.getMessage());
        }
    }
}
