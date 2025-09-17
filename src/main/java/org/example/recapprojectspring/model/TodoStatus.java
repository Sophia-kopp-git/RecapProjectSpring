package org.example.recapprojectspring.model;

public enum TodoStatus {
    OPEN("Open"),
    DOING("Doing"),
    DONE("Done");

    private String value;

    TodoStatus(String value) {
        this.value = value;
    }
}
