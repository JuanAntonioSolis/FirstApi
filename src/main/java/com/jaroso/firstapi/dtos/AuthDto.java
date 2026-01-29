package com.jaroso.firstapi.dtos;

import java.util.List;

public record AuthDto(String username, List<String> authorities, String token) {
}
