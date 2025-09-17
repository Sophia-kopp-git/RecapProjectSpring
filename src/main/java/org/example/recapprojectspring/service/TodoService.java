package org.example.recapprojectspring.service;

import org.example.recapprojectspring.dto.TodoDto;
import org.example.recapprojectspring.exceptions.NoTaskWithThisIDFoundException;
import org.example.recapprojectspring.model.Todo;
import org.example.recapprojectspring.model.TodoStatus;
import org.example.recapprojectspring.repository.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepo repo;
    private final IdService idService;
    private final StatusService statusService;


    public TodoService(TodoRepo repo, IdService idService, StatusService statusService) {
        this.repo = repo;
        this.idService = idService;
        this.statusService = statusService;
    }

    public List<Todo> getAllTasks() {
    return repo.findAll();
    }

    public Todo addNewTask(TodoDto todoDto) {
        Todo todo = new Todo(idService.getUUid(), todoDto.description(), todoDto.status());
        repo.save(todo);
        return todo;
    }

    public Todo getTaskById(String id) {
        return repo.findById(id).orElseThrow( ()-> new NoTaskWithThisIDFoundException("No Task found with id: " + id));
    }

    public void editExistingTask(String id, TodoDto todoDto) {
        Optional<Todo> existingTask = repo.findById(id);
        if(existingTask.isPresent()){
            repo.save(existingTask.get()
                    .withDescription(todoDto.description())
                    .withStatus(todoDto.status()));
        } else {
            throw new NoTaskWithThisIDFoundException("No Task found with id: " + id);
        }
    }

    public void deleteTaskWithId(String id) {
        repo.deleteById(id);
    }
}
