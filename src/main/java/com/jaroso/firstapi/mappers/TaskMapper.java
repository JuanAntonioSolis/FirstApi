package com.jaroso.firstapi.mappers;

import com.jaroso.firstapi.dtos.TaskCreateDto;
import com.jaroso.firstapi.dtos.TaskDto;
import com.jaroso.firstapi.dtos.TaskUpdateDto;
import com.jaroso.firstapi.entities.Task;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);
    Task toEntity(TaskCreateDto taskDto);
    Task updateToEntity(TaskUpdateDto taskDto);


}
