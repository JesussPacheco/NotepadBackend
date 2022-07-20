package com.challenge.backend.users.domain.service;

import com.challenge.backend.users.domain.model.Entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User authenticate(String email, String password);
    User register(User request);
    User update(Long userId, User request);
    ResponseEntity<?> delete(Long userId);
}
