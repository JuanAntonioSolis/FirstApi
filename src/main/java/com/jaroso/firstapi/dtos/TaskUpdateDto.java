package com.jaroso.firstapi.dtos;

import java.time.LocalDate;

public record TaskUpdateDto(Integer id, String title, String description, LocalDate finishDate) {
}
