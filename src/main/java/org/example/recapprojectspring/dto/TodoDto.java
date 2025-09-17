package org.example.recapprojectspring.dto;

import org.example.recapprojectspring.model.TodoStatus;

public record TodoDto(String description, TodoStatus status) {
}
