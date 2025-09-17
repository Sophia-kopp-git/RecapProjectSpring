package org.example.recapprojectspring.service;

import org.example.recapprojectspring.dto.TodoDto;
import org.example.recapprojectspring.model.Todo;
import org.example.recapprojectspring.repository.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepo repo;
    private final IdService idService;


    public TodoService(TodoRepo repo, IdService idService) {
        this.repo = repo;
        this.idService = idService;
    }

    public List<Todo> getAllTasks() {
    return repo.findAll();
    }

    public Todo addNewTask(TodoDto todoDto) {
        Todo todo = new Todo(idService.getUUid(), todoDto.description(), todoDto.status());
        repo.save(todo);
        return todo;
    }
}
