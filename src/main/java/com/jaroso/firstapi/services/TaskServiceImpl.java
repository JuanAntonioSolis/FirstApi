package com.jaroso.firstapi.services;

import com.jaroso.firstapi.dtos.TaskCreateDto;
import com.jaroso.firstapi.dtos.TaskDto;
import com.jaroso.firstapi.dtos.TaskUpdateDto;
import com.jaroso.firstapi.dtos.UserDto;
import com.jaroso.firstapi.entities.Task;
import com.jaroso.firstapi.entities.User;
import com.jaroso.firstapi.mappers.TaskMapper;
import com.jaroso.firstapi.repositories.TaskRepository;
import com.jaroso.firstapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TaskDto> findAll() {
        return taskRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<TaskDto> findById(Integer id) {
        return taskRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<TaskDto> findByTitle(String title) {
        return taskRepository.findByTitle(title).map(mapper::toDto);
    }

    @Override
    public List<TaskDto> findAllByOrderByTitle(String order) {
        if (order.equals("asc")) {
            return taskRepository.findAllByOrderByTitleAsc().stream().map(mapper::toDto).toList();
        } else  {
            return taskRepository.findAllByOrderByTitleDesc().stream().map(mapper::toDto).toList();
        }
    }

    @Override
    public List<TaskDto> buscarPorTitulo(String titulo) {
        return taskRepository.buscarPorTitulo(titulo).stream().map(mapper::toDto).toList();
    }

    @Override
    public TaskDto saveTask(TaskCreateDto task) {
        //Luego depende de token
        String username = task.username();

        Optional<User> user = userRepository.findByUsername(username);

        Task taskEntity = mapper.toEntity(task);

        user.ifPresent(taskEntity::setUser);

        return mapper.toDto(taskRepository.save(taskEntity));
    }

    @Override
    public TaskDto updateTask(TaskUpdateDto task) {
        Task taskEntity = mapper.updateToEntity(task);

        return mapper.toDto(taskRepository.save(taskEntity));
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
