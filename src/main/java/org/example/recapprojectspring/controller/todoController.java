package org.example.recapprojectspring.controller;

import org.example.recapprojectspring.service.TodoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
public class todoController {
    private final TodoService todoService;

    public todoController(TodoService todoService) {
        this.todoService = todoService;
    }

}
