package com.jaroso.firstapi.services;

import com.jaroso.firstapi.entities.Task;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Optional<Task> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Task> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Task saveTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(Integer id, Task task) {
        return null;
    }

    @Override
    public void deleteTask(Integer id) {

    }

    @Override
    public void deleteAll() {

    }
}
