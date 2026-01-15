package com.jaroso.firstapi.services;

import com.jaroso.firstapi.entities.Task;
import com.jaroso.firstapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public Optional<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    @Override
    public List<Task> findAllByOrderByTitle(String order) {
        if (order.equals("asc")) {
            return taskRepository.findAllByOrderByTitleAsc();
        } else  {
            return taskRepository.findAllByOrderByTitleDesc();
        }
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        taskRepository.deleteAll();
    }
}
