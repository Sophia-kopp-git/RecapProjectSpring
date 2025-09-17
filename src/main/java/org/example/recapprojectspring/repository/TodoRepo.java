package org.example.recapprojectspring.repository;

import org.example.recapprojectspring.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends MongoRepository<Todo, String> {
    List<Todo> getById(String id);
}
