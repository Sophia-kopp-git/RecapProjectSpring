package org.example.recapprojectspring.service;

import org.example.recapprojectspring.repository.TodoRepo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepo repo;

    public TodoService(TodoRepo repo) {
        this.repo = repo;
    }
}
