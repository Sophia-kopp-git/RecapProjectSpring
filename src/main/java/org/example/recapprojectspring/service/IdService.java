package org.example.recapprojectspring.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
    public String getUUid(){
        return UUID.randomUUID().toString();
    }
}
