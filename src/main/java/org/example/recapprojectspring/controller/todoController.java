package org.example.recapprojectspring.controller;

import org.example.recapprojectspring.dto.TodoDto;
import org.example.recapprojectspring.model.Todo;
import org.example.recapprojectspring.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class todoController {

    private final TodoService service;

    public todoController(TodoService todoService) {
        this.service = todoService;
    }

    @GetMapping
    public List<Todo> getAllTasks(){
        return service.getAllTasks();
    }

    @PostMapping
    public Todo addNewTask(@RequestBody TodoDto todoDto){
        return service.addNewTask(todoDto);
    }
}
