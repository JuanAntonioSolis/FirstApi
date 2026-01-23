package com.jaroso.firstapi.services;

import com.jaroso.firstapi.dtos.TaskCreateDto;
import com.jaroso.firstapi.dtos.TaskDto;
import com.jaroso.firstapi.dtos.TaskUpdateDto;
import com.jaroso.firstapi.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    //RETRIEVE
    List<TaskDto> findAll();
    Optional<TaskDto> findById(Integer id);
    Optional<TaskDto> findByTitle(String title);
    List<TaskDto> findAllByOrderByTitle(String order);
    List<TaskDto> buscarPorTitulo(String titulo);

    //CREATE / UPDATE
    TaskDto saveTask(TaskCreateDto taskDto);
    TaskDto updateTask(TaskUpdateDto taskDto);

    //DELETE
    void deleteTask(Integer id);
    void deleteAll();


}
