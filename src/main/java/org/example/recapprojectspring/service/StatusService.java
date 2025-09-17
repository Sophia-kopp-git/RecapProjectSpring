package org.example.recapprojectspring.service;

import org.example.recapprojectspring.model.TodoStatus;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    public TodoStatus advanceStatus(TodoStatus status){
        if(status.equals(TodoStatus.OPEN)){
            return TodoStatus.IN_PROGRESS;
        } else if(status.equals(TodoStatus.IN_PROGRESS)){
            return TodoStatus.DONE;
        } else{
            return null;
        }
    }
}
