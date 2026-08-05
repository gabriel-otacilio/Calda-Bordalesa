package org.example.repository;

import org.example.entity.Planta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Integer> {

    //Planta findByNome(String nome);

    void removeById(int id);

    // aqui o Spring ja fornece os metodos de save(), findAll(), deleteById() etc
    // aqui eu implemento os que eu preciso
}
