package com.security.learning.Repository;

import com.security.learning.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByUsername(String username);
     Optional<User> findByEmail(String email);

}
