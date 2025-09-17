package org.example.recapprojectspring.model;

import lombok.With;

@With
public record Todo(String id, String description, TodoStatus status) {
}
