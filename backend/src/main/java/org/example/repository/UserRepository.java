package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.User;

public interface UserRepository extends JpaRepository <User, Integer>{
    // repositorio que ja vem com o Spring
}
