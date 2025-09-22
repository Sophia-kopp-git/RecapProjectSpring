package org.example.recapprojectspring.controller;

import org.example.recapprojectspring.model.Todo;
import org.example.recapprojectspring.model.TodoStatus;
import org.example.recapprojectspring.repository.TodoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    TodoRepo repo;


    @Test
    void getAllTasks() throws Exception {
        Todo todo = new Todo("1", "test", TodoStatus.OPEN);
        repo.save(todo);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [
                                                                {"id": "1",
                                                                "description": "test",
                                                                "status": "OPEN"
                                }]
                                """
                ));
    }

    @Test
    void addNewTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                        {
                                        "id": "1",
                                                                        "description": "test",
                                                                        "status": "OPEN"
                                        }
                                        """
                        )).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                
                                                                {
                                                                "description": "test",
                                                                "status": "OPEN"
                                }
                                """
                ));
    }

    @Test
    void seeDetails() throws Exception {
        Todo todo = new Todo("1", "test", TodoStatus.OPEN);
        repo.save(todo);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                
                                                                {"id": "1",
                                                                "description": "test",
                                                                "status": "OPEN"
                                }
                                """
                ));

    }

    @Test
    void editTodo() throws Exception {
        Todo todo = new Todo("1", "test", TodoStatus.OPEN);
        repo.save(todo);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                        {
                                        "id": "1",
                                                                        "description": "testAdapt",
                                                                        "status": "OPEN"
                                        }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                
                                                                {"id": "1",
                                                                "description": "testAdapt",
                                                                "status": "OPEN"
                                }
                                """
                ));

    }




@Test
void deleteTask() throws Exception {
    Todo todo = new Todo("1", "test", TodoStatus.OPEN);
    repo.save(todo);
    mockMvc.perform(MockMvcRequestBuilders.delete("/api/todo/1"))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
}
}