package org.example.recapprojectspring.model;

public enum TodoStatus {
    OPEN("Open"),
    IN_PROGRESS("Doing"),
    DONE("Done");

    private final String value;

    TodoStatus(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
