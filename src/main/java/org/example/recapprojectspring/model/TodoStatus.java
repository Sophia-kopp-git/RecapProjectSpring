package org.example.recapprojectspring.model;

public enum TodoStatus {
    TODO("Todo"),
    DOING("Doing"),
    DONE("Done");

    private String value;

    TodoStatus(String value) {
        this.value = value;
    }
}
