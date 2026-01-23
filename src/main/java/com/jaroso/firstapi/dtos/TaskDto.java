package com.jaroso.firstapi.dtos;

import java.time.LocalDate;

public record TaskDto(Integer id, String title, String description, LocalDate finishDate) {
}
