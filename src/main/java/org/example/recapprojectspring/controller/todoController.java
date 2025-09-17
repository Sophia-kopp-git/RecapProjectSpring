package org.example.recapprojectspring.controller;

import org.example.recapprojectspring.dto.TodoDto;
import org.example.recapprojectspring.model.Todo;
import org.example.recapprojectspring.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class todoController {

    private final TodoService service;

    public todoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAllTasks(){
        return service.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<Todo> addNewTask(@RequestBody TodoDto todoDto){
           Todo createdTask = service.addNewTask(todoDto);
       // return ResponseEntity.badRequest()
                //.body("Year of birth cannot be in the future");

        return ResponseEntity.status(HttpStatus.CREATED).header("URI", "/api/todo/" + createdTask.id())
                .body(createdTask);

    }

    @GetMapping("/{id}")
    public Todo seeDetails(@PathVariable String id){
        return service.getTaskById(id);
    }

    @PutMapping("/{id}")
    public void editTodo(@PathVariable String id, @RequestBody TodoDto todoDto){
        service.editExistingTask(id, todoDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id){
       service.deleteTaskWithId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Task was deleted!");
    }
}
