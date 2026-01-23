package com.jaroso.firstapi.dtos;

import java.time.LocalDate;

public record TaskCreateDto(String title, String description, LocalDate finishDate, String username) {
}
