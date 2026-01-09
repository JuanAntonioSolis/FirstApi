package com.jaroso.firstapi.services;

import com.jaroso.firstapi.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    //RETRIEVE
    List<Task> findAll();
    Optional<Task> findById(Integer id);
    Optional<Task> findByTitle(String title);

    //CREATE / UPDATE
    Task saveTask(Task task);

    //DELETE
    void deleteTask(Integer id);
    void deleteAll();


}
