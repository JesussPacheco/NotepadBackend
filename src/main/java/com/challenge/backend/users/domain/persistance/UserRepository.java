package com.challenge.backend.users.domain.persistance;

import com.challenge.backend.users.domain.model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmailAndPassword(String email, String password);
    Boolean existsByNameAndLastName(String name, String lastName);
    Boolean existsByEmail(String email);
}
