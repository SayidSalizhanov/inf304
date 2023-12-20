package ru.itis.inf304.lab28;

public class StageBuildingList implements NextStageBuild {
    private Node current;

    public Node project;
    public Node foundation;
    public Node wall;
    public Node roof;
    public Node decoration;

    @Override
    public Stage next() {
        current = current.next;
        return current.stage;
    }

    @Override
    public Stage prev() {
        current = current.prev;
        return current.stage;
    }

    public StageBuildingList(Status projectStatus, Status foundationStatus, Status wallStatus, Status roofStatus, Status decorationStatus) {
        this.project = new Node(new Project(projectStatus));

        this.foundation = new Node(new Foundation(foundationStatus));

        this.wall = new Node(new Wall(wallStatus));

        this.roof = new Node(new Roof(roofStatus));

        this.decoration = new Node(new Decoration(decorationStatus));

        // ссылки
        project.prev = null;
        project.next = foundation;

        foundation.prev = project;
        foundation.next = wall;

        wall.prev = foundation;
        wall.next = roof;

        roof.prev = wall;
        roof.next = decoration;

        decoration.prev = roof;
        decoration.next = null;
    }
}