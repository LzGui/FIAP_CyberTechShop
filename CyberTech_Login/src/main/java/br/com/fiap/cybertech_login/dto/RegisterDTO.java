package br.com.fiap.cybertech_login.dto;

import br.com.fiap.cybertech_login.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
