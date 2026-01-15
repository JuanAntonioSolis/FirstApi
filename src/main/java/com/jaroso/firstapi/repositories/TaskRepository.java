package com.jaroso.firstapi.repositories;

import com.jaroso.firstapi.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findByTitle(String title);
    List<Task> findAllByOrderByTitleAsc();
    List<Task> findAllByOrderByTitleDesc();

}
