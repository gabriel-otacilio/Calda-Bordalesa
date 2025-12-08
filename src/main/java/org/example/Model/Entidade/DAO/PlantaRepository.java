package org.example.Model.Entidade.DAO;

import org.example.Model.Entidade.Planta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Integer> {
    // aqui o Spring ja fornece os metodos de save(), findAll(), deleteById() etc
}
