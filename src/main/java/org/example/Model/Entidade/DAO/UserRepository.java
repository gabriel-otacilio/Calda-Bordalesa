package org.example.Model.Entidade.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.Model.Entidade.User;

public interface UserRepository extends JpaRepository <User, Integer>{
    // repositorio que ja vem com o Spring
}
