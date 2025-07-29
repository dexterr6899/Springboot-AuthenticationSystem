package com.dexterbrains.AuthenticationSystem.repository;

import com.dexterbrains.AuthenticationSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
