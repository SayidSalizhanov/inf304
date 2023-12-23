package ru.itis.inf304.lab28;

public class BuildingProcess implements Building{
    public void start() throws InvalidProjectIsRejected {
        StageBuildingList list = new StageBuildingList(Status.REJECTED, Status.COMPLETED, Status.COMPLETED, Status.COMPLETED, Status.COMPLETED);
        if (list.project.stage.status == Status.REJECTED) {
            throw new InvalidProjectIsRejected();
        }
    }

    public void end(String result) {
        System.out.println(result);
    }
}
