package org.example.recapprojectspring.controller;

import org.example.recapprojectspring.dto.TodoDto;
import org.example.recapprojectspring.exceptions.NoTaskWithThisIDFoundException;
import org.example.recapprojectspring.exceptions.NoTodoWasCreatedException;
import org.example.recapprojectspring.model.Todo;
import org.example.recapprojectspring.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class todoController {

    private final TodoService service;

    public todoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAllTasks() {
        return service.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<Todo> addNewTask(@RequestBody TodoDto todoDto) {
        Todo createdTask = service.addNewTask(todoDto);
        if (createdTask.description() != null) {

            return ResponseEntity.status(HttpStatus.CREATED).header("URI", "/api/todo/" + createdTask.id())
                    .body(createdTask);
        } else {
            throw new NoTodoWasCreatedException("Todo wasnt created. Wrong format");
        }

    }

    @GetMapping("/{id}")
    public Todo seeDetails(@PathVariable String id) {
        Todo response = service.getTaskById(id);
        if (response != null) {

            return response;
        } else {
            throw new NoTaskWithThisIDFoundException("No Task found with id " + id);
        }
    }

    @PutMapping("/{id}")
    public void editTodo(@PathVariable String id, @RequestBody TodoDto todoDto) {
        service.editExistingTask(id, todoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        service.deleteTaskWithId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Task was deleted!");
    }
}
