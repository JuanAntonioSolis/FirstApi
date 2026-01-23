package com.jaroso.firstapi.controllers;

import com.jaroso.firstapi.dtos.TaskCreateDto;
import com.jaroso.firstapi.dtos.TaskDto;
import com.jaroso.firstapi.dtos.TaskUpdateDto;
import com.jaroso.firstapi.entities.Task;
import com.jaroso.firstapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/tasks/order/{order}")
    public ResponseEntity<List<TaskDto>> getAllTasksOrder(@PathVariable String order) {
        return ResponseEntity.ok(taskService.findAllByOrderByTitle(order));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Integer id) {
        Optional<TaskDto> task = taskService.findById(id);

        if (task.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(task.get());
    }

    @GetMapping("/tasks/title/{title}")
    public ResponseEntity<TaskDto> getTaskByTitle(@PathVariable String title) {
        Optional<TaskDto> task = taskService.findByTitle(title);
        if (task.isEmpty())
            return ResponseEntity.notFound().build();


        return ResponseEntity.ok(task.get());
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskCreateDto task) {
       // return ResponseEntity.ok(taskService.saveTask(task));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task));

    }

    @PutMapping("/tasks")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskUpdateDto task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> deleteTaskById(@PathVariable Integer id) {

        Optional<TaskDto> task = taskService.findById(id);

        if (task.isPresent()){
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/tasks")
    public ResponseEntity<Void> deleteAll(){
        taskService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks/search/{texto}")
    public ResponseEntity<List<TaskDto>> buscarPorTitulo(@PathVariable String texto) {
        return ResponseEntity.ok(taskService.buscarPorTitulo(texto));
    }
}
